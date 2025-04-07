package ConDemo;//并发工具类-3
//信号量
//Semaphore 用于控制并发访问的线程数量，类似于限流器。
//控制数据库连接池的最大连接数。
//限流，如限制 API 访问的并发数。
import java.util.concurrent.Semaphore;

public class ConDemo_3 {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(2);

        for(int i = 0; i < 5; i++){
            new Thread(() -> {
                try{
                    semaphore.acquire(); // 获取许可
                    System.out.println(Thread.currentThread().getName() + " 进入，正在执行任务");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " 释放资源");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();// 释放许可
                }
            }).start();
        }
    }
}
