import java.util.ArrayList;
import java.util.List;
/*
    1st time
    ---hash function: 2069
    ---handle collision: list
* */
public class Leetcode706DesignHashMap {
    class MyHashMap {
        private int key_space;
        private List<Bucket> hash_table;
        /** Initialize your data structure here. */
        public MyHashMap() {
            this.key_space = 2069;
            this.hash_table = new ArrayList<>();
            for(int i=0;i<this.key_space;i++){
                this.hash_table.add(new Bucket());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash_key = key % this.key_space;
            this.hash_table.get(hash_key).update(key,value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash_key = key % this.key_space;
            return this.hash_table.get(hash_key).get(key);
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash_key = key % this.key_space;
            this.hash_table.get(hash_key).remove(key);
        }
    }

    class Pair{
        int key;
        int val;
        public Pair(int _key, int _val){
            this.key = _key;
            this.val = _val;
        }
    }

    class Bucket{
        private List<Pair> bucket;
        public Bucket(){
            this.bucket = new ArrayList<Pair>();
        }
        public int get(int key){
            for(Pair pair : this.bucket){
                if(pair.key==key) return pair.val;
            }
            return -1;
        }
        public void update(int key, int val){
            boolean found = false;
            for(Pair pair : this.bucket){
                if(pair.key==key){
                    pair.val = val;
                    found = true;
                }
            }
            if(!found){
                this.bucket.add(new Pair(key,val));
            }
        }
        public void remove(int key){
            for(Pair pair : this.bucket){
                if(pair.key == key){
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
    }
}
