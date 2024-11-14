package murilo.barbosa.array;


import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

public class ListPersonalized<T> {

    private T[] elements;
    private int size = 0;
    private boolean isDynamic = true;
    private static final int DEFAULT_CAPACITY = 10;

    public ListPersonalized(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.isDynamic = false;
    }

    public ListPersonalized() {
        this(DEFAULT_CAPACITY);
    }

    public void add(T element) {
        if (this.size == this.elements.length) {
            if (this.isDynamic) {
                this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
            } else {
                throw new IllegalArgumentException("List is full");
            }
        }
        this.elements[this.size++] = element;
        // O(1)
    }


    public T get(int index) {
        verifyIndex(index);
        return this.elements[index];
        // O(1)
    }

    private void verifyIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    public void remove(int index) {
        verifyIndex(index);
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
        // O(n)
    }

    public boolean remove(T element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
        // O(n)
    }


    public void forEach(Function<T, T> function) {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = function.apply(this.elements[i]);
        }
        // O(n)
    }

    public boolean contains(T element) {
        int found = binarySearch(element);
        return found >= 0;
        // O(log n)
    }

    public int binarySearch(T element) {
        var array = Arrays.copyOf(this.elements, this.size);
        Arrays.sort(array);
        // O(n log n)

        int left = 0;
        int right = this.size - 1;
        int middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle].equals(element)) {
                return middle;
            }
            if (element.hashCode() < array[middle].hashCode()) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public void sort() {
        Arrays.sort(this.elements, 0, this.size);
        // O(n log n)
    }

    public void clear() {
        this.size = 0;
        // O(1)
    }

    public boolean isEmpty() {
        return this.size == 0;
        // O(1)
    }

    public void set(int index, T element) {
        verifyIndex(index);
        this.elements[index] = element;
        // O(1)
    }

    public int size() {
        return this.size;
    }


    public ListIterator iterator() {
        return new ListIterator();
    }

    public class ListIterator {

        private int current = 0;

        public boolean hasNext() {
            return current < size;
        }

        public T next() {
            return elements[current++];
        }
    }
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < this.size - 1; i++) {
            builder.append(this.elements[i]);
            builder.append(", ");
        }
        builder.append(this.elements[this.size - 1]);
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        var list = new ListPersonalized<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach(x -> x * x);
        System.out.println(list);
    }

}
