//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

 class Pair{
    int weight ;
    int from;
     int to ;
     Pair(int weight , int from , int to ){
         this.weight=weight;
         this.from = from ;
          this.to = to;

     }
}
 class DisjointSetUnion{
    ArrayList<Integer> size = new ArrayList();
    ArrayList<Integer> parent = new ArrayList();

    DisjointSetUnion(int n){
      for(int i=0;i<n;i++){
          size.add(i,0);
          parent.add(i,i);
      }
    }

    public int getUltimateParent( int x){
        if(x==parent.get(x))return x;

        int sa= getUltimateParent(parent.get(x));
        parent.set(x,sa);
        return sa;
    }

    public void union(int x , int y){
        int parx = getUltimateParent(x);
        int pary = getUltimateParent(y);

        int sz_par_x = size.get(parx);
        int sz_par_y = size.get(pary);

        if(sz_par_x>sz_par_y){
            parent.set(pary,parx);
            size.set(parx,parx+pary);
        }
        else if(sz_par_y>=sz_par_x){
            parent.set(parx , pary);
             size.set(pary,parx+pary);
        }
        
        
    }
}

class Solution{
	static int spanningTree(int n, int E, int edges[][]){
	    ArrayList<Pair> al = new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            al.add(new Pair(weight , from , to ));
        }
        Collections.sort(al,Comparator.comparingInt(Pair ->Pair.weight));
          
          int totalweight = 0;
     DisjointSetUnion dsu = new DisjointSetUnion(n);
           for(int i=0;i<edges.length;i++){
          Pair popped = al.get(i);
          int wt = popped.weight;
          int fm = popped.from;
           int dest= popped.to;

           if(dsu.getUltimateParent(fm)!=dsu.getUltimateParent(dest)){
               dsu.union(fm, dest);
               totalweight+=wt;
           }
        }
      return totalweight;
	}
}
