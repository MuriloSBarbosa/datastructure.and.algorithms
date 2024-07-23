package murilo.barbosa.graph;


import java.util.HashMap;
import java.util.LinkedList;

public class Graph<T> {

    private int numOfNodes;
    private HashMap<T, LinkedList<T>> adjascentList;

    public Graph() {
        this.adjascentList = new HashMap<>();
    }

    public void addVertex(T value) {
        this.adjascentList.put(value, new LinkedList<>());
    }

    public void addEdge(T value, T connection) {
        var vertex = this.adjascentList.get(value);
        var connectionVertex = this.adjascentList.get(connection);

        if (vertex != null && connectionVertex != null) {
            vertex.add(connection);
            connectionVertex.add(value);
        } else {
            throw new IllegalArgumentException("Vertex not found");
        }
    }

    @Override
    public String toString() {
        // showConnections
        StringBuilder builder = new StringBuilder();
        for (T key : this.adjascentList.keySet()) {
            builder.append(key).append(" -> ");
            for (T connection : this.adjascentList.get(key)) {
                builder.append(connection).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        var graph = new Graph<String>();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        graph.addEdge("3", "1");
        graph.addEdge("3", "4");
        graph.addEdge("4", "2");
        graph.addEdge("4", "5");
        graph.addEdge("1", "2");
        graph.addEdge("1", "0");
        graph.addEdge("0", "2");
        graph.addEdge("6", "5");

        System.out.println(graph);
    }
}
