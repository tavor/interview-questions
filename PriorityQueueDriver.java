import java.util.LinkedList;

class MyPriorityQueue {
	LinkedList<Integer> queue;

	MyPriorityQueue() {
		queue = new LinkedList<Integer>();
	}

	void enqueue(Integer i) {
		if (queue.size() == 0) {
			queue.add(i);
			return;
		}
		
		int e = 0;
		while (e < queue.size() && 
		       queue.get(e) > i) { 
			e++; 
		}

		queue.add(e, i);
	}

	Integer dequeue() { return queue.poll(); }	
}

public class PriorityQueueDriver {
	public static void main(String[] args) {
		MyPriorityQueue mpq = new MyPriorityQueue();

		mpq.enqueue(1);
		mpq.enqueue(-1);
		mpq.enqueue(2);

		assert 2 == mpq.dequeue();
	}
}
