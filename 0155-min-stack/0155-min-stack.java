class MinStack {
Stack<Integer> st;
Stack<Integer> minSt;
    public MinStack() { // stack intiliazed in construtor
        st=new Stack<>(); //noramal stack
        minSt =new Stack<>(); //min stack to store minEle for each element
    }
    
    public void push(int value) {  //when push element into st.. push also min element in minst see if condition
       st.push(value);
       if(minSt.size()==0||value<minSt.peek()) minSt.push(value) ; // is stack is empty and value is smaller that minstack's peek then push updated val in min stack
       else minSt.push(minSt.peek());
    }
    
    public void pop() {
       st.pop();
       minSt.pop();  //pop from both minstack ans stack
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */