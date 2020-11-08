package leetcode;

public class Leetcode1290 {
    public int getDecimalValue(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        ListNode curr = prev;
        int ans = 0;
        int index = 0;
        while(curr!=null){

            ans += Math.pow(2,index++)*curr.val;
            curr = curr.next;
        }
        return ans;
    }
}
