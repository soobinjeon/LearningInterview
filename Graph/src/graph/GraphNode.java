package graph;

import java.util.LinkedList;

public class GraphNode<T> {
    T data;
    public boolean marked;
    public LinkedList<GraphNode> adjacent;

    public GraphNode(T _data){
        data = _data;
        marked = false;
        adjacent = new LinkedList<GraphNode>();
    }
}
