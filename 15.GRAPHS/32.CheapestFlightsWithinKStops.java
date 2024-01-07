class QPair{
     int stops ;
     int node ;
     int price;
    QPair(int stops , int node , int price){
        this.stops=stops;
        this.node=node;  
        this.price=price;
    }
    
}

class graphPair{
    int node ;
    int weight;
    graphPair(int node , int weight){
        this.node= node;
        this.weight= weight;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // PriorityQueue<QPair> queue= new PriorityQueue<>(Comparator.comparingInt(pair -> pair.price));
        
        Queue<QPair> queue= new LinkedList<>();
        queue.add(new QPair(0 ,src , 0));
        
        int distance[]= new int [n];
        
        for(int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        ArrayList<ArrayList<graphPair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<graphPair>());
        }
        
        for(int i=0;i< flights.length;i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price= flights[i][2];
            
            graph.get(from).add(new graphPair(to , price));
        }
        
        
       
        while(!queue.isEmpty()){
            
           QPair  removed= queue.remove();
            int stops = removed.stops;
            int node= removed.node;
            int price= removed.price;
            
            // if(node==dst)return price;
           
            
            for(int i=0;i<graph.get(node).size();i++)
            {
                
                graphPair curr= graph.get(node).get(i);
                int newnode=curr.node;
                int newprice=curr.weight;
                
                int lowerprice = Math.min(distance[newnode], price + newprice);
                
                if(stops>k)continue;
                if( distance[newnode]> price + newprice )
                {
                     distance[newnode]= lowerprice;
                    queue.add(new QPair(stops+1 , newnode , lowerprice));
                    
                }
               
            }
            
            
        }
        // for(int i=0;i<distance.length;i++){
        //     System.out.println(distance[i]);
        // }
       if(distance[dst]!=Integer.MAX_VALUE) return distance[dst];
        else return -1;
        
    }
}
