package pl.migibud.bfs2;

class Vertex {

    private String name;

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}
