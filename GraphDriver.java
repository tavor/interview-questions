import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Edge { 
	NodeWithEdges n;
	int cost;

	public Edge(NodeWithEdges n, int c) {
		this.n = n;
		this.cost = c;
	}

	public void setNodeAndCost(NodeWithEdges e, int c) {
		this.n = n;
		this.cost = c;
	}
}

class Node {
	int val;
	Node[] nodes;

	public Node(int v) {
		this.val = v;
	}
}

class NodeWithEdges {
	int val;
	Edge[] edges;
	int cost;

	public NodeWithEdges(int v) {
		this.val = v;
		this.cost = Integer.MAX_VALUE;
	}

	public void setEdges(Edge[] e) {
		this.edges = e;
	}

	public String toString() {
		return this.val + "";
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

class WeightedGraph {
	NodeWithEdges head;
	public List<NodeWithEdges> dijkstras() {
		NodeWithEdges current = head;		
		current.cost = 0;

		List<NodeWithEdges> path = new ArrayList<NodeWithEdges>();
		path.add(current);

		while (current.edges != null) {
			int cost = Integer.MAX_VALUE;
			Edge bestEdge = null;

			for (Edge e : current.edges) {
				e.n.cost = e.cost + current.cost < e.n.cost ? 
					e.cost + current.cost : e.n.cost;

				if (e.n.cost < cost) {
					bestEdge = e;
					cost = e.n.cost;
				}
			}

			current = bestEdge.n;
			path.add(bestEdge.n);
		}

		return path;
	}

	public void printPath(List<NodeWithEdges> l) {
		for (NodeWithEdges n : l) {
			System.out.print(n + " " );
		}
		System.out.println();
	}
}

public class GraphDriver {	
		

	public static void main(String[] args) {
		Graph g = new Graph();

		g.head = new Node(1);
		Node t = new Node(2);
		Node e = new Node(3);
		g.head.nodes = new Node[] { t, e };
		t.nodes = new Node[] { new Node(4) };
		e.nodes = new Node[] { new Node(5), g.head };

		g.breadthFirstSearch();

		// Based on https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif
		WeightedGraph weightedGraph = new WeightedGraph();
		NodeWithEdges one = new NodeWithEdges(1);
		NodeWithEdges two = new NodeWithEdges(2);
		NodeWithEdges three = new NodeWithEdges(6);
		NodeWithEdges four = new NodeWithEdges(3);
		NodeWithEdges five = new NodeWithEdges(4);
		NodeWithEdges six = new NodeWithEdges(5);

		Edge[] edgesFromOne = new Edge[3];
		edgesFromOne[0] = new Edge(two, 7);
		edgesFromOne[1] = new Edge(three, 14);
		edgesFromOne[2] = new Edge(four, 9);

		one.setEdges(edgesFromOne);

		Edge[] edgesFromSix = new Edge[1];
		edgesFromSix[0] = new Edge(six, 9);
		
		three.setEdges(edgesFromSix);

		Edge[] edgesFromThree = new Edge[2];
		edgesFromThree[0] = new Edge(three, 2);
		edgesFromThree[1] = new Edge(five, 11);

		four.setEdges(edgesFromThree);

		Edge[] edgesFromTwo = new Edge[2];
		edgesFromTwo[0] = new Edge(five, 15);
		edgesFromTwo[1] = new Edge(four, 10);

		two.setEdges(edgesFromTwo);

		Edge[] edgesFromFour = new Edge[1];
		edgesFromFour[0] = new Edge(six, 6);

		five.setEdges(edgesFromFour);

		weightedGraph.head = one;
		weightedGraph.printPath(weightedGraph.dijkstras());
	}	
}
