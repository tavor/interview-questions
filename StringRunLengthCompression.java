public class StringRunLengthCompression {
	public static void main(String[] args) {
		StringRunLengthCompression program = new StringRunLengthCompression();

		assert "aabc".equals(program.compress("aabc")): "Failed aabc";
		assert "a3b3c3".equals(program.compress("aaabbbccc")): "Failed aaabbbccc";
		assert "a4$3b3c3".equals(program.compress("aaaa$$$bbbccc")): "Failed aaaa$$$bbbccc";
	}

	public String compress(String str) {
		StringBuilder result = new StringBuilder();
		Integer trackingCount = null;
		
		for (int c = 0; c < str.length(); c++) {
			if (result.length() == 0 || str.charAt(c) != result.charAt(result.length() - 1)) {		
				if (trackingCount != null) {
					result.append(trackingCount);
					result.append(str.charAt(c));
				} else {
					result.append(str.charAt(c));
				}
				trackingCount = 1;
			} else {
				trackingCount += 1;
			}
			if (c == str.length() - 1) {
				result.append(trackingCount);
			}
		}
		
		if (result.length() < str.length()) {
			return result.toString();
		} else {
			return str;
		}
	}
}
