package com.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.RowFilter.Entry;

/*

20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

[ { ] }
0 1 2 3
i   j  
 */

public class ValidaParentheses {

    static Map<Character,Character> brackets = Map.of('(', ')','[', ']','{', '}');

    static String s1 = "()";
    static String s2 = "()[]{}";
    static String s3 = "()[{]}";
    static String s4 = "(]";
    static String s5 = "{}{}()[]";
    static String s6 = "(([]){})";
    static String s7 = "[[[]";
    static String s8 = "{}{{}}";
    static String s9 = "){";
    static String s10 = "([}}])";
    static String s11 = "(){}}{";
    static String s12 = "{";

    public static void main(String[] args) {
        double[] myTimes = new double[1000];
        double[] otherTimes = new double[1000];
        
        for(int i=0;i<1000;i++){
            myTimes[i] = myTests();
            otherTimes[i] = top1SolutionTests();
        }
        System.out.println("My time: " + Arrays.stream(myTimes).average().orElse(0) + " ms");
        System.out.println("Other time: " + Arrays.stream(otherTimes).average().orElse(0) + " ms");
    }

    public static double myTests() {
        System.out.println("\nMy Tests");
        long start = System.nanoTime();
        System.out.println(s1 + " resultado: " + isValid(s1));
        System.out.println(s2 + " resultado: " + isValid(s2));
        System.out.println(s3 + " resultado: " + isValid(s3));
        System.out.println(s4 + " resultado: " + isValid(s4));
        System.out.println(s5 + " resultado: " + isValid(s5));
        System.out.println(s6 + " resultado: " + isValid(s6));
        System.out.println(s7 + " resultado: " + isValid(s7));
        System.out.println(s8 + " resultado: " + isValid(s8));
        System.out.println(s9 + " resultado: " + isValid(s9));
        System.out.println(s10 + " resultado: " + isValid(s10));
        System.out.println(s11 + " resultado: " + isValid(s11));
        System.out.println(s12 + " resultado: " + isValid(s12));
        long end = System.nanoTime();
        return (end - start)/1000000.0;
    }

    public static double top1SolutionTests(){
        System.out.println("\nOther Tests");
        long start = System.nanoTime();
        System.out.println(s1 + " resultado: " + isValidTop1Solution(s1));
        System.out.println(s2 + " resultado: " + isValidTop1Solution(s2));
        System.out.println(s3 + " resultado: " + isValidTop1Solution(s3));
        System.out.println(s4 + " resultado: " + isValidTop1Solution(s4));
        System.out.println(s5 + " resultado: " + isValidTop1Solution(s5));
        System.out.println(s6 + " resultado: " + isValidTop1Solution(s6));
        System.out.println(s7 + " resultado: " + isValidTop1Solution(s7));
        System.out.println(s8 + " resultado: " + isValidTop1Solution(s8));
        System.out.println(s9 + " resultado: " + isValidTop1Solution(s9));
        System.out.println(s10 + " resultado: " + isValidTop1Solution(s10));
        System.out.println(s11 + " resultado: " + isValidTop1Solution(s11));
        System.out.println(s12 + " resultado: " + isValidTop1Solution(s12));
        long end = System.nanoTime();
        return (end - start)/1000000.0;
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                
                if(stack.isEmpty() && (c == ')' || c == '}' || c == ']')){
                    return false;
                }

                char lastChar = stack.getLast();
                if( (c == ')' && lastChar == '(') || (c == '}' && lastChar == '{') || (c == ']' && lastChar == '[')) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidOld(String s) {
        StringBuilder stack = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.append(c);
            } else {
                
                if(stack.length() == 0 && (c == ')' || c == '}' || c == ']')){
                    return false;
                }

                char lastChar = stack.charAt(stack.length()-1);
                if( (c == ')' && lastChar == '(') || (c == '}' && lastChar == '{') || (c == ']' && lastChar == '[')) {
                    stack = stack.deleteCharAt(stack.length()-1);
                } else {
                    return false;
                }
            }
        }
        return stack.length() == 0;
    }

    public static boolean isValidTop1Solution(String s) {
        char[] str = s.toCharArray();
        char[] stack = str;
        int top = -1;
        for(char c: str) {
            if(c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else if(top < 0) {
                return false;
            } else if(c == ')' && stack[top] != '(') {
                return false;
            } else if(c == ']' && stack[top] != '[') {
                return false;
            } else if(c == '}' && stack[top] != '{') {
                return false;
            } else {
                top--;
            }
        }
        return top < 0;
  }
}
