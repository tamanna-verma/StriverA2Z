//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int src) {
          int []distance = new int [n];
        Arrays.fill(distance , 100000000);
        distance[src]=0;

        for(int i=0;i<n-1;i++){
            
            for(int j=0;j<edges.size();j++){
                int from = edges.get(j).get(0);
                int to = edges.get(j).get(1);
                int weight = edges.get(j).get(2);

                int olddistance= distance[from];
                if(distance[from]!=100000000){
                   int newdistance = olddistance+weight;
                   if(distance[to]>newdistance) distance[to]=newdistance;
                }
            }
            //if in the nth iteration ,
            // the value in distance array is still decreasing then there is a negative cycle 
            // there is no problem will be negative edge , problem is wiht negative cycles
            // because they keep on reducing
        }
            for(int k=0;k<edges.size();k++){
                int from = edges.get(k).get(0);
                int to = edges.get(k).get(1);
                int weight = edges.get(k).get(2);

               int olddistance= distance[from];
               
                   int newdistance = olddistance+weight;
                   if( distance[to] != 100000000 && distance[to]>newdistance){
                      int ans[]=new int[1];
                      ans[0]=-1;
                      return ans;
                   }
                }
                
           
            
             return distance;
           
    }
}
