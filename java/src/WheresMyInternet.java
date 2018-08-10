import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WheresMyInternet {

    private static int N, M;
    private static House[] houses;
    private static int numConnected;

    private static class House {

        boolean visited;
        List<House> adjacent;

        House() {
            visited = false;
            adjacent = new ArrayList<>();
        }

    }

    private static void traverse(House pos) {
        for (House h : pos.adjacent) {
            if (!h.visited) {
                h.visited = true;
                numConnected++;
                traverse(h);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        numConnected = 1;
        N = s.nextInt();
        M = s.nextInt();
        houses = new House[N];
        for (int i = 0; i < N; i++) {
            houses[i] = new House();
        }
        houses[0].visited = true;
        for (int i = 0; i < M; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            houses[a - 1].adjacent.add(houses[b - 1]);
            houses[b - 1].adjacent.add(houses[a - 1]);
        }
        traverse(houses[0]);
        if (numConnected == N) {
            System.out.println("Connected");
        } else {
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (!houses[i].visited) {
                    out.append(i + 1);
                    out.append('\n');
                }
            }
            System.out.println(out.toString());
        }
    }

}
