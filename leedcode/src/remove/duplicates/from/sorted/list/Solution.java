package remove.duplicates.from.sorted.list;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
        ListNode inputHead = head;
        ListNode node = head;
        while (node.next != null) {
        	if (node.val == node.next.val) {
        		node.next = node.next.next;
        	} else {
        		node = node.next;
        	}
        }
        return inputHead;
    }
}
