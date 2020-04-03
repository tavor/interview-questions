import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		
	public Integer maxDepth() {
		if (root == null) {
			return 0;
		}

		Integer leftSubtreeDepth = null, rightSubtreeDepth = null;
		if (root.getLeft() != null) {
			leftSubtreeDepth = 1 + getDepth(root.getLeft());
		}

		if (root.getRight() != null) {
			rightSubtreeDepth = 1 + getDepth(root.getRight());
		}

		if (leftSubtreeDepth != null && rightSubtreeDepth != null) {
			return leftSubtreeDepth > rightSubtreeDepth ?
				leftSubtreeDepth : rightSubtreeDepth;
		} else if (leftSubtreeDepth != null) { 
			return leftSubtreeDepth;
		} else if (rightSubtreeDepth != null) {
			return rightSubtreeDepth;
		}
		return 1;
	}

	private Integer getDepth(Node n) {	
		Integer leftSubtreeDepth = null, rightSubtreeDepth = null;
		if (n.getLeft() != null) {
			leftSubtreeDepth = 1 + getDepth(n.getLeft());
		}

		if (n.getRight() != null) {
			rightSubtreeDepth = 1 + getDepth(n.getRight());
		}
		
		if (leftSubtreeDepth != null && rightSubtreeDepth != null) {
			return leftSubtreeDepth > rightSubtreeDepth ?
				leftSubtreeDepth : rightSubtreeDepth;
		} else if (leftSubtreeDepth != null) { 
			return leftSubtreeDepth;
		} else if (rightSubtreeDepth != null) {
			return rightSubtreeDepth;
		}
		return 1;		
	}

	public List<List<Node>> getLevelLists() {
		List<List<Node>> levels = new ArrayList<List<Node>>();
		ArrayList<Node> currentLevel = null;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(this.root);

		int count = 0, product = 1;
		while (queue.peek() != null) {
			Node n = queue.poll();
			if ((count + 1) % product == 0) {
				currentLevel = new ArrayList<Node>();
				levels.add(currentLevel);
				product *= 2;
			}
			
			if (n != null) {
				currentLevel.add(n);
				queue.add(n.getLeft());
				queue.add(n.getRight());
			}
			count++;
		}

		return levels;
	}

	public Node firstCommonAncestor(Integer p, Integer q) {
		if (this.root == null) {
			return null;
		}

		if (this.root.getValue() == p &&
		    (contains(q, this.root.getLeft()) ||
		     contains(q, this.root.getRight()))) {
			return this.root;
		}

		if (this.root.getValue() == q &&
		    (contains(q, this.root.getLeft()) ||
		     contains(q, this.root.getRight()))) {
			return this.root;
		}

		Node left = firstCommonAncestor(p, q, this.root.getLeft());
		if (left != null) {
			return left;
		}

		Node right = firstCommonAncestor(p, q, this.root.getRight());
		if (right != null) {
			return right;
		}

		if ((contains(p, this.root.getLeft()) || contains(p, this.root.getRight())) &&
		    (contains(q, this.root.getRight()) || contains(q, this.root.getLeft()))) {
			return this.root;
		}
		
		return null;
	}

	private Node firstCommonAncestor(Integer p, Integer q, Node n) {
		if (n == null) {
			return null;
		}		

		if (n.getValue() == p &&
		    (contains(q, n.getLeft()) ||
		     contains(q, n.getRight()))) {
			return n;
		}

		if (n.getValue() == q &&
		    (contains(p, n.getLeft()) ||
		     contains(p, n.getRight()))) {
			return n;
		}

		Node left = firstCommonAncestor(p, q, n.getLeft());
		if (left != null) {
			return left;
		}

		Node right = firstCommonAncestor(p, q, n.getRight());
		if (right != null) {
			return right;
		}

		if ((contains(p, n.getLeft()) || contains(p, n.getRight())) &&
		    (contains(q, n.getRight()) || contains(q, n.getLeft()))) {
			return n;
		}

		return null;
	}

	private boolean contains(Integer v, Node n) {
		if (n == null) {
			return false;
		}

		if (n.getValue() == v) {
			return true;
		}

		return contains(v, n.getLeft()) || contains(v, n.getRight());
	}

	public boolean isBinarySearchTree() {
		if (this.root == null) {
			return true;
		}

		boolean leftOk = true;
		if (this.root.getLeft() != null){
			leftOk = this.root.getLeft().getValue() < this.root.getValue() &&
				isBinarySearchTree(this.root.getLeft());
		}

		boolean rightOk = true;
		if (this.root.getRight() != null) {
			rightOk = this.root.getRight().getValue() > this.root.getValue() &&
				isBinarySearchTree(this.root.getRight()); 
		} 

		return leftOk && rightOk;
	}

	private boolean isBinarySearchTree(Node n) {
		boolean leftOk = true, rightOk = true;

		if (n.getLeft() != null) {
			leftOk = n.getLeft().getValue() < n.getValue() &&
				isBinarySearchTree(n.getLeft());
		}

		if (n.getRight() != null) {
			rightOk = n.getRight().getValue() > n.getValue() &&
				isBinarySearchTree(n.getRight());
		}

		return leftOk && rightOk;
	}

	public boolean isSubtree(Node root) {
		if (this.root == null ^ root == null) {
			return false;
		} else if (this.root == null && root == null) {
			return true;
		}

		if (this.root.getValue() == root.getValue() &&
		    (root.getLeft() == null || (
		    	(root.getLeft() != null && isSubtree(this.root.getLeft(), root.getLeft())))) &&
		    (root.getRight() == null || (
			(root.getRight() != null && isSubtree(this.root.getRight(), root.getRight()))))) {
			return true;	
		}

		return isSubtree(this.root.getLeft(), root) || 
		       isSubtree(this.root.getRight(), root);
	}

	private boolean isSubtree(Node n, Node r) {
		if (n == null ^ r == null) {
			return false;
		} else if (n == null && r == null) {
			return true;
		}

		if (n.getValue() == r.getValue() &&
		    (r.getLeft() == null || 
		     (r.getLeft() != null && isSubtree(n.getLeft(), r.getLeft()))) &&
		    (r.getLeft() == null ||
		     (r.getLeft() != null && isSubtree(n.getLeft(), r.getLeft())))) {
			return true;
		}

		return isSubtree(n.getLeft(), r) || 
		       isSubtree(n.getRight(), r);
	}

	class PathResult {
		List<String> path;
		int sum;

		PathResult(Node n) {
			this.path = new ArrayList<String>();
			this.path.add(n.getValue().toString());
			this.sum += n.getValue();
		}
		
		PathResult() {
			this.path = new ArrayList<String>();
			this.sum = 0;
		}
	}

	public List<String> findPathsForSum(int sum) {
		if (this.root == null) {
			return new ArrayList<String>();
		}

		List<String> paths = new ArrayList<String>();
		List<PathResult> candidatePaths = new ArrayList<PathResult>();
		
		if (this.root.getValue() == sum) {
			paths.add(this.root.getValue().toString());
		}

		PathResult p = new PathResult(this.root);
		candidatePaths.add(p);

		findPathsForSum(sum, this.root.getLeft(), candidatePaths, paths);
		findPathsForSum(sum, this.root.getRight(), candidatePaths, paths);

		return paths;
	}

	private void findPathsForSum(int sum, Node n, List<PathResult> candidatePaths, List<String> paths) {
		if (n != null) {
			System.out.println(n.getValue());
			PathResult thisNodeResult = new PathResult(n);
			candidatePaths.add(thisNodeResult);

			List<PathResult> candidatePathsCopy = new ArrayList<PathResult>();
			for (PathResult r : candidatePaths) {
				r.sum += n.getValue();
				r.path.add(n.getValue().toString());
				if (r.sum == sum) {
					StringBuilder str = new StringBuilder();
					for (int s = 0; s < r.path.size(); s++) {
						if (s < r.path.size() - 1) {
							str.append(r.path.get(s) + "->");
						} else {
							str.append(r.path.get(s));
						}
					}
					paths.add(str.toString());
				}
				
				PathResult result = new PathResult();
				result.sum = r.sum;	
				for (String p : r.path) {
					result.path.add(new String(p));
				}

				candidatePathsCopy.add(result);
				
			}

			if (n.getValue() == sum) {
				paths.add(n.getValue().toString());
			}

			PathResult r = new PathResult(n);
			candidatePaths.add(r);

			PathResult r2 = new PathResult(n);
			candidatePathsCopy.add(r2);

			findPathsForSum(sum, n.getLeft(), candidatePaths, paths);
			findPathsForSum(sum, n.getRight(), candidatePathsCopy, paths);
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
		assert 4 == treeFromLinkedList.maxDepth();

		List<List<Node>> levelLists = treeFromLinkedList.getLevelLists();
		System.out.println("Binary tree constructed linkedlist has 4 levels");
		assert 4 == levelLists.size();

		System.out.println("1 at level 0");	
		assert levelListEquals(levelLists.get(0), Arrays.asList(1));

		System.out.println("2, 3, at level 1");
		assert levelListEquals(levelLists.get(1), Arrays.asList(2, 3)); 

		System.out.println("4, 5, 6, 7 at level 2");
		assert levelListEquals(levelLists.get(2), Arrays.asList(4, 5, 6, 7));

		System.out.println("8, 9, 10 at level 3");
		assert levelListEquals(levelLists.get(3), Arrays.asList(8, 9, 10));

		System.out.println("Check binary search tree");
		LinkedList<Integer> binarySearchInput = new LinkedList<Integer>(
			Arrays.asList(5, 3, 7, 2, 4, 6, 8, 1)
		);
		BinaryTree binarySearchTree = new BinaryTree(binarySearchInput);
		BinaryTreePrinter binarySearchTreePrinter = new BinaryTreePrinter(binarySearchTree.getNode());
		binarySearchTreePrinter.print();

		assert binarySearchTree.isBinarySearchTree();
		
		System.out.println("First common ancestor of 2 and 4 is 3");
		assert 3 == binarySearchTree.firstCommonAncestor(2, 4).getValue();

		System.out.println("First common ancestor of 4 and 6 is 5");
		assert 5 == binarySearchTree.firstCommonAncestor(4, 6).getValue();

		System.out.println("First common ancestor of 2 and 7 is 5");
		assert 5 == binarySearchTree.firstCommonAncestor(2, 7).getValue();

		System.out.println("Binary search subtree");
		LinkedList<Integer> binarySearchSubtreeInput = new LinkedList<Integer>(
			Arrays.asList(7, 6, 8)
		);
		LinkedList<Integer> binarySearchSubtreeInput2 = new LinkedList<Integer>(
			Arrays.asList(3, 2)
		);
		BinaryTree binarySearchSubtree = new BinaryTree(binarySearchSubtreeInput);
		BinaryTree binarySearchSubtree2 = new BinaryTree(binarySearchSubtreeInput2);

		assert binarySearchTree.isSubtree(binarySearchSubtree.getNode());
		assert binarySearchTree.isSubtree(binarySearchSubtree2.getNode());

		System.out.println("Binary search tree paths that sum to 7");
		System.out.println(binarySearchTree.findPathsForSum(7));
	}

	private static boolean levelListEquals(List<Node> level, List<Integer> vals) {
		if (level.size () != vals.size()) {
			return false;
		}

		for (int i = 0, j = 0; i < level.size() && j < vals.size(); i++, j++) {
			if (level.get(i).getValue() != vals.get(j)) {
				return false;
			}
		}
		return true;
	}
}

