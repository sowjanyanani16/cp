public class Fib{
    public static void main(String[] args)
    {
        int a=1,b=1,c;
        while(true)
        {
            c=a+b;
            if(c>(int)1e9)
            break;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
    }
}