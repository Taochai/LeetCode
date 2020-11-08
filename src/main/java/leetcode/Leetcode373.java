package leetcode;

import java.util.*;

public class Leetcode373 {


        public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            List<List<Integer>> ans = new ArrayList<>();
            if(k==0 || nums1.length==0 || nums2.length==0) return ans;
            class compareL implements Comparator<List<Integer>> {
                @Override
                public int compare(List<Integer> l1, List<Integer> l2) {
                    return l1.get(0) + l1.get(1) - l2.get(0) - l2.get(1);
                }
            }
            PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(new compareL());
            for(int i=0;i<nums1.length;i++){
                for(int j=0;j<nums2.length;j++){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums1[i]);
                    l.add(nums2[j]);
                    pq.add(l);
                }
            }
            while(!pq.isEmpty() && k>0){
                ans.add(pq.poll());
                k--;
            }
            return ans;
        }

    }

