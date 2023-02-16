package pl.migibud.dfs2;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DfsRecursion {

    void traverse(Map<Vertex, List<Vertex>> adjacencyList, Vertex root) {
        Set<Vertex> visited = new HashSet<>();
        visited.add(root);
        traverse(adjacencyList, root, visited);
    }

    private void traverse(Map<Vertex, List<Vertex>> adjacencyList, Vertex vertex, Set<Vertex> visited) {
        System.out.println(vertex);
        List<Vertex> vertices = adjacencyList.get(vertex);
        if (vertices != null) {
            vertices.forEach(v -> {
                if (!visited.contains(v)) {
                    visited.add(v);
                    traverse(adjacencyList, v, visited);
                }
            });
        }
    }
}
