import java.util.HashMap;

public class Leetcode525ContiguousArray {

        public int findMaxLength(int[] nums) {
            //corner case:
            if(nums.length==0 || nums.length==1) return 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0) nums[i] = -1;
            }
            int ans = 0;
            int sum = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
                if(sum==0) ans = i+1;
                if(!map.containsKey(sum)){
                    map.put(sum,i);
                }else{
                    ans = Math.max(ans, i-map.get(sum));
                }
            }
            return ans;
        }

/////////
// 存 sum = n, 最小的index i，包括i在内， length = j - i
// sum = 0, 0
}
