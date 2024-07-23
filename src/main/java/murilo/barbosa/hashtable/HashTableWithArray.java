package murilo.barbosa.hashtable;


import java.util.ArrayList;
import java.util.Arrays;
import murilo.barbosa.array.ListPersonalized;

public class HashTableWithArray<K, V> {

    private int size;

    private Object[] elements;


    public HashTableWithArray(int size) {
        this.elements = new Object[size];
        this.size = size;
    }

    public HashTableWithArray() {
        this(10);
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % this.size);
        // O(1)
    }

    public void put(K key, V value) {
        var address = this.getHash(key);

        if (this.elements[address] == null) {
            this.elements[address] = new ListPersonalized<Entry>();
        }

        var list = (ListPersonalized<Entry>) this.elements[address];

        list.add(new Entry(key, value));
    }

    public V get(K key) {
        var address = this.getHash(key);

        var list = (ListPersonalized<Entry>) this.elements[address];

        var iterator = list.iterator();

        while (iterator.hasNext()) {
            var current = (Entry<K, V>) iterator.next();
            if (key.equals(current.key)) {
                return current.value;
            }
        }

        return null;
        // O(1) in most cases, but can be O(n) if we have a lot of collisions
    }


    @Override
    public String toString() {
        var result = new StringBuilder();
        var index = 0;
        for (var element : this.elements) {
            result.append(index).append(": ");
            if (element != null) {
                var array = new ArrayList<>();
                var iterator = ((ListPersonalized<Entry>) element).iterator();
                while (iterator.hasNext()) {
                    array.add(iterator.next());
                }
                result.append(Arrays.toString(array.toArray()));
            } else {
                result.append("null");
            }
            result.append("\n");
            index++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // In most cases, HashTableWithArray is O(1) for get and put operations

        var hashTable = new HashTableWithArray<String, Integer>();

        hashTable.put("Murilo", 1);
        hashTable.put("Barbosa", 2);
        hashTable.put("Teste", 3);

        System.out.println(hashTable);

        // But if we have limited space, we can have a lot of collisions
        // In this case, the complexity can be O(n)

        var hashTable2 = new HashTableWithArray<String, Integer>(2);

        hashTable2.put("Murilo", 1);
        hashTable2.put("Barbosa", 2);
        hashTable2.put("Teste", 3);

        System.out.println(hashTable2);
    }

}
