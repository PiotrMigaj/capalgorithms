package pl.migibud.bfs;

import java.util.LinkedList;
import java.util.List;

class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList = new LinkedList<>();

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex vertex) {
        this.adjacencyList.add(vertex);
    }
}
