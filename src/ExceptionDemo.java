//异常处理
public class ExceptionDemo {

    public static int divide(int a, int b) {
        return a / b;
    }

    //catch用于捕获和处理不同类型的异常
    //finally无论是否发生异常，finally 中的代码总会执行
    public static void main(String[] args){
        try{
            int result = divide(10, 0);
        }catch (ArithmeticException e){
            System.out.println("Error: Cannot divide by zero.");
        }catch (Exception e){
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }finally {
            System.out.println("This will always execute.");
        }
    }
}
