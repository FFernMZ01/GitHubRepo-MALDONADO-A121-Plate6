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

public class Example4 {
    public Map<Integer, Integer> degreeMap;
    
    Example4(int vertices){
        degreeMap = new HashMap<>();
        for (int i = 0; i < vertices; i++ ){
            degreeMap.put(i, 0);
        }
    }
    
    void addEdge(int source, int destination){
        degreeMap.put(source, degreeMap.get(source)+ 1);
        degreeMap.put(destination, degreeMap.get(destination)+ 1);
    }
    
    void printDegrees(){
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()){
            System.out.println("Vertex " + entry.getKey() + "has degree " + entry.getValue());
        }
    }
    public static void main(String[] args){
        Example4 FGraph1 = new Example4(5);
        FGraph1.addEdge(1,0);
        FGraph1.addEdge(0,2);
        FGraph1.addEdge(2,1);
        FGraph1.addEdge(0,3);
        FGraph1.addEdge(3,4);
        System.out.println("Graph 1: ");
        FGraph1.printDegrees();
        
        Example4 FGraph2 = new Example4(3);
        FGraph2.addEdge(0,1);
        FGraph2.addEdge(1,2);
        System.out.println("Graph 2: ");
        FGraph2.printDegrees();
        
        Example4 FGraph3 = new Example4(3);
        FGraph3.addEdge(0,1);
        FGraph3.addEdge(1,1);
        System.out.println("Graph 3: ");
        FGraph3.printDegrees();
        
        Example4 FGraph4 = new Example4(4);
        FGraph4.addEdge(0,1);
        FGraph4.addEdge(1,2);
        FGraph4.addEdge(2,3);
        System.out.println("Graph 4: ");
        FGraph4.printDegrees();
        
        Example4 FGraph5 = new Example4(4);
        FGraph5.addEdge(0,1);
        FGraph5.addEdge(1,2);
        FGraph5.addEdge(2,0);
        System.out.println("Graph 5: ");
        FGraph5.printDegrees();
        
    }
}


