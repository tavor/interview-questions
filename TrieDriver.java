import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

public class TrieDriver {
	class Node {
		Character c;
		HashMap<Character, Node> children;
		boolean isWord;

		Node(Character c) {
			this.c = c;
			this.children = new HashMap<Character, Node>();
			this.isWord = false;
		}
	}

	public static void main(String[] args) {
		TrieDriver program = new TrieDriver();

		Node n = program.createTrie(Arrays.asList("a","about"));
		program.printTrie(n, 0);

		Node n2 = program.createTrie(Arrays.asList("a","aloof","about"));
		program.printTrie(n2, 0);

		Node n3 = program.createTrie(Arrays.asList(""));
		program.printTrie(n3, 0);

		Node n4 = program.createTrie(Arrays.asList("aaa", "abc","ab"));
		program.printTrie(n4, 0);
	}

	public void printTrie(Node root, int depth) {
		if (root == null) {
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			builder.append("\t");
		}

		System.out.println(builder.toString() + root.c);

		for (Map.Entry<Character, Node> e : root.children.entrySet()) {
			printTrie(e.getValue(), depth + 1);	
		}
	}

	private Node createTrie(List<String> dictionary) {
		Node root = null;
		for (String s : dictionary) {
			if (s != "") {
				root = insertIntoTrie(s, root);
			}			
		}

		return root;
	}

	public Node insertIntoTrie(String s, Node root) {
		int c = 0;
		
		if (root == null) {
			root = new Node(s.charAt(c));
			c++;
		} else if (root.c == s.charAt(c)) {
			c++;
		}

		if (c == s.length()) {
			return root;
		}	

		insertIntoTrie(s, root, c);
		return root;
	}

	public void insertIntoTrie(String s, Node n, int c) {
		Character ch = s.charAt(c);
		if (n.children.containsKey(ch)) {
			c++;
			if (c == s.length()) {
				return;
			}
			insertIntoTrie(s, n.children.get(ch), c);
		} else {
			Node m = new Node(ch);
			n.children.put(ch, m);
			c++;
			if (c == s.length()) {
				return;
			}
			insertIntoTrie(s, m, c);
		}
	}
}
