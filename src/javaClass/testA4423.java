package javaClass;

public class testA4423 {
    public static void main(String args[]){
        int a[] = new int[6];
        for(int m=0;m<a.length;m++){
            a[m]=m+1;
            System.out.println(a[m]);
            if(m%3==0)
                System.out.println();
        }
    }
}
