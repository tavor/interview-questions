import java.util.Arrays;
public class SelectionSortDriver {
	public static void main(String[] args) {
		SelectionSortDriver program = new SelectionSortDriver();
		int[] test1 = new int[] { 7, -1, 2, 5, 11 };
		
		program.selectionSort(test1);

		assert Arrays.equals(new int[] { -1, 2, 5, 7, 11 }, test1);
	}

	public void selectionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = 0;
			while (j < i && a[i] > a[j]) {
				j++;
			}
			
			int temp = a[i], k = i;
			while (k > j) {
				a[k] = a[k - 1]; k--;
			}
			a[k] = temp;
		}
	}
}
