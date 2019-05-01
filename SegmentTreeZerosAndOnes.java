import java.io.*;
import java.util.*;
public class SegmentTreeZerosAndOnes
{
    static int[] arr;
    static int[] tree;

    static void build(int node,int start,int end)
    {
        if(start == end)
        {
            tree[node] = arr[start];
        }
        else
        {
            int mid = (start+end)/2;
            build(2*node,start,mid);
            build(2*node+1,mid+1,end);
            tree[node]=tree[2*node]+tree[2*node+1];
        }
    }

    static void update(int node,int start,int end,int index)
    {
        if(start == end)
        {
            tree[node] = 0;
            arr[index] = 0;
        }
        else
        {
            int mid = (start+end)/2;
            if(index>=start && index<=mid)
                update(2*node,start,mid,index);
            else
                update(2*node+1,mid+1,end,index);
            tree[node]=tree[2*node]+tree[2*node+1];
        }
    }

    static int query(int node,int start,int end,int actual)
    {
        if(start==end)
            return start;
        int mid = (start+end)/2;
        if(tree[2*node]>=actual)
            return query(2*node,start,mid,actual);
        else
            return query(2*node+1,mid+1,end,actual-tree[2*node]);
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        Arrays.fill(arr,1);
        arr[0]=0;
        tree = new int[4*n];
        build(1,1,n);

        int q = Integer.parseInt(br.readLine());
        while(q-->0)
        {
            String[] s = br.readLine().split(" ");
            if(Integer.parseInt(s[0])==0)
            {
                update(1,1,n,Integer.parseInt(s[1]));
            }
            else
            {
                if(tree[1]<Integer.parseInt(s[1]))
                    sb.append("-1").append("\n");
                else
                    sb.append(query(1,1,n,Integer.parseInt(s[1]))).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}