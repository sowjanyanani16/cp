import java.io.*;
import java.util.TreeSet;

class ArrayRebuild
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        TreeSet<Long> ts = new TreeSet<Long>();
        long ans = 0,x,l=0,h=0;
        for(int i=0;i<n;i++)
        {
            x=Long.parseLong(s[i]);
            ts.add(x);
            if(ts.lower(x)==null)
                l=0;
            else 
                l=ts.lower(x);
            if(ts.higher(x)==null)
                h=0;
            else
                h=ts.higher(x);
            ans += l*h;
            //System.out.println(x+" "+l+" "+h);
        }
        System.out.println(ans);
    }
}