package dijkstra;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        Dijkstra dij = new Dijkstra(graph);
        graph.addEdge(0, 1, 8);
        graph.addEdge(0,2,9);
        graph.addEdge(1,2,3);
        graph.addEdge(1,4,7);
        graph.addEdge(1,5,1);
        graph.addEdge(2,3,3);
        graph.addEdge(4, 3, 4);
        graph.addEdge(4, 5, 3);
        //graph.addEdge(5, 6, 5);
        graph.addEdge(5,3,2);

        dij.doDijkstra(0, 6);
    }
}
