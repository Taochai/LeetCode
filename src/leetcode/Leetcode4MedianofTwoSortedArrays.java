package leetcode;

public class Leetcode4MedianofTwoSortedArrays {
    /**1st time:
//时间复杂度要求O(log (m+n))， 要用二分法来找median,实际上复杂度为O(log(min(m,n)))
// nums1: 1,2
// nums2: 3,4
// cut1: 左边有几个数
// cut2： 左边有几个数
// L1,R1       L2,R2
// 应该是 cut1+cut2 = len/2, L1<= R2, L2<=R1
// cut1 = (cutL + cutR) /2 每次二分cutL，cutR
// reference: https://www.youtube.com/watch?v=do7ibYtv5nk
     */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //O(log(min(m,n)));
            if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
            int len = nums1.length + nums2.length;
            int cut1 = 0, cut2 = 0;
            int cutL = 0, cutR = nums1.length;
            while(cut1<=nums1.length){
                cut1 = (cutR - cutL)/2 + cutL;
                cut2 = len/2 - cut1;
                int L1 = (cut1==0) ? Integer.MIN_VALUE : nums1[cut1-1];
                int R1 = (cut1==nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
                int L2 = (cut2==0) ? Integer.MIN_VALUE : nums2[cut2-1];
                int R2 = (cut2==nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
                if(L1>R2){
                    cutR = cut1 - 1;
                }else if(L2>R1){
                    cutL = cut1 + 1;
                }else{
                    if(len%2 == 0){
                        return (double)(Math.max(L1,L2)+Math.min(R1,R2))/2;
                    }else{
                        return (double)Math.min(R1,R2);
                    }
                }
            }
            return -1;
        }

}
