package LabPractice;

import java.util.Scanner;

class UnderAge extends Exception {
    UnderAge(String s) {
        super(s);
    }

    public String toString() {
        return "Sorry, you are underage.";
    }
}

class validLLR extends Exception {
    validLLR(String s) {
        super(s);
    }

    public String toString() {
        return "Sorry, You need to have LLR.";
    }
}

class NumAcc extends Exception {
    NumAcc(String s) {
        super(s);
    }

    public String toString() {
        return "Sorry, you cannot have accidents in past year.";
    }
}

class License {
    String name, llr;
    int numAcc, age;

    License(String name, int age, String llr, int numAcc) {
        this.name = name;
        this.age = age;
        this.llr = llr;
        this.numAcc = numAcc;
    }

    void validation() {
        try {
            if (age < 18)
                throw new UnderAge("Under age : ");
            else if (llr != "Y")
                throw new validLLR("no learning license : ");
            else if (numAcc > 0)
                throw new NumAcc("You had accidents : ");
            else
                System.out.println("Congradulations.");
        } catch (UnderAge e) {
            System.out.println(e.getMessage() + e);
        } catch (validLLR e) {
            System.out.println(e.getMessage() + e);
        } catch (NumAcc e) {
            System.out.println(e.getMessage() + e);
        }
    }
}

public class TW8 {
    public static void main(String[] args) {
        License l1 = new License("Jayesh", 19, "Y", 0);
        l1.validation();

        License l2 = new License("Taneeshq", 18, "Y", 0);
        l2.validation();
        
        License l3 = new License("Pratik", 19, "N", 0);
        l3.validation();

        License l4 = new License("Aryan", 19, "Y", 1);
        l4.validation();
    }
}
