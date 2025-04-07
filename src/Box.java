//泛型类,可自行创建类型
public class Box<T> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
    //泛型方法
    public static <T> void print(T value){
        System.out.println(value);
    }

    public static void main(String[] args){
        Box<String> stringBox = new Box<>("Hello");
        System.out.println(stringBox.getValue());

        Box<Integer> IntegerBox = new Box<>(114514);
        System.out.println(IntegerBox.getValue());

        print(114);
        print("514");
        print(114.514);
    }
}
