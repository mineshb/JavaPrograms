package org.complex.extra;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListIntersection {

    // Function to find the intersection point of two linked lists
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Calculate the lengths of both linked lists
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // Align the start of both linked lists
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        // Traverse both lists together to find the intersection point
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // Intersection point found
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null; // No intersection point found
    }

    // Helper function to calculate the length of a linked list
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static ListNode findIntersectionUsingTortoiseMethod(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != h2) {
            if(h1.next == null) h1 = headB;
            else h1 = h1.next;

            if(h2.next == null) h2 = headA;
            else h2 = h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        // Example case: Creating a Y-shaped linked list
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(9);
        headA.next.next.next = common;

        ListNode headB = new ListNode(4);
        headB.next = common;

        ListNode intersection = findIntersectionUsingTortoiseMethod(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection point data: " + intersection.data);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}
