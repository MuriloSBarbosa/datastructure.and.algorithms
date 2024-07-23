package murilo.barbosa.hashtable;


import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {

//    [[entry,entry,entry], [entry,entry], [entry,entry,entry], [entry,entry,entry]]

    private final int size;

    private final Node<K, V>[] elements;

    private class Node<K, V> {

        Entry<K, V> entry;
        Node<K, V> next;
    }

    public HashTable(int size) {
        this.elements = new Node[size];
        this.size = size;
    }

    public HashTable() {
        this(10);
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % this.size);
        // O(1)
    }

    public void put(K key, V value) {
        var address = this.getHash(key);

        if (this.elements[address] == null) {
            this.elements[address] = new Node<K, V>();
            this.elements[address].entry = new Entry<K, V>(key, value);
        } else {
            Node<K, V> current = this.elements[address];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>();
            current.next.entry = new Entry<K,V>(key, value);
        }
        // O(1) in most cases, but can be O(n) if we have a lot of collisions
    }

    public V get(K key) {
        var address = this.getHash(key);

        Node<K, V> current = this.elements[address];

        if (current == null) {
            return null;
        }

        while (current.next != null) {
            current = current.next;
        }
        return current.entry.value;
        // O(1) in most cases, but can be O(n) if we have a lot of collisions
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Node<K, V> element : this.elements) {
            Node<K, V> current = element;
            while (current != null) {
                keys.add(current.entry.key);
                current = current.next;
            }
        }
        return keys;
        // O(n)
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Node<K, V> element : this.elements) {
            Node<K, V> current = element;
            while (current != null) {
                values.add(current.entry.value);
                current = current.next;
            }
        }
        // O(n)
        return values;
    }

    public boolean containsKey(K key) {
        return this.elements[this.getHash(key)] != null && this.elements[this.getHash(
              key)].entry.key.equals(key);
        // O(1)
    }

    public boolean containsValue(V value) {
        for (Node<K, V> element : this.elements) {
            Node<K, V> current = element;
            while (current != null) {
                if (current.entry.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
        // O(n)
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        for (Node<K, V> element : this.elements) {
            Node<K, V> current = element;
            while (current != null) {
                result.append(current.entry).append(" ");
                current = current.next;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // In most cases, HashTableWithArray is O(1) for get and put operations

        var hashTable = new HashTable<String, Integer>();

        hashTable.put("Murilo", 1);
        hashTable.put("Barbosa", 2);
        hashTable.put("Teste", 3);

        System.out.println("Teste " + hashTable.get("Teste"));

        System.out.println(hashTable);

        // But if we have limited space, we can have a lot of collisions
        // In this case, the complexity can be O(n)

        var hashTable2 = new HashTable<String, Integer>(2);

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
