/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds2plate6maldonado;

/**
 *
 * @author Fernando Maldonado
 */
import java.util.Arrays;

public class Example8 {
    public static boolean areIsomorphic(int[][] fgraph1, int[][] fgraph2 ){
        int f = fgraph1.length;
        if(fgraph2.length != f) return false;
        
        int[] mapping = new int[f];
        Arrays.fill(mapping, -1);
        
        boolean[] used = new boolean[f];
        return isIsomorphicUtil(fgraph1, fgraph2, mapping, used, 0);
    }
    
     public static boolean isIsomorphicUtil(int[][] fgraph1, int[][] fgraph2, int[] mapping, boolean[] used, int vertex) {
        if (vertex == fgraph1.length) return true;
        
        for(int i = 0; i < fgraph2.length; i++){
            if(!used[1] && isCompatible(fgraph1, fgraph2, mapping, vertex, i)){
                mapping[vertex] = i;
                used[i] = true;
                if(isIsomorphicUtil(fgraph1, fgraph2, mapping, used, vertex + 1)) return true;
                used[i] = false;
                mapping[vertex] = -1;
            }
        }
        return false;
    }
    
    public static boolean isCompatible(int[][] fgraph1, int[][] fgraph2, int[] mapping, int f1, int f2){
        for (int i = 0; i < f1; i++){
            if(fgraph1[f1][i] != fgraph2[f2][mapping[i]])return false;
        }
        return true;
    }
    public static void main(String[] args){
        int[][] fgraph1a = {
            {0,1,0,0},
            {1,0,1,1,},
            {0,1,0,1},
            {0,1,1,0}
        };
        
        int[][] fgraph1b = {
            {0,0,1,1},
            {0,0,1,1},
            {1,1,0,0},
            {1,1,0,0} 
        };
        
        int[][] fgraph2a = {
            {0,1,1,0},
            {1,0,0,1},
            {1,0,0,1},
            {0,1,1,0}
        };
        
        int[][] fgraph2b = {
            {0,0,1,1},
            {0,0,1,1},
            {1,1,0,0},
            {1,1,0,0}
        };
        
        int[][] fgraph3a = {
            {0,1,1,1},
            {1,0,0,0},
            {1,0,0,1},
            {1,0,1,0}
        };
        
        int[][] fgraph3b = {
            {0,1,1,1},
            {1,0,1,0},
            {1,1,0,1},
            {1,0,1,0}
        };
        
        System.out.println("Graph 1a and Graph 1b are Isomorphic: " + areIsomorphic(fgraph1a, fgraph1b));
        System.out.println("Graph 2a and Graph 2b are Isomorphic: " + areIsomorphic(fgraph2a, fgraph2b));
        System.out.println("Graph 1a and Graph 2a are Isomorphic: " + areIsomorphic(fgraph1a, fgraph2a));
        System.out.println("Graph 3a and Graph 3b are Isomorphic: " + areIsomorphic(fgraph3a, fgraph3b));
        System.out.println("Graph 2a and Graph 3a are Isomorphic: " + areIsomorphic(fgraph2a, fgraph3a));
    }
    
}


