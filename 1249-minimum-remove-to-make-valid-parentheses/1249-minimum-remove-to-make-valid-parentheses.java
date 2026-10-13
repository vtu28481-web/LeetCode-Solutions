import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {

        boolean[] remove = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    remove[i] = true;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}