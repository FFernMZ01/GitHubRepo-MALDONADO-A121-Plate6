/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ds2plate6maldonado;

/**
 *
 * @author Fernando Maldonado
 */
import java.util.*;

public class DS2Plate6Maldonado {
    public static class fEdges {
        int source;
        int destination;

        public fEdges(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void main(String[] args) {
        List<fEdges> edges1 = Arrays.asList(new fEdges(0, 1), new fEdges(1, 2), new fEdges(2, 3), new fEdges(3, 4));
        System.out.println("Graph 1: " + isConnected(edges1));

        List<fEdges> edges2 = Arrays.asList(new fEdges(0, 1), new fEdges(1, 2), new fEdges(2, 3), new fEdges(3, 0));
        System.out.println("Graph 2: " + isConnected(edges2));

        List<fEdges> edges3 = Arrays.asList(new fEdges(0, 1), new fEdges(1, 2), new fEdges(2, 3), new fEdges(3, 4), new fEdges(4, 5));
        System.out.println("Graph 3: " + isConnected(edges3));

        List<fEdges> edges4 = Arrays.asList(new fEdges(0, 1), new fEdges(1, 2), new fEdges(2, 3), new fEdges(3, 4), new fEdges(4, 0), new fEdges(2, 5));
        System.out.println("Graph 4: " + isConnected(edges4));

        List<fEdges> edges5 = Arrays.asList(new fEdges(0, 1), new fEdges(1, 2), new fEdges(2, 3), new fEdges(3, 4), new fEdges(4, 0), new fEdges(2, 5), new fEdges(5, 6));
        System.out.println("Graph 5: " + isConnected(edges5));
    }

    private static boolean isConnected(List<fEdges> edges) {
        int vertices = getVertices(edges);
        boolean[] visited = new boolean[vertices];
        int connectedComponents = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(edges, visited, i);
                connectedComponents++;
            }
        }

        return connectedComponents == 1;
    }

    private static void dfs(List<fEdges> edges, boolean[] visited, int currentVertex) {
        visited[currentVertex] = true;

        for (fEdges edge : edges) {
            if (edge.source == currentVertex && !visited[edge.destination]) {
                dfs(edges, visited, edge.destination);
            }
        }
    }

    private static int getVertices(List<fEdges> edges) {
        Set<Integer> vertices = new HashSet<>();

        for (fEdges edge : edges) {
            vertices.add(edge.source);
            vertices.add(edge.destination);
        }

        return vertices.size();
    }
}