import java.util.*;
class DataSetUnion{

    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent= new ArrayList<>();

    DataSetUnion(int n){
      for(int i=0;i<n+1;i++){
        size.add(0);
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
        int size_ulp_u=size.get(ulp_u);
        int size_ulp_v=size.get(ulp_v);
        if(size_ulp_u>size_ulp_v){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size_ulp_v + size_ulp_u);
        }
        else  if(size_ulp_v>size_ulp_u){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size_ulp_v + size_ulp_u);
        }
        else { // if they have equal sizes
          parent.set(ulp_u,ulp_v);
          size.set(ulp_u,size_ulp_v + size_ulp_u);
          
        }
    }
    
}
class dsu_size{
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

      dsu.Union(6,0);
   
    ulpu= dsu.getUltimateParent(6);
    ulpv= dsu.getUltimateParent(5);

    if(ulpu==ulpv)System.out.println("same component");
    else System.out.println("different component");

       dsu.Union(5,6);

      ulpu= dsu.getUltimateParent(6);
      ulpv= dsu.getUltimateParent(5);

    if(ulpu==ulpv)System.out.println("same component");
    else System.out.println("different component");


    }
}
