package murilo.barbosa.stack.and.queue.exercises;

import murilo.barbosa.stack.and.queue.Stack;

public class ImplementingQueueUsingStacks {

    private static class Queue<T> {

        private Stack<T> stack1;
        private Stack<T> stack2;

        public Queue(T value) {
            this.stack1 = new Stack<>(value);
            this.stack2 = new Stack<>();
        }

        public Queue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public T peek() {
            return this.stack1.peek();
        }

        public void enqueue(T value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            stack1.push(value);

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public T dequeue() {
            return this.stack1.pop();
        }

    }

    public static void main(String[] args) {
        var queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
