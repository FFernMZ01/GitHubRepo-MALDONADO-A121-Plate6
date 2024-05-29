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

public class Example6 {
    public int[][] FadjacencyMatrix;
    
    Example6(int vertices){
        FadjacencyMatrix = new int[vertices][vertices];
    }
    
    void addEdge(int source, int destination) {
        FadjacencyMatrix[source][destination] = 1;
        if (source != destination) {
            FadjacencyMatrix[destination][source] = 1;
        }
    }
    
    void printFAdjacencyMatrix(){
        for(int[]row : FadjacencyMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        
        Example6 FGraph1 = new Example6(5);
        FGraph1.addEdge(1,0);
        FGraph1.addEdge(0,2);
        FGraph1.addEdge(2,1);
        FGraph1.addEdge(0,3);
        FGraph1.addEdge(3,4);
        FGraph1.printFAdjacencyMatrix();
        
        Example6 FGraph2 = new Example6(3);
        FGraph2.addEdge(0,1);
        FGraph2.addEdge(1,2);
        FGraph2.addEdge(0,1);
        FGraph2.printFAdjacencyMatrix();
        
        Example6 FGraph3 = new Example6(3);
        FGraph3.addEdge(0,1);
        FGraph3.addEdge(1,2);
        FGraph3.addEdge(2,1);
        FGraph3.printFAdjacencyMatrix();
        
        Example6 FGraph4 = new Example6(4);
        FGraph4.addEdge(0,1);
        FGraph4.addEdge(1,2);
        FGraph4.addEdge(2,3);
        FGraph4.printFAdjacencyMatrix();
        
        Example6 FGraph5 = new Example6(4);
        FGraph5.addEdge(0,1);
        FGraph5.addEdge(1,2);
        FGraph5.addEdge(2,0);
        FGraph5.printFAdjacencyMatrix();
    }
}
