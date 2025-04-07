package javaClass;
import java.util.Random;
import java.util.Scanner;
public class GuessNumber4423 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        while (true){
            System.out.println("玩家当前得分:" + score);
            System.out.println("1.开始；2.退出");
            int choice = scanner.nextInt();
            if (choice == 1){
                int target = random.nextInt(100);
                int times = 3;
                while (true) {
                    if (times == 0){
                        score -= 2;
                        System.out.println("次数用完了。答案是" + target);
                        break;
                    }
                    System.out.println("请输入你猜的数(0~100)：");
                    int guess = scanner.nextInt();
                    if (guess < target) {
                        System.out.println("太小了");
                        times--;
                    } else if (guess > target) {
                        System.out.println("太大了");
                        times--;
                    } else {
                        System.out.println("你猜对了");
                        if (times == 3){
                            score += 3;
                        } else if (times == 2) {
                            score += 2;
                        } else if (times == 1) {
                            score += 1;
                        }
                        break;
                    }
                }
            }else if (choice == 2){
                System.out.println("退出");
                scanner.close();
                break;
            }else {
                System.out.println("输入错误");
            }
        }
    }
}
