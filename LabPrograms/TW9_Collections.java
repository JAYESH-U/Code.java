package LabPrograms;

import java.util.LinkedList;

public class TW9_Collections {
    public static void main(String[] args) {
        // create a linked list.
        LinkedList<String> ll = new LinkedList<String>();

        // add elements to linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2"); // index starts from 0.

        System.out.println("Original Contents of ll : " + ll);

        // remove elements from linked list.
        ll.remove("F");
        ll.remove(2); // index starts from 0.
        System.out.println("Contents of ll after deletion : " + ll);

        ll.removeFirst();
        ll.removeLast();
        System.out.println("Contents of ll after deletion : " + ll);

        String val = ll.get(2);
        ll.set(2, val + " Changed");
        System.out.println("ll after change : " + ll);
    }
}
