package leetcode;

public class Leetcode846HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || W == 0 || hand.length % W != 0) return false;
        int[] count = new int[W];
        for(int h : hand) {
            count[h % W]++;
        }
        for(int c : count) {
            if (c != (hand.length / W)) {
                return false;
            }
        }
        return true;
    }
    //     public boolean isNStraightHand(int[] hand, int W) {
//         if(hand.length%W!=0) return false;

//         int[][] arr = new int[hand.length/W][2];

//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int handCard : hand) pq.offer(handCard);

//         for(int i=0;i<hand.length/W;i++){
//             int tmp = pq.poll();
//             for(int j=0;j<W-1;j++){
//                 tmp++;
//                 if(pq.remove(tmp)){
//                     continue;
//                 }
//                 else{
//                     return false;
//                 }
//             }
//         }
//         return true;

//     }v
}
