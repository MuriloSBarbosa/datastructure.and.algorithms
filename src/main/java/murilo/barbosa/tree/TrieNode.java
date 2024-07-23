package murilo.barbosa.tree;

import java.util.HashMap;
import java.util.Set;

public class TrieNode {

    private HashMap<Character, TrieNode> children;

    private boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public boolean containsKey(char c) {
        return this.children.containsKey(c);
    }

    public Set<Character> keys() {
        return this.children.keySet();
    }

    public TrieNode get(char c) {
        return this.children.get(c);
    }

    public void put(char c, TrieNode node) {
        this.children.put(c, node);
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

}