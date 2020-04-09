import java.util.ArrayList;
import java.util.Arrays;

class Heap {
	ArrayList<Integer> heap;

	Heap() {
		heap = new ArrayList<Integer>();
	}

	public void add(Integer i) {
		heap.add(i);
		siftUp();
	}

	public int poll() {
		int i = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		siftDown();
		return i;
	}

	private void siftDown() {
		int i = 0;
		while (hasLeftChild(i) || hasRightChild(i)) {
			int greatestIndex = getLeftChild(i);
			if (hasRightChild(i) && hasLeftChild(i) &&
			    heap.get(getRightChild(i)) > heap.get(getLeftChild(i))) {
				greatestIndex = getRightChild(i); 
			}

			if (heap.get(getLeftChild(i)) < heap.get(i)) {
				break;
			}
		
			int t = heap.get(greatestIndex);
			heap.set(greatestIndex, heap.get(i));
			heap.set(i, t);
			i = greatestIndex;
		}
	}

	private boolean hasLeftChild(int i) {
		return 2 * i + 1 < heap.size();	
	}
	
	private boolean hasRightChild(int i) { 
		return 2 * i + 2 < heap.size();
	}

	private int getLeftChild(int i) {
		return 2 * i + 1;
	}

	private int getRightChild(int i) {
		return 2 * i + 2;
	}

	private void siftUp() {
		int i = heap.size() - 1;
		while (hasParent(i) && heap.get(getParentIndex(i)) < heap.get(i)) {
			int t = heap.get(getParentIndex(i));
			heap.set(getParentIndex(i), heap.get(i));
			heap.set(i, t);
			i = getParentIndex(i);
		}
	}

	private boolean hasParent(int i) {
		if (i % 2 == 0) {
			return (i - 2) / 2 > -1;
		}
		return (i - 1) / 2 > -1;
	}

	private int getParentIndex(int i) {
		if (i % 2 == 0) {
			return (i - 2) / 2; 
		}
		return (i - 1) / 2;
	}

	public Integer peek() {
		return heap.get(0);
	}
}

public class HeapDriver {	
	public static void main(String[] args) {
		Heap heap = new Heap();

		heap.add(1);
		heap.add(2);

		assert 2 == heap.peek() : "Top of heap should be 2";
		assert Arrays.equals(Arrays.asList(2, 1).toArray(), heap.heap.toArray()) : "Heap array should look like [2, 1]";
	
		heap.add(3);
		heap.add(-1);
		heap.add(5);

		assert 5 == heap.peek() : "Top of heap should be 5";
		assert 5 == heap.poll() : "5 should be first off heap";
		assert 3 == heap.poll() : "3 should be second off heap";
		assert 2 == heap.poll() : "2 should be third off heap";
		assert 1 == heap.poll() : "1 should be fourth off heap";
		assert -1 == heap.poll() : "-1 should be fourth off heap";
	}
}
