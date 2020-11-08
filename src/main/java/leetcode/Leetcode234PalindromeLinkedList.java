package leetcode;

import java.util.ArrayList;

public class Leetcode234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();
        while(head!=null){
            l.add(head.val);
            head=head.next;
        }

        int i=0,j=l.size()-1;
        while(i<j){

            if(!l.get(i++).equals(l.get(j--))) return false;
        }
        // for(int i=0;i<l.size()/2;i++){
        //     if(l.get(i)!=l.get(l.size()-1-i)) return false;
        // }
        return true;
    }
}
