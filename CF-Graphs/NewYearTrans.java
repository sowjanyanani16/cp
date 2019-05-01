import java.util.*;
// class Graph
// {
//     int n;
//     ArrayList<Integer> arr[];
    
//     Graph(int n)
//     {
//         this.n=n;
//         arr=new ArrayList[n+1];
//         for(int i=0;i<=n;i++)
//         arr[i]=new ArrayList<>();
//     }

//     boolean bfs(int root)
//     {
//         return false;
//     }

//     boolean dfs(int root)

//     {
//         return false;
//     }
// }
public class NewYearTrans
{
    public static void main(String[] args) {
        Map<String,Map<String,Set<String>>> hm = new HashMap<>();
        hm.put("abc",()->{
            HashMap<String,Set<String>> h1=new HashMap<String,Set<String>>();
            h1.put("bc",()->{
                Set<String> s1 = new HashSet<String>();
                s1.add("abdc");
                s1.add("adfshl");
                return s1;
            });
            return h1;
        });
    }
}