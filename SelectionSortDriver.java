import java.util.Arrays;
public class SelectionSortDriver {
	public static void main(String[] args) {
		SelectionSortDriver program = new SelectionSortDriver();
		int[] test1 = new int[] { 7, -1, 2, 5, 11 };
		
		program.selectionSort(test1);

		assert Arrays.equals(new int[] { -1, 2, 5, 7, 11 }, test1);
	}

	public void selectionSort(int[] a) {
		for (int j = 0; j < a.length; j++) {
			int min = Integer.MAX_VALUE, k = 0;
			for (int i = j; i < a.length; i++) {
				if (a[i] < min) {
					min = a[i];
					k = i;
				}
			}
		
			int l = k;
			while (l > j) {
				a[l] = a[l - 1];
				l--;
			}
			a[j] = min;
		}
	}
}
