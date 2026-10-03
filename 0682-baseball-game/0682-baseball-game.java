class Solution {
    public int calPoints(String[] arr) {
       Stack <Integer> st=new Stack<>();
     
       for(int i=0;i<arr.length;i++){
        String s=arr[i];
        if(s.equals("C"))st.pop();
        else if(s.equals("D"))st.push(2*st.peek());
        else if(s.equals("+")){
            int top=st.pop();
            int secondtop=st.peek();
            int sum=top+secondtop;
            st.push(top);
            st.push(sum);
        }else{
            st.push(Integer.parseInt(s));
        }
       }
        int total=0;
        for(int score : st){
            total+=score;
        }
       return total;

       
    }
}