package advJava.lab.TW6;

import java.util.Scanner;

class Array {
    private int arr[];
    private int n;
    private Scanner s;

    Array() {
        System.out.println();
        s = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        n = s.nextInt();
        arr = new int[n];
        System.out.println("Allocated memory for array of size : " + arr.length);
    }

    Array(int n) {
        this.n = n;
        arr = new int[n];
        System.out.println("Allocated memory for array of size : " + arr.length);
    }

    void readArray() {
        s = new Scanner(System.in);
        System.out.print("Enter elements to sort : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
    }

    void printArray() {
        System.out.print("Array elements are : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void sortAsc() {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    void sortDesc() {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}

class AscThread extends Thread {
    Array a;

    AscThread() {
        a = new Array();
        a.readArray();
        a.printArray();
    }

    @Override
    public void run() {
        a.sortAsc();
        System.out.println("\nSorted Ascendging Array -->");
        a.printArray();
    }

}

class DescThread extends Thread {
    Array a;

    DescThread() {
        a = new Array();
        a.readArray();
        a.printArray();
    }

    @Override
    public void run() {
        a.sortDesc();
        System.out.println("\nSorted Descending Array -->");
        a.printArray();
    }

}

public class ArraySorting {
    public static void main(String[] args) {
        //this will jumble up the output -------->
        // AscThread at = new AscThread();
        // DescThread dt = new DescThread();

        // at.start();
        // dt.start();

        // ------------------------------------------------ //

        //this won't jumble the output --------->
        AscThread at = new AscThread();
        at.start();

        DescThread dt = new DescThread();
        dt.start();
    }
}
