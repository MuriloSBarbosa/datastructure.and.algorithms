package murilo.barbosa.linkedlists;


import murilo.barbosa.common.Node;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    public int size;

    public LinkedList(T value) {
        this.head = new Node<>(value);
        this.tail = this.head;
        this.size = 1;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> append(T value) {
        var newNode = new Node<>(value);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
            return newNode;
        }

        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
        return newNode;
        // O(1)
    }

    public Node<T> prepend(T value) {
        var newNode = new Node<>(value);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
        return newNode;
        // O(1)
    }

    public Node<T> insert(int index, T value) {
        if (index == 0) {
            return this.prepend(value);
        }

        this.validateIndex(index);

        var current = this.transverseToIndex(index - 1);
        var next = current.next;
        var newNode = new Node<>(value);
        newNode.next = next;
        current.next = newNode;
        this.size++;
        return newNode;
        // O(n)
    }

    private void validateIndex(int index) {
        if (index > this.size - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    private Node<T> transverseToIndex(int index) {
        var current = this.head;
        int count = 0;

        while (count != index) {
            current = current.next;
            count++;
        }
        return current;
        // O(n)
    }

    public void remove(int index) {
        this.validateIndex(index);

        if (index == 0) {
            this.head = this.head.next;
        } else {
            var prev = this.transverseToIndex(index - 1);
            var target = prev.next; //15
            var next = target.next; // 20
            if (next == null) {
                this.tail = prev;
            }
            prev.next = next;
        }
        this.size--;
        // O(n)'
    }

    // prev | current
    // null | 1 -> 2 -> 3
    // next = 2 -> 3

    // prev       | current
    // null <- 1  |  2 -> 3
    // next = 3

    // prev             | current
    // null <- 1  <-  2 |  3
    // next = null

    // prev                    | current
    // null <- 1  <-  2  <-  3 | null

    public void reverse() {
        if(this.head.next == null) {
            return;
        }

        var current = this.head;
        Node<T> prev = null;
        Node<T> next = null;

        this.tail = this.head;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        // O(n)
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        var current = this.head;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }

    public static void main(String[] args) {
        var node = new LinkedList<Integer>(10);
        node.append(20);
        node.append(30);
        node.prepend(50);
        node.insert(2, 100);
        node.remove(3);
        System.out.println(node);
        node.reverse();
        System.out.println(node);
    }
}
