class Solution {
    public static void main(String args[]){
        String s="aabzbzcc";

    }
    public String removeDuplicates(String s) {
        Stack<Character> st= new Stack();
        Stack<Character> st2=new Stack();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.empty()||st.peek()!=ch){
                st.push(ch);
                
            }else{
                st.pop();
            } 
            }while(st.size()>0){
            st2.push(st.pop());

        }
        while(st2.size()>0){
            st.push(st2.pop());
        }
        System.out.println(st);
    StringBuilder result=new StringBuilder();
    for(char ch:st){
        result.append(ch);
    }
    return result.toString();
    }
           
        
    }
