package beakjoon.BJ_14426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TrieNode {

    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Main {

    static TrieNode root;

    static void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c);
        }
        currentNode.isEndOfWord = true;
    }

    static boolean searchPrefix(String prefix) {

        TrieNode currentNode = root;

        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfStrings = Integer.parseInt(st.nextToken());
        int numberOfQueries = Integer.parseInt(st.nextToken());

        root = new TrieNode();

        for (int i = 0; i < numberOfStrings; i++) {
            String str = br.readLine();
            insert(str);
        }

        int count = 0;
        for (int i = 0; i < numberOfQueries; i++) {
            String query = br.readLine();
            if (searchPrefix(query)) {
                count++;
            }
        }

        System.out.println(count);
    }

}
