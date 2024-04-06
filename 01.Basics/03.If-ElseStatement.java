//way 1
public class Solution {
    public static String compareIfElse(int a, int b) {
     
     if(a>b)return("greater");
     else if(a<b)return("smaller");
     else return("equal");
      
    }
}

//WAY 2
public class Solution {
    public static String compareIfElse(int a, int b) {
     
return (a>b)?"greater":(a<b)?"smaller":"equal";
      
    }
}
