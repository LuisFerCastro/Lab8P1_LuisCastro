/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_luiscastro;

import java.util.ArrayList;

/**
 *
 * @author lfern
 */
public class Game {
    int matrizAc[][];
    int matrizSig[][];
    ArrayList<String>coords;
    int num_r;

    public Game() {//Constructor
    }

    public int[][] getMatrizAc() {
        return matrizAc;
    }

    public void setMatrizAc(int[][] matrizAc) {
        this.matrizAc = matrizAc;
    }

    public int[][] getMatrizSig() {
        return matrizSig;
    }

    public void setMatrizSig(int[][] matrizSig) {
        this.matrizSig = matrizSig;
    }

    public ArrayList<String> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<String> coords) {
        this.coords = coords;
    }

    public int getNum_r() {
        return num_r;
    }

    public void setNum_r(int num_r) {
        this.num_r = num_r;
    }
    
    public void jugar(int num_r){
        //ArrayList <String> lista = new ArrayList<>();
        for(int i = 0; i < num_r; i++){
            Print(nextGen());
        }
    }
  
    public ArrayList<String>nextGen(){
        int cont_vecinos = 0;
        ArrayList<String> lista = new ArrayList<>();
        int [][]temp =  new int[10][10];
        for (int i = 0; i < matrizAc.length; i++) {
            for (int j = 0; j < matrizAc[i].length; j++) {
                if(i == 0 || j == 0 || i == 9 || j == 9){
                    
                }else{
                    if(matrizAc[i][j] == 1){
                        if(matrizAc[i-1][j-1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i-1][j]== 1){
                            cont_vecinos++;
                        }
                    
                        if(matrizAc[i-1][j+1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i][j-1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i][j+1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i+1][j-1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i+1][j] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i+1][j+1] == 1){
                            cont_vecinos++;
                        }
                        
                        if(cont_vecinos == 2){
                            matrizSig[i][j] = 1;
                            cont_vecinos = 0;
                        }else{
                            matrizSig[i][j] =0;
                            cont_vecinos = 0;
                        }
                        
                       }else if (matrizAc[i][j] == 0){
                        if(matrizAc[i-1][j-1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i-1][j]== 1){
                            cont_vecinos++;
                        }
                    
                        if(matrizAc[i-1][j+1] == 1){
                        cont_vecinos++;
                        }
                        if(matrizAc[i][j-1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i][j+1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i+1][j-1] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i+1][j] == 1){
                            cont_vecinos++;
                        }
                        if(matrizAc[i+1][j+1] == 1){
                            cont_vecinos++;
                        }
                    
                        if(cont_vecinos == 3){
                                matrizSig[i][j] = 1;
                                cont_vecinos = 0;
                            }else{
                                matrizSig[i][j] = 0;
                                cont_vecinos = 0;
                        }
                    }  
                }        
            }
        }
        
        for (int i = 0; i < matrizSig.length; i++) {
            for (int j = 0; j < matrizSig.length; j++) {
                if(matrizSig[i][j] == 1){
                    lista.add(Integer.toString(i)+":"+Integer.toString(j));
                }
            }
        }
        matrizAc = matrizSig;
        matrizSig = temp;
        System.out.println("Las coordenas son: "+lista);
        return lista;
    }// fin metodo nextGen
    
    public void Print(ArrayList<String> coords){
        int [][]temporal = new int[10][10];
        int coorx;
        int coory;
        String indice_ac;
        
        for (int i = 0; i < coords.size(); i++) {
            indice_ac = coords.get(i);
            coorx = (int)indice_ac.charAt(0) - (int)'0';
            coory =(int) indice_ac.charAt(2) - (int)'0';
            temporal[coorx][coory] = 1;
        }
        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < temporal[i].length; j++) {
                System.out.print("["+temporal[i][j]+"]");
                
            }
            System.out.println(""); 
        }
    }
}


