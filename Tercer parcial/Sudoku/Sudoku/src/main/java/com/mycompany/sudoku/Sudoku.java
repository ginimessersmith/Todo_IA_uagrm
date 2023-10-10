/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sudoku;

import java.util.LinkedList;
/**
 *
 * @author Hp 14
 */
public class Sudoku {
public static long vueltas=0;
public static long soluciones=0;
    public static void main(String[] args) {
        int n=9;
        int m[][]=new  int [n][n];
        int ma[][] = {
            {5,0,0,0,0,2,6,0,0},
            {0,0,0,0,6,5,0,3,1},
            {0,1,0,0,0,3,0,7,5},
            {0,0,0,0,0,1,0,2,0},
            {8,0,0,3,0,7,0,0,6},
            {0,3,0,4,0,0,0,0,0},
            {3,6,0,7,0,0,0,8,0},
            {2,8,0,5,3,0,0,0,0},
            {0,0,4,2,0,0,0,0,7}    
        };
        
        if (sudoku(m,0,0))
            System.out.println("Tiene Solucion");
        else
            System.out.println("No Tiene Solucion");
        mostrar(m);
        System.out.println("Cantidad de vueltas: "+vueltas);
        /*System.out.println("-----------------------------------");
        AllSudokus(ma,0,0);
        System.out.println("Cantidad de soluciones: "+soluciones);
    */}
    
    public static boolean sudoku(int m[][], int i, int j){
        if(i>=m.length)return true;
        if(j>=m[i].length)return sudoku(m,i+1,0);
        if(m[i][j]!=0)return sudoku(m, i, j+1);
        
        LinkedList<Integer> L1 =reglasAplicables(m,i,j);
        while(!L1.isEmpty()){
            m[i][j]=elegirReglaG(L1,m,i,j);
            if(sudoku(m,i,j+1))return true;
            m[i][j]=0;
            vueltas++;
        }
        return false;
    }
     // Sin heurística
    public static int elegirReglaA ( LinkedList<Integer> L1){
        return L1.removeFirst();
    }
    // Con heurística
    // Elegir del medio
    public static int elegirReglaB ( LinkedList<Integer> L1){
        return L1.remove(L1.size() / 2);
    }//Random
    public static int elegirReglaC ( LinkedList<Integer> L1){
        return L1.remove((int)(Math.random()*L1.size()));
    }
    // Elemento promedio
    public static int elegirReglaD(LinkedList<Integer> L1) {
        double promedio = calcularPromedio(L1);
        int regla = encontrarElementoMasCercano(L1, promedio);
        L1.remove(Integer.valueOf(regla));
        return regla;
    }

public static double calcularPromedio(LinkedList<Integer> lista) {
    double sum = 0;
    for (int num : lista) {
        sum += num;
    }
    return sum / lista.size();
}

public static int encontrarElementoMasCercano(LinkedList<Integer> lista, double target) {
    int closestValue = lista.get(0);
    double minDifference = Math.abs(lista.get(0) - target);

    for (int value : lista) {
        double difference = Math.abs(value - target);
        if (difference < minDifference) {
            closestValue = value;
            minDifference = difference;
        }
    }

    return closestValue;
}
// Utilizando MRV (Minimum Remaining Values)
public static int elegirReglaE(LinkedList<Integer> L1, int m[][], int i, int j) {
    int minCount = Integer.MAX_VALUE;
    int selectedValue = -1;

    for (int value : L1) {
        m[i][j] = value;
        int count = contarValoresPosibles(m, i, j);
        if (count < minCount) {
            minCount = count;
            selectedValue = value;
        }
        m[i][j] = 0; // Deshacer la asignación para explorar otras opciones
    }

    L1.remove(Integer.valueOf(selectedValue));
    return selectedValue;
}
public static int contarValoresPosibles(int m[][], int i, int j) {
    int count = 0;
    for (int valor = 1; valor <= m.length; valor++) {
        if (!enFila(m, i, valor) && !enColumna(m, j, valor) && !enRegion(m, i, j, valor)) {
            count++;
        }
    }
    return count;
}
// Utilizando LCV (Least Constraining Value)
public static int elegirReglaF(LinkedList<Integer> L1, int m[][], int i, int j) {
    int minConstraints = Integer.MAX_VALUE;
    int selectedValue = -1;

    for (int value : L1) {
        m[i][j] = value;
        int constraints = calcularRestricciones(m, i, j);
        if (constraints < minConstraints) {
            minConstraints = constraints;
            selectedValue = value;
        }
        m[i][j] = 0; // Deshacer la asignación para explorar otras opciones
    }

    L1.remove(Integer.valueOf(selectedValue));
    return selectedValue;
}
public static int calcularRestricciones(int m[][], int i, int j) {
    int count = 0;
    int n = m.length;

    for (int k = 0; k < n; k++) {
        if (k != i && m[k][j] == 0) { // Celdas vacías en la misma columna
            for (int valor : reglasAplicables(m, k, j)) {
                count++;
            }
        }

        if (k != j && m[i][k] == 0) { // Celdas vacías en la misma fila
            for (int valor : reglasAplicables(m, i, k)) {
                count++;
            }
        }
    }

    int nFil = (int) Math.sqrt(n);
    int nCol = (int) Math.sqrt(n);
    int iRegion = (i / nFil) * nFil;
    int jRegion = (j / nCol) * nCol;

    for (int a = iRegion; a < iRegion + nFil; a++) {
        for (int b = jRegion; b < jRegion + nCol; b++) {
            if (a != i && b != j && m[a][b] == 0) { // Celdas vacías en la misma región
                for (int valor : reglasAplicables(m, a, b)) {
                    count++;
                }
            }
        }
    }

    return count;
}
// Utilizando Backtracking con búsqueda ordenada (LCV)
public static int elegirReglaG(LinkedList<Integer> L1, int m[][], int i, int j) {
    int minConstraints = Integer.MAX_VALUE;
    int selectedValue = -1;

    for (int value : L1) {
        m[i][j] = value;
        int constraints = calcularRestricciones(m, i, j);
        if (constraints < minConstraints) {
            minConstraints = constraints;
            selectedValue = value;
        }
        m[i][j] = 0; // Deshacer la asignación para explorar otras opciones
    }

    L1.remove(Integer.valueOf(selectedValue));
    return selectedValue;
}




    public static void AllSudokus(int m[][], int i, int j) {
        if (i >= m.length) {
            mostrar(m);
            soluciones++;
            return;
        }
        if (j >= m[i].length) {
            AllSudokus(m, i + 1, 0);
            return;
        }
        if (m[i][j] != 0) {
            AllSudokus(m, i, j + 1);
            return;
        }
        LinkedList<Integer> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            m[i][j] = L1.removeFirst();
            AllSudokus(m, i, j + 1);
            m[i][j] = 0;
        }
    }
    public static LinkedList<Integer> reglasAplicables(int m[][], int i, int j){
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
    public static void mostrar(int m[][]) {
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