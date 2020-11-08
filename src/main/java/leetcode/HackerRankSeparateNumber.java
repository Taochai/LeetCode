package leetcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerRankSeparateNumber {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        String firstS = "";
        for(int len=1;len<=s.length();len++){

            String currS = s.substring(0,len);
            int currInt = Integer.parseInt(currS);
            if(currInt==0){
                System.out.println("NO");
                return;
            }
            int tmpLen = len;
            tmpLen += helper(currS);
            firstS = currS;
            for(int i=len;i<=s.length();){
                if(i+tmpLen > s.length()){
                    break;
                }
                // tmpLen += helper(s.substring(i,i+tmpLen));
                String nextS = s.substring(i,i+tmpLen);
                int nextInt = Integer.parseInt(nextS);
                // System.out.print("first "+currInt);
                // System.out.println("  second "+nextInt);
                if(nextInt-currInt==1){
                    if(i+tmpLen==s.length()){
                        System.out.println("YES "+firstS);
                        return;
                    }
                    currInt = nextInt;
                    i = i + tmpLen;
                    tmpLen += helper(nextS);
                }else{
                    break;
                }
            }
        }
        System.out.println("NO");
    }
    static int helper(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='9'){
                return 0;
            }
        }
        return 1;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}

