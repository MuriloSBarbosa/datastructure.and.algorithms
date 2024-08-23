package murilo.barbosa.linkedlists;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    public int size;


    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

    }

    public DoublyLinkedList(T value) {
        this.head = new Node<>(value);
        this.tail = this.head;
        this.size = 1;
    }

    public DoublyLinkedList() {
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
        newNode.prev = this.tail;
        this.tail = newNode;
        this.size++;
        return newNode;
        // O(1)
    }

    public Node<T> prepend(T value) {
        var newNode = new Node<>(value);
        newNode.next = this.head;
        this.head.prev = newNode;
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
        next.prev = newNode;
        newNode.prev = current;
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
            this.head.next.prev = null;
            this.head = this.head.next;
        } else {
            var prev = this.transverseToIndex(index - 1); //10
            var target = prev.next; //15
            var next = target.next; // 20
            if (next != null) {
                next.prev = prev;
            } else {
                this.tail = prev;
            }
            prev.next = next;

        }
        this.size--;
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
            result.append(current.value).append(" <==> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }

    public static void main(String[] args) {
        var node = new DoublyLinkedList<Integer>(10);
        node.append(20);
        node.append(30);
        node.append(40);
        node.prepend(5);
        node.insert(2, 15);
        node.remove(5);
        System.out.println(node);
        System.out.println(node.size);
    }
}
