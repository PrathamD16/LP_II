import java.util.*;

public class AI_A1 {
    public static void BFS(ArrayList<LinkedList>l, int v, int start) {
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            start = q.poll();
            System.out.print(start + " ");
            LinkedList y = l.get(start);
            Iterator<Integer> i = y.listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void DFS(ArrayList<LinkedList>l, int v, int start) {
        boolean visited[] = new boolean[v];
        Stack<Integer> stk = new Stack<>();

        visited[start] = true;
        stk.add(start);
        while (!stk.isEmpty()) {
            start = stk.pop();
            System.out.print(start + " ");
            LinkedList y = l.get(start);
            Iterator<Integer> ptr = y.listIterator();
            while (ptr.hasNext()) {
                int n = ptr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    stk.push(n);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<LinkedList>l = new ArrayList<LinkedList>(7);
        for(int i = 0; i < 7; i++){
            LinkedList<Integer>x = new LinkedList<>();
            l.add(x);
        }

        int vertex = 7;

        while (true) {
            int choice = 0;
            System.out.println("1. Add Edges \n2. BFS \n3. DFS \n4.Exit ");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();
            if (choice == 1) {
                System.out.print("Enter start vertex: ");
                int start = s.nextInt();
                System.out.print("Enter destination vertex: ");
                int des = s.nextInt();
                LinkedList L = l.get(start);
                L.add(des);

            } else if (choice == 2) {
                System.out.println("Enter start vertex ");
                int point = s.nextInt();
                BFS(l, vertex, point);
                System.out.println();
            } else if (choice == 3) {
                System.out.println("Enter start vertex");
                int point = s.nextInt();
                DFS(l, vertex, point);
                System.out.println();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Enter correct choices");
            }
        }
        s.close();
        
    }
}
