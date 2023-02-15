package pl.migibud.bfs2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class App {
    public static void main(String[] args) {

        Map<Vertex, List<Vertex>> adjacencyList = new HashMap<>();
        Bfs bfs = new Bfs();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        adjacencyList.put(a, List.of(b, f, g));
        adjacencyList.put(b, List.of(a, c, d));
        adjacencyList.put(c, List.of(b));
        adjacencyList.put(d, List.of(b, e));
        adjacencyList.put(e, List.of(d));
        adjacencyList.put(f, List.of(a));
        adjacencyList.put(g, List.of(a, h));


        bfs.traverse(adjacencyList, a);

    }
}
