public class BreakAndContinueStatements {
    public static void main(String[] args) {
        for(int i = 0; i < 5;i++)
        {
            if(i == 3)
            {
                System.out.println("break statement executed..");
                break;      //break the loop and control comes out of the loop.
            }
            System.out.println(i);
        }
        System.out.println("for loop ends here\n");
        for(int i = 0;i < 5;i++)
        {
            if(i==3)
            {
                System.out.println("continue statement executed..");
                continue;   //ignore the statements below this statement in a loop.
            }
            System.out.println(i);
        }
        System.out.println("for loop ends here\n");
    }
}
