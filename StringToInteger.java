public class StringToInteger {
	public static void main(String[] args) {
		StringToInteger program = new StringToInteger();

		System.out.println(program.atoi("123"));
		System.out.println(program.atoi("42"));
		System.out.println(program.atoi("   -42"));
		System.out.println(program.atoi("4193 with words"));
		System.out.println(program.atoi("words and 987"));
		System.out.println(program.atoi("-91283472332"));
		System.out.println(program.atoi("2147483650"));
	}
	
	public Integer atoi(String str) {
		int index = 0; 
		long result = 0L;
		boolean negative = false, converting = false;
		while(index < str.length()) {
			char c = str.charAt(index);
			boolean isParseable = parseable(c); 
			if (!isParseable && !converting && c != ' ' ) {
				return 0;
			} else if (isParseable) {
				if (!converting) {
					converting = true;
				}
				
				if (result > 0) {
					result *= 10;
				}
				
				if (c >= 48 && c <= 57) {
					result += c - 48;
				} else {
					negative = c == '-';
				}	
			}
			index++;
		}
		if (negative && result > 2147483648L) {
			return -2147483648;
		} else if (!negative && result > 2147483647) {
			return 2147483647;
		}
		return (int)result * (negative ? -1 : 1);
		
	}

	public boolean parseable(char c) {
		return c >= 48 && c <= 57 || c == '-' || c == '+';
	}
}
