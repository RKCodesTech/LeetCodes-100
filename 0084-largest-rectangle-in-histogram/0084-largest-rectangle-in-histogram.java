class Solution {
    public int largestRectangleArea(int[] heights) {
              int n= heights.length;
         int[] nse =new int[n];
        int[] pse =new int[n];
        Stack<Integer> st= new Stack();
        nse[n-1]=n;
        st.push(n-1);
        for(int i= n-2;i>=0 ;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i])st.pop();         //next greater element code
            if(st.size()==0) nse[i]=n; //-1 nahi karege calculation ki vajah se
            else nse[i]= st.peek();
            st.push(i);
        }  
        st.clear();                                                     //clear stack

        for(int i=0;i<heights.length;i++){
    while(st.size()>0 && heights[st.peek()] >= heights[i]) st.pop();       //preveous greater element 
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<n;i++){
           int area=heights[i]*(nse[i]-pse[i]-1);               //area of rectangle
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;
    }
}