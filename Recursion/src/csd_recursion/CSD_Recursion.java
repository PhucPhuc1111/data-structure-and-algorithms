/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_recursion;

/**
 *
 * @author Admin
 */
public class CSD_Recursion {


    static int fractorial(int n) 
    {if (n <= 1) {return 1;} 
     else {return n * fractorial(n - 1);}
    }

    static void tail(int n) 
    {if (n > 0) {System.out.print(n);
     tail(n - 1);
     System.out.print(n);}
    }

    static String ex237(int n) {
     if (n <= 0) return ""; 
     return (ex237(n-3) + n + ex237(n-2) + n); 
    }
    
    static int sum(int n)
    {if(n <= 1) return 1;
     else return n + sum(n - 1);
    }
    
    static int min(int a[], int n) 
    {if(n == 1) return a[0];
     if(a[0] > a[n-1]) a[0] = a[n-1];
     return min(a,n - 1);
    }
    
    static boolean isPlindrome(char c[], int n) 
    {if(n == 1) return true;
     int m = c.length;
     if(c[m - n] != c[n-1]) return false;
     else {return isPlindrome(c, n-1);}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         System.out.println(fractorial(5));
        System.out.println(sum(7));//28
        int [] a = {7, 2, 10, 1, -9, 2};
        System.out.println(min(a,a.length));
        char [] c = "radar".toCharArray();
        System.out.println(isPlindrome(c, c.length));
    }
    
}
