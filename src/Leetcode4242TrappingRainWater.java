public class Leetcode4242TrappingRainWater {
    // brute force -> DP -> two pointer
        public int trap(int[] height) {
            int n = height.length;
            // corner case:
            if(n==0 || n==1) return 0;
            // two pointer
            int l=0, r=n-1;
            int ans=0;
            int maxL = height[l];
            int maxR = height[r];
            while(l<r){
                if(maxL<maxR){
                    ans += maxL - height[l];
                    l++;
                    maxL = Math.max(maxL,height[l]);
                }else{
                    ans += maxR-height[r];
                    r--;
                    maxR = Math.max(maxR,height[r]);
                }
            }
            return ans;
        }

}
