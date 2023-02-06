package LabPrograms;

import java.util.Scanner;

class UnderAgeException extends Exception {
    UnderAgeException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Sorry. You must be over 18 years of age to apply for permanent license.";
    }
}

class ValidLLR extends Exception {
    ValidLLR(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Sorry. You must hold a valid learner license to apply for a permanent license.";
    }
}

class NumAccidents extends Exception {
    NumAccidents(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Sorry. You cannot apply for permanent license if you have been in an accident in the last year.";
    }
}

class License {
    String name;
    int age, no_of_cases;
    char gender;
    char validLLR;

    void readData() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name : ");
        name = in.nextLine();
        System.out.print("Enter the age : ");
        age = in.nextInt();
        System.out.print("Enter the gender : ");
        gender = in.next().charAt(0);
        System.out.print("Do you have Valid LLR (Y/N)? : ");
        validLLR = in.next().charAt(0);
        System.out.print("How many number of cases in past one year? : ");
        no_of_cases = in.nextInt();
        in.close();
    }

}

public class TW8_ExceptionHandling {
    static void validateApplicant(License a) {
        try {
            if (a.age < 18)
                throw new UnderAgeException("Underageexception:");
            if (a.validLLR != 'Y')
                throw new ValidLLR("ValidLLRexception:");
            if (a.no_of_cases > 0)
                throw new NumAccidents("Numberofaccidentsexception:");
            System.out.println("Congrats!! Your license is being posted");
        } catch (UnderAgeException e) {
            System.out.println(e.getMessage() + e);
        } catch (ValidLLR e) {
            System.out.println(e.getMessage() + e);
        } catch (NumAccidents e) {
            System.out.println(e.getMessage() + e);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e);
        }
    }

    public static void main(String[] args) {
        License applicant = new License();
        applicant.readData();
        validateApplicant(applicant);
    }
}