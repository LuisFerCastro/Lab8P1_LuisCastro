/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_luiscastro;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author lfern
 */
public class Lab8P1_LuisCastro {
static Scanner leer = new Scanner(System.in);
static Random rand = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*****Menu*****");
        System.out.println("1. Game of Life.");
        System.out.println("2. Salir. ");
        System.out.println("Ingrese su opcion: ");
        int opcion = leer.nextInt();
        
        while(opcion != 2){
            while(opcion < 0 || opcion > 2){
                System.out.println("Opcion invalida. Ingrese de nuevo: ");
                opcion = leer.nextInt();
            }
            switch(opcion){
                case 1:
                    Game g = new Game();
                    
                    System.out.println("Ingrese el # de rondas: ");
                    int n_rondas = leer.nextInt();
                    g.setNum_r(n_rondas);
                    
                    int [][]matriz = new int [10][10];
                    g.setMatrizSig(matriz);
                    
                    int [][]matriz2 = new int[10][10];
                    
                    ArrayList<String> coords = new ArrayList<>();
                    System.out.println("");
                    
                    matriz2 = tablero(matriz,matriz2,coords);
                    g.setMatrizAc(matriz2);
                    
                    
                    coords = devolver_coords(matriz2, coords);
                    g.setCoords(coords);
                            
                    
                    imprimirmatriz(matriz2);
                    
                    g.jugar(n_rondas);
                    break;   
            }
            System.out.println("*****Menu*****");
            System.out.println("1. Game of Life.");
            System.out.println("2. Salir.");
            System.out.println("Ingrese su opcion: ");
            opcion = leer.nextInt();
        }
    // TODO code application logic here
    }
    public static int [][] tablero(int [][]matriz, int[][]matriz2, ArrayList<String> coords){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if( i == 0 || j == 0 || i == 9 || j == 9){
                    matriz[i][j]=0;
                }else{
                    matriz2[i][j] = rand.nextInt((1-0)+1)+0;
                    if (matriz2 [i][j]==1){
                        coords.add(Integer.toString(i)+":"+Integer.toString(j));
                    }
                }        
            }
        }
        System.out.println("La lista de coordenadas es: "
                +coords);
        
        return matriz2;
    }//fin metodo crear inicial
    
    public static ArrayList<String> devolver_coords(int[][]matriz, ArrayList<String>coords){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == 1){
                    coords.add(Integer.toString(i)+":"+Integer.toString(j));
                }          
            }   
        }
        return coords;
    }
    public static void imprimirmatriz(int[][]matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
                
            }
            System.out.println(""); 
        }//fin metodo imprimir matriz
    }   //fin metodo main
}
