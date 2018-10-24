package dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    public static enum G_STATUS {
        NONE(0), TRUE(1), FALSE(-1);

        int status = 0;
        private G_STATUS(int a){
            status = a;
        }

        public int getStatusNumeric(){
            return status;
        }

        public static G_STATUS getStatusbyNumberic(int nu){
            if (nu == 0)
                return G_STATUS.NONE;
            else if(nu == 1)
                return G_STATUS.TRUE;
            else
                return G_STATUS.FALSE;

        }
    }

    public GraphNode<Integer>[] nodes;
    private int noneSize = 0;
    public Graph(int size){
        nodes = new GraphNode[size];
        for(int i =0;i<size;i++)
        {
            nodes[i] = new GraphNode<Integer>(i);
        }
    }

    private void addNoneSize(G_STATUS gst){
        if(G_STATUS.NONE == gst){
            noneSize ++;
        }
    }
    public void addEdge(int d1, int d2){
        addEdge(d1, d2, 0);
    }
    public void addEdge(int d1, int d2, int distance){
        GraphNode<Integer> n1 = nodes[d1];
        GraphNode<Integer> n2 = nodes[d2];

        if(false == n1.isAdded)
        {
            n1.isAdded = true;
        }

        if(false == n2.isAdded)
        {
            n2.isAdded = true;
        }

        if(false == n1.adjacent.contains(n2)){
            n1.addAdjacent(n2, distance);
        }

        if(false == n2.adjacent.contains(n1)){
            n2.addAdjacent(n1, distance);
        }
    }

    public GraphNode getNodebyID(int id){
        return nodes[id];
    }

    public void DFS(int i){
        GraphNode<Integer> root = nodes[i];
        Stack<GraphNode> g_stack = new Stack<GraphNode>();
        g_stack.push(root);
        root.status = G_STATUS.TRUE;

        while(false == g_stack.isEmpty()){
            GraphNode<Integer> r = g_stack.pop();
            for (GraphNode nn : r.adjacent){
                if(G_STATUS.NONE == nn.status){
                    g_stack.push(nn);
                    nn.status = G_STATUS.TRUE;
                }
            }
            System.out.print(r.data + " ");
        }
        System.out.println();
    }

    public void BFS(int idx){
        GraphNode<Integer> root = nodes[idx];
        Queue<GraphNode> g_queue = new LinkedList<GraphNode>();
        g_queue.add(root);
        root.status = G_STATUS.TRUE;

        while(false == g_queue.isEmpty()){
            GraphNode<Integer> r = g_queue.poll();
            for (GraphNode nn : r.adjacent){
                if(G_STATUS.NONE == nn.status){
                    g_queue.add(nn);
                    nn.status = G_STATUS.TRUE;
                }
            }
            System.out.print(r.data + " ");
        }
        System.out.println();
    }

    public void BFS_E(int idx){
        int depth = 0;
        GraphNode<Integer> root = nodes[idx];
        Queue<GraphNode> g_queue = new LinkedList<GraphNode>();
        g_queue.add(root);
        root.status = G_STATUS.TRUE;

        while(false == g_queue.isEmpty()){
            GraphNode<Integer> r = g_queue.poll();
            for (GraphNode nn : r.adjacent){
                if(G_STATUS.NONE == nn.status){
                    nn.depth = r.depth + 1;
                    g_queue.add(nn);
                    nn.status = G_STATUS.TRUE;
                }
            }
            System.out.print(r.data + "(" + r.depth + ") ");
        }
        System.out.println();
    }

    public void BFS_E2(ArrayList<Integer> alist){
        int depth = 0;
        int nofOutput = -alist.size();
        int ldepth = 0;
        Queue<GraphNode> g_queue = new LinkedList<GraphNode>();
        for(int sdata : alist){
            g_queue.add(nodes[sdata]);
        }

        while(false == g_queue.isEmpty()){
            GraphNode<Integer> r = g_queue.poll();
            for (GraphNode nn : r.adjacent){
                if(G_STATUS.NONE == nn.status){
                    nn.depth = r.depth + 1;
                    g_queue.add(nn);
                    nn.status = G_STATUS.TRUE;
                }
            }
            //System.out.print(r.data + "(" + r.depth + ") ");
            nofOutput ++;
            ldepth = r.depth;
        }
        //System.out.println();
        if(nofOutput < noneSize){
            System.out.println("-1");
        }
            //System.out.println("Total="+nofOutput+", nl="+noneSize+", "+"-1");
        else
        {
            System.out.println(ldepth);
        }
        //System.out.println();
    }
}
