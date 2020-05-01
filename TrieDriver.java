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
	}

	public void printTrie(Node root, int depth) {
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
				if (root == null) {
					root = new Node(s.charAt(0));
					insertIntoTrie(s, root, 1);
				}
				insertIntoTrie(s, root, 0);
			}			
		}

		return root;
	}

	public void insertIntoTrie(String s, Node root, int c) {
		if (c == s.length()) {
			root.isWord = true;
			return;
		}
	
		Character ch = s.charAt(c);

		if (root.c == ch) {
			c++;	
			if (c == s.length()) {
				root.isWord = true;
				return;
			}
			ch = s.charAt(c);
		}
		
		if (root.children.containsKey(ch)) {
			c++;
			root = root.children.get(ch);
		} else {
			Node n = new Node(ch);
			root.children.put(ch, n);
			root = n;
			c++;
		}

		
		insertIntoTrie(s, root, c);
	}
}
