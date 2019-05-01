import java.io.*;
import java.util.*;

public class RotateMatrix
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringBuilder sb = new StringBuilder("");
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        String[] s1;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> ar;
        for(int i=0;i<n;i++)
        {
            ar = new ArrayList<Integer>();
            s1 = br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                ar.add(Integer.parseInt(s1[j]));
            }
            a.add(ar);
        }
        int t1,t2,t3,t4;
        for(int i=0;i<n/2;i++)
        {
            for(int j=i;j<n-i-1;j++)
            {
                t1=a.get(i).get(j);
                t2=a.get(j).get(n-1-i);
                t3=a.get(n-1-i).get(n-1-j);
                t4=a.get(n-1-j).get(i);
                a.get(j).set(n-1-i,t1);
                a.get(n-1-i).set(n-1-j,t2);
                a.get(n-1-j).set(i,t3);
                a.get(i).set(j,t4);
            }
        }
        System.out.println("------------------------------");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}                                                                                                                                                    