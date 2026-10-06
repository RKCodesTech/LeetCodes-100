/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.util.Stack;
class Solution {
 
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            while(!st.empty()&&st.peek().val<temp.val){
                st.pop();
            }
            st.push(temp);
            temp=temp.next;
        }
        ListNode newhead=null;
        while(!st.empty()){
            ListNode Node=st.pop();
            Node.next=newhead;
            newhead=Node;
        }
        return newhead;
    }
}