/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mochiladoble;

import java.util.LinkedList;

/**
 *
 * @author PAZ
 */
public class MochilaDoble {

    public static void main(String[] args) {
        
        LinkedList<LinkedList> Lmochila=new LinkedList();   //mochila
        LinkedList<LinkedList> Lobjetos=new LinkedList();   // lista de objetos
        LinkedList<Integer> L1=new LinkedList(); //objeto 1
        LinkedList<Integer> L2=new LinkedList(); 
        LinkedList<Integer> L3=new LinkedList(); 
        LinkedList<Integer> L4=new LinkedList(); 
        LinkedList<Integer> L5=new LinkedList(); 
        
        /* TABLA DE ACLARACION
            1 = ROJO
            2 = AZUL
            3 = AMARILLO
        */
        //     PESO        COLOR
        L1.add(1);L1.add(1);
        L2.add(3);L2.add(1);
        L3.add(2);L3.add(2);
        L4.add(4);L4.add(2);
        L5.add(5);L5.add(3);
        
        //cargamos los objetos
        Lobjetos.add(L1);
        Lobjetos.add(L2);
        Lobjetos.add(L3);
        Lobjetos.add(L4);
        Lobjetos.add(L5);
        
        mochilaDiferenteColorPeso(Lobjetos,Lmochila,8,0);
        
        System.out.println("Lo hicimos!");
    }
     public static int sumar(LinkedList<LinkedList>Lmochila){
        int s=0;
       LinkedList<Integer> L1;
        for(int i=0; i<Lmochila.size();i++){
            L1=Lmochila.get(i);
            s=s+L1.getFirst();
        }
        return s;
    }

    
 // 1) Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila.
    
    public static void mochila(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        System.out.println(L2);
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochila(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
   // 2) Encontrar todas las combinaciones de pesos de objetos que se pueden 
   //    transportar en la mochila del mismo color.
    public static boolean mismoColor(LinkedList<LinkedList>Lmochila){
        
        LinkedList<Integer>L1,L2;
        L1=Lmochila.getFirst();
        int color=L1.getLast();
        for(int i=1; i<Lmochila.size();i++){  
            L2=Lmochila.get(i);
            if(color!=L2.getLast())
                return false;
        }
        return true;
    }
   
    public static void mochilaMismoColor(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        
        if(L2.size()<=1){
            System.out.println(L2);
        }else{
            if(mismoColor(L2))
                System.out.println(L2);
        }
                
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaMismoColor(L1,L2,max,k+1);
            L2.removeLast();
        }
    }

// 3) Encontrar todas las combinaciones de pesos de objetos que se pueden 
//    transportar en la mochila, todos de colores diferentes.
    public static boolean distintoColor(LinkedList<LinkedList>Lmochila){
        LinkedList<Integer>L1,L2;       
        for(int i=0; i<Lmochila.size(); i++){  
            L1=Lmochila.get(i);
            int color=L1.getLast();
            for(int j=i+1; j<Lmochila.size();j++){
                L2=Lmochila.get(j);    
                    if(color==L2.getLast())
                        return false;
            }
        }
        return true;
    }
    public static void mochilaDiferenteColor(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        
        if(L2.size()<=1){
            System.out.println(L2);
        }else{
            if(distintoColor(L2))
                System.out.println(L2);
        }
                
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaDiferenteColor(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
// 4) Encontrar todas las combinaciones de pesos de objetos que se pueden 
//    transportar en la mochila, que sean del mismo peso y el mismo color.
    public static boolean mismoPeso(LinkedList<LinkedList>Lmochila){
        LinkedList<Integer>L1,L2;
        L1=Lmochila.getFirst();
        int peso=L1.getFirst();
        for(int i=1; i<Lmochila.size();i++){  
            L2=Lmochila.get(i);
            if(peso!=L2.getFirst())
                return false;
        }
        return true;
    }
    
    public static void mochilaMismoColorPeso(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        
        if(L2.size()<=1){
            System.out.println(L2);
        }else{
            if(mismoColor(L2)&& mismoPeso(L2))
                System.out.println(L2);
        }
                
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaMismoColorPeso(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
// 5) Encontrar todas las combinaciones de pesos de objetos que se pueden 
//    transportar en la mochila que sean de pesos diferentes y colores diferentes.    
    public static boolean distintoPeso(LinkedList<LinkedList>Lmochila){
        LinkedList<Integer>L1,L2;       
        for(int i=0; i<Lmochila.size(); i++){  
            L1=Lmochila.get(i);
            int Peso=L1.getFirst();
            for(int j=i+1; j<Lmochila.size();j++){
                L2=Lmochila.get(j);    
                    if(Peso==L2.getFirst())
                        return false;
            }
        }
        return true;
    }
    public static void mochilaDiferenteColorPeso(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        
        if(L2.size()<=1){
            System.out.println(L2);
        }else{
            if(distintoColor(L2)&& distintoPeso(L2))
                System.out.println(L2);
        }
                
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaDiferenteColorPeso(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
// 6)   Plantear al menos 3 consultas adicionales interesantes.
    
    // 6.1 Dado un color muestra las posibles convinaciones que entren en la mochila  
    public static void mochilaDeUnColor(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i, int color){
        int sum=sumar(L2);
        if (sum>max) return;
               
        if(mismoColor2(L2, color))
            System.out.println(L2);
        
                
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaDeUnColor(L1,L2,max,k+1,color);
            L2.removeLast();
        }
    }
    public static boolean mismoColor2(LinkedList<LinkedList>Lmochila, int color){
        
        LinkedList<Integer>L1;
        for(int i=0; i<Lmochila.size();i++){  
            L1=Lmochila.get(i);
            if(color!=L1.getLast())
                return false;
        }
        return true;
    }
    // 6.2 Mostrar las convinaciones posibles de pesos primos
    public static void mochilaPrimos(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        
        if(pesosPrimos(L2)){
            System.out.println(L2);
        }
        
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaPrimos(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
    public static boolean pesosPrimos(LinkedList<LinkedList>Lmochila){
        LinkedList<Integer>L1;
        for(int i=0; i<Lmochila.size();i++){  
            L1=Lmochila.get(i);
            int peso=L1.getFirst();
            if(!esPrimo(peso))
                return false;
        }
        return true;
    }
    
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
    // 6.3 Mostrar las posibles convinaciones de objetos de colores primarios
    public static boolean colorPrimario(LinkedList<LinkedList>Lmochila){
        LinkedList<Integer>L1;
        for(int i=0; i<Lmochila.size();i++){  
            L1=Lmochila.get(i);
            int color=L1.getLast();
            if(color>3)
                return false;
        }
        return true;
    }
    public static void mochilaColorPrimario(LinkedList<LinkedList>L1,LinkedList<LinkedList>L2, int max, int i){
        int sum=sumar(L2);
        if (sum>max) return;
        
        if(colorPrimario(L2)){
            System.out.println(L2);
        }
        
        for (int k=i; k<L1.size(); k++){
            L2.add(L1.get(k));
            mochilaColorPrimario(L1,L2,max,k+1);
            L2.removeLast();
        }
    }
    }


