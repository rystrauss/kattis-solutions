import java.util.Scanner;

public class PhoneList {

    private static class Node {

        String value;
        Node[] children;
        boolean isLeaf;

        Node() {
            value = null;
            children = new Node[10];
            isLeaf = true;
        }

    }

    private static class Trie {

        Node root;

        Trie() {
            root = new Node();
        }

        boolean add(String number) {
            Node cur = root;
            for (int i = 0; i < number.length(); i++) {
                int digit = number.charAt(i) - 48;
                cur.isLeaf = false;
                if (cur.children[digit] == null) {
                    cur.children[digit] = new Node();
                } else if (cur.children[digit].value != null) {
                    return false;
                }
                cur = cur.children[digit];
            }
            cur.value = number;
            return cur.isLeaf;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            Trie t = new Trie();
            int k = s.nextInt();
            String out = "YES";
            for (int j = 0; j < k; j++) {
                String number = s.next();
                if (!t.add(number))
                    out = "NO";
            }
            System.out.println(out);
        }
    }

}
