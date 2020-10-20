package leetcode;

// 1st time
// 对于nums1里的每一个数，index i，在nums2 i之后找比他大的。找不到返回-1,找到了返回那个值。
// time complexity: O(n*n)
// 2nd time 用stack写了一遍。在stack里的比curr小的数，其下一个最大的就是curr。
public class Leetcode496NextGreatElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // corner case:
        if(nums1==null || nums1.length==0) return nums1;
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = nextGreat(nums2,nums1[i]);
        }
        return ans;
    }
    public int nextGreat(int[] nums2, int val){
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==val){
                for(int j=i+1;j<nums2.length;j++){
                    if(nums2[j]>val) return nums2[j];
                }
                return -1;
            }
        }
        return -1;
    }
}
// stack 找下一个更大的。
// 用map来记录。
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        // corner case:
//        if(nums1==null || nums1.length==0) return nums1;
//        int[] ans = new int[nums1.length];
//        Map<Integer,Integer> map = new HashMap<>();
//        Stack<Integer> stack = new Stack<>();
//        stack.push(nums2[0]);
//        for(int i=1;i<nums2.length;i++){
//            if(stack.size()==0){
//                stack.push(nums2[i]);
//                continue;
//            }
//            int tmp = stack.peek();
//            if(nums2[i]<tmp) stack.push(nums2[i]);
//            else{
//                while(stack.size()>0){
//                    int tmp2 = stack.peek();
//                    if(tmp2<nums2[i]){
//                        int tmp3 = stack.pop();
//                        map.put(tmp3,nums2[i]);
//                        if(stack.size()==0){
//                            stack.push(nums2[i]);
//                            break;
//                        }
//                    }
//                    else{
//                        stack.push(nums2[i]);
//                        break;
//                    }
//                }
//            }
//        }
//
//        while(stack.size()!=0){
//            map.put(stack.pop(),-1);
//        }
//        for(int i=0;i<nums1.length;i++){
//            ans[i] = map.get(nums1[i]);
//        }
//        return ans;
//    }
//public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//    Stack<Integer> s = new Stack<>();
//    Map<Integer,Integer> m = new HashMap<>();
//    for(int i=0;i<nums2.length;i++){
//        while(!s.isEmpty() && s.peek()<nums2[i]){
//            m.put(s.pop(),nums2[i]);
//        }
//        s.push(nums2[i]);
//    }
//    while(!s.isEmpty()){
//        m.put(s.pop(),-1);
//    }
//    int[] ans = new int[nums1.length];
//    for(int i=0;i<nums1.length;i++){
//        ans[i] = m.get(nums1[i]);
//    }
//    return ans;
//}
