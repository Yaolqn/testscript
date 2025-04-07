package javaClass;

public class Node4423 {
    int value;
    Node4423 next;
    public static void main(String[] args){
        Node4423 h = new Node4423();
        Node4423 p = h;
        for(int k = 1; k <= 4; k++){
            p.value = 10 - k;
            Node4423 q = new Node4423();
            p.next = q;
            p = q;
        }
        p = h;
        while (p != null){
            System.out.println(p.value);
            p = p.next;
        }
    }
}
