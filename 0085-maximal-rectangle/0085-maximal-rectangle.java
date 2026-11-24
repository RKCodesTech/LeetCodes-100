class Solution {
    public int largestRectangle(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        // Next Smaller Element
        nse[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0; i--) {
            while(st.size()>0 && heights[st.peek()]>=heights[i])
                st.pop();
            if(st.size()==0)
                nse[i]=n;
            else
                nse[i]=st.peek();

            st.push(i);
        }
        st.clear();
        // Previous Smaller Element
        for(int i=0; i<n; i++) {
            while(st.size()>0 && heights[st.peek()]>=heights[i])
                st.pop();
            if(st.size()==0)
                pse[i]=-1;
            else
                pse[i]=st.peek();

            st.push(i);
        }
        int maxarea=0;
        for(int i=0; i<n; i++) {
            int area=heights[i]*(nse[i]-pse[i]-1);
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] heights=new int[m];
        int maxArea=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j]=='1') {
                    heights[j]++;
                }
                else {
                    heights[j]=0;
                }
            }

            maxArea=Math.max(maxArea,largestRectangle(heights));
        }

        return maxArea;
    }
}
