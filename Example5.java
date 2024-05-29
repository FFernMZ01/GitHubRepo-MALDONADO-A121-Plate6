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

public class Example5 {
    public Map<Integer, List<Integer>> graph;
    public Map<Integer, Integer> colorMap;
    
    Example5(int vertices){
        graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }
        colorMap = new HashMap<>();
    }
    
    void addEdge(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }
    
    boolean isBipartiteUtil(int currentVertex, int parentVertex) {
        if (colorMap.containsKey(currentVertex)){
            return colorMap.get(currentVertex) == 1;
        }
        colorMap.put(currentVertex, 1);
        
        for (int adjacentVertex : graph.get(currentVertex)){
            if (adjacentVertex == parentVertex) {
                continue;
            }
            
            if (!isBipartiteUtil(adjacentVertex, currentVertex)){
                return false;
            }
        }
        
        return true;
    }
    
    boolean isBipartite(){
        for(int vertex : graph.keySet()){
            if(!colorMap.containsKey(vertex)){
                if(!isBipartiteUtil(vertex, -1)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        
        Example5 FGraph1 = new Example5(5);
        FGraph1.addEdge(1,0);
        FGraph1.addEdge(0,2);
        FGraph1.addEdge(2,1);
        FGraph1.addEdge(0,3);
        FGraph1.addEdge(3,4);
        System.out.println("Graph 1: " + FGraph1.isBipartite());
        
        Example5 FGraph2 = new Example5(3);
        FGraph2.addEdge(0,1);
        FGraph2.addEdge(1,2);
        System.out.println("Graph 2: " + FGraph2.isBipartite());
        
        Example5 FGraph3 = new Example5(3);
        FGraph3.addEdge(0,1);
        FGraph3.addEdge(1,1);
        System.out.println("Graph 3: " + FGraph3.isBipartite());
        
        Example5 FGraph4 = new Example5(4);
        FGraph4.addEdge(0,1);
        FGraph4.addEdge(1,2);
        FGraph4.addEdge(2,3);
        System.out.println("Graph 4: " + FGraph4.isBipartite());
        
        Example5 FGraph5 = new Example5(4);
        FGraph5.addEdge(0,1);
        FGraph5.addEdge(1,2);
        FGraph5.addEdge(2,0);
        System.out.println("Graph 5: " + FGraph5.isBipartite());
    }
}
