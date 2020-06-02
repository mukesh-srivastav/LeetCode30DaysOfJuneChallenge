/**
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Day2_DeleteNodeInLinkedList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        ListNode curr = node; ListNode prev = null;
        
        while (curr.next != null) {
            prev = curr;
            prev.val = curr.next.val;
            curr = curr.next;
        }
        
        prev.next = null;
    }
}