class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

 // 1st time. 12/19/2019
 //
 public class Leetcode2AddTwoNumbers {
     public static void main(String[] args) {
         System.out.println("hello 2");
     }
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummy = new ListNode(0);
         ListNode curr = dummy;
         int m = 0;
         while(l1!=null && l2!=null){
             int val = (l1.val+l2.val+m)%10;
             m = (l1.val+l2.val+m)/10;
             curr.next = new ListNode(val);
             curr = curr.next;
             l1 = l1.next;
             l2 = l2.next;
         }
         while(l1!=null){
             int val1 = (l1.val+m)%10;
             m = (l1.val+m)/10;
             curr.next = new ListNode(val1);
             curr = curr.next;
             l1 = l1.next;
         }
         while(l2!=null){
             int val2 = (l2.val+m)%10;
             m = (l2.val+m)/10;
             curr.next = new ListNode(val2);
             curr = curr.next;
             l2 = l2.next;
         }
         if(m==1){
             curr.next = new ListNode(1);
         }
         return dummy.next;
     }
 }
