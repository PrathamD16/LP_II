
import java.util.*;

public class AI_A3 {
    static void showGraph(int g[][]) {
        System.out.println("\n******** Current Graph *************");
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static boolean isValidEdge(int u, int v, boolean[] mst) {
        if (u == v)
            return false;
        if (mst[u] == false && mst[v] == false)
            return false;
        else if (mst[u] == true && mst[v] == true)
            return false;
        return true;
    }

    static void PrimsALgo(int g[][]) {
        int V = g.length;
        boolean[] mst = new boolean[V];

        mst[0] = true;
        int edge_count = 0, mincost = 0;
        while (edge_count < V - 1) {

            // Find minimum weight valid edge.
            int min = Integer.MAX_VALUE, a = -1, b = -1;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (g[i][j] < min) {
                        if (isValidEdge(i, j, mst)) {
                            min = g[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            if (a != -1 && b != -1) {
                System.out.printf("Edge %d:(%d, %d) g: %d \n",
                        edge_count++, a, b, min);
                mincost = mincost + min;
                mst[b] = mst[a] = true;
            }
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inf = Integer.MAX_VALUE;
        System.out.print("Enter number of vertices in graph : ");
        int V = s.nextInt();
        int g[][] = new int[V][V];

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                g[i][j] = inf;
            }
        }

        while (true) {
            System.out.println("\n1.Add edges \n2.Find Prims \n3.Show Graph \n4.Exit");
            int choice = s.nextInt();
            if (choice == 1) {
                System.out.println("Enter the start vertice: ");
                int start = s.nextInt();
                System.out.println("Enter the end vertice: ");
                int des = s.nextInt();
                System.out.println("Enter cost: ");
                int cost = s.nextInt();
                g[start][des] = cost;
                g[des][start] = cost;
            } else if (choice == 2) {
                PrimsALgo(g);
            } else if (choice == 3) {
                showGraph(g);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("\nEnter correct choice");
            }
        }

        s.close();

        // int g[][] = { { inf, inf, 3, inf, inf }, { inf, inf, 10, 4, inf }, { 3, 10,
        // inf, 2, 6 }, { inf, 4, 2, inf, 1 }, { inf, inf, 6, 1, inf } };
        // PrimsALgo(g);
    }
}
