public class Leetcode25ReverseNodesinkGroup {
    class Solution {
        // recursive method...recusive 还是牛逼啊////////////////////////////////
        public ListNode reverse(ListNode head, int k){
            ListNode prev = null;
            while(k>0){
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                k--;
            }
            return prev;
        }
        public ListNode reverseKGroup(ListNode head, int k){
            int count = 0;
            ListNode ptr = head;
            while(count<k && ptr!=null){
                count++;
                ptr = ptr.next;
            }
            if(count==k){
                ListNode newHead = reverse(head,k);
                head.next = reverseKGroup(ptr,k);
                return newHead;
            }
            return head;
        }
 ////////////////////////////////////////////////////////////////////////////////
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if(head==null || head.next==null) return head;
//         int len = 0;
//         ListNode lenNode = head;
//         while(lenNode!=null){
//             len++;
//             lenNode =  lenNode.next;
//         }

//         ListNode first = head;
//         ListNode prev = null;
//         ListNode last = head;
//         ListNode prevFirst = null;
//         ListNode tmp = null;
//         ListNode ans = null;
//         for(int i=0;i<len/k;i++){
//             for(int j=0;j<k;j++){
//                 tmp = last.next;
//                 last.next = prev;
//                 prev = last;
//                 last = tmp;
//             }
//             if(i==0) ans = prev;
//             if(prevFirst==null){
//                 prevFirst = first;
//                 first = last;
//             }else{
//                 prevFirst.next = prev;
//                 prevFirst = first;
//                 first = last;
//             }
//         }
//         prevFirst.next = last;
//         return ans;
//     }

    }
}
