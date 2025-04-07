package ConDemo;//并发工具类-2
//循环屏障
//CyclicBarrier 让多个线程相互等待，直到所有线程都到达屏障后，才会继续执行。
//多线程任务分阶段执行，如多个线程需要同步执行某一阶段任务后，才能进入下一阶段。
//赛跑比赛，所有选手准备好后一起出发。
import java.util.concurrent.CyclicBarrier;

public class ConDemo_2 {
    public static void main(String[] args){
        int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("所有线程到达屏障，开始执行下一步");
        });

        for(int i = 0; i < threadCount; i++){
            new Thread(() -> {
                try{
                    System.out.println(Thread.currentThread().getName() + " 到达屏障点");
                    barrier.await(); // 线程被阻塞，等待其他线程
                    System.out.println(Thread.currentThread().getName() + " 继续执行");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
