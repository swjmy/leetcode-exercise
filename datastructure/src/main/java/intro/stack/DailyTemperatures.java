package intro.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 80, 72, 76, 73};
        int[] ints = dailyTemperatures(temperatures);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] dailyTemperatures1(int[] t) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] days = new int[t.length];
        for (int i = 0; i < t.length; i++) {

        }
        return days;
    }
}
