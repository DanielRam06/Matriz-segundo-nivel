import java.util.Scanner;
import java.util.Arrays;

public class Matriz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu Matrices");
            System.out.println("1. Multiplicar matrices");
            System.out.println("2. Transponer matriz");
            System.out.println("3. Sumar diagonal principal");
            System.out.println("4. Encontrar el valor más grande");
            System.out.println("5. Suma de matrices");
            System.out.println("6. Producto escalar por matriz");
            System.out.println("0. Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                    int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};//dos matrices que seran multiplicadas
                    multiplicarMatrices(A, B);
                    break;
                case 2:
                    int[][] matriz = {{1, 2, 3}, {4, 5, 6}};//matriz que sera traspuesta
                    int[][] matrizTranspuesta = transponerMatriz(matriz);
                    System.out.println("Matriz original:");
                    imprimirMatriz(matriz);
                    System.out.println("Matriz transpuesta:");
                    imprimirMatriz(matrizTranspuesta);
                    break;
                case 3:
                	 int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//matriz cuadrada 
                    int suma = sumaDiagonalPrincipal(matriz1);
                    System.out.println("La suma de la diagonal principal es: " + suma);
                    break;
                case 4:
                	int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//matris para el valor mas grande
                    int max = valorMasGrande(matriz2);
                    System.out.println("El valor más grande de la matriz es: " + max);
                    break;
                case 5:
                	int[][] matriz3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//matrices que seran sumadas 
                    int[][] matriz4 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
                    imprimirMatrizSumada(matriz3, matriz4);
                    break;
                case 6:
                	int[][] resultado;
                    int escalar;
                    int[][] matriz5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//la matriz ya esta esblecida para el escalar
                    System.out.print("Ingrese el escalar: ");//pide que se ingrese el escalar a escoger
                    escalar = sc.nextInt();
                    resultado = productoMatrizPorEscalar(matriz5, escalar);
                    for (int i = 0; i < resultado.length; i++) {
                        for (int j = 0; j < resultado[0].length; j++) {
                            System.out.print(resultado[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }

    //1. Escribe un método que multiplique dos matrices y muestre el resultado.
    //Las matrices pueden ser de cualquier tamaño, pero deben ser compatibles para multiplicarse.
    public static void multiplicarMatrices(int[][] A, int[][] B) {

        // Comprobar que las matrices son compatibles
        if (A[0].length != B.length) {
            System.out.println("Las matrices no son compatibles para multiplicarse.");
            return;
        }

        // Crear matriz vacía para el resultado
        int[][] resultado = new int[A.length][B[0].length];

        // Multiplicar las matrices
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El resultado de la multiplicación es:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }

    //2. Transponer una matriz, escriba un método que tome una matriz como entrada y devuelva la transpuesta de dicha matriz.
    public static int[][] transponerMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] matrizTranspuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizTranspuesta[j][i] = matriz[i][j];
            }
        }

        return matrizTranspuesta;
    }
  
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
  //3. Suma diagonal: escribe un método que tome una matriz cuadrada como entrada y devuelva la suma de los elementos de la diagonal principal.
        public static int sumaDiagonalPrincipal(int[][] matriz) {
            int n = matriz.length;
            int suma = 0;
            for (int i = 0; i < n; i++) {
                suma += matriz[i][i];
            }
            return suma;
        }
      //4. Encuentra el máximo: escribe un método que reciba una matriz de entrada y que devuelva el valor mas grande de la matriz.
        public static int valorMasGrande(int[][] matriz) {
            int max = matriz[0][0];
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] > max) {
                        max = matriz[i][j];
                    }
                }
            }
            return max;
        }

	
	//5. Suma dos matrices: escribe un método que reciba dos matrices de entrada y devuelva la matriz sumada.
public static void imprimirMatrizSumada(int[][] matriz1, int[][] matriz2) {
    if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
        System.out.println("Las matrices no tienen la misma dimensión");
        return;
    }
    
    int filas = matriz1.length;
    int columnas = matriz2[0].length;
    
    int[][] matrizSumada = new int[filas][columnas];
    
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            matrizSumada[i][j] = matriz1[i][j] + matriz2[i][j];
        }
    }
    
    // Imprimir la matriz sumada
    System.out.println("Matriz sumada:");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            System.out.print(matrizSumada[i][j] + " ");
        }
        System.out.println();
    }
}
	//6. Multiplicar una matriz por un escalar: Escribe un método que reciba cualquier matriz y un escalar como entradas y devuelve el producto de la matriz por el escalar.
public static int[][] productoMatrizPorEscalar(int[][] matriz, int escalar) {
    int filas = matriz.length;
    int columnas = matriz[0].length;
    int[][] resultado = new int[filas][columnas];
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            resultado[i][j] = matriz[i][j] * escalar;
        }
    }
    return resultado;
}
}
