package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphNode<T> {
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

class Graph {
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

    private GraphNode<Integer>[] nodes;
    private int noneSize = 0;
    public Graph(int size){
        nodes = new GraphNode[size];
        for(int i =0;i<size;i++)
        {
            nodes[i] = new GraphNode<Integer>(i, G_STATUS.NONE);
        }
    }

    private void addNoneSize(G_STATUS gst){
        if(G_STATUS.NONE == gst){
            noneSize ++;
        }
    }
    public void addEdge(int d1, G_STATUS d1_s, int d2, G_STATUS d2_s){
        GraphNode<Integer> n1 = nodes[d1];
        GraphNode<Integer> n2 = nodes[d2];

        if(false == n1.isAdded)
        {
            n1.status = d1_s;
            n1.isAdded = true;
            addNoneSize(d1_s);
        }

        if(false == n2.isAdded)
        {
            n2.status = d2_s;
            n2.isAdded = true;
            addNoneSize(d2_s);
        }

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

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        ArrayList<Integer> slist = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrSize = br.readLine().split(" ");
        int xsize = Integer.parseInt(arrSize[0]);
        int ysize = Integer.parseInt(arrSize[1]);
        if(xsize >= 2 && ysize <= 1000) {
            Graph gr = new Graph(xsize * ysize);

            //System.out.println(numofdata);
            int ycnt = 0;
            int totalcnt = 0;
            while (ysize > ycnt) {
                //String d = br.readLine();
                String[] sdata = br.readLine().split(" ");
                int xcnt = 0;
                for (String sd : sdata) {
                    int idata = Integer.parseInt(sd);
                    int leftData = 0;
                    int abovedata = 0;

                    if (Graph.G_STATUS.getStatusbyNumberic(idata) == Graph.G_STATUS.TRUE) {
                        slist.add(totalcnt);
                    }
                    if ((xcnt - 1) >= 0) {
                        leftData = Integer.parseInt(sdata[xcnt - 1]);
                        gr.addEdge(totalcnt - 1, Graph.G_STATUS.getStatusbyNumberic(leftData)
                                , totalcnt, Graph.G_STATUS.getStatusbyNumberic(idata));
                    }

                    if ((ycnt - 1) >= 0) {
                        gr.addEdge((xcnt + (xsize * (ycnt - 1))), Graph.G_STATUS.getStatusbyNumberic(0)
                                , totalcnt, Graph.G_STATUS.getStatusbyNumberic(idata));
                    }
                    xcnt++;
                    totalcnt++;
                }
                ycnt++;
            }

            /**
             * 4 3
             * 0 1 0 0
             * 1 0 0 0
             * 0 0 0 0
             * 1(0) 4(0) 0(1) 2(1) 5(1) 8(1) 3(2) 6(2) 9(2) 7(3) 10(3) 11(4)
             */
            gr.BFS_E2(slist);
        }
    }
}
