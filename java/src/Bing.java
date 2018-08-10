import java.util.*;

public class Bing {

    private static class TrieLexicon {

        private class Node {

            Node parent;
            Map<Character, Node> children;
            boolean isWord;
            char c;
            int eventualLeaves;

            Node() {
                children = new TreeMap<>();
                isWord = false;
                parent = null;
                c = '\0';
                eventualLeaves = 0;
            }

            Node(char c, Node parent) {
                children = new TreeMap<>();
                isWord = false;
                this.parent = parent;
                this.c = c;
                eventualLeaves = 0;
            }

        }

        private Node root;

        TrieLexicon() {
            root = new Node();
        }

        boolean add(String word) {
            word = word.toLowerCase();
            Node pos = root;
            pos.eventualLeaves++;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node child = pos.children.get(c);
                if (child == null) {
                    child = new Node(c, pos);
                    pos.children.put(c, child);
                }
                pos = child;
                pos.eventualLeaves++;
            }
            if (!pos.isWord) {
                pos.isWord = true;
                return true;
            }
            return false;
        }

        int possibleWords(String s) {
            s = s.toLowerCase();
            Node pos = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                pos = pos.children.get(c);
                if (pos == null) {
                    return 0;
                }
            }
            return pos.eventualLeaves;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TrieLexicon lexicon = new TrieLexicon();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String word = in.next();
            int count = lexicon.possibleWords(word);
            lexicon.add(word);
            System.out.println(count);
        }
    }

}
