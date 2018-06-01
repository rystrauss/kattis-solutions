import java.util.*;

public class FaultyRobot {

    private static class Graph {

        HashMap<Integer, HashSet<Integer>> edges;
        HashMap<Integer, Integer> forced;

        Graph() {
            edges = new HashMap<>();
            forced = new HashMap<>();
        }

        void addEdge(int a, int b) {
            edges.get(Math.abs(a)).add(b);
            if (a < 0) {
                forced.put(-a, b);
            }
        }

        void addNodes(int N) {
            for (int i = 1; i <= N ; i++) {
                forced.put(i, null);
                edges.put(i, new HashSet<>());
            }
        }

        int endpoints() {
            Set<Integer> endpoints = new HashSet<>();
            Set<Integer> visited = new HashSet<>();
            traverse(endpoints, visited, 1, false);
            return endpoints.size();
        }

        void traverse(Set<Integer> endpoints, Set<Integer> visited, int pos, boolean malfunctioned) {
            if (visited.contains(pos))
                return;
            visited.add(pos);
            if (malfunctioned) {
                Integer f = forced.get(pos);
                if (f == null) {
                    endpoints.add(pos);
                    return;
                }
                traverse(endpoints, visited, f, true);
            } else {
                Integer f = forced.get(pos);
                if (f == null) {
                    endpoints.add(pos);
                }
                for(Integer i : edges.get(pos)) {
                    if (f != null && f.equals(i)) {
                        traverse(endpoints, visited, i, false);
                    } else {
                        traverse(endpoints, new HashSet<>(), i, true);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int M = in.nextInt();
            Graph g = new Graph();
            g.addNodes(N);
            for (int i = 0; i < M; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                g.addEdge(a, b);
            }
            System.out.println(g.endpoints());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
