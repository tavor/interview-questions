import java.util.Arrays;
import java.lang.Math;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
/* 
 * Mistakenly interpreted the prompt from https://leetcode.com/problems/symmetric-tree/
 * to be for a list.
 */
public class SymmetricBinaryTree {
	public static void main(String args[]) {
		SymmetricBinaryTree solution = new SymmetricBinaryTree();

		TreeNode root = new TreeNode(1);
		TreeNode m1 = new TreeNode(2);
		TreeNode m2 = new TreeNode(2);
		TreeNode e1 = new TreeNode(3);
		TreeNode e2 = new TreeNode(4);
		TreeNode e3 = new TreeNode(4);
		TreeNode e4 = new TreeNode(3);

		m1.left = e1; m1.right = e2;
		m2.left = e3; m2.right = e4;
		
		root.left = m1;
		root.right = m2;

		assert solution.isSymmetric(root);
	}

	public boolean isSymmetric(int[] lst) {
		int level = 1, i = 0; 
		int power = (int) Math.pow(2, level);
		while (i < lst.length && i + power - 1 < lst.length) {
			for (int b = i, e = i + power - 1; b < i + power / 2 && e > i + power / 2 - 1; b++, e--) {
				if (lst[b] != lst[e]) {
					return false;
				}
			} 
			level++; power = (int) Math.pow(2, level);
			i += power - 1;
		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	
		queue.add(root.left);
		queue.add(root.right);
		int level = 1, levelSize = (int) Math.pow(2, level);
		while(queue.peek() != null) {
			int sum = 0;
			for (int children = 0; children < levelSize; children++) {
				TreeNode child = null;
				if (queue.peek() == null) {
					return false;
				} else {
					child = queue.poll();
					queue.add(child.left);
					queue.add(child.right);
				}
				
				System.out.println(child.val);
				
				if (children < levelSize / 2) {
					sum += child.val;
				} else {
					sum -= child.val;
				}
				
			}
			if (sum != 0) {
				return false;
			}
			level++; levelSize = (int) Math.pow(2, level);
		}
		return true;
	}
}
