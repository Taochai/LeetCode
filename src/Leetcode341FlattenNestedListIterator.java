//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class Leetcode341FlattenNestedListIterator {
//    /**
//     * // This is the interface that allows for creating nested lists.
//     * // You should not implement it, or speculate about its implementation
//     * public interface NestedInteger {
//     *
//     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     *     public boolean isInteger();
//     *
//     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     *     // Return null if this NestedInteger holds a nested list
//     *     public Integer getInteger();
//     *
//     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     *     // Return null if this NestedInteger holds a single integer
//     *     public List<NestedInteger> getList();
//     * }
//     */
//    public class NestedIterator implements Iterator<Integer> {
//
//        int count=0;
//        List<Integer> allList;
//        public NestedIterator(List<NestedInteger> nestedList) {
//            allList = getAllInteger(nestedList);
//        }
//
//        @Override
//        public Integer next() {
//            return allList.get(count++);
//        }
//
//        @Override
//        public boolean hasNext() {
//            return count<allList.size();
//        }
//        private List<Integer> getAllInteger(List<NestedInteger> nestedList){
//            List<Integer> l = new ArrayList<>();
//            for(NestedInteger ni : nestedList){
//                if(ni.isInteger()){
//                    l.add(ni.getInteger());
//                }else{
//                    l.addAll(getAllInteger(ni.getList()));
//                }
//            }
//            return l;
//        }
//    }
//
///**
// * Your NestedIterator object will be instantiated and called as such:
// * NestedIterator i = new NestedIterator(nestedList);
// * while (i.hasNext()) v[f()] = i.next();
// */
//}
