/*
Write a menu-driven Java Program to create a HashMap to store key-value pairs of login
credentials. The menu options to be provided are for: adding a key-value pair, retrieve the
“value” for a given “key” (first check if the specified key is present), retrieve all the keys,
retrieve all the values, retrieve all the key-value pairs, change the value associated with a
key in a HashMap, remove a HashMap element given the key, remove a HashMap entry
with Key and Value, check if a given “value” exists in the Hashmap and display the
HashMap. Read user input where required and display suitable error messages where
applicable.


 */

import java.util.*;


class Credientials {
    private Map<String, String> data = new HashMap<String, String>();

    void add() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the key: ");
        String key = scn.next();

        System.out.println("Enter the value: ");
        String value = scn.next();

        data.put(key, value);
    }

    void get() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the key: ");
        String key = scn.next();

        if (data.containsKey(key)) {
            System.out.println("The value is: " + data.get(key));
        } else {
            System.out.println("Key is not present");
        }
    }

    void getkeys() {
        Set<String> keys = data.keySet();

        for (String key : keys) {
            System.out.print(key + ", ");
        }

        System.out.println();
    }

    void getValues() {
        Collection<String> values = data.values();

        for (String value : values) {
            System.out.print(value + ", ");
        }

        System.out.println();
    }

    void getpairs() {
        // Set<String> keys = data.keySet();

        // for (String key : keys) {
        //     System.out.print("(" + key + " : " + data.get(key) + "), ");
        // }
        System.out.println(data);

        System.out.println();
    }

    void change() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the key:");
        String key = scn.next();

        if (data.containsKey(key)) {
            System.out.print("Enter the value: ");
            String value = scn.next();
            
            data.put(key, value);
        } else {
            System.out.println("No such value!!");
        }
    }

    void remove() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the key to remove:");
        String key = scn.next();

        if (data.containsKey(key)) {
            data.remove(key);
        } else {
            System.out.println("No such value!!");
        }
    }

    void removeKeyValue() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the key to remove:");
        String key = scn.next();

        System.out.print("Enter the value: ");
        String value = scn.next();
        
        if (data.containsKey(key)) {
            if (data.get(key) == value)
                data.remove(key);
            else
                System.out.println("Pair not found!!");
        } else {
            System.out.println("No such value!!");
        }
    }

    void containsValue() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the value to search: ");
        String value = scn.next();

        Collection<String> values = data.values();

        if (values.contains(value))
            System.out.println("value is found!");
        else
            System.out.println("value not found");

        System.out.println();
    }

    void display() {
        System.out.println(data);
    }
}

public class prob4 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Credientials c1 = new Credientials();
        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1. Add a key-value pair");
            System.out.println("2. Retrieve value for a key");
            System.out.println("3. Retrieve all keys");
            System.out.println("4. Retrieve all values");
            System.out.println("5. Retrieve all key-value pairs");
            System.out.println("6. Change value associated with a key");
            System.out.println("7. Remove a HashMap element given the key");
            System.out.println("8. Remove a HashMap entry with Key and Value");
            System.out.println("9. Check if a given value exists in the Hashmap");
            System.out.println("10. Display the HashMap");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    c1.add();
                    break;
                case 2:
                    c1.get();
                    break;
                case 3:
                    c1.getkeys();
                    break;
                case 4:
                    c1.getValues();
                    break;
                case 5:
                    c1.getpairs();
                    break;
                case 6:
                    c1.change();
                    break;
                case 7:
                    c1.remove();
                    break;
                case 8:
                    c1.removeKeyValue();
                    break;
                case 9:
                    c1.containsValue();
                    break;
                case 10:
                    c1.display();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("enter a valid choice!!");

            }
        }
    }
}
