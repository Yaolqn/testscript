import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args){
        ExecutorService executor = new ThreadPoolExecutor(
                3,
                5,
                60L, TimeUnit.SECONDS,// 线程空闲时间
                new ArrayBlockingQueue<>(10),// 任务队列（最多存 10 个等待任务）
                Executors.defaultThreadFactory(),// 线程工厂
                new ThreadPoolExecutor.AbortPolicy()// 拒绝策略：任务满了抛出异常
        );

        //模拟15个用户请求
        for(int i = 1; i <= 15; i++){
            final int requestId = i;
            executor.execute(() -> processRequest(requestId));
        }

        // 关闭线程池（不再接受新任务，但会等待已提交任务完成）
        executor.shutdown();
    }

    public static void processRequest(int requestId){
        System.out.println(Thread.currentThread().getName() + " 正在处理请求 " + requestId);
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 完成请求 " + requestId);
    }
}
