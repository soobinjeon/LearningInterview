package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphNode<T> implements Comparable<GraphNode>{
    T data;
    public LinkedList<GraphNode> adjacent;
    public HashMap<GraphNode, Integer> distances;
    public GraphNode prevNode = null;
    public boolean isAdded;
    public Graph.G_STATUS status;
    public int depth = 0;
    public int Distance = 0;

    public GraphNode(T _data){
        this(_data, Graph.G_STATUS.NONE);
    }
    public GraphNode(T _data, Graph.G_STATUS st){
        data = _data;
        isAdded = false;
        status = st;
        adjacent = new LinkedList<GraphNode>();
        distances = new HashMap<GraphNode, Integer>();
        Distance = Integer.MAX_VALUE;
    }

    public void addAdjacent(GraphNode nd){
        addAdjacent(nd, 0);
    }
    public void addAdjacent(GraphNode nd, int dis){
        adjacent.add(nd);
        distances.put(nd, dis);
    }

    @Override
    public int compareTo(GraphNode o) {
        if(this.Distance > o.Distance){
            return 1;
        }else if(this.Distance < o.Distance){
            return -1;
        }
        return 0;
    }
}
