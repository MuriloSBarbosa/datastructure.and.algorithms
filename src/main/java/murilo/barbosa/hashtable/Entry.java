package murilo.barbosa.hashtable;

public class Entry<K, V> {

    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
              "key=" + key +
              ", value=" + value +
              '}';
    }
}
