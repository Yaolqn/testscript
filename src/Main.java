import java.util.*;

public class Main {
    public static void main(String[] args) {
        //动态数组，查询快，增删慢
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Apple");//可重复

        System.out.println(list1.get(1));//第二个Banana
        System.out.println(list1);//[Apple,Banana.Apple]

        //双向链表，增删快，查询慢
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Apple");
        list2.addFirst("First");
        list2.addLast("Last");

        System.out.println(list2.get(1));//第二个Apple
        System.out.println(list2);//[First,Apple,Last]

        //哈希表，无序唯一
        HashSet<String> set1 = new HashSet<>();
        set1.add("Apple");
        set1.add("Banana");
        //set.add("Apple");//重复数据会忽略

        System.out.println(set1);//[Apple,Banana]

        //树，自动排序，不重复
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(30);
        set2.add(10);
        set2.add(20);

        System.out.println(set2);//[10,20,30]

        //(LinkedList实现)队列，先进先出
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");

        System.out.println(queue.poll());//A 取出A
        System.out.println(queue);//[B]

        //Map键值对，key唯一
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("Apple",10);
        map1.put("Banana",20);
        map1.put("Apple",30);//key重复会覆盖

        System.out.println(map1);//{Apple = 30，Banana = 20}

        TreeMap<Integer,String> map2 = new TreeMap<>();
        map2.put(2,"Banana");
        map2.put(1,"Apple");
        map2.put(3, "Cherry");

        System.out.println(map2);//{1=Apple, 2=Banana, 3=Cherry}

        //Collections集合工具类
        ArrayList<Integer> listC = new ArrayList<>();
        listC.add(20);
        listC.add(10);
        listC.add(30);

        System.out.println(listC);//[20,10,30]
        Collections.sort(listC);//排序
        System.out.println(listC);//[10,20,30]
        System.out.println(Collections.max(listC));//求最大
        //Collections.reverseOrder(list);//降序排序
        //Collections.reverse(list);//反转顺序
        //Collections.binarySearch(list,20);//二分查找，要先排序
        //Collections.fill(list,"X");//填充"X"
        //Collections.replaceAll(list,"X","A");//批量把X换成A
        //Collections.shuffle(list);//随机化，打乱
        //Collections.copy(list,src);//把src复制到list，两者大小必须相等
        //Collections.frequency(list,20);//统计list中20出现次数
    }

}