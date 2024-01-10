package com.example.leetcode.easy;

import com.example.leetcode.easy.RemoveDuplicatesFromSortedArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void test1(){

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        Assertions.assertEquals(obj.removeDuplicates(nums), 5);
    }

    @Test
    void test2(){

        int[] nums = new int[]{1,1,2};

        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        Assertions.assertEquals(obj.removeDuplicates(nums), 2);
    }
}
