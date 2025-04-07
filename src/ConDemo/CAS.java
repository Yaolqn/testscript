package ConDemo;

//CAS（Compare-And-Swap，比较并交换）
//CAS是一种无锁并发算法，用于实现多线程环境下的变量更新，避免传统的加锁同步带来的性能开销。

//无锁化操作：相比 synchronized 关键字，CAS 是 非阻塞的，避免了线程切换的开销，提高并发性能。
//原子性保证：CAS 依赖 CPU 指令（如 cmpxchg），可以保证多线程并发更新的安全性。
//适用于高并发环境：如 ConcurrentHashMap、AtomicInteger 等都使用 CAS 来提高性能。

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS {
    public static void main(String[] args){

        AtomicInteger atomicInteger = new AtomicInteger(10);//基于CAS的原子类

        boolean success = atomicInteger.compareAndSet(10,20);//如果当前值为10，则变为20
        System.out.println("CAS 更新是否成功：" + success + "，当前值：" + atomicInteger.get());

        success = atomicInteger.compareAndSet(10,30);//期望值不为10，不会更新
        System.out.println("CAS 更新是否成功：" + success + "，当前值：" + atomicInteger.get());

        //处理ABA问题(CAS 只检查值是否相等，但不关注值是否被修改过）
        //注意：在使用AtomicStampedReference时，需要注意比较的对象是引用而不是单纯的数值。即使两个对象的值相同，如果它们的引用地址不同，compareAndSet() 也会返回 false
        AtomicStampedReference<Integer> atomicStamped = new AtomicStampedReference<>(100, 1);

        new Thread(() -> {
            int stamp = atomicStamped.getStamp(); // 获取版本号
            System.out.println("线程 A 初始版本：" + stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}

            boolean success1 = atomicStamped.compareAndSet(atomicStamped.getReference(), 200, atomicStamped.getStamp(), 2);
            System.out.println("线程 A CAS 是否成功：" + success1 + "，当前值：" + atomicStamped.getReference());
        }).start();

        new Thread(() -> {
            int stamp = atomicStamped.getStamp();
            System.out.println("线程 B 初始版本：" + stamp);
            boolean success2 = atomicStamped.compareAndSet(atomicStamped.getReference(), 150, atomicStamped.getStamp(), atomicStamped.getStamp() + 1);
            System.out.println("线程 A CAS 是否成功：" + success2 + "，当前值：" + atomicStamped.getReference());
        }).start();

        new Thread(() -> {
            try{
                Thread.sleep(200);
            } catch(InterruptedException ignored) {}
            int stamp = atomicStamped.getStamp();
            System.out.println("线程 C 初始版本：" + stamp);
            boolean success3 = atomicStamped.compareAndSet(atomicStamped.getReference(), 100, atomicStamped.getStamp(), atomicStamped.getStamp() + 1);
            System.out.println("线程 A CAS 是否成功：" + success3 + "，当前值：" + atomicStamped.getReference());
        }).start();
    }
}
