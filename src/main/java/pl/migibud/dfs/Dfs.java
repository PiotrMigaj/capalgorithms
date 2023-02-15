package pl.migibud.dfs;

import java.util.List;
import java.util.Stack;

class Dfs {

    private Stack<Vertex> stack = new Stack<>();

    void dfs(List<Vertex> vertexList) {
        Stack<Vertex> stack = new Stack<>();
        vertexList.forEach(
                vertex -> {
                    if (!vertex.isVisited()) {
                        vertex.setVisited(true);
                        dfsHelper(vertex);
                    }
                }
        );
    }

    private void dfsHelper(Vertex root) {
        stack.add(root);
        root.setVisited(true);
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            current.getAdjacencyList().forEach(
                    vertex -> {
                        if (!vertex.isVisited()) {
                            stack.add(vertex);
                        }
                    }
            );
        }
    }
}
