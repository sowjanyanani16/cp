import java.io.*;
class SegmentTree
{
    static int[] arr;
    static int[] tree;
    static int n;

    static void build(int node,int start,int end)
    {
        if(start==end){
        tree[node]=arr[start];
        }
        else{
            int mid = (start+end)/2;
            build(2*node,start,mid);
            build(2*node+1,mid+1,end);
            tree[node] = (tree[2*node]<tree[2*node+1])?tree[2*node]:tree[2*node+1];
        }
    }
    
    static int query(int node,int start,int end,int lo,int hi)
    {
        if(start>hi || end<lo)
        return Integer.MAX_VALUE;
        else if(lo <= start && end <= hi)
        {
            return tree[node];
        }
        int mid = (start+end)/2;
        int p1=query(2*node,start,mid,lo,hi);
        int p2=query(2*node+1,mid+1,end,lo,hi);
        return (p1<p2)?p1:p2;
    }

    static void update(int node,int start,int end,int index,int val)
    {
        if(start==end)
        {
            tree[node]=val;
            arr[index]=val;
        }
        else
        {
            int mid = (start+end)/2;
            if(index>=start && index<=mid)
            update(2*node,start,mid,index,val);
            else
            update(2*node+1,mid+1,end,index,val);
            tree[node] = (tree[2*node]<tree[2*node+1])?tree[2*node]:tree[2*node+1];
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        arr = new int[n+1];
        for(int i=1;i<=n;i++)
        arr[i] = Integer.parseInt(s2[i-1]);
        tree = new int[2*n];
        build(1,1,n);
        while(q-->0)
        {
            String[] s3 = br.readLine().split(" ");
            if(s3[0].charAt(0)=='q')
            {
                sb.append(query(1,1,n,Integer.parseInt(s3[1]),Integer.parseInt(s3[2]))).append("\n");
            }
            else
            {
                update(1,1,n,Integer.parseInt(s3[1]),Integer.parseInt(s3[2]));
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}