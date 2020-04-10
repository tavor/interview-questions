import java.util.HashSet;
import java.util.LinkedList;

class Node {
	int val;
	Node[] nodes;

	public Node(int v) {
		this.val = v;
	}
}
class Graph {
	Node head;
	public void breadthFirstSearch() {
		HashSet<Node> visited = new HashSet<Node>();
		LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(head);
		
		while (queue.peek() != null) {
			Node n = queue.poll();
				visited.add(n);				
			System.out.println(n.val);
				if (n.nodes != null) {
				for (int i = 0; i < n.nodes.length; i++) {
					if (!visited.contains(n.nodes[i])) {
						queue.add(n.nodes[i]);
					}
				}
			}
			
		}
	}
}

public class GraphDriver {	
		

	public static void main(String[] args) {
		Graph g = new Graph();

		g.head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		g.head.nodes = new Node[] { two, three };
		two.nodes = new Node[] { new Node(4) };
		three.nodes = new Node[] { new Node(5), g.head };

		g.breadthFirstSearch();
	}
}
