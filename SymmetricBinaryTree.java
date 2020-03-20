import java.util.Arrays;
import java.lang.Math;

/* 
 * Mistakenly interpreted the prompt from https://leetcode.com/problems/symmetric-tree/
 * to be for a list.
 */
public class SymmetricBinaryTree {
	public static void main(String args[]) {
		int[] lst = new int[] {1, 2, 2, 3, 4, 4, 3, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5 };
		
		int level = 1, i = 0; 
		int power = (int) Math.pow(2, level);
		while (i < lst.length && i + power - 1 < lst.length) {
			for (int b = i, e = i + power - 1; b < i + power / 2 && e > i + power / 2 - 1; b++, e--) {
				if (lst[b] != lst[e]) {
					System.out.println("Symmetric");
					System.exit(0);
				}
			} 
			level++; power = (int) Math.pow(2, level);
			i += power - 1;
		}
		System.out.println("Unsymmetric");
	}
}
