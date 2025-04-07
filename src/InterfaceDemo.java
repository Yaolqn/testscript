//接口
interface Animal {
    void eat();
    void makeSound();

    //默认方法，可被继承，可被重写
    default void Sleep(){
        System.out.println("Animals is Sleeping");
    }
}

class Pig implements Animal {
    public void eat(){
        System.out.println("Pig is eating meat.");
    }

    public void makeSound(){
        System.out.println("Pig is making sound.");
    }
}

class Cow implements Animal {
    public void eat(){
        System.out.println("Cow is eating grass.");
    }

    public void  makeSound(){
        System.out.println("Cow is making sound.");
    }
}
public class InterfaceDemo {
    public static void main(String[] args){
        Pig myPig = new Pig();
        Cow myCow = new Cow();

        myPig.eat();
        myCow.eat();

        myPig.makeSound();
        myCow.makeSound();

        myPig.Sleep();
        myCow.Sleep();
    }
}
