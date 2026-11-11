class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n=arr.length;
        int [] output=new int[n];
        Stack<Integer> st = new Stack();
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.empty() && arr[i]>=arr[st.peek()]) st.pop();
            if(st.empty()) {output[i]=0;}
              else{ output[i]=st.peek()-i;
              }
               st.push(i);
        } 
        return output;
    } 
}