// an array of length n has n! distinct permutations
// Knuth Shuffle
// time complexity: O(n)
public class Leetcode384ShuffleAnArray {
    private int[] original;
    public Leetcode384ShuffleAnArray(int[] nums) {
        this.original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] rand = this.original.clone();
        for (int i = 0; i < rand.length; i++){
            int r = (int) (Math.random() * (i+1));
            int tmp = rand[r];
            rand[r] = rand[i];
            rand[i] = tmp;
        }
        return rand;
    }

}
