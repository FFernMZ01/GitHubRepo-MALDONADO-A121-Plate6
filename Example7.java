/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds2plate6maldonado;

/**
 *
 * @author Fernando Maldonado
 */
import java.util.*;

public class Example7 {
    public int [][] FincidenceMatrix;
    public Map<String, Integer> edgeMap;
    
    Example7(int vertices, int edges){
        FincidenceMatrix = new int[vertices][edges];
        edgeMap = new HashMap<>();
    }
    
    void addEdge(int vertex1, int vertex2, int edgeIndex){
        FincidenceMatrix[vertex1][edgeIndex] = 1;
        FincidenceMatrix[vertex2][edgeIndex] = 1;
        edgeMap.put(vertex1 + "," + vertex2, edgeIndex);
        edgeMap.put(vertex2 + "," + vertex1, edgeIndex);
    }
    
    void printFIncidenceMatrix(){
        for(int[] row : FincidenceMatrix) {
            for(int value : row){
                System.out.print(value + " ");  
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        
        Example7 FGraph1 = new Example7(5,5);
        FGraph1.addEdge(0, 1, 0);
        FGraph1.addEdge(0, 2, 1);
        FGraph1.addEdge(1, 2, 2);
        FGraph1.addEdge(2, 3, 3);
        FGraph1.addEdge(3, 4, 4);
        FGraph1.printFIncidenceMatrix();
        
        Example7 FGraph2 = new Example7(3,3);
        FGraph2.addEdge(0, 1, 0);
        FGraph2.addEdge(1, 2, 1);
        FGraph2.addEdge(0, 2, 2);
        FGraph2.printFIncidenceMatrix();
        
        Example7 FGraph3 = new Example7(4,4);
        FGraph3.addEdge(0, 1, 0);
        FGraph3.addEdge(1, 2, 1);
        FGraph3.addEdge(2, 3, 2);
        FGraph3.addEdge(3, 0, 3);
        FGraph3.printFIncidenceMatrix();
        
        Example7 FGraph4 = new Example7(4,5);
        FGraph4.addEdge(0, 1, 0);
        FGraph4.addEdge(1, 2, 1);
        FGraph4.addEdge(2, 3, 2);
        FGraph4.addEdge(3, 0, 3);
        FGraph4.addEdge(0, 2, 4);
        FGraph4.printFIncidenceMatrix();
        
        Example7 FGraph5 = new Example7(5,6);
        FGraph5.addEdge(0, 1, 0);
        FGraph5.addEdge(1, 2, 1);
        FGraph5.addEdge(2, 3, 2);
        FGraph5.addEdge(3, 4, 3);
        FGraph5.addEdge(4, 0, 4);
        FGraph5.addEdge(0, 3, 5);
        FGraph5.printFIncidenceMatrix();
    }
}
