import java.util.Set;
import java.util.HashSet;

public class LongestSubstring {
	public static void main(String[] args) {
		LongestSubstring program = new LongestSubstring();
		System.out.println(program.longestSubstring("aabcb"));
		System.out.println(program.longestSubstring("abcabc"));
		System.out.println(program.longestSubstring("abcabcbb"));
		System.out.println(program.longestSubstring("bbbbb"));
		System.out.println(program.longestSubstring("pwwkew"));
	}
	
	public Integer longestSubstring(String str) {
		if ("".equals(str)) {
			return 0;
		}
		Set<Character> uniqueCharacters = new HashSet<Character>();
		
		int candidateSubstringIndex = 0, longestSubstringLength = 0, 
		    candidateSubstringLength = 0, index = 0;
		while (index < str.length()) {
			if (!uniqueCharacters.contains(str.charAt(index))) {
				uniqueCharacters.add(str.charAt(index));

				candidateSubstringLength++;
				if (longestSubstringLength < candidateSubstringLength) {
					longestSubstringLength = candidateSubstringLength;
				}
			} else {
				uniqueCharacters.clear(); uniqueCharacters.add(str.charAt(index));
				candidateSubstringIndex = index;
				candidateSubstringLength = 1;
			}	
			index++;
		}
		return longestSubstringLength;
	}
}
