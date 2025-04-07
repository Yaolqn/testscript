import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入你的名字: ");
        String name = scanner.nextLine();//读取一行字符串

        System.out.print("请输入你的年龄: ");
        int age = scanner.nextInt();//读取一个int

        System.out.print("请输入你的身高（米）: ");
        double height = scanner.nextDouble();//读取一个double

        System.out.println("你好, " + name + "! 你 " + age + " 岁, 身高 " + height + " 米。");

        scanner.close();// 关闭 Scanner，防止资源泄漏
    }
}
