/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sumandos;

import java.util.LinkedList;

/**
 *
 * @author PAZ
 */
public class Sumandos {

    public static void main(String[] args) {
        
        LinkedList<Integer> L1=new LinkedList();
        sumandos(L1,3,1);
        
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
    public static int sumar(LinkedList<Integer>L1){
        int s=0;
        for(int i=0; i<L1.size();i++){
            s=s+L1.get(i);
        }
        return s;
    }
    //1) Encontrar los sumandos posibles en una Lista.
        public static void sumandos(LinkedList<Integer> L1, int n, int i){
        int sum=sumar(L1);
        if (sum>n)return;
        if(sum==n){
            
            System.out.println(L1);
            return;
            
        }
        for(int k=i; k<=n;k++){
            L1.add(k);
            sumandos(L1,n,k);
            L1.removeLast();
        }
    }
    
// 2)Encontrar todos los sumandos posibles diferentes en una Lista.
    public static void sumandosDiferentes(LinkedList<Integer> L1, int n, int i){
        int sum=sumar(L1);
        if (sum>n)return;
        if(sum==n){
            if(diferentes(L1)){
            System.out.println(L1);
            return;
            }
        }
        for(int k=i; k<=n;k++){
            L1.add(k);
            sumandosDiferentes(L1,n,k);
            L1.removeLast();
        }
    }
 // 3) Encontrar todos los sumandos posibles iguales en una Lista.   
        public static void sumandosIguales(LinkedList<Integer> L1, int n, int i){
        int sum=sumar(L1);
        if (sum>n)return;
        if(sum==n){
            if(iguales(L1)){
            System.out.println(L1);
            return;
            }
        }
        for(int k=i; k<=n;k++){
            L1.add(k);
            sumandosIguales(L1,n,k);
            L1.removeLast();
        }
    }
//4) Encontrar todos los sumandos primos posibles en una Lista.
        public static boolean esPrimo(int n){
            if (n==1||n==2)
                return true;
            else{
                int d=n-1;
                while (d>1){
                    if (n%d==0)
                        return false;
                    d--;
                }
                return true;
            }                
        }
        public static boolean todosPrimos(LinkedList<Integer>L1){
        
        for(int i=0; i<L1.size();i++){  
            int primero=L1.get(i);
            if(!esPrimo(primero))
                return false;
        }
        return true;
    }
        
        public static void sumandosPrimos(LinkedList<Integer> L1, int n, int i){
        int sum=sumar(L1);
        if (sum>n)return;
        if(sum==n){
            if(todosPrimos(L1)){
            System.out.println(L1);
            return;
            }
        }
        for(int k=i; k<=n;k++){
            L1.add(k);
            sumandosPrimos(L1,n,k);
            L1.removeLast();
        }
    }
        
}