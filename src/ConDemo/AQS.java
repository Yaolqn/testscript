package ConDemo;

//AQS(AbstractQueuedSynchronizer)是 Java 并发框架的核心组件，用于构建 同步器（Synchronizer）
//AQS 通过 FIFO（先进先出）等待队列 + CAS 机制 实现线程同步管理，简化了并发组件的实现。
//AQS有两种模式 1.只有一个线程能获得锁可执行，其他等待（ReentrantLock、CountDownLatch）; 2.多个线程可以获得锁同时执行（Semaphore、ReentrantReadWriteLock）

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//AQS实现Semaphore
public class AQS {
    private static class Sync extends AbstractQueuedSynchronizer {

        Sync(int permits){
            setState(permits);//表示当前可用的许可数
        }
        //tryAcquireShared(int arg) → state--，如果 state < 0，进入等待队列
        protected int tryAcquireShared(int arg){
            for(;;){
                int available = getState();//获取许可数
                int remaining = available - arg;//计算剩余许可数
                //剩余许可不足 或 CAS更新成功
                if(remaining < 0 || compareAndSetState(available, remaining)){
                    return remaining;//正数代表成功，负数代表失败，进入等待队列
                }
            }
        }
        //tryReleaseShared(int arg) → state++，如果 state > 0，唤醒等待线程
        protected boolean tryReleaseShared(int arg){
            for(;;){
                int current = getState();
                int next = current + arg;
                if(compareAndSetState(current, next)){
                    return true;//释放线程
                }
            }
        }
        // 新增方法用于外部获取当前许可数(在Sync即AbstractQueuedSynchronizer外面用不了getState())
        public int getPermits() {
            return getState();
        }

    }
    // 用 Sync 实现信号量的功能
    private final Sync sync;

    public AQS(int permits) {
        this.sync = new Sync(permits);
    }

    // 获取指定数量的许可（这里模拟阻塞获取）
    public void acquire(int permits) {
        // 自旋等待直到 tryAcquireShared 返回非负值
        while (sync.tryAcquireShared(permits) < 0) {
            // 这里简单让线程让出 CPU，模拟等待
            Thread.yield();
        }
    }

    // 释放指定数量的许可
    public void release(int permits) {
        sync.tryReleaseShared(permits);
    }

    // 获取当前可用许可数（供调试使用）
    public int availablePermits() {
        return sync.getPermits();
    }

    public static void main(String[] args){
        AQS aqs = new AQS(3);//具有三个许可量的信号量

        //创建5个线程，模拟获取和释放许可
        for(int i = 0; i < 5; i++){
            final int threadId = i;
            new Thread(() -> {
                try {
                    // 每个线程申请许可前延时，错开申请时间
                    Thread.sleep(200 * threadId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("线程 " + threadId + " 正在尝试获取许可...");
                aqs.acquire(1); // 每个线程申请 1 个许可
                System.out.println("线程 " + threadId + " 获取许可成功，当前剩余许可：" + aqs.availablePermits());
                try {
                    // 模拟业务操作（休眠 2 秒）
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                aqs.release(1);
                System.out.println("线程 " + threadId + " 释放许可，当前剩余许可：" + aqs.availablePermits());
            }, "线程-" + i).start();
        }
    }
}
