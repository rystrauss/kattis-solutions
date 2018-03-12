import java.io.File;
import java.util.*;

public class Emergency {

    private boolean[][] graph;
    private int n, k;

    public Emergency(int n, int k) {
        graph = new boolean[n][n];
        this.k = k;
        this.n = n;
        buildGraph();
    }

    private void buildGraph() {
        for (int v = 0; v < n; v++) {
            for (int w = v; w < n; w++) {
                if (v + 1 == w) {
                    graph[v][w] = true;
                    graph[w][v] = true;
                } else if (v % k == 0 && w % k == 0 && v != 0  && w != 0) {
                    graph[v][w] = true;
                    graph[w][v] = true;
                }
            }
        }
    }

    public int[] shortestPaths() {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        Set<Integer> visited = new HashSet<>();
        shortestPaths(0, visited, dist, 0);
        return dist;
    }

    private void shortestPaths(int node, Set<Integer> visited, int[] dist, int count) {
        if (visited.contains(node))
            return;
        if (count < dist[node])
            dist[node] = count;
        visited.add(node);
        for (int i = 0; i < n; i++) {
            if (graph[node][i]) {
                shortestPaths(i, visited, dist, count + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
            int n = s.nextInt();
            int k = s.nextInt();
            Emergency e = new Emergency(n, k);
            int[] dist = e.shortestPaths();
            System.out.println(dist[n - 1]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

}
