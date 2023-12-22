import java.util.Scanner;

public class CRC {

    public static void main(String[] args) {
        int i, j, flag = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message polynomial bit pattern:");
        String msg = scanner.nextLine();
        int msgLen = msg.length();

        System.out.println("Enter the generator polynomial bit pattern:");
        String gen = scanner.nextLine();
        int genDegree = gen.length() - 1;

        char[] a = new char[100];
        char[] rem = new char[50];

        for (i = 0; i < msgLen; i++) {
            a[i] = msg.charAt(i);
        }

        for (i = 0; i <= genDegree; i++) {
            a[i + msgLen] = '0';
        }
        a[genDegree + msgLen] = '\0';

        System.out.print("The message polynomial when appended with zeros is: ");
        System.out.println(a);

        // Perform modulo operation
        for (i = 0; i < msgLen; i++) {
            if (a[i] == '1') {
                for (j = 0; j <= genDegree; j++) {
                    if (a[i + j] == gen.charAt(j))
                        a[i + j] = '0';
                    else
                        a[i + j] = '1';
                }
            }
        }

        a[i + genDegree + 1] = '\0';

        for (i = 0; i <= genDegree; i++) {
            rem[i] = a[i + msgLen];
        }
        rem[genDegree] = '\0';
        System.out.print("\nThe checksum calculated is:\n ");
        System.out.println(rem);

        for (i = 0; i < msgLen; i++) {
            a[i] = msg.charAt(i);
        }

        System.out.print("\nThe polynomial with checksum is: ");
        System.out.println(a);

        // receiver side

        System.out.println("Enter the received polynomial bit pattern:");
        msg = scanner.nextLine();
        msgLen = msg.length();

        char[] b = new char[100];
        char[] remrev = new char[50];

        for (i = 0; i < msgLen; i++) {
            b[i] = msg.charAt(i);
        }

        for (i = 0; i <= genDegree; i++) {
            b[i + msgLen] = rem[i];
        }
        b[genDegree + msgLen] = '\0';
        System.out.println("Message appended with CRC");
        System.out.println(b);

        for (i = 0; i < msgLen; i++) {
            if (b[i] == '1') {
                for (j = 0; j <= genDegree; j++) {
                    if (b[i + j] == gen.charAt(j))
                        b[i + j] = '0';
                    else
                        b[i + j] = '1';
                }
            }
        }

        b[i + genDegree + 1] = '\0';

        for (i = 0; i <= genDegree; i++) {
            remrev[i] = b[i + msgLen];
        }
        remrev[genDegree] = '\0';
        System.out.print("\nThe checksum calculated is:\n ");
        System.out.println(remrev);

        for (i = 0; i < genDegree; i++) {
            if (remrev[i] != '0')
                flag = 1;
        }
        if (flag == 1)
            System.out.print("\nReceived message is erroneous ");
        else
            System.out.print("\nReceived message is not erroneous ");

    }

}