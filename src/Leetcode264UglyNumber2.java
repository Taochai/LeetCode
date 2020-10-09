public class Leetcode264UglyNumber2 {
    //     public int nthUglyNumber(int n) {
//         //答案会超出int型的范围，所以用了Long
//         PriorityQueue<Long> pq = new PriorityQueue<>();
//         Set<Long> set = new HashSet<>();
//         long[] prime = {2,3,5};
//         pq.add(1L);
//         int cnt = 0;
//         long ans = 1;
//         while(cnt<n){
//             ans = pq.poll();
//             // System.out.println(ans); 出现重复，需要set去重
//             for(long p : prime){
//                 if(!set.contains(p*ans)){
//                     set.add(p*ans);
//                     pq.add(p*ans);
//                 }
//             }

//             cnt++;
//         }
//         return (int)ans;
//     }

    public int nthUglyNumber(int n){
        int[] nums = new int[1690];
        int i2=0, i3=0, i5=0;
        nums[0] = 1;
        for(int i=1;i<n;i++){
            int tmp1 = nums[i2]*2;
            int tmp2 = nums[i3]*3;
            int tmp3 = nums[i5]*5;
            int ugly = Math.min(Math.min(tmp1,tmp2),tmp3);
            nums[i] = ugly;
            if (ugly == tmp1) ++i2;
            if (ugly == tmp2) ++i3;
            if (ugly == tmp3) ++i5;
        }
        return nums[n-1];
    }
}
