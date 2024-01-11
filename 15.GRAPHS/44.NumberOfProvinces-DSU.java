 class DisjointSetUnion{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    DisjointSetUnion(int n){
        for(int i=0;i<n;i++){
            size.add(i,1);
            parent.add(i,i);
        }
    }

    public int getUltimateParent(int node){
        if(node == parent.get(node))return node;
        int par = parent.get(node);

        int sa = getUltimateParent(par);
        parent.set(node , sa);
        return sa;
    }
    public void Union( int x , int y ){
        int parx = getUltimateParent(x);
        int pary = getUltimateParent(y);

        int size_parx = size.get(parx);
        int size_pary = size.get(pary);

        if(size_parx> size_pary){
             size.set(parx , size_parx+size_pary);
             parent.set(pary , parx);
        }
        else{
              size.set(pary , size_parx+size_pary);
             parent.set(parx , pary);
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
         
         DisjointSetUnion dsu = new DisjointSetUnion(n);

         for(int i=0;i< n ;i++){
             for(int j=0;j<n;j++){
                 if(isConnected[i][j]==1){
                     int parx = dsu.getUltimateParent(i);
                     int pary  = dsu.getUltimateParent(j);

                     if(parx != pary)dsu.Union(i,j);
                 }
             }
         }

         int count=0;
         for(int i=0;i<n;i++){
             if(dsu.getUltimateParent(i)==i)count++;
         }
         return count;

    }
}
