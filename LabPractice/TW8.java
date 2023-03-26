package LabPractice;

import java.time.Year;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

class UnderAgeException extends Exception {
    UnderAgeException(String s) {
        super(s);
    }

    public String toString() {
        return "You have to be above 18 to apply for License.";
    }
}

class LernerLicence extends Exception {
    LernerLicence(String s) {
        super(s);
    }

    public String toString() {
        return "You need to have Learner license apply for License.";
    }
}

class NumAcc extends Exception {
    NumAcc(String s) {
        super(s);
    }

    public String toString() {
        return "You should not have any number of accidents in the past 1 year to apply for learner license.";
    }
}

class License {
    String name, llr;
    int age, numAcc;

    License(String name, String llr, int age, int numAcc){
        this.name= name;
        this.llr= llr;
        this.age = age;
        this.numAcc = numAcc;
    }

    void readData(){
        Scanner sc = new Scanner(System.in);

        System.out.print("name : ");
        name = sc.next();
        System.out.print("age : ");
        age = sc.nextInt();
        System.out.print("Learning licence (Y/N) : ");
        llr = sc.next();
        System.out.print("Number of accidents in past year : ");
        numAcc = sc.nextInt();
        System.out.println();

        sc.close();
    }
}

public class TW8 {

    public static void validation(License a){
        try{
            if(a.age<18)
                throw new UnderAgeException("UnderAgeException");
            else if(a.llr == "N" || a.llr=="n")
                throw new LernerLicence("LearnerLicense");
            else if(a.numAcc>0)
                throw new NumAcc("Number of Accidents");
            else
                System.out.println("Congratulation for your Driving license.");
        }
        catch(UnderAgeException e){
            System.out.println(e.getMessage() +" exception : "+ e);
        }
        catch(LernerLicence e){
            System.out.println(e.getMessage() +" exception : " + e);
        }
        catch(NumAcc e){
            System.out.println(e.getMessage() +" exception : " + e);
        }
    }

    public static void main(String[] args) {
        License l1 = new License("Jayesh", "y", 19, 0);
        validation(l1);

        License l2 = new License("Taneeshq", "Y", 18, 0);
        validation(l2);
        
        License l3 = new License("Pratik", "N", 19, 0);
        validation(l3);

        License l4 = new License("Aryan", "Y", 19, 1);
        validation(l4);
    }
}
