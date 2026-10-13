import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    stack.pop();
                } 
                else if (stack.peek() == -asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }
}