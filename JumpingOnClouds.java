public class JumpingOnClouds {
	public static void main(String[] args) {
		JumpingOnClouds program = new JumpingOnClouds();

		int[] input = new int[] { 0, 0, 1, 0, 0, 1, 0 };
		assert 4 == program.jumpingOnClouds(7, input);
		
		int[] input2 = new int[] { 0, 0, 0, 0, 1, 0 };
		assert 3 == program.jumpingOnClouds(6, input2);
	}

	private int jumpingOnClouds(int n, int[] c) {
		int jumps = 0, i = 0;
		while (i < n - 1) {
			if (i + 2 < n && c[i + 2] == 1) {
				jumps += 1; i += 1;
			} else if (i + 2 < n && c[i + 2] == 0) {
				jumps += 1; i += 2;
			} else {
				jumps += 1; i += 1;
			}
		} 
		return jumps;
	}
}
