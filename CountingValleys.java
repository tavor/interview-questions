public class CountingValleys {
	public static void main(String[] args) {
		CountingValleys solution = new CountingValleys();

		assert 1 == solution.countValleys(8, "UDDDUDUU");
		assert 3 == solution.countValleys(6, "DUDUDU");
	}

	public int countValleys(int n, String path) {
		int sum = 0;
		int valleys = 0;
		for (int c = 0; c < n; c++) {
			if ('U' == path.charAt(c)) {
				sum += 1;
				if (sum == 0) {
					valleys += 1;
				}
			} else if ('D' == path.charAt(c)) {
				sum -= 1;
			}
		}
		return valleys;
	}
}
