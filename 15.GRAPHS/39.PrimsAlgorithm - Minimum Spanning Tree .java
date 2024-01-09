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


// Usimer function Template for Java
class Pair{
	int weight ;
	int node;
	 int parent;
	 Pair(int weight , int node , int parent){
		 this.weight=weight;
		 this.node=node;
		 this.parent=parent;
	 }
}

class graphPair{
	int node;
	int weight;
	graphPair(int node , int weight){
		this.node=node;
		this.weight=weight;

	}
}
class ansPair{
	int parent;
	int node;
	ansPair(int parent , int node){
		this.parent=parent;
		this.node=node;
	}
}

class Solution{
	static int spanningTree(int n, int E, int edges[][]){
	   ArrayList<ArrayList<graphPair>> graph = new ArrayList();
		for(int i=0;i<n;i++){
			graph.add(new ArrayList<graphPair>());
		}
		for(int i=0;i<edges.length;i++){
        int from = edges[i][0];
		 int to = edges[i][1];
		  int weight = edges[i][2];
		  graph.get(from).add(new graphPair(to, weight));
		  graph.get(to).add(new graphPair(from, weight));
		}
		PriorityQueue<Pair> pq =new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
		int []visited = new int [n];
        pq.add(new Pair(0 , 0 , -1));
        ArrayList<ansPair> ans = new ArrayList<>();
         

		int sum=0;

		while(!pq.isEmpty()){
			Pair popped = pq.remove();
			int weight =popped.weight;
			int node =popped.node;
			int parent = popped.parent;
            
             if(visited[node]!=0)continue;
			   else
			   {
			       if(parent!=-1) ans.add(new ansPair(parent ,node));
		    	   visited[node]=1;
			       sum+=weight;
			       
			   }
			  
              
			  for(int i=0;i<graph.get(node).size();i++){
                 graphPair adjpair = graph.get(node).get(i);
				 int newnode= adjpair.node;
				 int newweight = adjpair.weight;
				 
                 if(visited[newnode]==0)
				 pq.add(new Pair (newweight , newnode , node));//queue me to add krdiya
				 
			  }
		
// 	
		}
		
//. MST	print krake dekh rhe h
// 			for(int i=0;i<ans.size();i++){
// 			System.out.print(ans.get(i).parent +" "+ ans.get(i).node +"-");
// 		}
		return sum;
	}
}
