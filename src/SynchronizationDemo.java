//同步
class BankAccount {
    private int balance = 100;

    public void withdraw(int amount){
        synchronized (this){//锁定这个代码块
            if (balance >= amount){
                System.out.println(Thread.currentThread().getName() + " 正在取款：" + amount);
                balance -= amount;
                System.out.println("剩余余额：" + balance);
            }else {
                System.out.println("余额不足！");
            }
        }
    }
}

public class SynchronizationDemo {
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(60);//lambda写法

        Thread task1 = new Thread(task,"线程1");
        Thread task2 = new Thread(task,"线程2");

        task1.start();
        task2.start();

    }
}
