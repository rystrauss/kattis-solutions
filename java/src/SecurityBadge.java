import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SecurityBadge {

    private class Lock {

        int low, high;
        int lowPassed, highPassed;
        int destination;

        Lock(int low, int high, int destination) {
            this.low = low;
            this.high = high;
            this.destination = destination;
            lowPassed = Integer.MAX_VALUE;
            highPassed = Integer.MIN_VALUE;
        }

    }

    private int N, L, B;
    private List<List<Lock>> rooms;
    private int S, D;
    private int permissableBadges;

    private SecurityBadge(int N, int L, int B, int S, int D) {
        this.N = N;
        this.L = L;
        this.B = B;
        this.permissableBadges = 0;
        this.rooms = new ArrayList<>(this.N);
        for (int i = 0; i < this.N; i++)
            this.rooms.add(new LinkedList<>());
        this.S = S;
        this.D = D;
    }

    private void buildGraph(FastReader in) throws IOException {
        for (int i = 0; i < L; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            int low = in.nextInt();
            int high = in.nextInt();
            this.rooms.get(from).add(new Lock(low, high, to));
        }
    }

    private void traverse(int pos, int low, int high) {
        if (pos == this.D) {
            this.permissableBadges += high - low + 1;
            return;
        }
        for (Lock lock : rooms.get(pos)) {
            if ((low <= lock.high && low < lock.lowPassed) || (high >= lock.low && high > lock.highPassed)) {
                lock.lowPassed = low;
                lock.highPassed = high;
                int newLow = Math.max(low, lock.low);
                int newHigh = Math.min(high, lock.high);
                traverse(lock.destination, newLow, newHigh);
            }
        }
    }

    private void solve() {
        traverse(this.S, 0, this.B);
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        SecurityBadge securityBadge = new SecurityBadge(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() - 1, in.nextInt() - 1);
        securityBadge.buildGraph(in);
        in.close();
        securityBadge.solve();
        System.out.println(securityBadge.permissableBadges);
    }

}
