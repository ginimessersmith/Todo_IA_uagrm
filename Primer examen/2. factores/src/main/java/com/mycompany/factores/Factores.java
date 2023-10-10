/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factores;

import java.util.LinkedList;

/**
 *
 * @author PAZ
 */
public class Factores {

    public static void main(String[] args) {
        
        LinkedList<Integer> L1=new LinkedList();
        factores(L1,6,1);
        
        System.out.println("Lo hicimos!");
    }
   
    public static boolean iguales(LinkedList<Integer>L1){
        boolean s=true;
        int primero=L1.getFirst();
        for(int i=1; i<L1.size();i++){  
            if(primero!=L1.get(i))
                s=false;
        }
        return s;
    }
    
    public static boolean diferentes(LinkedList<Integer>L1){
        boolean s=true;
        
        for(int i=0; i<L1.size(); i++){  
            int primero=L1.get(i);
            for(int j=i+1; j<L1.size();j++){
            if(primero==L1.get(j))
                s=false;
            }
        }
        return s;
    }
    
    public static void factores(LinkedList<Integer> L1, int n, int i) {

        int p = multiplicar(L1);
        if (p > n) {
            return;
        }
        if (p == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n) {
            L1.add(k);
            if (L1.getLast() == 1) {
                factores(L1, n, k + 1);
            } else {
                factores(L1, n, k);
            }
            L1.removeLast();
            k++;
        }
    }

    public static int multiplicar(LinkedList<Integer> L1) {
        int s = 1;
        for (int i = 0; i < L1.size(); i++) {
            s = s * L1.get(i);
        }
        return s;
    }
    /*public static boolean factor(LinkedList<Integer>L1, int n){
        boolean a=false;
        for(int i=0; i<L1.size();i++){
            if(n%L1.get(i)==0)
                a=true;
            else
                return false;
        }
        return a;
    }
    //1) Encontrar los sumandos posibles en una Lista.
        public static void factores(LinkedList<Integer> L1, int n, int i){
        boolean fac=factor(L1,n);
        
        if(fac){
            System.out.println(L1);
            return;            
        }
        if (i>n)return;
        for(int k=i; k<=n;k++){
            
            L1.add(k);
            
            factores(L1,n,k+1);
            L1.removeLast();
        }
    }*/
}
