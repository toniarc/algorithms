package com.example.leetcode.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome(101);

        long start = System.nanoTime();
        
        System.out.println(isPalindrome);
        
        long finish = System.nanoTime();
        System.out.println("Executed in " + (finish - start) + " ns");
    }

    public static boolean isPalindrome(int number) {

        int reverse = 0;
        int originalNumber = number;

        while (number > 0 ) {
            reverse = (reverse * 10) + (number % 10);
            number = number / 10;
        }

        return reverse == originalNumber;
    }

}
