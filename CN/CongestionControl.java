import java.util.Scanner;

public class CongestionControl {
    public static void main(String[] args) {
        int c = 0, s, rem = 0, n, i, j, rate;
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the no of packets : ");
        n = scanner.nextInt();

        int size[] = new int[n];
        System.out.print("\nEnter sizes:");

        for (j = 0; j < n; j++) {
            size[j] = scanner.nextInt();
        }

        System.out.print("\nEnter the size of the bucket:");
        s = scanner.nextInt();

        System.out.println("\nEnter output rate:");
        rate = scanner.nextInt();

        for (i = 0; i < n; i++) {
            System.out.println("\n" + "TIME " + c);

            if (size[i] > s) {
                System.out.println("\n" + "dropped" + c + "\n");
            } else if ((size[i] + rem) > s) {
                System.out.println("\n" + "dropped" + c + "\n");
            } else {
                rem = rem + size[i];
            }

            if (rem < rate)
                System.out.println("\n" + "bytes txmitted " + rem + "\n");
            else
                System.out.println("\n" + "bytes txmitted " + rate + "\n");

            rem -= rate;

            if (rem <= 0)
                rem = 0;
            else
                System.out.println("\n" + "bytes txmitted" + rem + "\n");

            c++;
        }

        while (rem != 0) {
            System.out.println("\n" + "TIME" + c + "\n");
            c++;

            if (rem < rate) {
                System.out.println("\n" + "bytes txmitted" + rem + "\n");
                rem = 0;
            }

            if (rem >= rate) {
                System.out.println("\n" + "bytes txmitted" + rate + "\n");
                rem -= rate;
                System.out.println("\n" + "bytes txmitted" + rem + "\n");
            }
        }

        scanner.close();
    }
}