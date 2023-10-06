/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mochilaia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Veronica
 */
public class MochilaIA {

    /**
     *
     */
    public int max = 4;

    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> L1 = new LinkedList();
        LinkedList<Integer> L2 = new LinkedList();
        L1.add(2);
        L1.add(4);
        L1.add(6);
        L1.add(1);
        //mochilaCantMayor(L1, L2, 8, 0, L2.size());
        // sumando(L2, 4, 1);
        //System.out.println();
        // encontrarFactores(L1);
        //factores(L2,4,1);
        // factores(L2, 4, 1);
        factoresIguales(L2, 4, 1);
    }

    public static void sumando(LinkedList<Integer> L1, int n, int i) {
        int sum = sumar(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        for (int k = i; k <= n; k++) {
            L1.add(k);
            sumando(L1, n, k);
            L1.removeLast();
        }
    }

    //Ejercicio 1
    //Encontrar los factores posibles en una Lista.
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

    //Ejercicio 2
    //Encontrar todos los factores posibles diferentes en una Lista.
    public static int frecuencia(LinkedList<Integer> L1, int x) {
        int c = 0;
        for (int i = 0; i < L1.size(); i++) {
            if (L1.get(i) == x) {
                c++;
            }
        }
        return c;
    }

    public static boolean diferentes(LinkedList<Integer> L1) {
        for (int i = 0; i < L1.size(); i++) {
            if (frecuencia(L1, L1.get(i)) > 1) {
                return false;
            }
        }
        return true;
    }

    

    public static void factoresDiferentes(LinkedList<Integer> L1, int n, int i) {
        int fd = multiplicar(L1);
        if (fd > n) {
            return;
        }
        if (fd == n) {
            if (diferentes(L1)) {
                System.out.println(L1);
            }
            return;
        }
        int k = i;
        while (k <= n) {
            L1.add(k);
            if (L1.getLast() == 1) {
                factoresDiferentes(L1, n, k + 1);
            } else {
                factoresDiferentes(L1, n, k);
            }
            L1.removeLast();
            k++;
        }
    }

    public static boolean iguales(LinkedList<Integer> L1) {
        boolean b = true;
        int pri = L1.getFirst();
        for (int i = 1; i < L1.size(); i++) {
            if (pri != L1.get(i)) {
                b = false;
            }
        }
        return b;
    }
    

    public static void factoresIguales(LinkedList<Integer> L1, int n, int i) {
        int fd = multiplicar(L1);
        if (fd > n) {
            return;
        }
        if (fd == n) {
            if (iguales(L1)) {
                System.out.println(L1);
            }
            return;
        }
        int k = i;
        while (k <= n) {
            L1.add(k);
            if (L1.getLast() == 1) {
                factoresIguales(L1, n, k + 1);
            } else {
                factoresIguales(L1, n, k);
            }
            L1.removeLast();
            k++;
        }
    }
    
    //Ejercicio 4
     public static boolean esPrimo(int x){
        if(x<=1){
            return false;
        }
        int cont=0;
        for(int i=(int) Math.sqrt(x); i > 1; i--){
            if(x%i==0){
                cont++;
            }
        }
        return cont<1;
    }
     
    public static boolean Primos(LinkedList<Integer> L1){
        for (int i = 0; i < L1.size(); i++) {
            if(!esPrimo(L1.get(i))){
                return false;
            }
        }
        return true;
    }
    
    public static void factoresPrimos(LinkedList<Integer> L1, int n, int i){
        int p= multiplicar(L1);
        if(p>n){
            return;
        }
        if(p==n){
            if(Primos(L1)){
                System.out.println(L1);
            }            
            return;
        }
        int k=i;
        while(k<=n){
            L1.add(k);
            if(L1.getLast()==1){
               factoresPrimos(L1, n, k+1); 
            }else{
                factoresPrimos(L1, n, k);
            }            
            L1.removeLast();
            k++;
        }
    }
//Ejercicio 5
    //Encontrar todos los factores entre a y b inclusive en una Lista.
    public static boolean entreAyB(LinkedList<Integer> L1, int a, int b){
        for (int i = 0; i < L1.size(); i++) {
            if(L1.get(i)<a || L1.get(i)>b){
                return false;
            }
        }
        return true;
    }
    
    public static void factoresEntreAyB(LinkedList<Integer> L1, int n, int i, int a, int b){
        int p= multiplicar(L1);
        if(p>n){
            return;
        }
        if(p==n){
            if(entreAyB(L1,a,b)){
                System.out.println(L1);
            }            
            return;
        }
        int k=i;
        while(k<=n){
            L1.add(k);
            if(L1.getLast()==1){
               factoresEntreAyB(L1, n, k+1,a,b); 
            }else{
                factoresEntreAyB(L1, n, k,a,b);
            }            
            L1.removeLast();
            k++;
        }
    }
    //Ejercicio 6 
    //Factor de un numero 
    public static boolean FactorN(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
    
    
    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i) {
        int sum = sumar(L2);
        if (sum > max) {
            return;
        }
        System.out.println(L2);
        for (int k = i; k < L1.size(); k++) {

            L2.add(L1.get(k));
            mochila(L1, L2, max, k + 1);
            L2.removeLast();
        }
    }

    public static int sumar(LinkedList<Integer> L1) {
        int sum = 0;
        for (int i = 0; i < L1.size(); i++) {
            sum = sum + L1.get(i);
        }
        return sum;
    }

    public static void mochilaDiferente(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i) {
        int sum = sumar(L2);
        if (sum > max) {
            return;
        }
        if (listadiferente(L2)) {
            System.out.println(L2);
        }

        for (int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));
            mochilaDiferente(L1, L2, max, k + 1);
            L2.removeLast();
        }

    }

    public static boolean listadiferente(LinkedList<Integer> L1) {
        for (int k = 0; k < L1.size(); k++) {
            int pri = L1.get(k);
            for (int i = k + 1; i < L1.size(); i++) {
                if (pri == L1.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Ejercicio 3
    //a y b inclusive
    //Ejercicio 4
    public static void mochilaCantMayor(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i, int mayor) {
        int sum = sumar(L2);
        if (sum > max) {
            return;
        }

        for (int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));
            if (mayor < L2.size()) {
                mayor = L2.size();
                System.out.println(L2);
            }
            mochilaCantMayor(L1, L2, max, k + 1, mayor);

            L2.removeLast();
        }

    }

    public static int cantidadMayor(LinkedList<Integer> L1) {
        return L1.size();
    }

}
