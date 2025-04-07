package javaClass;
import java.util.Random;
public class Bus4423 {
    public static void main(String[] args) {
        final int TOTAL_SIMULATIONS = 10_000_000;  // 模拟次数
        Random random = new Random();
        double totalWaitingTime = 0.0;

        for (int i = 0; i < TOTAL_SIMULATIONS; i++) {
            double W;
            // 生成随机耽搁时间
            double D1 = random.nextDouble() * 30;
            // 生成旅客到达时间
            double L1 = random.nextDouble() * 30;
            if (D1 - L1 >= 20.0){
                W = D1 - L1 - 20.0;
            }else {
                double D2 = random.nextDouble() * 30;
                W = 40.0 + D2 - L1;
            }
            totalWaitingTime += W;
        }
        // 计算平均等待时间
        double average = totalWaitingTime / TOTAL_SIMULATIONS;
        System.out.printf("Average waiting time: %.4f minutes%n", average);
    }
}
