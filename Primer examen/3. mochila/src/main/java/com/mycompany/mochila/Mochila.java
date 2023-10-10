/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mochila;

import java.util.LinkedList;

/**
 *
 * @author PAZ
 */
public class Mochila {
    

    public static void main(String[] args) {
        
        LinkedList<Integer> L1=new LinkedList();
        LinkedList<Integer> L2=new LinkedList();
        L1.add(2);
        L1.add(4);
        L1.add(1);
        L1.add(6);
        mochila(L1,L2,8,0);
        
        System.out.println("Lo hicimos!");
    }
     public static int sumar(LinkedList<Integer>L1){
        int s=0;
        for(int i=0; i<L1.size();i++){
            s=s+L1.get(i);
        }
        return s;
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
    
 // 1) Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila.
    
    public static void mochila(LinkedList<Integer>L1,LinkedList<Integer>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        System.out.println(L2);
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochila(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
// 2) Encontrar todas las combinaciones de pesos diferentes que se pueden transportar en la mochila.
    public static void mochiladiferentes(LinkedList<Integer>L1,LinkedList<Integer>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        if (diferentes(L2)){
            System.out.println(L2);
        }
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
           
            mochiladiferentes(L1,L2,max,k+1);
            L2.removeLast();
        }
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
// 3) Encontrar todas las combinaciones de pesos entre a y b inclusive que se pueden transportar en la mochila.
   public static void mochilaAB(LinkedList<Integer>L1,LinkedList<Integer>L2, int max,int i,int A, int B){
        int sum=sumar(L2);
        if (sum>max) return;
        System.out.println(L2);
        for (int k=i; k<L1.size(); k++){
            int ele=L1.get(k);
            if(ele>=A && ele<=B){
                L2.add(ele);
                mochilaAB(L1,L2,max,k+1,A,B);
                L2.removeLast();
            }
        }
    }
   
// 4) Encontrar las combinaciones de objetos de mayor cantidad de objetos que se pueden transportar..
   public static void mochilaLarga(LinkedList<Integer>L1,LinkedList<Integer>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        if(L2.size()>2)
        System.out.println(L2);
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaLarga(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
// 5) Encontrar las mejores combinaciones que se pueden transportar en la mochila. (Las más próximas a la capacidad de la mochila)
   public static void mochilaProxima(LinkedList<Integer>L1,LinkedList<Integer>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        if(sum >= max-1 && sum <=max)
        System.out.println(L2);
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaProxima(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
}
