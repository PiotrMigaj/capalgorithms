package pl.migibud.dfs2;

class Vertex {
    private String name;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}
