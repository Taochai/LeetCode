package leetcode;

import java.util.*;

public class Leetcode380 {
    class RandomizedSet {
        Map<Integer,Integer> map;
        List<Integer> l;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            l = new ArrayList<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val,l.size());
            l.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if(!map.containsKey(val)) return false;
            int i = map.get(val);

            map.put(l.get(l.size()-1),i);
            l.set(i,l.get(l.size()-1));
            l.remove(l.size()-1);
            map.remove(val);
            /*
            * remove map里的值要放在最后面，因为可能会有list里只有一个值的情况。那样的话，换了以后再加进去map就会出错
            * */
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {

            return l.get(rand.nextInt(l.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
