//反射机制
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("无参构造方法被调用");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    private void privateMethod() {
        System.out.println("这是一个私有方法");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        //获取class对象(方法一）
        Class<?> clazz1 = Class.forName("Person");
        //通过无参构造创建对象
        Object Obj1 = clazz1.getDeclaredConstructor().newInstance();//获取指定(包括私有,不包括继承)的Constructor对象
        System.out.println(Obj1);
        //通过有参构造创建对象(还用了构造器)
        Constructor<?> constructor = clazz1.getConstructor(String.class, int.class);//获取公开的,不包括私有构造方法only public
        Object Obj2 = constructor.newInstance("Alice",18);
        System.out.println(Obj2);

        //获取class对象(方法二)
        Class<?> clazz2 = Person.class;
        Person person = new Person("Tom", 20);
        //获取public字段
        Field ageField = clazz2.getField("age");
        System.out.println("原始 age：" + ageField.get(person));
        //修改字段值
        ageField.set(person, 25);
        System.out.println("修改后 age：" + ageField.get(person));
        //获取private字段
        Field nameField = clazz2.getDeclaredField("name");
        nameField.setAccessible(true);  // 允许访问私有字段
        System.out.println("原始 name：" + nameField.get(person));
        //修改private字段
        nameField.set(person, "Jerry");
        System.out.println("修改后 name：" + nameField.get(person));

        //获取class对象(方法三)
        Person person1 = new Person("Cookie", 12);
        Class<?> clazz3 = person1.getClass();
        //调用public方法
        Method method = clazz3.getMethod("sayHello");
        method.invoke(person1);//相当于 person.sayHello();
        //调用private方法
        Method method1 = clazz3.getDeclaredMethod("privateMethod");
        method1.setAccessible(true);//允许访问私有方法
        method1.invoke(person1);

    }
}
