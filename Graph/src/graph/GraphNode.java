package graph;

import java.util.LinkedList;

public class GraphNode<T> {
    T data;
    public Graph.G_STATUS status;
    public LinkedList<GraphNode> adjacent;
    public boolean isAdded;
    public int depth = 0;

    public GraphNode(T _data, Graph.G_STATUS st){
        data = _data;
        status = st;
        isAdded = false;
        adjacent = new LinkedList<GraphNode>();
    }
}
