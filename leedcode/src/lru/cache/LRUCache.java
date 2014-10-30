package lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Node head = null;
	private Node tail = null;
	private Map<Integer,Node> data = null;
	private int capacity = 0;
	
	public class Node {
		int key;
		int val;
		Node next;
		Node pre;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		data = new HashMap<Integer,Node>();
		//设置虚拟的链表头和尾
		head = new Node(-1,-1);
		tail = new Node(-1,-1);
		head.next = tail;
		tail.pre = head;
    }
	
	public void putToHead(Node p) {
		if (p.next != null && p.pre != null) {
			p.pre.next = p.next;
			p.next.pre = p.pre;
		}
		head.next.pre = p;
		p.next = head.next;
		head.next = p;
		p.pre = head;
	}
	
	public int removeEnd() {
		Node p = tail.pre;
		p.pre.next = tail;
		tail.pre = p.pre;
		p.pre = null;
		p.next = null;
		return p.key;
	}
    
    public int get(int key) {
    	if (data.containsKey(key)) {
    		Node p = data.get(key);
    		putToHead(p);
    		return p.val;
    	} else {
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if (data.containsKey(key)) {
    		//data中已经存在p，更新p的值，并将其移动到链表头
    		Node p = data.get(key);
    		p.val = value;
    		data.put(key, p);
    		putToHead(p);
    	} else {
    		//data中不存在
    		if (data.size() < capacity) {
    			//data的size未达到上限，新建p将其加入data，并设为链表头
    			Node p = new Node(key, value);
    			data.put(key, p);
    			putToHead(p);
    		} else {
    			//data的size已达上限，删除链表尾，并在data中删除链表尾对应的key，新建p，将p加入data，并设为链表头
    			data.remove(removeEnd());
    			Node p = new Node(key,value);
    			putToHead(p);
    			data.put(key, p);
    		}
    	}
    }
}
