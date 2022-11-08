import java.util.Scanner;
public class CWH19_practiceSet
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
//        Question 1 --> Throw an error

//        Question 2 --> Program to find out whether a student is pass or fail.
//            If it requires total 40% and at least 33% in each subject to pass.
//            assume 3 subjects and take marks as an input from the user.

        System.out.println("Question 2 -->");
        System.out.print("Enter marks for 3 subjects each (100m): ");
        byte m1 = sc.nextByte();
        byte m2 = sc.nextByte();
        byte m3 = sc.nextByte();

        float avg = (m1+m2+m3)/3.0f;

        System.out.println("Your overall percentage is : "+ avg);

        if(avg>=40 && m1>=33 && m2>=33 && m3>=33)
        {
            System.out.println("Congratulations, You have been selected.");
        }
        else
        {
            System.out.println("Sorry, You have been not promoted.");
        }

//        Question 3 --> Calculate income tax paid by an user to the government
//            as per the slabs mentioned below
//            income slab --> 2.25 - 5.0L     tax --> 5%
//            income slab --> 5.0 - 10.0L     tax --> 20%
//            income slab --> above 10.0L     tax --> 30%
//            note that there is no tax below 2.5L.


        System.out.println("Question 3 -->");
        float tax = 0.0f;
        System.out.print("enter Income : ");
        float income = sc.nextFloat();
        if(income<2.5f)
        {
            tax = tax + 0.0f;
        }
        else if(income>=2.5f && tax<5.0f)
        {
            tax = tax + 0.05f* (income - 2.5f);
        }
        else if(income>=5.0f && tax<10.0f)
        {
            tax = tax + 0.05f* (5.0f - 2.5f);
            tax = tax + 0.05f* (income - 5.0f);
        }
        else if(income>=10.0f)
        {
            tax = tax + 0.05f* (5.0f - 2.5f);
            tax = tax + 0.05f* (10.0f - 5.0f);
            tax = tax + 0.05f* (income - 10.0f);
        }
        System.out.println("Tax = " + tax);

//        Question 4 --> Print weekdays according to numbers.
        System.out.println("Question 4 -->");
        System.out.print("enter the number of weekday : ");
        int day = sc.nextInt();
        switch (day)
        {
            case 7 -> System.out.println("Sunday");
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            default -> System.out.println("invalid day!.");
        }

//        Question 5 --> Program to find the type of website.
//        .com = commercial website.
//        .org = organisation website.
//        .in = indian website.

        System.out.print("enter the website : ");
        String web = sc.next();
        if(web.endsWith(".org"))
        {
            System.out.println("this is a organisation website.");
        }
        else if(web.endsWith(".com"))
        {
            System.out.println("this is a commercial website.");
        }
        else if(web.endsWith(".in"))
        {
            System.out.println("this is a Indian website.");
        }
        else
        {
            System.out.println("invalid input!.");
        }
    }
}
