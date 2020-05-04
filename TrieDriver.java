import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;

public class TrieDriver {
	class Node {
		HashMap<Character, Node> children;
		boolean isWord;

		Node() {
			this.children = new HashMap<Character, Node>();
			this.isWord = false;
		}
	}

	public static void main(String[] args) {
		TrieDriver program = new TrieDriver();

		Node n = program.createTrie(Arrays.asList("a","about"));
		program.printTrie(n, 0, '*');

		Node n2 = program.createTrie(Arrays.asList("a","aloof","about"));
		program.printTrie(n2, 0, '*');

		Node n3 = program.createTrie(Arrays.asList(""));
		program.printTrie(n3, 0, '*');

		Node n4 = program.createTrie(Arrays.asList("aaa", "abc","ab"));
		program.printTrie(n4, 0, '*');

		Node n5 = program.createTrie(Arrays.asList("a", "b"));
		program.printTrie(n5, 0, '*');

		assert program.wordInTrie(n4, "aaa");
		assert program.wordInTrie(n4, "abc");
		assert program.wordInTrie(n4, "ab");

		assert program.wordInTrie(n2, "aloof");

		List<String> words = program.findWords("a99999bbbbout", n);
		for (String w : words) {
			System.out.print(w + " ");
		}
		System.out.println();
	}

	public List<String> findWords(String p, Node root) {
		int c = 0;
		List<String> result = new ArrayList<String>();		
		StringBuilder builder = new StringBuilder();
		Node n = null;

		while (c < p.length()) {
			if (root.children.containsKey(p.charAt(c))) {
				n = root.children.get(p.charAt(c));
				builder.append(p.charAt(c));
				break;
			}
			c++;
		}
		
		if (n == null) {
			return result;
		} else if (n.isWord) {
			result.add(builder.toString());
		}
	
		findWords(p, n, c, builder, result);

		return result;
	}

	public void findWords(String p, Node n, int c, StringBuilder builder, List<String> result) {
		Node m = null;
		while (c < p.length()) {
			if (n.children.containsKey(p.charAt(c))) {
				m = n.children.get(p.charAt(c));
				builder.append(p.charAt(c));
				break;
			}
			c++;
		}

		if (m == null) {
			return;
		} else if (m.isWord) {
			result.add(builder.toString());
		}

		findWords(p, m, c, builder, result);
	}

	public void printTrie(Node root, int depth, Character c) {
		if (root == null) {
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			builder.append("\t");
		}

		System.out.println(builder.toString() + c + (root.isWord ? "*" : ""));

		for (Map.Entry<Character, Node> e : root.children.entrySet()) {
			printTrie(e.getValue(), depth + 1, e.getKey());	
		}
	}

	private boolean wordInTrie(Node root, String s) {
		if (root == null) {
			return false;
		}
		return wordInTrie(root, s, 0);
	}

	private boolean wordInTrie(Node n, String s, int c) {
		Character ch = s.charAt(c);
		if (n.children.containsKey(ch)) {
			if (c + 1 == s.length()) {
				return n.children.get(ch).isWord;
			}
			c++;
			return wordInTrie(n.children.get(ch), s, c);
		}
		return false;
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
	
		Character ch = s.charAt(c);	
		if (root == null) {
			root = new Node();
			Node m = new Node();
			root.children.put(ch, m);
			c++;
			if (c == s.length()) {
				m.isWord = true;
				return root;
			}
			insertIntoTrie(s, m, c);
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
				n.children.get(ch).isWord = true;
				return;
			}
			insertIntoTrie(s, n.children.get(ch), c);
		} else {
			Node m = new Node();
			n.children.put(ch, m);
			c++;
			if (c == s.length()) {
				n.children.get(ch).isWord = true;
				return;
			}
			insertIntoTrie(s, m, c);
		}
	}
}
