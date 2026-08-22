import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    // New base index
                    stack.push(i);

                } else {

                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}