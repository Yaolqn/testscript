//继承
class Animals{
    protected String Name;

    public Animals(String name){
        this.Name = name;
    }

    public void MakeSound(){
        System.out.println(Name + " is making sound ");
    }
}

class Cat extends Animals{
    //显式调用父类的构造方法
    public Cat(String name){
        super(name);
    }

    @Override
    public void MakeSound(){
        System.out.println(Name + " NyeNyeNye ");
    }
}

class Dog extends Animals{

    public Dog(String name){
        super(name);
    }

    @Override
    public  void MakeSound(){
        System.out.println(Name + " WuWuWU ");
    }
}


public class InheritanceDemo {
    public static void main(String[] args){
        Cat myCat = new Cat("Cookie");
        Dog myDog = new Dog("Blues");

        myCat.MakeSound();
        myDog.MakeSound();
    }
}
