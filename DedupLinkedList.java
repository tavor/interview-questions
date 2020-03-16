import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class DedupLinkedList {
	public static void main(String[] args) {
		DedupLinkedList program = new DedupLinkedList();
			
		LinkedList<Integer> lst = new LinkedList<Integer>();
		lst.add(0); lst.add(0); lst.add(1);
		
		LinkedList<Integer> lstResult = new LinkedList<Integer>();
		lstResult.add(0); lstResult.add(1);

		program.dedup(lst);
		assert lstResult.equals(lst);
	}
	
	private void dedup(LinkedList<Integer> lst) {
		for (int i = 0; i < lst.size(); i++) {
			for (int j = i + 1; j < lst.size(); j++) {
				if (lst.get(i) == lst.get(j)) {
					lst.remove(j);
				}
			}
		}
	}	
}
