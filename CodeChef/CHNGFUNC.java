import java.util.Scanner;

class CHNGFUNC
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans=0;
        for(int x=1;x<=a;x++)
        {
            ans = ans + (long)Math.floor(Math.sqrt((long)x*x+b)) - x;
        }
        System.out.println(ans);
    }
}