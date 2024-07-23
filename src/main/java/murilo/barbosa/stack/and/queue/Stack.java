package murilo.barbosa.stack.and.queue;


import murilo.barbosa.common.Node;

public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack(T value) {
        this.top = new Node<>(value);
        this.size++;
    }

    public Stack() {
    }

    public T peek() {
        if (this.top != null) {
            return this.top.value;
        }
        return null;
        // O(1)
    }

    public void push(T value) {
        var newNode = new Node<>(value);
        if (this.size == 0) {
            this.top = newNode;
        } else {
            var current = this.top;
            this.top = newNode;
            newNode.next = current;
        }
        this.size++;
        // O(1)
    }

    public T pop() {
        if (this.top == null) {
            return null;
        }

        var value = this.top.value;
        this.top = this.top.next;
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
        var current = this.top;
        while (current != null) {
            sb.append(current.value).append(" <- ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }

}
