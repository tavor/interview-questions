public class NQueensDriver {
	public static void main(String[] args) {
		NQueensDriver program = new NQueensDriver();

		int[][] a = new int[4][4];
		program.solution(a);
		program.printArray(a);
	}

	public void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}

	public void solution(int[][] a) {
		int r = 0;
		a[r][0] = 1;

		while(!solution(a, 1) && r < a.length) {
			a[r][0] = 0; r++;
			if (r < a.length) {
				a[r][0] = 1;
			} else {
				break;
			}
		}
	}

	public boolean solution(int[][] a, int c) {
		if (c == a.length) {
			return true;
		}

		for (int r = 0; r < a.length; r++) {
			if (safePosition(a, r, c)) {
				a[r][c] = 1;
				if (solution(a, c + 1)) {
					return true;
				}
				a[r][c] = 0;
			}
		}
		return false;
	}

	public boolean safePosition(int[][] a, int i, int j) {
		// previous upwards diagonal
		int k = i - 1, l = j - 1;
		while (k >= 0 && l >= 0) {
			if (a[k][l] == 1) {
				return false;
			}
			k--; l--;
		}


		k = j - 1;
		// previous horizontal
		while (k >= 0) {
			if (a[i][k] == 1) {
				return false;
			}
			k--;
		} 

		// previous downwards diagonal
		k = i + 1; l = j - 1;
		while (k < a.length && l > 0) {
			if (a[k][l] == 1) {
				return false;
			}
			k++; l--;
		}

		return true;
	}
}
