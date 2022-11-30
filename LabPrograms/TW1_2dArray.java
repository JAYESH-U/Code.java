package LabPrograms;

import java.util.Scanner;

public class TW1_2dArray{
    public static void main(String[] args){
        int ns;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of students : ");
        ns = sc.nextInt();
        int[][] m = new int[ns][3];
        int[] tm = new int[ns];
        float[] avg = new float[5];
        for (int i = 0; i < ns; i++) {
            System.out.print("Student "+(i+1)+" : ");
            for (int j = 0; j < 3; j++) {
                m[i][j] = sc.nextInt();
                tm[i] += m[i][j];
            }
            avg[i] = avg(m[i]);
        }
        System.out.println();
        for (int i = 0; i < ns; i++) {
            System.out.println(
                    "Total marks of student " + (i + 1) + " : " + " and the average of the best two is : " + avg[i]);
        }
        sc.close();
    }

    public static float avg(int m[]) {
        int tm = 0, min = m[0];
        for (int i = 0; i < 3; i++) {
            if (min > m[i]) {
                min = m[i];
            }
            tm += m[i];
        }
        tm -= min;
        return (tm / 2.0f);
    }
}
