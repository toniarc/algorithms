package com.example;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class RomamInteger {

    public static void main(String[] args) {
        long start = System.nanoTime();
        
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("VIII"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("X"));
        System.out.println(romanToInt("XLVIII"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        
        long finish = System.nanoTime();
        System.out.println("Executed in " + (finish - start) + " ns");
    }

    public static int romanToInt(String s) {
        
        int result = 0;
        char lastChar = '0';

        for(int i=0;i<s.length();i++){

            char currentChar = s.charAt(i);

            if(currentChar == 'I') {
                result += 1;
            }

            if(currentChar == 'V'){
                if(lastChar == 'I') {
                    result += 3;
                } else {
                    result += 5;
                }
            }

            if(currentChar == 'X'){
                if(lastChar == 'I') {
                    result += 8;
                } else {
                    result += 10;
                }
            }

            if(currentChar == 'L'){
                if(lastChar == 'X') {
                    result += 30;
                } else {
                    result += 50;
                }
            }

            if(currentChar == 'C'){
                if(lastChar == 'X') {
                    result += 80;
                } else {
                    result += 100;
                }
            }

            if(currentChar == 'D'){
                if(lastChar == 'C') {
                    result += 300;
                } else {
                    result += 500;
                }
            }

            if(currentChar == 'M'){
                if(lastChar == 'C') {
                    result += 800;
                } else {
                    result += 1000;
                }
            }

            lastChar = currentChar;
        }

        return result;
    }

    public int romanToIntTop1Solution(String s) {

        int ans = 0;

        int[] roman = new int[128];

        roman['I'] = 1;

        roman['V'] = 5;

        roman['X'] = 10;

        roman['L'] = 50;

        roman['C'] = 100;

        roman['D'] = 500;

        roman['M'] = 1000;

        for (int i = 0; i + 1 < s.length(); ++i)

        if (roman[s.charAt(i)] < roman[s.charAt(i + 1)])

            ans -= roman[s.charAt(i)];

        else

            ans += roman[s.charAt(i)];

        return ans + roman[s.charAt(s.length() - 1)];

    }
}
