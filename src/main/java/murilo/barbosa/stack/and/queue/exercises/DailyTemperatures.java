package murilo.barbosa.stack.and.queue.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
public class DailyTemperatures {

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temps.length; i++) {
            var current = temps[i];

            while(!stack.isEmpty() && current > temps[stack.peek()]) {
                results[stack.peek()] = i - stack.pop();
            }

            stack.add(i);
        }

        return results;
    }
}
