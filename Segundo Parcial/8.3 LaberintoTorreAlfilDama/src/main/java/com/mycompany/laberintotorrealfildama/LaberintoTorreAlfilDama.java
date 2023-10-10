/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laberintotorrealfildama;

import java.util.LinkedList;

/**
 *
 * @author PAZ
 */
public class LaberintoTorreAlfilDama {

   public static int c=0;
    public static int maxpaso=0;
    public static int minpaso= Integer.MAX_VALUE;
    public static LinkedList<int[][]> soluciones = new LinkedList<>();
    public static int filas = 3, columnas = 3;
    public static void main(String[] args) {
        //int filas = 5, columnas = 5;
        int matriz[][] = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
           // {0, 0, 0,0}
            //{0, 0, 0,0}
            
        };

        // A) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final.
        laberintoDama(matriz, 0, 0, filas - 1, columnas - 1, 1);
        System.out.println("Soluciones posibles: " + c);
        c = 0; // Reiniciar contador
/*
        // B) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final
        // tal que se visiten todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.
        laberintoCaballoB(matriz, 0, 0, filas - 1, columnas - 1, 1);
        System.out.println("Soluciones posibles con visita a todas las casillas: " + c);
        c = 0; // Reiniciar contador

        // C) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final
        // tal que NO se visiten todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.
        laberintoCaballoC(matriz, 0, 0, filas - 1, columnas - 1, 1);
        System.out.println("Soluciones posibles sin visita a todas las casillas: " + c);
        c = 0; // Reiniciar contador

        // D) Algoritmo para mostrar todos los caminos posibles de máxima longitud desde una posición inicial a una posición final.
        laberintoCaballoD(matriz, 0, 0, filas - 1, columnas - 1, 1);
        System.out.println("Soluciones posibles de máxima longitud: " + c);
        c = 0; // Reiniciar contador

        // E) Algoritmo para mostrar todos los caminos posibles de mínima longitud desde una posición inicial a una posición final.
        laberintoCaballoE(matriz, 0, 0, filas - 1, columnas - 1, 1);
        System.out.println("Soluciones posibles de mínima longitud: " + c);

        // Mostrar todas las soluciones posibles
        for (int[][] solucion : soluciones) {
            mostrar(solucion);
        }*/
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
    
    public static int[][] clonarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] clon = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                clon[i][j] = matriz[i][j];
            }
        }
        return clon;
    }
 
       
    public static LinkedList<Regla> reglasAplicablesTorre(int m[][], int i, int j) {
    LinkedList<Regla> L1 = new LinkedList();
    int[] dx = {0, -1, 0, 1}; // Desplazamiento en las coordenadas x
    int[] dy = {-1, 0, 1, 0}; // Desplazamiento en las coordenadas y

    for (int k = 0; k < 4; k++) {
        int x = i + dx[k];
        int y = j + dy[k];

        while (posValida(m, x, y)) {
            L1.add(new Regla(x, y));
            x += dx[k];
            y += dy[k];
        }
    }

    return L1;
}//*/
/* Otras formas de reglas para la torre
    public static LinkedList<Regla> reglasAplicablesTorre(int m[][], int i, int j){
        LinkedList<Regla> L1 = new LinkedList();
        int x=1;
        while(posValida(m, i, j - x)) {L1.add(new Regla(i, j - x));x++;
        } 
        x=1;
        while(posValida(m, i - x, j)) {L1.add(new Regla(i - x, j));x++;
        }
        x=1;
        while(posValida(m, i, j + x)) {L1.add(new Regla(i, j + x));x++;
        }
        x=1;
        while(posValida(m, i + x, j)) {L1.add(new Regla(i + x, j));x++;
        }    
                   
        return L1;
    }//*/
   
 /*   public static LinkedList<Regla> reglasAplicablesTorre(int m[][], int i, int j){
        LinkedList<Regla> L1 = new LinkedList();
        for(int x=j; x>=0; x--){
           if(posValida(m, i, j - x)) L1.add(new Regla(i, j - x));
        }
        for(int x=i; x>=0; x--){
           if(posValida(m, i - x, j)) L1.add(new Regla(i - x, j));
        }
        for(int x=j; x<columnas; x++){
           if(posValida(m, i, j + x)) L1.add(new Regla(i, j + x));
        }
        for(int x=i; x<filas; x++){
           if(posValida(m, i + x, j)) L1.add(new Regla(i + x, j));
        }    
                   
        return L1;
    }*/
    
/*a)     Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final. Además, mostrar la cantidad de soluciones posibles.  */  
   public static void laberintoTorre ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ mostrar(m); c++;}
            
            LinkedList<Regla> L1 = reglasAplicablesTorre(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoTorre(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*b)     Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que se visiten todas las casillas de la matriz. 
Además, mostrar la cantidad de soluciones posibles.   */
   public static void laberintoTorreB ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(!existe(m,0)){
                mostrar(m); c++;}
            }
            
            LinkedList<Regla> L1 = reglasAplicablesTorre(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoTorreB(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*c)      Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que NO se visiten todas las casillas de la matriz. 
Además, mostrar la cantidad de soluciones posibles.   */
   public static void laberintoTorreC ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(existe(m,0)){
                mostrar(m); c++;} 
            }
            
            LinkedList<Regla> L1 = reglasAplicablesTorre(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoTorreC(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*d)     Algoritmo para mostrar todos los caminos posibles de máxima longitud 
desde una posición inicial a una posición final. Además, mostrar la cantidad de 
soluciones posibles.*/
   public static void laberintoTorreD(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j))
            return;
        m[i][j] = paso;

        if (i == ifin && j == jfin) {
            if (paso > maxpaso) {
                maxpaso = paso; c = 1; mostrar(m);
            } else if (paso == maxpaso) {
                c++; mostrar(m);
            }
        }

        LinkedList<Regla> L1 = reglasAplicablesTorre(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoTorreD(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*e)     Algoritmo para mostrar todos los caminos posibles de mínima longitud 
desde una posición inicial a una posición final. Además, mostrar la cantidad de 
soluciones posibles.*/
   public static void laberintoTorreE(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j))
            return;
        m[i][j] = paso;

        if (i == ifin && j == jfin) {
            if (paso < minpaso) {
                minpaso = paso;
                c = 1;
                soluciones.clear();
                soluciones.addLast(clonarMatriz(m));
            } else if (paso == minpaso) {
                c++;
                soluciones.addLast(clonarMatriz(m));
            }
        }

        LinkedList<Regla> L1 = reglasAplicablesTorre(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoTorreE(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
public static LinkedList<Regla> reglasAplicablesAlfil(int m[][], int i, int j) {
    LinkedList<Regla> L1 = new LinkedList();
    int x = 1;
    
    // Movimiento en diagonal superior izquierda
    while (posValida(m, i - x, j - x)) {
        L1.add(new Regla(i - x, j - x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal superior derecha
    while (posValida(m, i - x, j + x)) {
        L1.add(new Regla(i - x, j + x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal inferior izquierda
    while (posValida(m, i + x, j - x)) {
        L1.add(new Regla(i + x, j - x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal inferior derecha
    while (posValida(m, i + x, j + x)) {
        L1.add(new Regla(i + x, j + x));
        x++;
    }
    
    return L1;
}
   
   /*a)     Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final. Además, mostrar la cantidad de soluciones posibles.  */  
   public static void laberintoAlfil ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ mostrar(m); c++;}
            
            LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoAlfil(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*b)     Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que se visiten todas las casillas de la matriz. 
Además, mostrar la cantidad de soluciones posibles.   */
   public static void laberintoAlfilB ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(!existe(m,0)){
                mostrar(m); c++;}
            }
            
            LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoAlfilB(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*c)      Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que NO se visiten todas las casillas de la matriz. 
Además, mostrar la cantidad de soluciones posibles.   */
   public static void laberintoAlfilC ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(existe(m,0)){
                mostrar(m); c++;} 
            }
            
            LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoAlfilC(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*d)     Algoritmo para mostrar todos los caminos posibles de máxima longitud 
desde una posición inicial a una posición final. Además, mostrar la cantidad de 
soluciones posibles.*/
   public static void laberintoAlfilD(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j))
            return;
        m[i][j] = paso;

        if (i == ifin && j == jfin) {
            if (paso > maxpaso) {
                maxpaso = paso; c = 1; mostrar(m);
            } else if (paso == maxpaso) {
                c++; mostrar(m);
            }
        }

        LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoAlfilD(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*e)     Algoritmo para mostrar todos los caminos posibles de mínima longitud 
desde una posición inicial a una posición final. Además, mostrar la cantidad de 
soluciones posibles.*/
   public static void laberintoAlfilE(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j))
            return;
        m[i][j] = paso;

        if (i == ifin && j == jfin) {
            if (paso < minpaso) {
                minpaso = paso;
                c = 1;
                soluciones.clear();
                soluciones.addLast(clonarMatriz(m));
            } else if (paso == minpaso) {
                c++;
                soluciones.addLast(clonarMatriz(m));
            }
        }

        LinkedList<Regla> L1 = reglasAplicablesAlfil(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoAlfilE(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
//------------------------------------------------------------------------------   
   public static LinkedList<Regla> reglasAplicablesDama(int m[][], int i, int j) {
    LinkedList<Regla> L1 = new LinkedList();

    // Movimientos de la torre
    L1.addAll(reglasAplicablesTorre(m, i, j));

    // Movimientos del alfil
    L1.addAll(reglasAplicablesAlfil(m, i, j));

    return L1;
    }
/*Otra forma de reglade dama   
   public static LinkedList<Regla> reglasAplicablesDama(int m[][], int i, int j) {
    LinkedList<Regla> L1 = new LinkedList();
    int x = 1;
    
    // Movimiento vertical hacia arriba
    while (posValida(m, i - x, j)) {
        L1.add(new Regla(i - x, j));
        x++;
    }
    
    x = 1;
    
    // Movimiento vertical hacia abajo
    while (posValida(m, i + x, j)) {
        L1.add(new Regla(i + x, j));
        x++;
    }
    
    x = 1;
    
    // Movimiento horizontal hacia la izquierda
    while (posValida(m, i, j - x)) {
        L1.add(new Regla(i, j - x));
        x++;
    }
    
    x = 1;
    
    // Movimiento horizontal hacia la derecha
    while (posValida(m, i, j + x)) {
        L1.add(new Regla(i, j + x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal superior izquierda
    while (posValida(m, i - x, j - x)) {
        L1.add(new Regla(i - x, j - x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal superior derecha
    while (posValida(m, i - x, j + x)) {
        L1.add(new Regla(i - x, j + x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal inferior izquierda
    while (posValida(m, i + x, j - x)) {
        L1.add(new Regla(i + x, j - x));
        x++;
    }
    
    x = 1;
    
    // Movimiento en diagonal inferior derecha
    while (posValida(m, i + x, j + x)) {
        L1.add(new Regla(i + x, j + x));
        x++;
    }
    
    return L1;
}*/

   
   /*a)     Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final. Además, mostrar la cantidad de soluciones posibles.  */  
   public static void laberintoDama ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ mostrar(m); c++;}
            
            LinkedList<Regla> L1 = reglasAplicablesDama(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoDama(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*b)     Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que se visiten todas las casillas de la matriz. 
Además, mostrar la cantidad de soluciones posibles.   */
   public static void laberintoDamaB ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(!existe(m,0)){
                mostrar(m); c++;}
            }
            
            LinkedList<Regla> L1 = reglasAplicablesDama(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoDamaB(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*c)      Algoritmo para mostrar todos los caminos posibles desde una posición 
inicial a una posición final tal que NO se visiten todas las casillas de la matriz. 
Además, mostrar la cantidad de soluciones posibles.   */
   public static void laberintoDamaC ( int m[][], int i , int j,int ifin , int jfin , int paso) {
            if(!posValida (m, i , j)) return;
            m[i ][j] = paso ;
            
            if(i == ifin && j == jfin ){ 
                if(existe(m,0)){
                mostrar(m); c++;} 
            }
            
            LinkedList<Regla> L1 = reglasAplicablesDama(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoDamaC(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*d)     Algoritmo para mostrar todos los caminos posibles de máxima longitud 
desde una posición inicial a una posición final. Además, mostrar la cantidad de 
soluciones posibles.*/
   public static void laberintoDamaD(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j))
            return;
        m[i][j] = paso;

        if (i == ifin && j == jfin) {
            if (paso > maxpaso) {
                maxpaso = paso; c = 1; mostrar(m);
            } else if (paso == maxpaso) {
                c++; mostrar(m);
            }
        }

        LinkedList<Regla> L1 = reglasAplicablesDama(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoDamaD(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
/*e)     Algoritmo para mostrar todos los caminos posibles de mínima longitud 
desde una posición inicial a una posición final. Además, mostrar la cantidad de 
soluciones posibles.*/
   public static void laberintoDamaE(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j))
            return;
        m[i][j] = paso;

        if (i == ifin && j == jfin) {
            if (paso < minpaso) {
                minpaso = paso;
                c = 1;
                soluciones.clear();
                soluciones.addLast(clonarMatriz(m));
            } else if (paso == minpaso) {
                c++;
                soluciones.addLast(clonarMatriz(m));
            }
        }

        LinkedList<Regla> L1 = reglasAplicablesDama(m, i, j);
            while(!L1.isEmpty()){
                Regla R = L1.removeFirst(); // Elige la 1ra Regla y elimina
                laberintoDamaE(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
    }
   
}
