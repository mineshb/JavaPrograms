package org.leetcode;


import java.util.ArrayList;
import java.util.List;

public class SumOfLinkedList {

    public static void main(String[] args) {
        List<ListNode> list1 = new ArrayList<>();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbersOptimized(l1, l2);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        StringBuilder first = new StringBuilder();
        while(l1 != null) {
            first.append(l1.val);
            l1 = l1.next;;
        }

        StringBuilder second = new StringBuilder();
        while(l2 != null) {
            second.append(l2.val);
            l2 = l2.next;;
        }

        int res = Integer.parseInt(first.toString()) + Integer.parseInt(second.toString());

        ListNode tmpNode = null, prevNode = null;
        for(char c : String.valueOf(res).toCharArray()) {
            tmpNode = new ListNode(Integer.parseInt(String.valueOf(c)), prevNode);
            prevNode = tmpNode;
        }
        result = tmpNode;
        return result;
    }

    public static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int first, second = 0;
        int sum, carry = 0;
        while(l1 != null || l2 != null) {
            first = (l1 != null) ?  l1.val : 0;
            second = (l2 != null) ?  l2.val : 0;
            sum = carry+first+second;
            carry = sum / 10;
            result.next = new ListNode(sum %10);
            result = result.next;
            if(l1 != null) l1 = l1.next;;
            if(l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbersGpt(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // A dummy node to simplify result list creation
        ListNode p = l1, q = l2, curr = dummy; // Pointers for l1, l2, and the result list
        int carry = 0; // To store carry from sum

        // Traverse both lists
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0; // Get value of l1 node, or 0 if null
            int y = (q != null) ? q.val : 0; // Get value of l2 node, or 0 if null
            int sum = carry + x + y; // Sum current digits and carry

            carry = sum / 10; // Update carry for next iteration
            curr.next = new ListNode(sum % 10); // Create a new node with the remainder
            curr = curr.next; // Move to the next node in the result

            // Move to the next nodes in l1 and l2 if available
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // If there is any carry left, add it as a new node
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        // Return the result list starting after the dummy node
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

