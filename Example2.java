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

public class Example2 {
    public int F;
    public int[][] FadjMatrix;
    
    public Example2(int[][] matrix){
        F = matrix.length;
        FadjMatrix = matrix;
    }
    
    public void FlistEdges(){
        Map<String, Integer> edgeCount = new HashMap<>();
        
        for (int i = 0; i < F; ++i){
            for (int m = i; m < F; ++m){
                if(FadjMatrix[i][m] > 0) {
                    String edge = i + "-" + m;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + FadjMatrix[i][m]);
                }
            }
        }
        
        System.out.println("Edges and their respective counts: ");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()){
            System.out.println("Edge" + entry.getKey() + ":" + entry.getValue() + "time(s)");
        }
    }
    
    public static void main(String[] args) {
        int [][][] testCases = {
            {
                {0,1,0},
                {1,0,1},
                {0,1,0}
            },
            {
                {0,1,0,0},
                {1,0,0,0},
                {0,0,0,1},
                {0,0,1,0}
            },
            {
                {0,2,0},
                {2,0,1},
                {0,1,0}
            },
            {
                {2,1,0},
                {1,1,1},
                {0,1,0}
            },
            {
                {0,0,0},
                {0,0,0},
                {0,0,0}
            }
        };
        
        for (int i = 0; i < testCases.length; ++i){
            System.out.println("Test case " + (i + 1) + ":");
            Example2 graph = new Example2(testCases[i]);
            graph.FlistEdges();
            System.out.println();
        }
    }
}
