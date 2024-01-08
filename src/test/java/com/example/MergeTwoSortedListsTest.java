package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {

    @Test
    public void test1(){

        ListNode list1_3 = new ListNode(4);
        ListNode list1_2 = new ListNode(2, list1_3);
        ListNode list1_1 = new ListNode(1,list1_2);
        
        ListNode list2_3 = new ListNode(4);
        ListNode list2_2 = new ListNode(3, list2_3);
        ListNode list2_1 = new ListNode(1,list2_2);

        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode head = mtsl.mergeTwoListsSampleSolution(list1_1, list2_1);
        
        String result = toString(head);
        System.out.println(result);
        
        Assertions.assertEquals(result, "1,1,2,3,4,4");
    }

    @Test
    public void test2(){

        ListNode list1_1 = null;
        
        ListNode list2_1 = null;

        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode head = mtsl.mergeTwoLists(list1_1, list2_1);
        
        String result = toString(head);
        System.out.println(result);
        
        Assertions.assertEquals(result, "");
    }

    @Test
    public void test4(){

        ListNode list1_1 = new ListNode(5);
        
        ListNode list2_3 = new ListNode(4);
        ListNode list2_2 = new ListNode(2, list2_3);
        ListNode list2_1 = new ListNode(1,list2_2);

        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode head = mtsl.mergeTwoLists(list1_1, list2_1);
        
        String result = toString(head);
        System.out.println(result);
        
        Assertions.assertEquals(result, "1,2,4,5");
    }

    @Test
    public void test5(){

        ListNode list1_3 = new ListNode(4);
        ListNode list1_2 = new ListNode(2, list1_3);
        ListNode list1_1 = new ListNode(1,list1_2);

        ListNode list2_1 = new ListNode(5);

        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode head = mtsl.mergeTwoLists(list1_1, list2_1);
        
        String result = toString(head);
        System.out.println(result);
        
        Assertions.assertEquals(result, "1,2,4,5");
    }

    @Test
    public void test3(){

        ListNode list1_1 = null;
        
        ListNode list2_1 = new ListNode(0);

        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode head = mtsl.mergeTwoLists(list1_1, list2_1);
        
        String result = toString(head);
        System.out.println(result);
        
        Assertions.assertEquals(result, "0");
    }

    public String toString(ListNode listNode){
        List<Integer> result = new ArrayList<>();
        ListNode currentNode = listNode;
        while (currentNode != null) {
            result.add(currentNode.val);
            currentNode = currentNode.next;
        }
        return result.stream().map(i -> i.toString()).collect(Collectors.joining(","));
    }
}
