import java.util.*;
import java.io.*;
public class SubMatricesSum
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        String[] s1=br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        ArrayList<Integer> ar;
        for(int i=0;i<n;i++)
        {
            ar = new ArrayList<Integer>();
            s1 = br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                ar.add(Integer.parseInt(s1[j]));
            }
            A.add(ar);
        }
        long sum = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                sum+=A.get(i).get(j)*(i+1)*(j+1)*(n-i)*(m-j);
            }
        }
        System.out.println(sum);
    }
}