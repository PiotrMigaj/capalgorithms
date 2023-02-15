package pl.migibud.bfs2;

import java.util.*;

class Bfs {

    void traverse(Map<Vertex, List<Vertex>> adjacencyList, Vertex root) {

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            System.out.println(current);
            List<Vertex> neighbours = adjacencyList.get(current);
            if (neighbours != null) {
                neighbours.forEach(
                        vertex -> {
                            if (!visited.contains(vertex)) {
                                queue.add(vertex);
                                visited.add(vertex);
                            }
                        }
                );
            }
        }
    }
}
