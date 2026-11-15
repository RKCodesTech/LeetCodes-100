class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int day = 0;
    public StockSpanner() {
        
    }
    public int next(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        int span;
        if (st.isEmpty()) {
            span = day + 1;
        } else {
            span = day - st.peek()[1];
        }
        st.push(new int[]{price, day});
        day++;

        return span;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */