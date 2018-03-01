import java.util.*;

public class WheresMyInternet {

    private int n;
    private boolean[][] edges;
    private Set<Integer> connected;

    public WheresMyInternet(Scanner s) {
        this.n = s.nextInt();
        connected = new HashSet<>();
        edges = new boolean[n][n];
        while(s.hasNext()) {
            s.nextLine();
            int h1 = s.nextInt();
            int h2 = s.nextInt();
            edges[h1 - 1][h2 - 1] = true;
            edges[h2 - 1][h1 - 1] = true;
        }
    }

    private void dfs() {
        Stack<Integer> toVisit = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        toVisit.push(1);
        dfs(toVisit, visited);
    }

    private void dfs(Stack<Integer> toVisit, Set<Integer> visited) {
        if (toVisit.isEmpty() || visited.contains(toVisit.peek()))
            return;
        int pos = toVisit.pop();
        connected.add(pos);
        for (int i = 0; i < n; i++) {
            if (edges[pos - 1][i])
                toVisit.push(i + 1);
        }
        visited.add(pos);
        dfs(toVisit, visited);
    }

    private void printUnconnected() {
        if(connected.size() == n) {
            System.out.println("Connected");
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (!connected.contains(i))
                    System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            WheresMyInternet i = new WheresMyInternet(s);
            i.dfs();
            i.printUnconnected();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }
    }

}
