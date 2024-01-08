package com.example;

/*
 You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */

public class MergeTwoSortedLists {

    public ListNode mergeTwoListsSampleSolution(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = null;
        ListNode lastNode = new ListNode();
        ListNode currentNode = null;

        while (list1 != null || list2 != null) {

            if( list1 == null || (list2 != null && list1.val > list2.val)){
                currentNode = new ListNode(list2.val);
                list2 = list2.next;
            } else if((list2 == null) || list1.val < list2.val){
                currentNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                currentNode = new ListNode(list1.val);
                currentNode.next = new ListNode(list2.val);
                list1 = list1.next;
                list2 = list2.next;
            } 

            if(head == null){
                head = currentNode;
            }

            lastNode.next = currentNode;
            lastNode = currentNode.next == null ? currentNode : currentNode.next;
            
        }
            
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}