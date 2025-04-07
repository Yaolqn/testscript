package ConDemo;//并发工具类-1
//CountDownLatch
//CountDownLatch 允许一个或多个线程等待其他线程完成操作后再继续执行。
//并行计算，等待多个线程完成（如任务拆分执行后，等待结果汇总）。
//控制程序启动顺序（如等待服务启动完毕再执行后续操作）。

import java.util.concurrent.CountDownLatch;

public class ConDemo_1 {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(3);//需要等待3个任务完成

        for(int i = 1; i <= 3; i++){
            final int workerId = i;
            new Thread(() -> {
                try{
                    System.out.println("任务 " + workerId + " 执行中...");
                    Thread.sleep(2000); // 模拟任务执行
                    System.out.println("任务 " + workerId + " 完成");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    latch.countDown();//计数减1
                }
            }).start();
        }

        latch.await();// 主线程阻塞，等待计数变为 0
        System.out.println("所有任务执行完毕，主线程继续");
    }
}
