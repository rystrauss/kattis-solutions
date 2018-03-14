import java.io.File;
import java.util.*;

public class Emergency {

    private List<Set<Integer>> graph;
    private int n, k;

    public Emergency(int n, int k) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        this.k = k;
        this.n = n;
        buildGraph();
    }

    private void buildGraph() {
        for (int v = 0; v < n; v++) {
            for (int w = v; w < n; w++) {
                if (v + 1 == w) {
                    graph.get(v).add(w);
                    graph.get(w).add(v);
                } else if (v % k == 0 && w % k == 0 && v != 0 && w != 0) {
                    graph.get(v).add(w);
                    graph.get(w).add(v);
                }
            }
        }
    }

    public int shortestPath() {
        Set<Integer> visited = new HashSet<>();
        return shortestPath(0, visited);
    }

    private int shortestPath(int node, Set<Integer> visited) {
        if (node == n - 1)
            return 0;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (graph.get(node).contains(i) && !visited.contains(i)) {
                visited.add(node);
                int dist = 1 + shortestPath(i, visited);
                if (dist < shortest)
                    shortest = dist;
                visited.remove(node);
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("input.txt"));
            int n = s.nextInt();
            int k = s.nextInt();
            Emergency e = new Emergency(n, k);
            int dist = e.shortestPath();
            System.out.println(dist);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

}
