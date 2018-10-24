package dijkstra;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Dijkstra {
    Graph graph;
    Queue<GraphNode> prqueue = new PriorityQueue<>();
    public Dijkstra(Graph _g){
        graph = _g;
    }

    public void doDijkstra(int startID, int endID){
        GraphNode snode = graph.getNodebyID(startID);
        snode.Distance = 0;
        prqueue.offer(snode);

        while(!prqueue.isEmpty()){
            GraphNode<Integer> pnode = prqueue.poll();

            if(pnode.status == Graph.G_STATUS.TRUE)
                continue;

            pnode.status = Graph.G_STATUS.TRUE;

            for(GraphNode n : pnode.adjacent){
                int totalDistance = pnode.Distance + pnode.distances.get(n);
                if(totalDistance < n.Distance){
                    n.Distance = totalDistance;
                    n.prevNode = pnode;
                    if(n.status != Graph.G_STATUS.TRUE){
                        prqueue.offer(n);
                    }
                }
            }
        }

        for(GraphNode n : graph.nodes){
            System.out.println(n.data + " : " +n.Distance);
        }

        System.out.println("Minimum Distance from "+startID + " to "+endID+": "+graph.getNodebyID(endID).Distance);

        GraphNode<Integer> cnode = graph.getNodebyID(endID);
        Stack<GraphNode> path = new Stack<>();
        boolean is_breakPath = false;
        while(cnode.data != startID){
            path.push(graph.getNodebyID(cnode.data));
            cnode = cnode.prevNode;
            if(cnode == null) {
                is_breakPath = true;
                break;
            }
        }
        path.push(graph.getNodebyID(startID));

        System.out.print("Path : ");
        if(true == is_breakPath)
            System.out.println("No Path");
        else{
            while(!path.isEmpty()){
                GraphNode<Integer> sn = path.pop();
                System.out.print(sn.data + "->");
            }

            System.out.println();
        }
    }
}
