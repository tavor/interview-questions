import java.util.Set;
import java.util.HashSet;

public class LongestSubstring {
	public static void main(String[] args) {
		LongestSubstring program = new LongestSubstring();
		System.out.println(program.longestSubstring("aabcb"));
	}
	
	public String longestSubstring(String str) {
		Set<Character> uniqueCharacters = new HashSet<Character>();
		
		int longestSubstringIndex = 0, candidateSubstringIndex = 0,
		    longestSubstringLength = 0, candidateSubstringLength = 0,
		    index = 0;
		boolean counting = false;
		while (index < str.length()) {
			if (index + 1 != str.length()) {
				char nextCharacter = str.charAt(index + 1);

				if (str.charAt(index) != nextCharacter &&
				    uniqueCharacters.contains(nextCharacter)) {
					uniqueCharacters.add(nextCharacter);

					if (!counting) {
						candidateSubstringIndex = index;
						candidateSubstringLength = 1;
					}

					counting = true;

					candidateSubstringLength++;
					if (longestSubstringLength < candidateSubstringLength) {
						longestSubstringLength = candidateSubstringLength;
						longestSubstringIndex = candidateSubstringIndex;
					}
				} else {
					counting = false;
					uniqueCharacters.clear();
				}
			} else if (index == str.length() && counting) {
				candidateSubstringLength++;
				if (longestSubstringLength < candidateSubstringLength) {
					longestSubstringLength = candidateSubstringLength;
					longestSubstringIndex = candidateSubstringIndex;
				}
			}
			index++;
		}
		return str.substring(longestSubstringIndex, longestSubstringLength + 1);
	}
}
