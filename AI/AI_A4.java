import java.util.*;
public class AI_A4{
    static boolean isSafe(int node, List<List<Integer>>g, int color[], int n, int currCol){
        for(int it : g.get(node)){
            if(currCol == color[it])return false;
        }
        return true;
    }
    static boolean solve(int node, List<List<Integer>>g, int color[], int n, int m){
        if(node == n)return true;

        for(int i = 1; i <= m; i++){
            if(isSafe(node, g, color, n, i)){
                color[node] = i;
                if(solve(node+1, g, color, n, m))return true;
                color[node] = 0;
            }
        }

        return false;
    }
    static boolean coloringPossible(int edges[][], int m, int n){
        List<List<Integer>>graph = new ArrayList<>();
        int []colors = new int[n];
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println(graph);

        if(solve(0, graph, colors, n, m)){
            for(int x: colors){
                System.out.print(x + " ");
            }

            return true;
        }
        else{
            System.out.println("Coloring not possible");
            return false;
        }
    }

    static void print(int arr[][]){
        for(int x[]: arr){
            System.out.println(x[0] + " " + x[1]);
        }
    }
    public static void main(String[] args) {
        int edges[][] =  {{0,3},{0,1},{0,2},{1,2},{1,3}};
        coloringPossible(edges, 3, 4);
        // Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // int edges[][] = new int[n*n][2];
        // while(true){
        //     System.out.println("\n1.Add edges \n2.Color graph");
        //     int choice = s.nextInt();
        //     if(choice == 1){
        //         int srs = s.nextInt();
        //         int des = s.nextInt();
        //         edges[srs][0] = srs;
        //         edges[des][1] = des;
        //         print(edges);
        //     }
        //     else if(choice == 2){
        //         int M = s.nextInt();
        //         coloringPossible(edges, M, n);
        //     }
        // }
        
    }
}