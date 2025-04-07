//重载
public class OverloadingDemo {
    public int add(int a, int b){
        return  a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

    public String add(String a, String b){
        return a + b;
    }

    public double add(double a, double b){
        return a + b;
    }

    public static void main(String[] args){
        OverloadingDemo calculator = new OverloadingDemo();
        System.out.println("两数相加:"+ calculator.add(1,2));
        System.out.println("三数相加:"+ calculator.add(1,2,3));
        System.out.println("两字符串相加:"+ calculator.add("114","514"));
        System.out.println("两浮点数相加:"+ calculator.add(1.14,5.14));
    }
}
