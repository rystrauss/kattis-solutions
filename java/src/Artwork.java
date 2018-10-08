/*
    Note: While this solution is correct, it is currently too slow for Kattis.
 */

import java.io.File;
import java.util.*;

public class Artwork {

    private static class Node {

        Node parent;
        int stroke, rank, x, y;

        Node(int x, int y) {
            parent = null;
            stroke = 0;
            rank = 0;
            this.x = x;
            this.y = y;
        }

    }

    private static int n, m, q;
    private static Node[][] grid;
    private static Set<Node> roots;
    private static Map<Integer, Set<Node>> strokes;

    private static void addStrokes(Scanner s) {
        for (int i = 1; i <= q; i++) {
            strokes.put(i, new HashSet<>());
            int x1 = s.nextInt() - 1;
            int y1 = s.nextInt() - 1;
            int x2 = s.nextInt() - 1;
            int y2 = s.nextInt() - 1;
            if (x1 == x2) {
                for (int j = y1; j <= y2; j++) {
                    if (grid[x1][j].stroke == 0) {
                        grid[x1][j].stroke = i;
                        strokes.get(i).add(grid[x1][j]);
                        roots.remove(grid[x1][j]);
                    }
                }
            } else {
                for (int j = x1; j <= x2; j++) {
                    if (grid[j][y1].stroke == 0) {
                        grid[j][y1].stroke = i;
                        strokes.get(i).add(grid[j][y1]);
                        roots.remove(grid[j][y1]);
                    }
                }
            }
        }
    }

    private static Node find(Node node) {
        Set<Node> path = new HashSet<>();
        Node curr = node;
        while (curr.parent != null) {
            path.add(curr);
            curr = curr.parent;
        }
        for (Node n : path) {
            n.parent = curr;
        }
        return curr;
    }

    private static void union(Node a, Node b) {
        Node rootA = find(a);
        Node rootB = find(b);
        if (rootA == rootB)
            return;
        if (rootA.rank < rootB.rank) {
            rootA.parent = rootB;
            rootB.rank += rootA.rank + 1;
            roots.remove(rootA);
        } else {
            rootB.parent = rootA;
            rootA.rank++;
            roots.remove(rootB);
        }
    }

    private static void makeUnions(int stroke) {
        if (stroke == q) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (grid[x][y].stroke == 0 || grid[x][y].stroke > stroke) {
                        if (x != n - 1 && (grid[x + 1][y].stroke == 0 || grid[x + 1][y].stroke > stroke)) {
                            union(grid[x][y], grid[x + 1][y]);
                        }
                        if (y != m - 1 && (grid[x][y + 1].stroke == 0 || grid[x][y + 1].stroke > stroke)) {
                            union(grid[x][y], grid[x][y + 1]);
                        }
                    }
                }
            }
        } else {
            for (Node node : strokes.get(stroke + 1)) {
                int x = node.x;
                int y = node.y;
                if (x != n - 1 && (grid[x + 1][y].stroke == 0 || grid[x + 1][y].stroke > stroke)) {
                    union(node, grid[x + 1][y]);
                }
                if (y != m - 1 && (grid[x][y + 1].stroke == 0 || grid[x][y + 1].stroke > stroke)) {
                    union(node, grid[x][y + 1]);
                }
                if (x != 0 && (grid[x - 1][y].stroke == 0 || grid[x - 1][y].stroke > stroke)) {
                    union(node, grid[x - 1][y]);
                }
                if (y != 0 && (grid[x][y - 1].stroke == 0 || grid[x][y - 1].stroke > stroke)) {
                    union(node, grid[x][y - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(new File("input.txt"))) {
            n = s.nextInt();
            m = s.nextInt();
            q = s.nextInt();

            grid = new Node[n][m];
            roots = new HashSet<>();
            strokes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Node n = new Node(i, j);
                    grid[i][j] = n;
                    roots.add(n);
                }
            }

            addStrokes(s);

            int[] beauty = new int[q];

            for (int i = q; i > 0; i--) {
                if (i != q)
                    roots.addAll(strokes.get(i + 1));
                makeUnions(i);
                beauty[i - 1] = roots.size();
            }

            StringBuilder sb = new StringBuilder(2 * q + 1);
            for (int i = 0; i < q; i++) {
                sb.append(beauty[i]).append("\n");
            }

            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}