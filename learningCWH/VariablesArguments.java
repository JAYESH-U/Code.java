public class VariablesArguments {
//    public static int sum(int a,int b)
//    {
//        return a+b;
//    }
//    public static int sum(int a,int b,int c)
//    {
//        return a+b+c;
//    }


//        variable arguments. --> accept any number of arguments.
    public static int sum(int ...arr) {
        int result=0;
        for (int a : arr)
        {
            result+=a;
        }
        return result;
    }
    public static int add(int x,int ...arr) {
        //at least one argument is required now.
        int result=x;
        for (int a : arr)
        {
            result+=a;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("welcome to VarArgs.");
        System.out.println("sum of nothing : " + sum());
        System.out.println("sum of 4 and 5 : " + sum(4,5));
        System.out.println("sum of 4 and 5 and 6 : " + sum(4,5,6));


        System.out.println("add of nothing : " + add(1));
        System.out.println("add of 4 and 5 : " + add(4,5));
        System.out.println("add of 4 and 5 and 6 : " + add(4,5,6));



    }
}
