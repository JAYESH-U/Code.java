package LabPractice;

import java.util.Scanner;

public class TW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students : ");
        int ns = sc.nextInt();

        System.out.println();

        int[][] m = new int[ns][3];
        int[] tm = new int[ns];
        float[] avg = new float[ns];

        System.out.println("Enter details : ");
        for (int i = 0; i < ns; i++) {
            System.out.print("Enter marks of student " + (i+1) + " : ");
            for (int j = 0; j < 3; j++) {
                m[i][j] = sc.nextInt();
                tm[i] += m[i][j];
            }
            avg[i] = average(m[i]);
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<ns;i++){
            System.out.println("Details of Student "+(i+1)+" -->");
            System.out.println("\tTotal marks : "+tm[i]);
            System.out.println("\tAverage of best two : "+avg[i]);
            System.out.println();
        }
        sc.close();
    }

    public static float average(int m[]) {
        float avg = 0;
        int min = m[0];
        for (int i = 0; i < 3; i++) {
            if (min > m[i]) {
                min = m[i];
            }
            avg += m[i];
        }
        avg -= min;
        avg /= 2;
        return avg;
    }
}
