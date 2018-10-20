package graph;

public class GraphMain {
    public static void main(String[] args){
        Graph gr = new Graph(9);
        gr.addEdge(0, 1);
        gr.addEdge(1, 2);
        gr.addEdge(1, 3);
        gr.addEdge(2, 3);
        gr.addEdge(2,4);
        gr.addEdge(3, 4);
        gr.addEdge(3, 5);
        gr.addEdge(5, 7);
        gr.addEdge(5, 6);
        gr.addEdge(6, 8);
        gr.DFS(0);
    }
}
