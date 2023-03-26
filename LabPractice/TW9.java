package LabPractice;

import java.util.LinkedList;

public class TW9 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");
        ll.add("G");
        ll.add("H");
        System.out.println("LL : " + ll);

        ll.removeLast();
        ll.removeFirst();
        System.out.println("LL after removing first and last element: " + ll);

        ll.remove("B");
        ll.remove(1);
        System.out.println("LL after deleting 'B' and index 2 : " + ll);

        String val = ll.get(1);
        ll.set(1, val + " Hello");
        System.out.println("LL after modifications : " + ll);
    }
}
