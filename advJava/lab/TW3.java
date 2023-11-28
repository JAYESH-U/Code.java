package advJava.lab;

import java.util.ArrayList;
import java.util.Scanner;

class Arrays {
    private ArrayList<Integer> intArrayList;
    private ArrayList<Float> floatArrayList;

    Arrays(int isize, int fsize) {
        intArrayList = new ArrayList<Integer>(isize);
        floatArrayList = new ArrayList<Float>(fsize);
        System.out.println(
                "Array of int and flaot has been initialized -> " + intArrayList.size() + ", " + floatArrayList.size());
    }

    public ArrayList<Integer> addElements(int element) {
        intArrayList.add(element);
        return intArrayList;
    }

    public ArrayList<Integer> addElements(int position, int element) {
        intArrayList.add(position, element);
        return intArrayList;
    }
    
    public void removeElements(int element) {
        if (intArrayList.isEmpty())
            System.out.println("Array is empty....");
        else
            if(intArrayList.remove((Integer)element))
                System.out.println("Element has been removed.");
            else
                System.out.println("Element not found to be removed.");
    }

    public ArrayList<Float> addElements(float element) {
        floatArrayList.add(element);
        return floatArrayList;
    }

    public ArrayList<Float> addElements(int position, float element) {
        floatArrayList.add(position, element);
        return floatArrayList;
    }

    public void removeElements(float element) {
        if (floatArrayList.isEmpty())
            System.out.println("Array is empty....");
        else
            if(floatArrayList.remove(element))
                System.out.println("Element has been removed.");
            else
                System.out.println("Element not found to be removed.");
    }

    public int LinearSearch(int key) {
        for (int i = 0; i < intArrayList.size(); i++) {
            if (intArrayList.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    public int LinearSearch(float key) {
        for (int i = 0; i < floatArrayList.size(); i++) {
            if (floatArrayList.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    public void printIntArrayList() {
        System.out.println("Int Array List : " + intArrayList);
    }

    public void printFloatArrayList() {
        System.out.println("Int Array List : " + floatArrayList);
    }
}

public class TW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays array = new Arrays(10, 10);

        while (true) {
            System.out.println(
                    "1.Add int\n2.Add float\n3.Remove int\n4.Remove float\n5.Linear int Search\n6.Linear float Search\n7.Print int\n8.Print float\n9.exit.\nYour choice? : ");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.print("Enter integer to add into list =>");
                    int ai = sc.nextInt();
                    array.addElements(ai);
                    break;

                case 2:
                    System.out.print("Enter integer to add into list =>");
                    float af = sc.nextFloat();
                    array.addElements(af);
                    break;

                case 3:
                    System.out.print("Enter element to remove element from list =>");
                    int ri = sc.nextInt();
                    array.removeElements(ri);
                    break;

                case 4:
                    System.out.print("Enter element to remove element from list =>");
                    int rf = sc.nextInt();
                    array.removeElements(rf);
                    break;

                case 5:
                    System.out.print("Enter element to search element from list =>");
                    int lsi = sc.nextInt();
                    System.out.println("Index of element " + lsi + " : " + array.LinearSearch(lsi));
                    break;

                case 6:
                    System.out.print("Enter element to search element from list =>");
                    float lsf = sc.nextInt();
                    System.out.println("Index of element " + lsf + " : " + array.LinearSearch(lsf));
                    break;

                case 7:
                    array.printIntArrayList();
                    System.out.println();
                    break;

                case 8:
                    array.printFloatArrayList();
                    System.out.println();
                    break;

                case 9:
                    System.exit(0);
                    break;

                default:
                    sc.close();
                    break;
            }
        }
    }
}
