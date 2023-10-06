package org.example;
import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int contadorCSR=0;
    public static int contadorCCR=0;
    public static int contadorPSR=0;
    public static int contadorPCR=0;

    public static void main(String[] args) {
        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);
        lista1.add(4);
//        lista1.add(4);
//        lista1.add(5);
        int r=2;
//        System.out.println("combinaciones sin repeticion:");
//        combinacionesSinRep(lista1,lista2,r,0);
//        System.out.println("cantidad total de soluciones: "+contadorCSR);
//        System.out.println("combinaciones con repeticion:");
//        combinacionesConRep(lista1,lista2,r,0);
//        System.out.println("cantidad total de soluciones: "+contadorCCR);
//        System.out.println("permutaciones con repeticion:");
//        permutacionesConRep(lista1,lista2,r,0);
//        System.out.println("cantidad total de soluciones: "+contadorPCR);
//        System.out.println("permutaciones sin repeticion:");
//        permutacionesSinRep(lista1,lista2,r,0);
//        System.out.println("cantidad total de soluciones: "+contadorPSR);
        System.out.println("cambinatoria pares repeticion:");
        combinacionesConRepPares(lista1,lista2,r,0);

    }

//    public static void combinacionesSinRep(LinkedList<Integer> lista1,LinkedList<Integer> lista2, int r, int i){
//        if(lista2.size()>r) return;
//        if(lista2.size()==r){
//            System.out.println(lista2);
//            contadorCSR++;
//            return;
//        }
//
//
//    }

    public static void combinacionesConRep(LinkedList<Integer> lista1,LinkedList<Integer> lista2, int r, int i){
        if(lista2.size()>r) return;
        if(lista2.size()==r){
            System.out.println(lista2);
            contadorCCR++;
            return;
        }

        for(int k=i;k<lista1.size();k++){
            lista2.add(lista1.get(k));
            combinacionesConRep(lista1,lista2,r,k);
//            combinacionesSinRep(lista1,lista2,r,k); cambiar k para con repeticion
            lista2.removeLast();
        }
    }

    public static void combinacionesConRepPares(LinkedList<Integer> lista1,LinkedList<Integer> lista2, int r, int i){
        if(lista2.size()>r) return;
        if(lista2.size()==r){
            System.out.println(lista2);
            contadorCCR++;
            return;
        }

        for(int k=i;k<lista1.size();k++){
            if(lista1.get(k)%2==0){
                lista2.add(lista1.get(k));
                combinacionesConRepPares(lista1,lista2,r,k);
                lista2.removeLast();
            }


        }
    }

    public static void permutacionesConRep(LinkedList<Integer> lista1,LinkedList<Integer> lista2, int r, int i){
        if(lista2.size()>r) return;
        if(lista2.size()==r){
            System.out.println(lista2);
            contadorPCR++;
            return;
        }

        for(int k=0;k<lista1.size();k++){
            lista2.add(lista1.get(k));
            permutacionesConRep(lista1,lista2,r,k);
            lista2.removeLast();
        }
    }
    public static void permutacionesSinRep(LinkedList<Integer> lista1,LinkedList<Integer> lista2, int r, int i){

        if(lista2.size()>r) return;
        if(lista2.size()==r){
            System.out.println(lista2);
            contadorPSR++;
            return;
        }

        for(int k=0;k<lista1.size();k++){
            if(!lista2.contains(lista1.get(k))){
                lista2.add(lista1.get(k));
                permutacionesSinRep(lista1,lista2,r,k);
                lista2.removeLast();
            }

        }
    }

}