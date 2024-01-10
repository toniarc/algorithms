package com.example.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LengthLastWordTest {

    @Test
    void testcase1(){

        String s = "Hello World";

        LengthLastWord llw = new LengthLastWord();
        int result = llw.lengthOfLastWord(s);

        Assertions.assertEquals(result, 5);
    }

    @Test
    void testcase2(){

        String s = "   fly me   to   the moon  ";

        LengthLastWord llw = new LengthLastWord();
        int result = llw.lengthOfLastWord(s);

        Assertions.assertEquals(result, 4);
    }

    @Test
    void testcase3(){

        String s = "luffy is still joyboy";

        LengthLastWord llw = new LengthLastWord();
        int result = llw.lengthOfLastWord(s);

        Assertions.assertEquals(result, 6);
    }
}
