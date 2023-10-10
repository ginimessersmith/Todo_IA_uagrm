/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.matrizia;


import java.util.LinkedList;
import java.util.Random;


/**
 *
 * @author Hp 14
 */
public class MatrizIA {
    
    private int[][] elem;   // elementos de la matriz
    private int cantFil;    // cantidad de filas
    private int cantCol;    // cantidad de columnas
    private int maxFil;     // máximo número de filas
    private int maxCol;     // máximo número de columnas
    
    public static void main(String[] args) {
        MatrizIA M1 = new MatrizIA(3,3);
        LinkedList<MatrizIA> L1 = new LinkedList();
        M1.generar(3,3,0,5);
		int m[][]={
			{0,0,0},
			{0,0,0},
			{0,0,0}
		};
        M1.mostrarMatriz();
        System.out.println("---------------------");
        System.out.println(M1.listaFil(1));
        System.out.println("---------------------");
       /* M1=M1.menor(0, 0);
        M1.mostrarMatriz*/
        System.out.println("El determinante de la matriz es: "+M1.determinante(M1, L1));
        /*M1.mostrarMatricesL1(L1);
        M1.mostrarMatrizMayorSuma(L1);*/
    }
    
    
     public MatrizIA (){
        this.elem = new int[0][0];
        this.cantFil = 0;
        this.cantCol = 0;
        this.maxFil = 0;
        this.maxCol = 0;
    }
    
    // Constructor que recibe la cantidad de filas y columnas
    public MatrizIA (int filas, int columnas) {
        this.elem = new int[filas][columnas];
        this.cantFil = filas;
        this.cantCol = columnas;
        this.maxFil = filas;
        this.maxCol = columnas;
    }
    
    // Constructor copia
    public MatrizIA(MatrizIA m) {
        this.elem = new int[m.maxFil][m.maxCol];
        this.cantFil = m.cantFil;
        this.cantCol = m.cantCol;
        this.maxFil = m.maxFil;
        this.maxCol = m.maxCol;
        
        for (int i = 0; i < m.cantFil; i++) {
            for (int j = 0; j < m.cantCol; j++) {
                this.elem[i][j] = m.elem[i][j];
            }
        }
    }
    
    // Métodos para obtener y establecer los atributos
    public int getCantFil() {
        return cantFil;
    }
    
    public int getCantCol() {
        return cantCol;
    }
    
    public int getMaxFil() {
        return maxFil;
    }
    
    public int getMaxCol() {
        return maxCol;
    }
    
    public void setElem(int[][] elem) {
        this.elem = elem;
    }
    
    public void setCantFil(int cantFil) {
        this.cantFil = cantFil;
    }
    
    public void setCantCol(int cantCol) {
        this.cantCol = cantCol;
    }
    
    public void setMaxFil(int maxFil) {
        this.maxFil = maxFil;
    }
    
    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }
    
    // Métodos para manipular la matriz
    public int getElem(int i, int j) {
        return elem[i][j];
    }
    
    public void setElem(int i, int j, int val) {
        elem[i][j] = val;
    }
    
    public void mostrarMatriz() {
    for (int i = 0; i < cantFil; i++) {
        for (int j = 0; j < cantCol; j++) {
            System.out.print(elem[i][j] + " ");
        }
        System.out.println();
    }
}

//2. Implementar M1.eliminarFila(i), método que elimina la fila i, de la matriz M1. 
   
    public void eliminarFila(int i) {
    // Desplazar las filas posteriores a la fila i una posición hacia arriba
    for (int j = i; j < cantFil - 1; j++) {
        for (int k = 0; k < cantCol; k++) {
            elem[j][k] = elem[j+1][k];
        }
    }
    
    // Decrementar la cantidad de filas
    cantFil--;
    }
    
//3. Implementar M1.eliminarCol(j)    
    public void eliminarCol(int i) {
    // Desplazar las columnas posteriores a la columna i una posición hacia la izquierda
    for (int j = 0; j < cantFil; j++) {
        for (int k = i; k < cantCol - 1; k++) {
            elem[j][k] = elem[j][k+1];
        }
    }
    
    // Decrementar la cantidad de columnas
    cantCol--;
}

//4. M1.generar(n, m, a, b) : Método que genera n x m elementos aleatorios entre a y b, inclusive en la matriz M1.    
    public void generar(int n, int m, int a, int b) {
    Random random = new Random();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            elem[i][j] = random.nextInt(b - a + 1) + a;
        }
    }
    cantFil = n;
    cantCol = m;
    }
//5. M1.listaFil(i) : Método que devuelve en una Lista, los elementos de la fila i, de la matriz M1.    
    public LinkedList<Integer> listaFil(int i) {
    LinkedList<Integer> fila = new LinkedList<Integer>();
    for (int j = 0; j < cantCol; j++) {
        fila.add(elem[i][j]);
    }
    return fila;
    }
//6. M1.listaCol(j): Método que devuelve en una Lista, los elementos de la columna j, de la matriz M1    
    public LinkedList<Integer> listaCol(int j) {
    LinkedList<Integer> columna = new LinkedList<Integer>();
    for (int i = 0; i < cantFil; i++) {
        columna.add(elem[i][j]);
    }
    return columna;
    }
//7. M1.insertarFil(i, L1) : Método que insertar los elementos de la lista L1, en la fila i, de la matriz M1.    
    public void insertarFil(int i, LinkedList<Integer> L1) {
    if (L1.size() != cantCol) {
        throw new IllegalArgumentException("La lista debe tener la misma cantidad "
                + "de elementos que la cantidad de columnas de la matriz.");
    }
    for (int j = 0; j < cantCol; j++) {
        elem[i][j] = L1.get(j);
    }
    }
//8. M1.insertarCol(i, L1) : Método que insertar los elementos de la lista L1, en la columna j, de la matriz M1.    
    public void insertarCol(int j, LinkedList<Integer> L1) {
    if (L1.size() != cantFil) {
        throw new IllegalArgumentException("La lista debe tener la misma cantidad "
                + "de elementos que la cantidad de filas de la matriz.");
    }
    for (int i = 0; i < cantFil; i++) {
        elem[i][j] = L1.get(i);
    }
    }
//9. M1.menor(i, j) : Método que devuelve una matriz nueva, resultado de eliminar la fila i y la columna j de la matriz M1.    
     
    public MatrizIA menor(int i, int j) {
    
    MatrizIA menor = new MatrizIA(this);
    menor.eliminarFila(i);
    menor.eliminarCol(j);
    return menor;    
    }
    
//10. M1.determinante() : Método que encuentra el determinante de la matriz cuadrada M1.     
    int determinante(MatrizIA A, LinkedList<MatrizIA> L1) { 
    if (A.getCantCol() == 1) return A.getElem(0, 0);//caso base
 
    int suma = 0, j = 0, i = 0;
    while (i < A.getCantCol()) {
        MatrizIA menor = A.menor(i, j);
        L1.add(new MatrizIA(menor));
        suma += signo(i, j) * A.getElem(i, j) * determinante(menor, L1);
        i++;
    } 
    return suma; 
}
    
    public int signo(int i, int j) {
    if ((i + j) % 2 == 0) {
        return 1;
    } else {
        return -1;
    }
    }
    public void mostrarMatricesL1(LinkedList<MatrizIA>L1){
        int n=1;
        for (MatrizIA matriz : L1) {
            System.out.println("Matriz Nº: "+n);
            matriz.mostrarMatriz();
            System.out.println("---------------------");
            n++;
        }

    }
// EJERCICIOS DE LA TAREA 6    
//1. Mostrar las matrices de tamaño-k. k <= n.    
    public void mostrarMatricesDeTamanoK(int k, LinkedList<MatrizIA> L1) {
    for (MatrizIA matriz : L1) {
        if (matriz.getCantFil() <= k && matriz.getCantCol() <= k) {
            System.out.println("Matriz de tamaño " + matriz.getCantFil() + "x" + matriz.getCantCol() + ":");
            matriz.mostrarMatriz();
            System.out.println();
        }
    }
    }
//2. Mostrar las matrices que tienen todos sus elementos diferentes.    
    public static boolean matrizElementosDiferentes(MatrizIA matriz) {
    for (int i = 0; i < matriz.getCantFil(); i++) {
        for (int j = 0; j < matriz.getCantCol(); j++) {
            int elemActual = matriz.getElem(i, j);
            for (int k = i; k < matriz.getCantFil(); k++) {
                for (int l = (k == i) ? j + 1 : 0; l < matriz.getCantCol(); l++) {
                    if (elemActual == matriz.getElem(k, l)) {
                        return false;
                    }
                }
            }
        }
    }
    return true;
}
    public void mostrarMatricesElemDif(LinkedList<MatrizIA> L1){
        for (MatrizIA matriz : L1) {
            if (matrizElementosDiferentes(matriz)) {
            matriz.mostrarMatriz();
            System.out.println("--------");
            }
        }
   }
//3. Mostrar las matrices que tienen todos sus elementos iguales.
    public static boolean todosIguales(MatrizIA matriz) {
    int n = matriz.getCantFil();
    int m = matriz.getCantCol();
    int primerElemento = matriz.getElem(0, 0); //Obtenemos el primer elemento
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(matriz.getElem(i, j) != primerElemento) { //Comparamos con el primer elemento
                return false; //Si encontramos un elemento diferente, retornamos falso
            }
        }
    }
    return true; //Si no se encontró ningún elemento diferente, retornamos verdadero
    }
    public void mostrarMatricesElemIguales(LinkedList<MatrizIA> L1){
        for (MatrizIA matriz : L1) {
            if (todosIguales(matriz)) {
            matriz.mostrarMatriz();
            System.out.println("--------");
            }
        }
    }
// 4. Mostrar las matrices identidades.
    public void mostrarMatricesIdentidad(LinkedList<MatrizIA> L1){
        for (MatrizIA matriz : L1) {
            if (esMatrizIdentidad(matriz)) {
            matriz.mostrarMatriz();
            System.out.println("--------");
            }
        }
    }
    
    public static boolean esMatrizIdentidad(MatrizIA matriz) {
    int filas = matriz.getCantFil();
    int columnas = matriz.getCantCol();
    
    // Una matriz identidad debe ser cuadrada
    if (filas != columnas) {
        return false;
    }
    
    // Verificar que los elementos en la diagonal principal sean 1 y los demás 0
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            int elemento = matriz.getElem(i, j);
            if (i == j) {
                if (elemento != 1) {
                    return false;
                }
            } else {
                if (elemento != 0) {
                    return false;
                }
            }
        }
    }
    
    return true;
    }
//5. Mostrar las matrices que tienen la mayor sumatoria de elementos. Asumir que
//  los elementos de la matriz original también pueden contener valores negativos.
    public void mostrarMatrizMayorSuma(LinkedList<MatrizIA> L1) {
    int maxSuma = Integer.MIN_VALUE;
    MatrizIA matrizMax = null;

    for (MatrizIA matriz : L1) {
        int suma = 0;
        for (int i = 0; i < matriz.getCantFil(); i++) {
            for (int j = 0; j < matriz.getCantCol(); j++) {
                suma += matriz.getElem(i, j);
            }
        }
        if (suma > maxSuma) {
            maxSuma = suma;
            matrizMax = matriz;
        }
    }

    System.out.println("La matriz con la mayor sumatoria de elementos es:");
    matrizMax.mostrarMatriz();
    }
//Otras adicionales
// Sumar las matrices de la Lista y devolver en nueva matriz
    public MatrizIA sumarMatrices(LinkedList<MatrizIA> L1) {
    int filas = L1.get(0).getCantFil();
    int columnas = L1.get(0).getCantCol();
    MatrizIA resultado = new MatrizIA(filas, columnas);

    for (MatrizIA matriz : L1) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.setElem(i, j, resultado.getElem(i, j) + matriz.getElem(i, j));
            }
        }
    }

    return resultado;
    }
//Matriz de L1 con menos pares
    public MatrizIA matrizConMenosPares(LinkedList<MatrizIA> listaMatrices) {
    MatrizIA matrizConMenosPares = null;
    int cantidadParesMinima = Integer.MAX_VALUE;
    
    for (MatrizIA matriz : listaMatrices) {
        int cantidadPares = contarPares(matriz);
        if (cantidadPares < cantidadParesMinima) {
            cantidadParesMinima = cantidadPares;
            matrizConMenosPares = matriz;
        }
    }
    
    return matrizConMenosPares;
    }
public int contarPares(MatrizIA A) {
    int pares = 0;
    for(int i = 0; i < A.getCantFil(); i++) {
        for(int j = 0; j < A.getCantCol(); j++) {
            if(A.getElem(i,j) % 2 == 0) {
                pares++;
            }
        }
    }
    return pares;
}

}
