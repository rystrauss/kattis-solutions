import java.util.*;

public class Brexit {

    static int C, P, X, L;
    static List<Set<Integer>> connections;
    static int[] originalSizes;


    private static void delete(int pos) {
        if (connections.get(pos) == null)
            return;
        Set<Integer> toVisit = connections.get(pos);
        Set<Integer> toDelete = new HashSet<>();
        connections.set(pos, null);
        for (int i : toVisit) {
            if (connections.get(i) != null) {
                connections.get(i).remove(pos);
                if (connections.get(i).size() <= originalSizes[i] / 2.) {
                    toDelete.add(i);
                }
            }
        }
        for (int i : toDelete) {
            delete(i);
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        C = s.nextInt();
        P = s.nextInt();
        X = s.nextInt();
        L = s.nextInt();
        connections = new ArrayList<>(C);
        originalSizes = new int[C];

        for (int i = 0; i < C; i++) {
            connections.add(new HashSet<>());
        }

        for (int i = 0; i < P; i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            connections.get(a).add(b);
            connections.get(b).add(a);
            originalSizes[a]++;
            originalSizes[b]++;
        }

        delete(L - 1);

        System.out.println(connections.get(X - 1) == null ? "leave" : "stay");

        s.close();
    }

}
