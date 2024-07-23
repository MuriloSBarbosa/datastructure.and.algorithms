package murilo.barbosa.stack.and.queue;

import murilo.barbosa.common.Node;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public Queue(T value) {
        var newNode = new Node<>(value);
        this.first = newNode;
        this.last = newNode;
        this.size++;
    }

    public Queue() {
    }

    public T peek() {
        if (this.first != null) {
            return this.first.value;
        }
        return null;
        // O(1)
    }

    public void enqueue(T value) {
        var newNode = new Node<>(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
        // O(1)
    }

    public T dequeue() {
        if (this.first == null) {
            return null;
        }

        if(this.first == this.last) {
            this.last = null;
        }

        var value = this.first.value;
        this.first = this.first.next;
        this.size--;
        return value;
        // O(1)
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var current = this.first;
        while (current != null) {
            sb.append(current.value).append(" <- ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        var queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
