package com.example.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        
        long[] myTimes = new long[100];
        long[] otherTimes = new long[100];
        for(int i=0;i<100;i++){
            myTimes[i] = meuTeste();
            otherTimes[i] = top1Solution();
        }
        System.out.println("My time: " + Arrays.stream(myTimes).average().orElse(0));
        System.out.println("Other time: " + Arrays.stream(otherTimes).average().orElse(0));
    }

    public static long top1Solution(){
        long start = System.nanoTime();
        
        longestCommonPrefixTop1Solution(new String[]{"flower","flow","flight"});
        longestCommonPrefixTop1Solution(new String[]{"cir","car"});
        longestCommonPrefixTop1Solution(new String[]{"c","acc","ccc"});
        longestCommonPrefixTop1Solution(new String[]{"dog","racecar","car"});
        longestCommonPrefixTop1Solution(new String[]{"a"});
        longestCommonPrefixTop1Solution(new String[]{"ab", "a"});
        
        long end = System.nanoTime();

        return (end - start);
    }

    public static long meuTeste(){
        long start = System.nanoTime();
        
        longestCommonPrefix(new String[]{"flower","flow","flight"});
        longestCommonPrefix(new String[]{"cir","car"});
        longestCommonPrefix(new String[]{"c","acc","ccc"});
        longestCommonPrefix(new String[]{"dog","racecar","car"});
        longestCommonPrefix(new String[]{"a"});
        longestCommonPrefix(new String[]{"ab", "a"});
        
        long finish = System.nanoTime();
        return finish - start;
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 1) return strs[0];

        
        int smallestWordIndex = 0;
        int smallestWordLength = strs[0].length();
        if(strs.length > 5){
            for(int j=1;j<strs.length;j++){
                if(strs[j].length() < smallestWordLength){
                    smallestWordIndex = j;
                }

                if(strs[smallestWordIndex].length() == 1){
                    break;
                }
            }
        }
        
        String commonPrefix = strs[smallestWordIndex];
        for(int j=0;j<strs.length;j++){

            if(j == smallestWordIndex) continue;

            while (strs[j].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0,commonPrefix.length() -1);
            }
        }

        return commonPrefix;
    }

    public static String longestCommonPrefixTop1Solution(String[] strs) {
        String S=strs[0];
        for(String sr : strs)
        {
            while(sr.indexOf(S)!=0){
                S=S.substring(0 , S.length()-1);
            }
        }
        return S;
    }
}
