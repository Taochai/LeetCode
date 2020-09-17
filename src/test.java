import java.util.*;

public class test {
    static int b;
    public static void main(String[] args) {
//        System.out.println( Math.round(12.773456*1000));
//        System.out.println((Math.round(12.773456*1000)/1000.0));
        ArrayList<Integer> arr = new ArrayList<>(2);
        System.out.println(arr.size());
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        for(int i: set){
            System.out.println(i);
        }
    }
    //test````````````````
    //test 笔记本
    String concatSwaps(String s, int[] sizes) {
        if(sizes.length==0 || sizes.length==1) return s;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[sizes.length];
        for(int i=0;i<sizes.length;i++){
            strArr[i] = s.substring(index, index+sizes[i]);
            index = index +sizes[i];
        }
        for(int i=0;i<strArr.length;i+=2){
            sb.append(strArr[i+1]);
            sb.append(strArr[i]);
        }
        if(strArr.length%2!=0){
            sb.append(strArr[strArr.length-1]);
        }
        return sb.toString();
    }


}
//class Solution {
//    public static  void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        Comparator comp = new Comparator<Object>(){
//            @Override
//            public int compare(Object o1, Object o2) {
//
//
//
//            }
//
//
////            @Override
////            public boolean compare(int a, int b) {
////                // TODO Auto-generated method stub
////                return a==b;
////            }
////            @Override
////            public boolean compare(String s1, String s2) {
////                // TODO Auto-generated method stub
////                return s1.equals(s2);
////            }
////            @Override
////            public boolean compare(int[] arr1, int[] arr2) {
////                // TODO Auto-generated method stub
////                if(arr1.length!=arr2.length) return false;
////                for (int i = 0; i < arr1.length; i++) {
////                    if(arr1[i]!=arr2[i]) return false;
////                }
////                return true;
////            }
//        };
//
//        int testCases = Integer.parseInt(scan.nextLine());
//        while(testCases-- > 0){
//            int condition = Integer.parseInt(scan.nextLine());
//            switch(condition){
//                case 1:
//                    String s1=scan.nextLine().trim();
//                    String s2=scan.nextLine().trim();
//
//                    System.out.println( (comp.compare(s1,s2)) ? "Same" : "Different" );
//                    break;
//                case 2:
//                    int num1 = scan.nextInt();
//                    int num2 = scan.nextInt();
//
//                    System.out.println( (comp.compare(num1,num2)) ? "Same" : "Different");
//                    if(scan.hasNext()){ // avoid exception if this last test case
//                        scan.nextLine(); // eat space until next line
//                    }
//                    break;
//                case 3:
//                    // create and fill arrays
//                    int[] array1 = new int[scan.nextInt()];
//                    int[] array2 = new int[scan.nextInt()];
//                    for(int i = 0; i < array1.length; i++){
//                        array1[i] = scan.nextInt();
//                    }
//                    for(int i = 0; i < array2.length; i++){
//                        array2[i] = scan.nextInt();
//                    }
//
//                    System.out.println( comp.compare(array1, array2) ? "Same" : "Different");
//                    if(scan.hasNext()){ // avoid exception if this last test case
//                        scan.nextLine(); // eat space until next line
//                    }
//                    break;
//                default:
//                    System.err.println("Invalid input.");
//            }// end switch
//        }// end while
//        scan.close();
//    }

//}
