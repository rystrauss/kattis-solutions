import java.util.*;

public class WheresMyInternet {

    private class House {

        public int id;
        public boolean connected;
        public Set<House> adjHouses;

        public House(int id, boolean connected) {
            this.id = id;
            this.connected = connected;
            adjHouses = new HashSet<>();
        }

    }

    private List<House> houses;
    private int n, m;

    public WheresMyInternet(Scanner s) {
        houses = new ArrayList<>();
        n = s.nextInt();
        m = s.nextInt();
        for (int i = 1; i <= n; i++) {
            houses.add(new House(i, i == 1));
        }
        while (m > 0 && s.hasNext()) {
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
        boolean connected = true;
        for (House h : houses) {
            connected = h.connected;
        }
        if (connected) {
            System.out.println("Connected");
            return;
        }
        for (House h : houses) {
            if (!h.connected) {
                System.out.println(h.id);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            WheresMyInternet wmi = new WheresMyInternet(s);
            wmi.traverse();
            wmi.printUnconnected();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

}
