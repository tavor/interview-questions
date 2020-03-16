public class FindKtoLast {

	private class LinkedListNode {
		Integer value;
		LinkedListNode next;

		public LinkedListNode(Integer value, LinkedListNode node) {
			this.value = value;
			this.next = node;
		}

		public LinkedListNode next() {
			return this.next;
		}
	}
	
	public static void main(String[] args) {
		FindKtoLast program = new FindKtoLast();
		
		assert program.findKst(program.init(), 3) == 4;
		assert program.findKst(null, 3) == null;
	}
	
	private LinkedListNode init() {
		LinkedListNode last = new LinkedListNode(6, null);
		LinkedListNode m4 = new LinkedListNode(5, last);
		LinkedListNode m3 = new LinkedListNode(4, m4);
		LinkedListNode m2 = new LinkedListNode(3, m3);
		LinkedListNode m1 = new LinkedListNode(2, m2);
		LinkedListNode head = new LinkedListNode(1, m1);

		return head;
	}

	private Integer findKst(LinkedListNode node, int k) {
		if (node == null) {
			return null;
		}
		int cursor = 1;
		LinkedListNode current = node;
		LinkedListNode result = current;
		while (current.next() != null) {
			cursor += 1;
			if (cursor > k) {
				result = result.next;
			}
			current = current.next();
		}
		return result.value;
	}
}
