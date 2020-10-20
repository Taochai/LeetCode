package leetcode;

import java.util.PriorityQueue;

public class Leetcode767ReorganizeString {
    public String reorganizeString(String S) {
        int[] m = new int[26];
        for(char cc : S.toCharArray()){
            m[cc-'a']++;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>(
                (o1,o2) -> -o1.count+o2.count
        );

        for(int i=0;i<26;i++){
            if(m[i]!=0){
                pq.add(new pair((char)('a'+i),m[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        pair prev = null;
        pair curr = null;
        if( pq.peek().count>(S.length()+1)/2) return "";

//         if(S.length()%2==0 && pq.peek().count>S.length()/2) return "";
//         if(S.length()%2!=0 && pq.peek().count>S.length()/2+1) return "";

        while(!pq.isEmpty() || prev.count!=0){

            if(prev!=null && prev.count!=0) pq.add(prev);
            prev = curr;
            curr = pq.poll();
            sb.append(curr.c);
            curr.count--;
        }

        return sb.toString();

    }
    class pair{
        char c;
        int count;
        public pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
}
