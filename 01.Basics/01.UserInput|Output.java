//WAY 1

import java.util.Scanner;
public class Solution {
    
    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);
       String str = scan.next();
       char c = str.charAt(0);
       if(c>='A' && c<='Z')System.out.println("1");
       else if ( c >='a' && c<='z')System.out.println("0");
       else System.out.println("-1");
    }
}


//WAY 2 

// Character.isLetter 
// Character.isUpperCase

import java.util.Scanner;
// import java.util.Character;
public class Solution {
    
    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);
       String str = scan.next();
       char c = str.charAt(0);
       if(Character.isUpperCase(c))System.out.println("1");
       else if ( Character.isLowerCase(c))System.out.println("0");
       else System.out.println("-1");
    }
}

// Character.isLetter 
// Character.isUpperCase

