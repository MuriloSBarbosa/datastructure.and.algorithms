package murilo.barbosa.stack.and.queue;



public class StackWithArray<T> {

    private T[] array;
    private int size;

    public StackWithArray(T value) {
        this.array = (T[]) new Object[10];
        this.size++;
    }

    public StackWithArray() {
        this.array = (T[]) new Object[10];
    }

    public T peek() {
        if (this.size > 0) {
            return this.array[this.size - 1];
        }
        return null;
        // O(1)
    }

    public void push(T value) {
        if (this.size == this.array.length) {
            var newArray = (T[]) new Object[this.array.length * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }
        this.array[this.size] = value;
        this.size++;
        // O(1)
    }

    public T pop() {
        if (this.size == 0) {
            return null;
        }
        var value = this.array[this.size - 1];
        this.array[this.size - 1] = null;
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
        for (int i = this.size - 1; i >= 0; i--) {
            sb.append(this.array[i]).append(" <- ");
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        var stack = new StackWithArray<Integer>();
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
