import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WheresMyInternet {

    private static int N, M;
    private static HashMap<Integer, ArrayList<Integer>> connections;
    private static boolean[] status;
    private static int numConnected;

    private static void traverse(int pos) {
        for (int i : connections.get(pos)) {
            if (!status[i]) {
                status[i] = true;
                numConnected++;
                traverse(i);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            numConnected = 1;
            N = s.nextInt();
            M = s.nextInt();
            connections = new HashMap<>();
            status = new boolean[N];
            status[0] = true;
            for (int i = 0; i < N; i++) {
                connections.put(i, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int a = s.nextInt();
                int b = s.nextInt();
                connections.get(a - 1).add(b - 1);
                connections.get(b - 1).add(a - 1);
            }
            traverse(0);
            if (numConnected == N) {
                System.out.println("Connected");
            } else {
                for (int i = 0; i < N; i++) {
                    if (!status[i]) {
                        System.out.println(i + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
