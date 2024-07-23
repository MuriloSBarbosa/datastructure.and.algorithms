package murilo.barbosa.tree;

import java.util.ArrayList;
import java.util.List;
import murilo.barbosa.utils.TxtReader;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
        // O(n) => n the length of the word
    }

    private void insert(List<String> words) {
        words.forEach(this::insert);
        // O(n * m) => n the number of words and m the length of the word
    }

    public List<String> search(String input) {
        TrieNode node = this.root;
        List<String> words = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!node.containsKey(c)) {
                return words;
            }
            node = node.get(c);
        }
        this.collect(node, input, words);
        return words;
        // O(n) => n the length of the input
    }

    private void collect(TrieNode node, String input, List<String> words) {
        if (node.isEnd()) {
            words.add(input);
        }

        for (var c : node.keys()) {
            this.collect(node.get(c), input + c, words);
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        var dictionary = TxtReader.readLines("src/main/java/murilo/barbosa/tree/dictionary.txt");

        trie.insert(dictionary);

        System.out.println(trie.search("bana"));
    }
}
