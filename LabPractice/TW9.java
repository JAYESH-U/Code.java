package LabPractice;

import java.util.LinkedList;

public class TW9 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");
        ll.add("G");
        ll.add("H");
        ll.add("I");
        ll.add("J");

        System.out.println("List : "+ll);

        ll.remove();
        ll.removeFirst();
        ll.removeLast();

        System.out.println("List : "+ll);

        String val = ll.get(2);
        ll.set(2,val+" Hello.");

        System.out.println("List : "+ll);
    }
}
