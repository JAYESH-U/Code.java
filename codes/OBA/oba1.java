package codes.OBA;

class selectionSort {

    void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {

            // let minimun index be i th element.
            int minInd = i;

            // find minimum numbers' index
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minInd])
                    minInd = j;
            }

            // swap
            int t = a[minInd];
            a[minInd] = a[i];
            a[i] = t;
        }
    }

    void display(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class oba1 {
    public static void main(String[] args) {
        selectionSort s = new selectionSort();

        int[] a = { 5, 4, 3, 2, 1 };

        System.out.print("Before Sorting : ");
        s.display(a);

        s.sort(a);

        System.out.print("After sorting : ");
        s.display(a);
    }
}
