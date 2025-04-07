package javaClass;
import java.util.Random;
public class CaluPi4423 {
    public static void main(String[] args){
        Random random = new Random();
        int time = 10000000;
        int num = 0;
        while (time >= 0){
            //System.out.println(time);
            double x = random.nextDouble();
            double y = random.nextDouble();
            if(Math.pow(x, 2) + Math.pow(y, 2) <= 1){
                num++;
            }
            time--;
        }
        System.out.println(4.0*num/10000000.0);
    }
}
