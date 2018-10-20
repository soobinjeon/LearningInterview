package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private GraphNode<Integer>[] nodes;
    private int gsize = 0;
    public Graph(int size){
        nodes = new GraphNode[size];
        for(int i =0;i<size;i++)
        {
            nodes[i] = new GraphNode<Integer>(i);
        }
    }

    public void addEdge(int d1, int d2){
        GraphNode<Integer> n1 = nodes[d1];
        GraphNode<Integer> n2 = nodes[d2];

        if(false == n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }

        if(false == n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    public void DFS(int i){
        GraphNode<Integer> root = nodes[i];
        Stack<GraphNode> g_stack = new Stack<GraphNode>();
        g_stack.push(root);
        root.marked = true;

        while(false == g_stack.isEmpty()){
            GraphNode<Integer> r = g_stack.pop();
            for (GraphNode nn : r.adjacent){
                if(false == nn.marked){
                    g_stack.push(nn);
                    nn.marked = true;
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
        root.marked = true;

        while(false == g_queue.isEmpty()){
            GraphNode<Integer> r = g_queue.poll();
            for (GraphNode nn : r.adjacent){
                if(false == nn.marked){
                    g_queue.add(nn);
                    nn.marked = true;
                }
            }
            System.out.print(r.data + " ");
        }
        System.out.println();
    }
}
