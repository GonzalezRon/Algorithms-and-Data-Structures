/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.DataStructures;

import static java.lang.Integer.max;

/**
 *
 * @author gonzalezron
 */
public class DynamicProgramming {
    
    
    public int CutRod(int [] p, int n){
        //check rod length      
        if (n == 0) return 0; 
        //go through the size and get the Max price recursively
        // max revenue is q
            int q = -1;
            //unknown value instantiated with value < zero 
            //counter for prices is from n-1 index 
        for ( int i = 1;  i <= n;  i++){
            //prices start from 1 to n however index is 0 to n-1
            q = max(q, p[i-1] + CutRod(p,n-i));
            }
        
         return q;
    }
    
    /** 
     * @param p array of prices 
     * @param n size of rod
     * 
     * @return revenue from aux method 
     */
    public int Memoized_Cut_Rod(int [] p, int n){
        //Top-down memoiziation
        //revenue 
        int r [] = new int [n + 1]; 
        //loop through the revenue array 
        for (int i = 0; i <= n; i++ ){                                      //size of rod plus one for zero index
            r[i]= -1;                                                       //loads revenue array
        //the revenue array is initially loaded with unknown elements    
        }
        //returns revenue
        return Memoized_Cut_Rod_Aux(p,n,r);  
        
    }
    
    /**
     * 
     * @param p
     * @param n
     * @param r 
     * 
     * @return revenue
     */
    public int Memoized_Cut_Rod_Aux(int [] p, int n, int [] r){
        //create the value for max revenue 
        int q; 
        //top down check revenue from size n cut
        if(r[n] > 0){
        //return largest revenue for the cut/price reference
            return r[n]; 
        }
        
        //return 0 revenue if size is 0
        if (n == 0){
            q = 0;
        }
        //new quantity for Max
        else
            q = -1; 
        //for loop calculates MAX profits 
        // max profit of smaller cuts top down! --> n - i
        for (int i = 1; i <= n; i++){
           q = max(q, p[i-1] + Memoized_Cut_Rod_Aux(p, n-i,r));
           //*!* notice p[i-1] because price-array  start from index of zero
        }
        
        r[n] = q;
        
        return q; 
    }
    
    
    
    public int Bottom_Up_Cut_Rod(int [] p, int n){
        //revenue array is the size of Rod plus 1 for zero index
        int [] r = new int[n+1]; 
        //initialize first profit index to 0 
        r[0] = 0;
        // j is 1 to n 
        for (int j = 1; j <= n; j++){
            int q = -1;
            //intialize max quantity with unknown value
            //for i is 1 to j "Solves subproblems of j ; -1 to fit revenue array
            for (int i = 1; i < j; i++){   
            //max quantity is the sum of revenue plus price 
                q = max(q, p[i] + r[(j-i)-1]);
            } 
            //max revenue is then added revenue array
            r[j] = q;
        }
        //return the revenue for the cut of size of n
        return r[n];
    }
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        //create a method that cuts the rod input of size n
        //input param array of prices and size of rod 
        DynamicProgramming dm = new DynamicProgramming(); 
        
        //ten prices for a rod of length of size n 
        int [] prices = {1,5,8,9,10,17,17,20,24,30};
        
        int [] rodSizes = {5,10,4}; 
        
        
        for (int e : rodSizes){
            
        //int k = dm.CutRod(prices, e); 
        //int k = dm.Memoized_Cut_Rod(prices, e);
        int k = dm.Bottom_Up_Cut_Rod(prices, e);
        
          System.out.println(k);
        }
        
        
        
        
    }

    
}
