/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.allbacktracks;

import java.util.LinkedList;

/**
 *
 * @author Hp 14
 */
public class AllBackTracks {
public static long vueltas=0;
    public static void main(String[] args) {
        int n = 9;
        int ma[][]= new int [n][n]; //Crear una matriz nxn llena de ceros
        
        int m[][] = {//Crear una matriz para colocar elementos de forma manual
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
            
        };
        if (sudoku(ma,0,0)){
            System.out.println("Tiene Solucion: ");
            mostrarSudoku(ma);
        }else
            System.out.println("No Tiene Solucion ");
        System.out.println("Cantidad de vueltas: "+vueltas);
    }
//-----------------------------------------------------------------------------    
    //1. El problema de Movimientos del Rey. Laberinto con BackTrack
    public static LinkedList<Regla> reglasAplicablesREY(int m[][],int i,int j){
        LinkedList<Regla>L1= new LinkedList();
        if(posVal(m,i , j-1))L1.add(new Regla(i , j-1));//izquierda
        if(posVal(m,i-1,j-1))L1.add(new Regla(i-1,j-1));//DiagonalSupriorIzq
        if(posVal(m,i-1,j  ))L1.add(new Regla(i-1,j  ));//arriba
        if(posVal(m,i-1,j+1))L1.add(new Regla(i-1,j+1));//DiagonalSuperiorDer
        if(posVal(m,i , j+1))L1.add(new Regla(i , j+1));//derecha
        if(posVal(m,i+1,j+1))L1.add(new Regla(i+1,j+1));//DiagonalInferiorDer
        if(posVal(m,i+1,j  ))L1.add(new Regla(i+1,j  ));//abajo
        if(posVal(m,i+1,j-1))L1.add(new Regla(i+1,j-1));//DiagonalInferiorIzq
        return L1;
    }
    public static boolean laberintoREY(int m[][],int i,int j,int i1,int j1,int paso){
        m[i][j]=paso;
        if(i==i1&&j==j1)return true;
        LinkedList<Regla>L1=reglasAplicablesREY(m,i,j);
        while(!L1.isEmpty()){
            Regla R=elegirReglaRB(L1,i1,j1);
            m[R.fil][R.col]=paso;
            if(laberintoREY(m,R.fil,R.col,i1,j1,paso+1))return true;
            m[R.fil][R.col]=0;
            vueltas++;
        }
        return false;
    }
    //Funciones auxiliares del laberinto backtrack
    public static boolean posVal(int m[][],int i,int j){
        return i>=0&&i<m.length&&j>=0&&j<m[i].length&&m[i][j]==0;
    }
    //Regla de la distancia menor
    public static Regla elegirReglaRB(LinkedList<Regla>L1,int i1,int j1){
        int i=0,men=Integer.MAX_VALUE,posMen=0;
        while(i<L1.size()){
            int dist = distancia(L1.get(i).fil,L1.get(i).col,i1,j1);
            if(dist<men){
                men=dist;
                posMen=i;
            }
            i=i+1;
        }
        return L1.remove(posMen);
    }
    public static int distancia(int x1,int y1,int x2,int y2){
        return (int)Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2,2));
    }
//-----------------------------------------------------------------------------
    //2. El problema nReinas.
    public static boolean nReinas (int m[][], int i){
        if(i >= m.length ) return true;
        LinkedList<Regla> L1 = reglasAplicablesNReinas(m, i);
        while(!L1.isEmpty()){
            Regla R = elegirReglaC(L1);
            m[R.fil][R.col ] = i + 1;
            if(nReinas (m, i + 1)) return true;
            m[R.fil][R.col ] = 0;
            vueltas++;
        }
        
        return false;
    }
    public static LinkedList<Regla> reglasAplicablesNReinas(int m[][], int i){
        LinkedList<Regla > L1 = new LinkedList();
        for(int j = 0; j < m[i].length; j++){
            if(posValido (m, i , j)) L1.add(new Regla (i ,j));
        }
        return L1;
    }
    public static boolean posValido (int m[][], int i , int j){
        return filValido (m, i) && colValido (m, j) &&
                diagSupIzq(m, i , j) && diagSupDer (m, i , j) &&
                diagInfIzq(m, i , j) && diagInfDer (m, i , j);
    }
    //Auxiliares de posValido
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
//-----------------------------------------------------------------------------
    //3. El problema del salto del caballo
    public static boolean SaltoCaballo ( int m[][], int i , int j, int paso) {
            if(!posValida (m, i , j)) return false;
            m[i ][j] = paso ;
                      
            if(!existe(m,0)){return true;}
                        
            LinkedList<Regla> L1 = reglasAplicablesCaballo(m, i, j);
            while(!L1.isEmpty()){
                Regla R = elegirReglaA(L1); // Elige Regla 
                if(SaltoCaballo(m, R.fil, R.col, paso+1))return true;
                m[R.fil][R.col] = 0;
                vueltas++;
            }
            return false;
    }
    public static boolean posValida(int m[][], int i, int j){
        return i>=0 && i<m.length &&
                j>=0 && j<m[i].length && m[i][j]==0;
    }
    
    public static LinkedList<Regla> reglasAplicablesCaballo(int m[][], int i, int j){
        LinkedList<Regla> L1 = new LinkedList();
            
            if(posValida(m, i-1,j-2))L1.add(new Regla(i-1,j-2));
            if(posValida(m, i-2,j-1))L1.add(new Regla(i-2,j-1));
            if(posValida(m, i-2,j+1))L1.add(new Regla(i-2,j+1));
            if(posValida(m, i-1,j+2))L1.add(new Regla(i-1,j+2));
            if(posValida(m, i+1,j+2))L1.add(new Regla(i+1,j+2));
            if(posValida(m, i+2,j+1))L1.add(new Regla(i+2,j+1));
            if(posValida(m, i+2,j-1))L1.add(new Regla(i+2,j-1));
            if(posValida(m, i+1,j-2))L1.add(new Regla(i+1,j-2));
            
        return L1;
    }
//-----------------------------------------------------------------------------
    public static boolean sudoku(int m[][], int i, int j){
        if(i>=m.length)return true;
        if(j>=m[i].length)return sudoku(m,i+1,0);
        if(m[i][j]!=0)return sudoku(m, i, j+1);
        
        LinkedList<Integer> L1 =reglasAplicablesSudoku(m,i,j);
        while(!L1.isEmpty()){
            m[i][j]=elegirReglaSC(L1);
            if(sudoku(m,i,j+1))return true;
            m[i][j]=0;
            vueltas++;
        }
        return false;
    }
     // Sin heurística
    public static int elegirReglaSA ( LinkedList<Integer> L1){
        return L1.removeFirst();
    }
    // Con heurística
    // Elegir del medio
    public static int elegirReglaSB ( LinkedList<Integer> L1){
        return L1.remove(L1.size() / 2);
    }//Random
    public static int elegirReglaSC ( LinkedList<Integer> L1){
        return L1.remove((int)(Math.random()*L1.size()));
    }
    //reglas del sudoku
    public static LinkedList<Integer> reglasAplicablesSudoku(int m[][], int i, int j){
        LinkedList<Integer> L1 = new LinkedList();
        for(int valor =1; valor <=m.length; valor++){
            if(!enFila(m,i, valor)&&
               !enColumna(m,j, valor)&&
               !enRegion(m,i,j,valor)) L1.add(valor);
        }
        return L1;
    }
    
    public static boolean enFila(int m[][], int i, int valor){
        for(int j=0; j<m[i].length;j++){
            if(m[i][j]==valor)return true;
        }
        return false;
    }
    
    public static boolean enColumna(int m[][], int j, int valor){
        for(int i=0; i<m.length;i++){
            if(m[i][j]==valor)return true;
        }
        return false;
    }
    
    public static boolean enRegion(int m[][], int i, int j, int valor){
        int nFil=(int)Math.sqrt(m.length);
        int nCol=(int)Math.sqrt(m[i].length);
        
        int iRegion=(i/nFil)*nFil;
        int jRegion=(j/nCol)*nCol;
        
        for(int a=iRegion; a< iRegion+nFil;a++){
            for(int b=jRegion; b<jRegion+nCol;b++){
                if(m[a][b]==valor)return true;
            }
        }
        return false;
    }
//----------------------------------------------------------------------------- 
    //Heuristicas generales (estas usan la clase Regla):
    // Sin heurística
    public static Regla elegirReglaA ( LinkedList<Regla> L1){
        return L1.removeFirst(); //toma el primer elemento de la lista
    }
    // Con heurística
    // Elegir del medio
    public static Regla elegirReglaB ( LinkedList<Regla> L1){
        return L1.remove(L1.size() / 2);
    }//Random
    public static Regla elegirReglaC ( LinkedList<Regla> L1){
        return L1.remove((int)(Math.random()*L1.size()));
    }
    
    //Algoritmos generales:
        public static boolean existe(int[][] matriz, int numero) {//Verifica si existe 0 en la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void mostrar(int m[][]){
        for (int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                if(m[i][j]/10==0)
                System.out.print(" "+m[i][j]+" ");
                else
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
   //Mostrar para que el sudoku se vea mejor 
    public static void mostrarSudoku(int m[][]) {
    int n = m.length;
    for (int i = 0; i < n; i++) {
        if (i > 0 && i % (int) Math.sqrt(n) == 0) {
            for (int j = 0; j < n; j++) {
                System.out.print("---");
            }
            System.out.println();
        }
        for (int j = 0; j < n; j++) {
            if (j > 0 && j % (int) Math.sqrt(n) == 0) {
                System.out.print("|");
            }
            if (m[i][j] / 10 == 0) {
                System.out.print(" " + m[i][j] + " ");
            } else {
                System.out.print(m[i][j] + " ");
            }
        }
        System.out.println();
    }
    System.out.println();
    }
}
