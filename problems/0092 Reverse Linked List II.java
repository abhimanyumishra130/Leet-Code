/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        if(left == 1){
            return reverseListNode(head,right-left+1);
        }
        ListNode temp = head;
        int count = 1;
        while(temp != null){
            if(count == left-1){
                break;
            }
            temp = temp.next;
            count++;
        }
        temp.next = reverseListNode(temp.next, right-left+1);
        return head;
    }
    
    public ListNode reverseListNode(ListNode head, int t){
        if(head == null || head.next == null || t == 1) return head;
        
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        while(cur != null && t-->0){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        if(next != null) head.next = next;
        return prev;
    }
}
