import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class SecurityBadge {

    private static Range[][] access;
    private static int rooms, badges;
    private static int start, end;
    private static HashSet<Integer> authorizedBadges;

    private static class Range {

        private int min, max;

        public Range(int min, int max) throws IllegalArgumentException {
            if(min < 1 || max < 1 || max < min)
                throw new IllegalArgumentException();
            this.min = min;
            this.max = max;
        }

        public Range intersection(Range r) {
            if (max < r.min || r.max < min)
                return null;
            int newMin = Math.max(min, r.min);
            int newMax = Math.min(max, r.max);
            return new Range(newMin, newMax);
        }

        @Override
        public String toString() {
            return "(" + min + ", " + max + ")";
        }
    }

    private static void traverse() {
        Stack<Integer> toVisit = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        dfs(start, new Range(1, badges), toVisit, visited);
    }

    private static void dfs(int room, Range badges, Stack<Integer> toVisit, HashSet<Integer> visited) {
        if(visited.contains(room) || badges == null)
            return;
        if(room == end) {
            for(int i = badges.min; i <= badges.max; i++)
                authorizedBadges.add(i);
            return;
        }
        visited.add(room);
        for(int i = 0; i < access[room-1].length; i++) {
            if(access[room-1][i] != null) {
                toVisit.push(i+1);
                dfs(toVisit.pop(), badges.intersection(access[room-1][i]), toVisit, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            String[] temp;
            temp = s.nextLine().split(" ");
            rooms = Integer.parseInt(temp[0]);
            badges = Integer.parseInt(temp[2]);
            temp = s.nextLine().split(" ");
            start = Integer.parseInt(temp[0]);
            end = Integer.parseInt(temp[1]);
            access = new Range[rooms][rooms];
            while(s.hasNext()) {
                temp = s.nextLine().split(" ");
                int from = Integer.parseInt(temp[0]);
                int to = Integer.parseInt(temp[1]);
                int minBadge = Integer.parseInt(temp[2]);
                int maxBadge = Integer.parseInt(temp[3]);
                access[from - 1][to - 1] = new Range(minBadge, maxBadge);
            }
            authorizedBadges = new HashSet<Integer>();
            traverse();
            System.out.println(authorizedBadges.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            s.close();
        }
    }

}
