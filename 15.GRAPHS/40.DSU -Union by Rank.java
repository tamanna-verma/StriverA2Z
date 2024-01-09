import java.util.*;
class DataSetUnion{

    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent= new ArrayList<>();

    DataSetUnion(int n){
      for(int i=0;i<n+1;i++){
        rank.add(0);
        parent.add(i);
      }
    }
     
    public int getUltimateParent(int node){
        if(parent.get(node)==node)return node ;
        else {
            int ul_p= getUltimateParent(parent.get(node));
            return ul_p;
        }

    }
    public void Union (int u , int v){
        int ulp_u= getUltimateParent(u);
        int ulp_v= getUltimateParent(v);
        int rank_ulp_u=rank.get(ulp_u);
        int rank_ulp_v=rank.get(ulp_v);
        if(rank_ulp_u>rank_ulp_v){
            parent.set(ulp_v,ulp_u);
        }
        else  if(rank_ulp_v>rank_ulp_u){
            parent.set(ulp_u,ulp_v);
        }
        else { // if they have equal ranks
          parent.set(ulp_u,ulp_v);
          rank.set(ulp_u,rank_ulp_u++);
        }
    }
    
}
class dsa{
    public static void main(String[]args){
    DataSetUnion dsu = new DataSetUnion(7);
    dsu.Union(1,2);
    dsu.Union(2,3);
    dsu.Union(4,5);
    
    int ulpu= dsu.getUltimateParent(4);
    int ulpv= dsu.getUltimateParent(2);

    if(ulpu==ulpv)System.out.println("same component");
    else System.out.println("different component");

    dsu.Union(2,4);
      ulpu= dsu.getUltimateParent(4);
      ulpv= dsu.getUltimateParent(2);
       if(ulpu==ulpv)System.out.println("same component");
    else System.out.println("different component");

    }
}
