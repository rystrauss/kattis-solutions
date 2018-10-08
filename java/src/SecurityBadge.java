/*
    Note: While this solution passes the first two test cases, it is currently exceeds the time limit on the third.
 */

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class SecurityBadge {

    private static Range[][] access;
    private static int rooms, locks, badges;
    private static int start, end;
    private static HashSet<Integer> authorizedBadges;

    private static class Range {

        private int min, max;

        private Range(int min, int max) throws IllegalArgumentException {
            if (min < 1 || max < 1 || max < min)
                throw new IllegalArgumentException();
            this.min = min;
            this.max = max;
        }

        private Range intersection(Range r) {
            if (max < r.min || r.max < min)
                return null;
            int newMin = Math.max(min, r.min);
            int newMax = Math.min(max, r.max);
            return new Range(newMin, newMax);
        }

    }

    private static void traverse() {
        HashSet<Integer> visited = new HashSet<>();
        traverse(start, new Range(1, badges), visited);
    }

    private static void traverse(int room, Range badges, HashSet<Integer> visited) {
        if (room == end) {
            for (int i = badges.min; i <= badges.max; i++)
                authorizedBadges.add(i);
            return;
        }
        if (visited.contains(room))
            return;
        visited.add(room);
        for (int i = 1; i <= rooms; i++) {
            if (access[room - 1][i - 1] != null) {
                traverse(i, badges.intersection(access[room - 1][i - 1]), visited);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(new File("input.txt"))) {
            rooms = s.nextInt();
            locks = s.nextInt();
            badges = s.nextInt();
            start = s.nextInt();
            end = s.nextInt();
            access = new Range[rooms][rooms];
            for (int i = 0; i < locks; i++) {
                int from = s.nextInt();
                int to = s.nextInt();
                int minBadge = s.nextInt();
                int maxBadge = s.nextInt();
                access[from - 1][to - 1] = new Range(minBadge, maxBadge);
            }
            authorizedBadges = new HashSet<>();
            traverse();
            System.out.println(authorizedBadges.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}