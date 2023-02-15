package pl.migibud.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Bfs {

    void traverse(Vertex root) {

        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);

        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            System.out.println(current);
            current.getAdjacencyList().forEach(
                    vertex -> {
                        if (!vertex.isVisited()) {
                            vertex.setVisited(true);
                            queue.add(vertex);
                        }
                    }
            );
        }
    }

}
