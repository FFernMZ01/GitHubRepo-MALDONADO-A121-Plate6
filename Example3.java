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

public class Example3 {
    public boolean[] visited;
    public boolean[] recursionStack;
    public List<List<Integer>> graph;
    
    Example3(int vertices){
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[vertices];
        recursionStack = new boolean[vertices];
    }
    
    void addEdge(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }
    
    boolean isCyclic(){
        for (int i = 0; i < graph.size(); i++){
            if(!visited[i] && isCyclicUtil(i, -1)) {
                return true;
            }
        }
        return false;
    }
    
    boolean isCyclicUtil(int currentVertex, int parentVertex){
        visited[currentVertex] = true;
        recursionStack[currentVertex] = true;
        
        for(int adjacentVertex : graph.get(currentVertex)){
            if(!visited[adjacentVertex]){
                if(isCyclicUtil(adjacentVertex, currentVertex)){
                    return true;
                }
            } else if (recursionStack[adjacentVertex] && adjacentVertex != parentVertex) {
                return true;
            }
        }
        
        recursionStack[currentVertex] = false;
        return false;
    }
    
    public static void main(String[] args){
        Example3 fg1 = new Example3(5);
        fg1.addEdge(1,0);
        fg1.addEdge(0,2);
        fg1.addEdge(2,1);
        fg1.addEdge(0,3);
        fg1.addEdge(3,4);
        
        Example3 fg2 = new Example3(3);
        fg2.addEdge(0,1);
        fg2.addEdge(1,2);
        
        Example3 fg3 = new Example3(3);
        fg3.addEdge(0,1);
        fg3.addEdge(1,1);
        
        Example3 fg4 = new Example3(4);
        fg4.addEdge(0,1);
        fg4.addEdge(1,2);
        fg4.addEdge(2,3);
        
        Example3 fg5 = new Example3(4);
        fg5.addEdge(0,1);
        fg5.addEdge(1,2);
        fg5.addEdge(2,0);
        
        System.out.println("Graph 1 is: " + fg1.isCyclic());
        System.out.println("Graph 2 is: " + fg2.isCyclic());
        System.out.println("Graph 3 is: " + fg3.isCyclic());
        System.out.println("Graph 4 is: " + fg4.isCyclic());
        System.out.println("Graph 5 is: " + fg5.isCyclic());

    }
}
