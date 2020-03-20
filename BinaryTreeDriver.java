import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

class Node {
	Integer value;
	Node lChild;
	Node rChild;
	
	public Node() {
		this.value = value;
		this.lChild = null;
		this.rChild = null;
	}

	public Node(Integer i) {
		this.value = i;
	}

	public void createLeft() {
		if (this.lChild == null) {
			this.lChild = new Node();
		}
	}

	public void createRight() {
		if (this.rChild == null) {
			this.rChild = new Node();
		}
	}

	public Node getLeft() {
		return lChild;
	}

	public Node getRight() {
		return rChild;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer i) {
		this.value = i;
	}

	public void setLeft(Node n) {
		this.lChild = n;
	}

	public void setRight(Node n) {
		this.rChild = n;
	}
}

class BinaryTree {
	private Node root;	
	
	public BinaryTree() {
		this.root = null;
	}

	public Node getNode() {
		return this.root;
	}

	public Node getLeft() {
		return root.lChild;
	}

	public Node getRight() {
		return root.rChild;
	}

	public Integer getValue() {
		return root.value;
	}

	public void add(Integer i) {
		if (root == null) {
			root = new Node();
			root.value = i;
		} else if (root.value > i) {
			root.createLeft();
			add(i, root.getLeft());
		} else if (root.value < i) {
			root.createRight();
			add(i, root.getRight());
		}
	}
	
	private void add(Integer i, Node n) {
		if (n.getValue() == null) {
			n.setValue(i);
		} else if (n.getValue() > i) {
			n.createLeft();
			add(i, n.lChild);
		} else if (n.getValue() < i) {
			n.createRight();
			add(i, n.rChild);
		}
	}

	public Integer get(Integer i) {
		if (root == null) {
			return null;
		} else if (root.getValue() == i) {
			return i;
		} else if (root.getValue() > i) {
			return get(i, root.getLeft());
		} else if (root.getValue() < i) {
			return get(i, root.getRight());
		}
		return null;
	}

	public Integer get(Integer i, Node n) { 	
		if (n == null) {
			return null;
		} else if (n.getValue() == i) {
			return i;
		} else if (n.getValue() > i) {
			return get(i, n.getLeft());
		} else if (n.getValue() < i) {
			return get(i, n.getRight());
		}
		return null;
	}

	public void depthFirstInOrderTraversal() {
		depthFirstInOrderTraversal(root);	
	}

	private void depthFirstInOrderTraversal(Node n) {
		if (n.getLeft() != null) {
			depthFirstInOrderTraversal(n.getLeft());
		}
	
		System.out.println(n.getValue());

		if (n.getRight() != null) {
			depthFirstInOrderTraversal(n.getRight());
		}
	}

	public void depthFirstPreOrderTraversal() {
		depthFirstPreOrderTraversal(root);	
	}	
	
	private void depthFirstPreOrderTraversal(Node n) {
		System.out.println(n.getValue());

		if (n.getLeft() != null) {
			depthFirstPreOrderTraversal(n.getLeft());
		}

		if (n.getRight() != null) {
			depthFirstPreOrderTraversal(n.getRight());
		}		
	}

	public void breadthFirstSearch() {
		LinkedList<Node> queue = new LinkedList<Node>();

		queue.add(root);
		while (queue.peek() != null) {
			Node n = queue.remove();
			System.out.println(n.getValue());
			if (n.getLeft() != null) {
				queue.add(n.getLeft());
			} 
			if (n.getRight() != null) {
				queue.add(n.getRight());
			}
		}
	}
	
	public void depthFirstSearch() {
		Stack<Node> stack = new Stack<Node>();

		stack.push(root);
		while (stack.peek() != null) {
			Node n = stack.pop();
			System.out.println(n.getValue());
			if (n.getLeft() != null) {
				stack.push(n.getLeft());
			}
			if (n.getRight() != null) {
				stack.push(n.getRight());
			}
		}
	}

	public BinaryTree(LinkedList<Integer> lst) {
		LinkedList<Node> queue = new LinkedList<Node>();
		
		if (lst.peek() == null) {
			this.root = null;
		}

		this.root = new Node(lst.poll());
		queue.add(root);

		while (queue.peek() != null) {
			Node parent = queue.poll();
		
			Node leftChild = null, rightChild = null;
			if (lst.peek() != null) {
				leftChild = new Node(lst.poll());
				queue.add(leftChild);
			}

			if (lst.peek() != null) {
				rightChild = new Node(lst.poll());
				queue.add(rightChild);
			}

			parent.setLeft(leftChild);
			parent.setRight(rightChild);
		}
	}
}

class BinaryTreePrinter {

    private Node tree;

    public BinaryTreePrinter(Node tree) {
        this.tree = tree;
    }

    private String traversePreOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└";
        String pointerLeft = (root.getRight() != null) ? "├" : "└";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
        boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└";
            String pointerLeft = (node.getRight() != null) ? "├" : "└";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);

        }

    }

    public void print() {
        System.out.println(traversePreOrder(tree));
    }

}

public class BinaryTreeDriver {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.add(1);
		tree.add(2);
		tree.add(-1);
		tree.add(-2);
		tree.add(11);

		BinaryTreePrinter printer = new BinaryTreePrinter(tree.getNode());
			
		printer.print();

		assert -1 == tree.get(-1);
		assert null == tree.get(10);
		
		System.out.println("Depth-first in order traversal");
		tree.depthFirstInOrderTraversal();

		System.out.println("Depth-first pre order traversal");
		tree.depthFirstPreOrderTraversal();

		System.out.println("Bread-first search");
		tree.breadthFirstSearch();

		System.out.println("Construct binary tree with linkedlist");
		LinkedList<Integer> input = new LinkedList<Integer>(
			Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		);
		BinaryTree treeFromLinkedList = new BinaryTree(input);
		BinaryTreePrinter linkedListTreePrinter = new BinaryTreePrinter(treeFromLinkedList.getNode());
		linkedListTreePrinter.print();
	}	
}

