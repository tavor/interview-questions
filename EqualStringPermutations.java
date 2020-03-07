import java.util.HashMap;

public class EqualStringPermutations {
	public static void main(String[] args) {
		EqualStringPermutations program = new EqualStringPermutations();

		assert program.permutationsOfEachOther(null, null);
		assert !program.permutationsOfEachOther(null, "");
		assert !program.permutationsOfEachOther("aaa","aa");
		assert program.permutationsOfEachOther("abcd", "bdca");
		assert program.permutationsOfEachOther("abc","bca");
	}

	public boolean permutationsOfEachOther(String str1, String str2) {
		boolean str1Empty = str1 == null || "".equals(str1),
			str2Empty = str2 == null || "".equals(str2);

		if (str1Empty ^ str2Empty) {
			return false;
		} else if ((str1 == null && str2 == null) ||
			   ("".equals(str1) && "".equals(str2))) {
			return true;
		} else if (("".equals(str1) && str2 == null) ||
			   ("".equals(str2) && str1 == null)) {
			return false;
		}

		if (str1.length() != str2.length()) {
			return false;
		}

		HashMap<Character, Integer> str1Counts = new HashMap<Character, Integer>();
		HashMap<Character, Integer> str2Counts = new HashMap<Character, Integer>();

		for (int c = 0; c < str1.length(); c++) {
			addToCounts(str1Counts, str1.charAt(c));
			addToCounts(str2Counts, str2.charAt(c));
		}

		if (str1Counts.keySet().size() != str2Counts.keySet().size()) {
			return false;
		}

		Object[] str1Characters = str1Counts.keySet().toArray();
		for (int i = 0; i < str1Characters.length; i++) {
			Character c = (Character) str1Characters[i];
			if (!str2Counts.containsKey(c)) {
				return false;
			} else if (str2Counts.get(c) != str1Counts.get(c)) {
				return false;
			}
		}

		return true;
	}
		
	private void addToCounts(HashMap<Character, Integer> map, Character c) {
		if (map.containsKey(c)) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}	
}
