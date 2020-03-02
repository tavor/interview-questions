import java.util.*;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber program = new PalindromeNumber();

		System.out.println(program.isPalindrome(121));
		System.out.println(program.isPalindrome(-121));
		System.out.println(program.isPalindrome(123));
		System.out.println(program.isPalindrome(12321));
		System.out.println(program.isPalindrome(10));
	}

	public boolean isPalindrome(int i) {
		if (i == 0) {
			return true;
		} else if (i < 0) {
			return false;
		}

		List<Integer> listOfIntegers = new ArrayList<Integer>();

		// Simple and relatively fast compared to some other approaches
		// see https://tinyurl.com/s63c6sb
		while(i > 0) {
			stack.add(i % 10);
			i /= 10;
		}

		for (int index = 0; index < stack.size() / 2; index++) {
			if (stack.get(index) != stack.get(stack.size() - 1 - index)) {
				return false;
			}
		}
		
		return true;
	}
}
