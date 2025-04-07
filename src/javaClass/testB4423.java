package javaClass;

public class testB4423 {

    static int fun(int x){
        int j=1;
        switch (x){
            case 1:j++;
            case 2:j++;
            case 3:j++;
            default:j++;
        }
        return j+x;
    }

    public static void main(String args[]){
        int result = 0;
        for(int i = 1;i<=3;i++){
            result = fun(i);
            System.out.println(result);
        }
    }
}
