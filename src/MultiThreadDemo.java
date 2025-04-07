//多线程
class Task1 implements Runnable{
    @Override
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Task1-Number:" + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Task1 interrupted: " + e.getMessage());
            }
        }
    }
}

class Task2 implements Runnable{
    @Override
    public void run(){
        for(char c = 'A'; c <= 'E'; c++){
            System.out.println("Task2-Char:" + c);
            try{
                Thread.sleep(1500);
            }catch(InterruptedException e){
                System.out.println("Task2 interrupted: " + e.getMessage());
            }
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args){
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());
        //启动线程
        thread1.start();
        thread2.start();

        try{
            //join()等待线程结束,再执行主线程代码
            thread1.join();
            thread2.join();
        }catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Both tasks are completed.");
    }

}
