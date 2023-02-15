package pl.migibud.dfs;

import java.util.List;

class DfsRecursion {

    void dfs(List<Vertex> vertexList) {
        vertexList.forEach(
                vertex -> {
                    if (!vertex.isVisited()) {
                        vertex.setVisited(true);
                        dfsHelper(vertex);
                    }
                }
        );
    }

    private void dfsHelper(Vertex vertex) {
        System.out.println(vertex);
        vertex.getAdjacencyList().forEach(
                vertex1 -> {
                    if (!vertex1.isVisited()) {
                        vertex1.setVisited(true);
                        dfsHelper(vertex1);
                    }
                }
        );
    }
}
