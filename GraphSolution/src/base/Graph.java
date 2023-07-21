package base;

public class Graph {
    public int vertex;
    public int[][] edges;

    public Graph() {
    }

    public Graph(int vertex) {
        super();
        this.vertex = vertex;
        edges = new int[vertex][vertex];
    }

    public void addEdges(int source, int destination, int weight) {
        edges[source][destination] = weight;
    }

}
