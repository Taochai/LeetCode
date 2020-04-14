class RLEIterator {
    int[] arr;
    int index; // next n真实的跑了的index
    int j;     // even index
    public RLEIterator(int[] A) {
        this.arr = A;
        this.index = 0;
        j = 0;
    }

    public int next(int n) {

        while(j<arr.length){
            if(index+n<=arr[j]){
                index += n;
                return arr[j+1];
            }else{
                n -= arr[j]-index;  //偶数位减去跑过的index就是剩下的n，
                index = 0;
                j += 2;
            }
        }
        return -1;
    }
}
