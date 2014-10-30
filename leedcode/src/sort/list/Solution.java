package sort.list;

public class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode head2 = slow.next;
		slow.next = null;
		ListNode newhead = sortList(head);
		ListNode newhead2 = sortList(head2);
		return merge(newhead, newhead2);
    }
	
	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode newhead = null;
		if (head1.val <= head2.val) {
			newhead = head1;
			head1 = head1.next;
		} else {
			newhead = head2;
			head2 = head2.next;
		}
		ListNode p = newhead;
		while(head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				p.next = head1;
				head1 = head1.next;
			} else {
				p.next = head2;
				head2 = head2.next;
			}
			p = p.next;
		}
		while (head1 != null) {
			p.next = head1;
			head1 = head1.next;
			p = p.next;
		}
		while (head2 != null) {
			p.next = head2;
			head2 = head2.next;
			p = p.next;
		}
		p.next = null;
		return newhead;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		ListNode res = s.sortList(head);
		while(res!=null) {
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
}
