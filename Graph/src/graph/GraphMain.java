package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphMain {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> slist = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt());
        System.out.println(sc.nextInt());
        System.out.println(sc.nextInt());
        System.out.println(sc.nextInt());
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrSize = br.readLine().split(" ");
        int xsize = Integer.parseInt(arrSize[0]);
        int ysize = Integer.parseInt(arrSize[1]);
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

                if (Graph.G_STATUS.getStatusbyNumberic(idata) == Graph.G_STATUS.TRUE){
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
        gr.BFS_E2(slist);*/
    }
}
