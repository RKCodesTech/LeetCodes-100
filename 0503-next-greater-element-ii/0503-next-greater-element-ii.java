import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!st.isEmpty() && st.peek() <= arr[idx]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) {
                    nge[idx] = -1;
                } else {
                    nge[idx] = st.peek();
                }
            }

            st.push(arr[idx]);
        }

        return nge;
    }
}