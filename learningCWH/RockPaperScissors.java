import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        System.out.println("Enter Your choice in numbers : \n1.Rock\n2.Paper\n3.Scissors\nYour choice is : ");
        int user = sc.nextInt();
        int comp = ra.nextInt(3) + 1;
        if(user == comp)
        {
            System.out.println("it's a tie.");
        }
        else
        {
            if(user == 1)
            {
                System.out.println("user choice = Rock.");
                if(comp == 2)
                {
                    System.out.println("compiler choice = Paper.\nPaper covers the rock and compiler wins.");
                }
                else if(comp == 3)
                {
                    System.out.println("compiler choice = scissor.\nRock break the scissor and you win.");
                }
            }
            else if(user == 2)
            {
                System.out.println("user choice = Paper.");
                if(comp == 1)
                {
                    System.out.println("compiler choice = Rock.\nPaper covers the rock and you win.");
                }
                else if(comp == 3)
                {
                    System.out.println("compiler choice = scissor.\nscissor cut the paper and compiler wins.");
                }
            }
            else if(user == 3)
            {
                System.out.println("user choice = Scissor.");
                if(comp == 1)
                {
                    System.out.println("compiler choice = Rock.\nRock breaks the scissor and compiler wins.");
                }
                else if(comp == 2)
                {
                    System.out.println("compiler choice = Paper.\nScissor cuts the paper and you win.");
                }
            }
            else
            {
                System.out.println("Invalid choice!.");
            }
        }
    }
}