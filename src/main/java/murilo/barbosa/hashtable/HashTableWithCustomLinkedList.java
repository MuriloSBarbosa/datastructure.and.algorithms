package murilo.barbosa.hashtable;


import java.util.ArrayList;
import java.util.List;
import murilo.barbosa.linkedlists.LinkedList;

public class HashTableWithCustomLinkedList<K, V> {

    private final int size;

    private final LinkedList<Entry<K, V>>[] elements;

    public HashTableWithCustomLinkedList(int size) {
        this.elements = new LinkedList[size];
        this.size = size;
    }

    public HashTableWithCustomLinkedList() {
        this(10);
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % this.size);
        // O(1)
    }

    public void put(K key, V value) {
        var address = this.getHash(key);

        if (this.elements[address] == null) {
            this.elements[address] = new LinkedList<Entry<K,V>>();
        }

        this.elements[address].append(new Entry(key, value));
        // O(1) in most cases, but can be O(n) if we have a lot of collisions
    }

    public V get(K key) {
        var address = this.getHash(key);

        LinkedList<Entry<K, V>> current = this.elements[address];

        if (current == null) {
            return null;
        }

        var node = current.getHead();

        while (!node.getValue().key.equals(key)) {
            node = node.getNext();
        }

        return node.getValue().value;
        // O(1) in most cases, but can be O(n) if we have a lot of collisions
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (var element : this.elements) {
            if (element == null) {
                continue;
            }
            var node = element.getHead();
            while (node != null) {
                keys.add(node.getValue().key);
                node = node.getNext();
            }
        }
        return keys;
        // O(n)
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (var element : this.elements) {
            if (element == null) {
                continue;
            }
            var node = element.getHead();
            while (node != null) {
                values.add(node.getValue().value);
                node = node.getNext();
            }
        }
        // O(n)
        return values;
    }

    public boolean containsKey(K key) {
        return this.elements[this.getHash(key)] != null &&
              this.elements[this.getHash(key)].getHead().getValue().key.equals(key);
        // O(1)
    }

    public boolean containsValue(V value) {
        for (var element : this.elements) {
            if (element == null) {
                continue;
            }
            var node = element.getHead();
            while (node != null) {
                if (node.getValue().value.equals(value)) {
                    return true;
                }
                node = node.getNext();
            }
        }

        return false;
        // O(n)
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        var index = 0;
        for (var element : this.elements) {
            result.append("Index ").append(index).append(": ");
            if (element == null) {
                result.append("null");
            } else {
                var node = element.getHead();
                while (node != null) {
                    result.append(node.getValue()).append(" -> ");
                    node = node.getNext();
                }

                result.append("null");
            }
            result.append("\n");
            index++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // In most cases, HashTableWithArray is O(1) for get and put operations

        var hashTable = new HashTableWithCustomLinkedList<String, Integer>();

        hashTable.put("Murilo", 1);
        hashTable.put("Barbosa", 2);
        hashTable.put("Teste", 3);

        System.out.println("Teste " + hashTable.get("Teste"));

        System.out.println(hashTable);

        // But if we have limited space, we can have a lot of collisions
        // In this case, the complexity can be O(n)

        var hashTable2 = new HashTableWithCustomLinkedList<String, Integer>(2);

        hashTable2.put("Murilo", 1);
        hashTable2.put("Barbosa", 2);
        hashTable2.put("Teste", 3);

        System.out.println(hashTable2);
        System.out.println("Keys");
        hashTable2.keys().forEach(System.out::println);
        System.out.println("values");
        hashTable2.values().forEach(System.out::println);

        System.out.println("Contains key");
        System.out.println(hashTable2.containsKey("Murilo"));
        System.out.println(hashTable2.containsKey("Murilwssso"));

        System.out.println("Contains value");
        System.out.println(hashTable2.containsValue(1));
        System.out.println(hashTable2.containsValue(4));
    }

}
