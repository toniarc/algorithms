package com.example.leetcode.easy;

import com.example.leetcode.easy.RemoveElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveElementTest {

    @Test
    void testcase1(){
        RemoveElement re = new RemoveElement();

        int[] nums = new int[]{1};
        int val = 1;

        int i = re.removeElement(nums, val);
        Assertions.assertEquals(0, i);
        Assertions.assertArrayEquals(new int[]{-1}, nums);
    }

    @Test
    void testcase2(){
        RemoveElement re = new RemoveElement();

        int[] nums = new int[]{2};
        int val = 3;

        int i = re.removeElement(nums, val);
        Assertions.assertEquals(1, i);
        Assertions.assertArrayEquals(new int[]{2}, nums);
    }
}
