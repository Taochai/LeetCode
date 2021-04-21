package leetcode;

public class Leetcode24 {
    /*
     * 两个指针，prev和curr，交换prev.next, curr用来定位更新后的prev.next位置
     * */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next == null) {
                break;
            }
            curr = curr.next.next;
            prev.next = swap(prev.next);
            prev = prev.next.next;
            prev.next = curr;
        }
        return dummyNode.next;
    }

    private ListNode swap(ListNode node) {
        if (node.next == null) return node;
        node.next.next = node;
        return node.next;
    }
}

