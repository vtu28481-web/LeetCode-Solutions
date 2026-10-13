import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> S = new Stack<>();
        int[] ans = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!S.isEmpty() && S.peek() > prices[i]) {
                S.pop();
            }

            if (S.isEmpty()) {
                ans[i] = prices[i];
            } else {
                ans[i] = prices[i] - S.peek();
            }

            S.push(prices[i]);
        }

        return ans;
    }
}