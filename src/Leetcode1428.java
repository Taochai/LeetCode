public class Leetcode1428 {
//    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//
//        List<Integer> pos = binaryMatrix.dimensions();
//        int row = pos.get(0);
//        int col = pos.get(1);
//        int ans = col;
//        for(int i=0;i<row;i++){
//            int l = 0, r = col-1;
//            while(l<r){
//                int mid = l + (r-l)/2;
//                int val = binaryMatrix.get(i,mid);
//                if(val==0){
//                    l = mid +1;
//                }else{
//                    r = mid;
//                }
//            }
//            if(binaryMatrix.get(i,l)==1) ans = Math.min(ans,r);
//        }
//
//        return ans==col ? -1 : ans;
//    }
}
