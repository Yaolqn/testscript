package ConDemo;//并发工具类-4
//线程间数据交换
//Exchanger 允许两个线程交换数据。
//线程之间的数据交换（如生产者-消费者模式）。
//多线程任务协作。
import java.util.concurrent.Exchanger;

public class ConDemo_4 {
    public static void main(String[] args){
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try{
                String data = "线程 A 的数据";
                System.out.println("线程 A 发送数据：" + data);
                String received = exchanger.exchange(data);
                System.out.println("线程 A 接收到数据：" + received);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try{
                String data = "线程 B 的数据";
                System.out.println("线程 B 发送数据：" + data);
                String received = exchanger.exchange(data);
                System.out.println("线程 B 接收到数据：" + received);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}
