import java.io.File;
import java.util.*;

public class WheresMyInternet {

    private class House {

        private int id;
        private boolean connected;
        private Set<House> adjHouses;

        private House(int id) {
            this.id = id;
            connected = false;
            adjHouses = new HashSet<>();
        }

    }

    private List<House> houses;

    private WheresMyInternet(Scanner s) {
        int n = s.nextInt();
        int m = s.nextInt();
        houses = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            houses.add(new House(i));
        }
        houses.get(0).connected = true;
        for (int i = 0; i < m && s.hasNext(); i++) {
            s.nextLine();
            House h1 = houses.get(s.nextInt() - 1);
            House h2 = houses.get(s.nextInt() - 1);
            h1.adjHouses.add(h2);
            h2.adjHouses.add(h1);
        }
    }

    private void traverse() {
        for (House h : houses.get(0).adjHouses) {
            traverse(h);
        }
    }

    private void traverse(House currHouse) {
        if (currHouse.connected)
            return;
        currHouse.connected = true;
        for (House h : currHouse.adjHouses) {
            traverse(h);
        }
    }

    private void printUnconnected() {
        boolean connectedGraph = true;
        StringBuilder out = new StringBuilder();
        for (House h : houses) {
            if (!h.connected) {
                out.append(h.id);
                out.append("\n");
                connectedGraph = false;
            }
        }
        if (connectedGraph) {
            System.out.println("Connected");
        } else {
            out.deleteCharAt(out.length() - 1);
            System.out.println(out.toString());
        }
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(new File("input.txt"))) {
            WheresMyInternet wmi = new WheresMyInternet(s);
            wmi.traverse();
            wmi.printUnconnected();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
