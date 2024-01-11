class DisjointSetUnion{

    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent  = new ArrayList<>();

    DisjointSetUnion(int n ){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int getUltimateParent(int node){
        if(node== parent.get(node)){
            return node;
        }
        int sa = getUltimateParent(parent.get(node));
        parent.set(node , sa);
        return sa;
    }

    public void Union(int x , int y){
        int parx = getUltimateParent(x);
        int pary = getUltimateParent(y);

        int size_parx = size.get(parx);
        int size_pary = size.get(pary);

        if(size_parx > size_pary){
         parent.set(pary , parx);
         size.set(parx , size_parx + size_pary);
        }
        else
        {
          parent.set(parx , pary);
          size.set(pary , size_parx + size_pary);
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections)
    {
        int extra=0;
        int needed=0;
         DisjointSetUnion dsu = new DisjointSetUnion(n);
        
         for(int i=0;i<connections.length;i++){
             int x = connections[i][0];
             int y = connections[i][1];

             int up_x = dsu.getUltimateParent(x);
             int up_y = dsu.getUltimateParent(y);

             if(up_x == up_y)extra++;
             else dsu.Union(up_x, up_y);

         }
         
         for(int i=0;i<n;i++){
             if( dsu.getUltimateParent(i) == i ){
                 //System.out.println("ulp of "+ i +" is"+ dsu.getUltimateParent(i));
             needed++;
             }
         }

//System.out.print("needed +=" + needed +" , extras = " +extra);

       needed = needed -1;//needed is no . of components -1 
         if(extra >= needed)return needed;
         return -1;
        // else return -1;
    }
}

// if the extras are equal to the new connections required , then we return the number of extras , else we return -1;
//so now we will be able to find the ultimate parent of x and y 
// now , we will check if the ultimate parent is same , it means it is an extra edge to connect but if the ultimate parent is different , it means , we need to connect them , and if the number of extras , is same as number of components , then we can say that it can be done 

    
