class FILOQueue {
	class Element {
		Integer val;
		Element parent;
		Element next;
		
		Element(Integer i) {
			this.val = i;
		}		
	}

	private Element head;
	private Element tail;

	public void enqueue(Integer i) {
		Element iE = new Element(i);

		if (this.head != null) {
			iE.next = this.head;
			this.head = iE;
			
			if (this.tail.parent == null) {
				this.tail.parent = this.head;	
			}
		} else {
			this.head = iE;
			this.tail = this.head;
		}
	}

	public Integer dequeue() {
		if (tail != null) {
			Element currentTail = this.tail;
			this.tail = this.tail.parent;

			return currentTail.val;
		} else if (head != null) {
			Element currentHead = this.head;
			this.head = this.head.next;

			return currentHead.val;
		}
		return null;
	}
}

class FIFOQueue {
	class Element {
		Integer val;
		Element next;

		Element (Integer v) {
			this.val = v;
		}
	}	

	private Element head;

	public void enqueue(Integer i) {
		Element iE = new Element(i);
	
		if (this.head != null) {
			iE.next = this.head;
		}

		this.head = iE;
	}

	public Integer dequeue() {
		if (head != null) {
			Element currentHead = this.head;
			this.head = this.head.next;

			return currentHead.val;
		}
		return null;
	}
}

public class QueueDriver {
	public static void main(String[] args) {
		FIFOQueue q = new FIFOQueue();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(5);
		
		assert 5 == q.dequeue();
		assert 2 == q.dequeue();
		assert 1 == q.dequeue();

		FILOQueue l = new FILOQueue();
		l.enqueue(1);
		l.enqueue(2);
		l.enqueue(3);

		assert 1 == l.dequeue();
		assert 2 == l.dequeue();
		assert 3 == l.dequeue();
	}
}
