package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Leetcode716 {
/*
*   也可以用两个stack来处理.
*   一个stack来做常规操作，另一个maxStack来记录最大值。
*   当做popMax操作时，依然需要一个buffer的stack来暂时存一些pop出去的值。
* */
    class MaxStack {
        private Stack<Integer> stack;
        private Queue<Integer> pq;

        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack<>();
            pq = new PriorityQueue<>((o1, o2)-> o2-o1);
        }

        public void push(int x) {
            stack.push(x);
            pq.offer(x);
        }

        public int pop() {
            int topElement = stack.pop();
            pq.remove(topElement);
            return topElement;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return pq.peek();
        }

        public int popMax() {
            int max = pq.poll();
            Stack<Integer> currStack = new Stack<>();
            while(!stack.isEmpty() && stack.peek()!=max){
                currStack.push(stack.pop());
            }
            stack.pop();
            while(!currStack.isEmpty()){
                stack.push(currStack.pop());
            }
            return max;
        }
    }
}
