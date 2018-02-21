import java.util.*;

public class Emergency {

    private List<List<Integer>> connections;
    private int n, k, shortest;

    public Emergency(int n, int k) {
        connections = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            connections.add(new ArrayList<Integer>());
        this.k = k;
        this.n = n;
        this.shortest = n;
        buildGraph();
    }

    private void buildGraph() {
        for (int i = 0; i < n - 1; i++) {
            connections.get(i).add(i + 1);
            connections.get(i + 1).add(i);
        }
        for (int v = 1; v < n; v++) {
            for (int w = v; w < n; w++) {
                if (v % k == 0 && w % k == 0) {
                    connections.get(v).add(w);
                    connections.get(w).add(v);
                }
            }
        }
    }

    public int findShortestPath() {
        if(n == 1)
            return 0;
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> toVisit = new Stack<>();
        findShortestPath(0, visited, toVisit, 0);
        return shortest;
    }

    private void findShortestPath(int location, Set<Integer> visited, Stack<Integer> toVisit, int count) {
        if (location == n - 1 && count < shortest) {
            shortest = count;
            return;
        }
        if (visited.contains(location))
            return;
        toVisit.addAll(connections.get(location));
        visited.add(location);
        findShortestPath(toVisit.pop(), visited, toVisit, ++count);
    }

    public static void main(String[] args) {
        Scanner s = null;
        try{
            s = new Scanner(System.in);
            String[] input = s.nextLine().split(" ");
            System.out.println(0);
            Emergency e = new Emergency(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            System.out.println(e.findShortestPath());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }
    }

}
