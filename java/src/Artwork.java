import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Artwork {

    private class Cell {

        int x, y;
        int rank;
        Cell parent;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.rank = 0;
            this.parent = null;
        }

    }

    private int n, m, q;
    private int numSegments, numBlack;
    private Cell[][] cellGrid;
    private boolean[][] blackGrid;
    private List<List<Cell>> strokes;

    private Artwork(int n, int m, int q) {
        this.n = n;
        this.m = m;
        this.q = q;

        cellGrid = new Cell[n][m];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                cellGrid[x][y] = new Cell(x, y);
            }
        }

        strokes = new ArrayList<>(q);
        numSegments = n * m;
        blackGrid = new boolean[n][m];
        numBlack = 0;
    }

    private void readStrokes(Scanner in) {
        for (int i = 0; i < q; i++) {
            List<Cell> cells = new LinkedList<>();

            int x1, y1, x2, y2;
            x1 = in.nextInt() - 1;
            y1 = in.nextInt() - 1;
            x2 = in.nextInt() - 1;
            y2 = in.nextInt() - 1;

            if (x1 == x2) {
                for (int y = y1; y <= y2; y++) {
                    if (!blackGrid[x1][y]) {
                        cells.add(cellGrid[x1][y]);
                        numBlack++;
                        blackGrid[x1][y] = true;
                    }
                }
            } else {
                for (int x = x1; x <= x2; x++) {
                    if (!blackGrid[x][y1]) {
                        cells.add(cellGrid[x][y1]);
                        blackGrid[x][y1] = true;
                        numBlack++;
                    }
                }
            }

            strokes.add(cells);
        }
    }

    private Cell find(Cell cell) {
        List<Cell> path = new LinkedList<>();
        Cell current = cell;

        while (current.parent != null) {
            path.add(current);
            current = current.parent;
        }

        for (Cell c : path) {
            c.parent = current;
        }

        return current;
    }

    private void union(Cell a, Cell b) {
        Cell p1 = find(a);
        Cell p2 = find(b);

        if (p1 == p2)
            return;

        if (p1.rank >= p2.rank) {
            p2.parent = p1;
            if (p1.rank == p2.rank)
                p1.rank++;
        } else {
            p1.parent = p2;
        }

        numSegments--;
    }

    private void initialize() {
        final int[] XDELTA = {0, 0, -1, 1};
        final int[] YDELTA = {1, -1, 0, 0};

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!blackGrid[x][y]) {
                    for (int k = 0; k < XDELTA.length; k++) {
                        int i = x + XDELTA[k];
                        int j = y + YDELTA[k];
                        if (0 <= i && i < n && 0 <= j && j < m && !blackGrid[i][j])
                            union(cellGrid[x][y], cellGrid[i][j]);
                    }
                }
            }
        }
    }

    private void solve() {
        int[] beauty = new int[q];
        final int[] XDELTA = {0, 0, -1, 1};
        final int[] YDELTA = {1, -1, 0, 0};
        for (int stroke = q - 1; stroke >= 0; stroke--) {
            beauty[stroke] = numSegments - numBlack;
            for (Cell c : strokes.get(stroke)) {
                blackGrid[c.x][c.y] = false;
                numBlack--;
                for (int k = 0; k < XDELTA.length; k++) {
                    int x = c.x + XDELTA[k];
                    int y = c.y + YDELTA[k];
                    if (0 <= x && x < n && 0 <= y && y < m && !blackGrid[x][y])
                        union(c, cellGrid[x][y]);
                }
            }
        }
        for (int i : beauty) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Artwork art = new Artwork(in.nextInt(), in.nextInt(), in.nextInt());
        art.readStrokes(in);
        in.close();
        art.initialize();
        art.solve();
    }

}
