package remove.nth.node.from.end.of.list;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = head;
		ListNode removeNode = new ListNode(0);
		removeNode.next = head;
		ListNode inputHead = removeNode;
		
		while(node != null && n>0) {
			node = node.next;
			n--;
		}
		if (n != 0) return null;
		
		while(node != null) {
			removeNode = removeNode.next;
			node = node.next;
		}
		
		if (removeNode.next != null) {
			removeNode.next = removeNode.next.next;
		}
		return inputHead.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = head;
		int x = 1;
		for(int i=2;i<=x;i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		node = head;
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println();
		
		Solution s = new Solution();
		int n = 1;
		head = s.removeNthFromEnd(head, n);
		while (head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
}
