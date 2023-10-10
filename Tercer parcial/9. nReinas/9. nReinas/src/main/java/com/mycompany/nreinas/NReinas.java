/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.nreinas;

import java.util.LinkedList;

/**
 *
 * @author EbenCT
 */
public class NReinas {
    public static long c=0;
    public static int anterior=0;
    public static void main(String[] args) {
        int n=5; anterior=(n/2);
        int m[][]= new int [n][n];
        if(nReinas(m,0)){
            System.out.println("Existe Solucion: ");
            mostrar(m);
        }else
            System.out.println("No existe solucion");
        System.out.println("Cantidad de vueltas: "+c);
    }
    
    public static void mostrar(int m[][]){
        for (int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean nReinas (int m[][], int i){
        if(i >= m.length ) return true;
        LinkedList<Regla> L1 = reglasAplicablesA(m, i);
        while(!L1.isEmpty()){
            Regla R = elegirReglaB(L1);
            m[R.fil][R.col ] = i + 1;
            if(nReinas (m, i + 1)) return true;
            m[R.fil][R.col ] = 0;
            c++;
        }
        
        return false;
    } 
//c) otras formas creativas de llenado de la matriz.
public static LinkedList<Regla> reglasAplicablesC(int m[][], int i){
        LinkedList<Regla > L1 = new LinkedList();
        if(i % 2 == 0 ){
        for(int j = 0; j < m[i].length; j++){
            if(posValido (m, i , j)) L1.add(new Regla (i ,j));
        }
        }else{
            int n=m.length-i;
            for(int j = 0; j < m[n].length; j++){
            if(posValido (m, n , j)) L1.add(new Regla (n ,j));
        }
        }
        return L1;
    }
//b) de las filas del medio, hacia afuera, alternativamente. idem al anterior
public static LinkedList<Regla> reglasAplicablesB(int m[][], int i){
        LinkedList<Regla > L1 = new LinkedList();
        int n=anterior;
        if(i % 2 != 0 ){
            n=anterior+i;anterior=n;
        for(int j = 0; j < m[n].length; j++){
            if(posValido (m, n , j)) L1.add(new Regla (n ,j));
        }
        }else{
            n=anterior-i;anterior=n;
            for(int j = 0; j < m[n].length; j++){
            if(posValido (m, n , j)) L1.add(new Regla (n ,j));
        }
        }
        return L1;
    }
//a) 1ra fila, luego última fila, 2da fila, luego penúltima fila y así sucesivamente.
public static LinkedList<Regla> reglasAplicablesA(int m[][], int i){
        LinkedList<Regla > L1 = new LinkedList();
        int n=m.length;
        if(i % 2 != 0 ){
            n=n-((i/2)+1);
        for(int j = 0; j < m[n].length; j++){
            if(posValido (m, n , j)) L1.add(new Regla (n ,j));
        }
        }else{
            n=n-(n-(i/2));
            for(int j = 0; j < m[n].length; j++){
            if(posValido (m, n , j)) L1.add(new Regla (n ,j));
        }
        }
        return L1;
    }
    
    public static LinkedList<Regla> reglasAplicables(int m[][], int i){
        LinkedList<Regla > L1 = new LinkedList();
        for(int j = 0; j < m[i].length; j++){
            if(posValido (m, i , j)) L1.add(new Regla (i ,j));
        }
        return L1;
    }
    
    public static boolean posValido (int m[][], int i , int j){
        return  filValido (m, i)     && colValido (m, j) &&
                diagSupIzq(m, i , j) && diagSupDer (m, i , j) &&
                diagInfIzq(m, i , j) && diagInfDer (m, i , j);
    }
    
    public static boolean filValido(int m[][], int i){
        int j=0;
        while(j<m[i].length){
            if(m[i][j] !=0)return false;
            j++;
        }
        return true;
    }
    public static boolean colValido(int m[][], int j){
        int i=0;
        while(i<m.length){
            if(m[i][j] !=0)return false;
            i++;
        }
        return true;
    }
    
    public static boolean diagSupDer (int m[][], int i1, int j1){
        int i = i1, j = j1;
        while(i >= 0 && j < m[i1].length){
        if(m[i ][j] != 0) return false;
        i--;
        j++;
        }
        return true;
    }
    
    public static boolean diagSupIzq (int m[][], int i1, int j1){
        int i = i1, j = j1;
        while(i >= 0 && j >=0){
        if(m[i ][j] != 0) return false;
        i--;
        j--;
        }
        return true;
    }
    
    public static boolean diagInfIzq (int m[][], int i1, int j1){
        int i = i1, j = j1;
        while(i < m.length && j >=0){
        if(m[i][j] != 0) return false;
        i++;
        j--;
        }
        return true;
    }
    
    public static boolean diagInfDer (int m[][], int i1, int j1){
        int i = i1, j = j1;
        while(i<m.length && j < m[i1].length){
        if(m[i ][j] != 0) return false;
        i++;
        j++;
        }
        return true;
    }
    
    // Sin heurística
    public static Regla elegirReglaA ( LinkedList<Regla> L1){
        return L1.removeFirst();
    }
    // Con heurística
    public static Regla elegirReglaB ( LinkedList<Regla> L1){
        return L1.remove(L1.size() / 2);
    }
}
