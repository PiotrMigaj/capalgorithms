package pl.migibud.dfs2;

import java.util.*;

class Dfs {

    void traverse(Map<Vertex, List<Vertex>> adjacencyList, Vertex root) {

        Deque<Vertex> stack = new ArrayDeque<>();
        Set<Vertex> visited = new HashSet<>();
        visited.add(root);
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Vertex current = stack.remove();
            System.out.println(current);
            List<Vertex> vertices = adjacencyList.get(current);
            if (vertices != null) {
                vertices.forEach(vertex -> {
                    if (!visited.contains(vertex)) {
                        visited.add(vertex);
                        stack.addFirst(vertex);
                    }
                });
            }
        }
    }
}
