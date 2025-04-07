package javaClass;

import java.util.Random;

public class BusAI4423 {
    public static void main(String[] args) {
        final int TOTAL_SIMULATIONS = 10_000_000;  // 模拟次数
        Random random = new Random();
        double totalWaitingTime = 0.0;

        for (int i = 0; i < TOTAL_SIMULATIONS; i++) {
            // 生成随机耽搁时间 D ~ [0,30)
            double D = random.nextDouble() * 30;
            // 生成旅客到达时间 T ~ [0,30)
            double T = random.nextDouble() * 30;
            // 计算等待时间 W = (40 + D) - T
            double W = 40 + D - T;
            totalWaitingTime += W;
        }

        // 计算平均等待时间
        double average = totalWaitingTime / TOTAL_SIMULATIONS;
        System.out.printf("Average waiting time: %.4f minutes%n", average);
    }
}
