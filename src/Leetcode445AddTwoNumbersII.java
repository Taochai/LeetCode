public class Leetcode445AddTwoNumbersII {
      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode ll1 = reverse(l1);
//            ListNode ll2 = reverse(l2);
//            ListNode ans = new ListNode(0);
//            ListNode ans1 = ans;
//            int cnt = 0;
//            int sum = 0;
//            while(ll1!=null || ll2!=null || cnt==1){
//                int add1 = ll1==null ? 0 : ll1.val;
//                int add2 = ll2==null ? 0 : ll2.val;
//                sum = (add1+add2+cnt)%10;
//                cnt = (add1+add2+cnt)/10;
//                ans.val = sum;
//                if(ll1!=null) ll1=ll1.next;
//                if(ll2!=null) ll2=ll2.next;
//                if(ll1==null && ll2==null && cnt==0) break;
//                ans.next = new ListNode(0);
//                ans = ans.next;
//            }
//            return reverse(ans1);
//        }
//        private ListNode reverse(ListNode l){
//            if(l==null || l.next==null) return l;
//            ListNode prev = null;
//            while(l!=null){
//                ListNode tmp = l.next;
//                l.next = prev;
//                prev = l;
//                l = tmp;
//            }
//            return prev;
//        }
//    }
//    class solution2{
//          // no reverse, using stack
//          public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//              // follow up: not modify input lists. no reverse list
//              // using stack to calculate from list end to start.
//              Stack<Integer> s1 = new Stack<>();
//              Stack<Integer> s2 = new Stack<>();
//              while(l1!=null){
//                  s1.push(l1.val);
//                  l1 = l1.next;
//              }
//              while(l2!=null){
//                  s2.push(l2.val);
//                  l2 = l2.next;
//              }
//              int sum = 0;
//              ListNode list = new ListNode(0);
//              while(!s1.isEmpty() || !s2.isEmpty()){
//                  if(!s1.isEmpty()) sum += s1.pop();
//                  if(!s2.isEmpty()) sum += s2.pop();
//                  list.val = sum % 10;
//                  ListNode prev = new ListNode(sum/10);
//                  prev.next = list;
//                  list = prev;
//                  sum /= 10;
//              }
//              return list.val == 0? list.next : list;
//          }
//}
}
