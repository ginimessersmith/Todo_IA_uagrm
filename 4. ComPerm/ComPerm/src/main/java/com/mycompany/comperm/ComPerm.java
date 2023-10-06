/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.comperm;

import java.util.LinkedList;

/**
 *
 * @author Hp 14
 */
public class ComPerm {

public static void main(String[] args) { // TODO code application logic here 
    LinkedList<Integer> L1 = new LinkedList<>(); 
    LinkedList<Integer> L2 = new LinkedList<>(); 
   /* L1.add(1); 
    L1.add(2); 
    L1.add(3); 
    L1.add(4); 
    combiSR(L1, L2, 2, 0); 
System.out.println("-----------------"); 
combiCR(L1, L2, 2, 0); 
System.out.println("-----------------"); */
//permuCR(L1, L2, 2, 0); 
problema3(L1,L2);
System.out.println("------------------------"); 
//permuSR(L1, L2, 2, 0); 
} 
public static void combiSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) { 
    if (L2.size() == r) { 
        System.out.println(L2); 
        return; 
    } int k = i; 
    while (k < L1.size()) { 
        L2.add(L1.get(k)); 
        combiSR(L1, L2, r, k + 1); 
        L2.removeLast(); 
        k = k + 1; 
    } 
} 
public static void combiCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) { 
    if (L2.size() == r) { 
        System.out.println(L2); 
        return; 
    } int k = i; 
    while (k < L1.size()) { 
        L2.add(L1.get(k)); 
        combiCR(L1, L2, r, k); 
        L2.removeLast(); 
        k = k + 1; } 
}
public static void permuSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) { 
    if (L2.size() == r) { 
        System.out.println(L2); 
        return; 
    } int k = 0; 
    while (k < L1.size()) { 
        if (!L2.contains(L1.get(k))) { 
            L2.add(L1.get(k)); 
            permuSR(L1, L2, r, k + 1); 
            L2.removeLast(); 
        } k = k + 1; 
    } 
} 
public static void permuCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) { 
    if (L2.size() == r) {
        System.out.println(L2); 
        return; 
    } 
    int k = 0; 
    while (k < L1.size()) { 
        L2.add(L1.get(k)); 
        permuCR(L1, L2, r, k+1 ); 
        L2.removeLast(); 
        k = k + 1; 
    } 
}
public static void permuCR2(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i,LinkedList<LinkedList> solucion) { 
    if (L2.size() == r) {
        //System.out.println(L2); 
        solucion.add(L2);
        return; 
    } 
    int k = 0; 
    while (k < L1.size()) { 
        L2.add(L1.get(k)); 
        permuCR2(L1, L2, r, k+1 , solucion); 
        L2.removeLast(); 
        k = k + 1; 
    } 
}
public static void problema1(LinkedList<Integer> L1, LinkedList<Integer> L2){
    LinkedList<LinkedList> solucion= new LinkedList<>();
    L1.add(1); //Color1
    L1.add(2); //Color2
    L1.add(3); //Color3
    
    permuCR2(L1,L2,4,0,solucion);
    
    System.out.println("El número de formas en que se pueden pintar el cuarto es: " + solucion.size());
}
public static void problema2(LinkedList<Integer> L1, LinkedList<Integer> L2){
    LinkedList<LinkedList> solucion= new LinkedList<>();
    L1.add(1); //Letra A
    L1.add(2); //Letra B
    L1.add(3); //Letra C
    L1.add(4); //Letra D
    
    permuCR2(L1,L2,4,0,solucion);
    
    System.out.println("El número de palabras que se pueden formar es: " + solucion.size());
}

public static void problema3(LinkedList<Integer> L1, LinkedList<Integer> L2){
    LinkedList<LinkedList> solucion= new LinkedList<>();
    L1.add(1); 
    L1.add(2); 
    L1.add(3); 
    L1.add(4); 
    L1.add(5);
    L1.add(6);
    L1.add(7);
    L1.add(8);
    L1.add(9);
    L1.add(0);
    
    permuCR2(L1,L2,4,0,solucion);
    
    System.out.println("El número de contraseñas posibles es: " + solucion.size());
}
}
