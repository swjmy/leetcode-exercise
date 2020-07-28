package intro.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    private char[][] pairs = new char[][]{{'(',')'},{'[',']'},{'{','}'}};

    public ValidParentheses() {
    }

    public static void main(String[] args) {
        ValidParentheses valid = new ValidParentheses();
        System.out.println(valid.isValid("()"));
        System.out.println(valid.isValid("()[]{}"));
        System.out.println(valid.isValid("(]"));
        System.out.println(valid.isValid("(]"));
        System.out.println(valid.isValid("([)]"));
        System.out.println(valid.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack  = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            Character peek = stack.peek();
            if (peek == null){
                stack.push(aChar);
                continue;
            }
            if (checkInPairs(peek,aChar)){
                stack.pop();
            }else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    private boolean checkInPairs(char left, char right) {
        for (char[] pair : pairs) {
            if (pair[0] == left && pair[1] == right){
                return true;
            }
        }
        return false;
    }
}
