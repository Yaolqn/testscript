package javaClass;

import java.util.Random;

public class List4423 {
    public static void main(String[] args){
        int[][] Array = new int[5][5];
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                Array[i][j] = random.nextInt(100);
            }
        }
        //操作1
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(Array[i][j] + " ");
                if (j == 4){
                    System.out.print("\n");
                }
            }
        }
        //操作2
        long Count = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if (i == 0 || i == 4 || j == 0 || j == 4){
                    System.out.print(Array[i][j]);
                    if (i == 4 && j == 4){
                        System.out.print("=");
                    }else {
                        System.out.print("+");
                    }
                    Count += Array[i][j];
                }
            }
        }
        System.out.println(Count);
        //操作3
        int Max=Array[0][0];
        int target = 0;
        for(int i = 0; i < 5; i++){
            if (Array[i][i] > Max){
                Max = Array[i][i];
                target = i;
            }
        }
        System.out.println("Max:" + Max + " In Array[" + target + "][" + target + "]");
    }
}
