/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.laberintoreycab;

/**
 *
 * @author EbenCT
 */
public class LaberintoReyCab {

    public static int c=0;
    
    public static void main(String[] args) {
        int a=3, b=3;
        int m[][]=new int[a][b];
        
        laberintoReyB(m, 0, 0,a-1, b-1, 1);
        System.out.println("Soluciones posibles: "+c);
    }
    
    
/*
    a)    
 Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final. Además, mostrar la cantidad de soluciones 
posibles (Cantidad de caminos posibles de la posición inicial a la 
posición final).
    */    
    public static void laberintoRey ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ mostrar(m); c++;}
            
            laberintoRey(m, i  ,j-1,ifin , jfin , paso + 1);
            laberintoRey(m, i-1,j-1,ifin , jfin , paso + 1);
            laberintoRey(m, i-1,j,  ifin , jfin , paso + 1);
            laberintoRey(m, i-1,j+1,ifin , jfin , paso + 1);
            laberintoRey(m, i , j+1,ifin , jfin , paso + 1);
            laberintoRey(m, i+1,j+1,ifin , jfin , paso + 1);
            laberintoRey(m, i+1,j,  ifin , jfin , paso + 1);
            laberintoRey(m, i+1,j-1,ifin , jfin , paso + 1);
            m[i][j] =0;
}
/*
b)    
 Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que se visiten todas las casillas de la
 matriz. Además, mostrar la cantidad de soluciones posibles.    
    */    
public static void laberintoReyB ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(!existe(m,0)){
                mostrar(m); c++;}
            }
            
            laberintoReyB(m, i  ,j-1,ifin , jfin , paso + 1);
            laberintoReyB(m, i-1,j-1,ifin , jfin , paso + 1);
            laberintoReyB(m, i-1,j,  ifin , jfin , paso + 1);
            laberintoReyB(m, i-1,j+1,ifin , jfin , paso + 1);
            laberintoReyB(m, i , j+1,ifin , jfin , paso + 1);
            laberintoReyB(m, i+1,j+1,ifin , jfin , paso + 1);
            laberintoReyB(m, i+1,j,  ifin , jfin , paso + 1);
            laberintoReyB(m, i+1,j-1,ifin , jfin , paso + 1);
            m[i][j] =0;
}
/*
c)     
 Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que NO se visiten todas las casillas de
 la matriz. Además, mostrar la cantidad de soluciones posibles.
*/
public static void laberintoReyC ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(existe(m,0)){
                mostrar(m); c++;}
            }
            
            laberintoReyC(m, i  ,j-1,ifin , jfin , paso + 1);
            laberintoReyC(m, i-1,j-1,ifin , jfin , paso + 1);
            laberintoReyC(m, i-1,j,  ifin , jfin , paso + 1);
            laberintoReyC(m, i-1,j+1,ifin , jfin , paso + 1);
            laberintoReyC(m, i , j+1,ifin , jfin , paso + 1);
            laberintoReyC(m, i+1,j+1,ifin , jfin , paso + 1);
            laberintoReyC(m, i+1,j,  ifin , jfin , paso + 1);
            laberintoReyC(m, i+1,j-1,ifin , jfin , paso + 1);
            m[i][j] =0;
}
/*
2.
 Ejecutar para todos los incisos del Ejercicio 1, utilizando 
el movimiento del caballo en sentido horario.

a) Caballo    
 Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final. Además, mostrar la cantidad de soluciones 
posibles (Cantidad de caminos posibles de la posición inicial a la 
posición final).
*/
public static void laberintoCaballo ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                
                mostrar(m); c++;
            }
            
            laberintoCaballo(m, i-1,j-2,ifin , jfin , paso + 1);
            laberintoCaballo(m, i-2,j-1,ifin , jfin , paso + 1);
            laberintoCaballo(m, i-2,j+1,ifin , jfin , paso + 1);
            laberintoCaballo(m, i-1,j+2,ifin , jfin , paso + 1);
            laberintoCaballo(m, i+1,j+2,ifin , jfin , paso + 1);
            laberintoCaballo(m, i+2,j+1,ifin , jfin , paso + 1);
            laberintoCaballo(m, i+2,j-1,ifin , jfin , paso + 1);
            laberintoCaballo(m, i+1,j-2,ifin , jfin , paso + 1);
            m[i][j] =0;
}
/*
b)Caballo    
 Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que se visiten todas las casillas de la
 matriz. Además, mostrar la cantidad de soluciones posibles.
*/
public static void laberintoCaballoB ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(!existe(m,0)){
                mostrar(m); c++;}
            }
            
            laberintoCaballoB(m, i-1,j-2,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i-2,j-1,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i-2,j+1,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i-1,j+2,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i+1,j+2,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i+2,j+1,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i+2,j-1,ifin , jfin , paso + 1);
            laberintoCaballoB(m, i+1,j-2,ifin , jfin , paso + 1);
            m[i][j] =0;
}
/*
c)     
 Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que NO se visiten todas las casillas de
 la matriz. Además, mostrar la cantidad de soluciones posibles.
*/
public static void laberintoCaballoC ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(existe(m,0)){
                mostrar(m); c++;}
            }
            
            laberintoCaballoC(m, i-1,j-2,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i-2,j-1,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i-2,j+1,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i-1,j+2,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i+1,j+2,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i+2,j+1,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i+2,j-1,ifin , jfin , paso + 1);
            laberintoCaballoC(m, i+1,j-2,ifin , jfin , paso + 1);
            m[i][j] =0;
}
    
    public static boolean posValida(int m[][], int i, int j){
        return i>=0 && i<m.length &&
                j>=0 && j<m[i].length && m[i][j]==0;
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
    public static boolean existe(int[][] matriz, int numero) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;
    }
}
