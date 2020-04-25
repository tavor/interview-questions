import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InsertionSortMain {
	public static void main(String[] args) {
		InsertionSortMain program = new InsertionSortMain();
		
		int[] a1 = new int[]{3, 2, 1};
		program.insertionSort(a1);		
	
		int[] a2 = new int[]{1, 2, -1};
		program.insertionSort(a2);

		int[] a3 = new int[]{1, 101, 100};
		program.insertionSort(a3);

		int[] a4 = new int[]{1, 2, 1, 3};
		program.insertionSort(a4);

		int[] a5 = new int[]{0, 1, 2, 3};
		program.insertionSort(a5);

		int[] a6 = new int[]{12, 11, 14, 15, 6};
		program.insertionSort(a6);		
		
		int[] a7 = new int[]{4, 3, 2, 10, 12, 1, 5, 6};
		program.insertionSort(a7);

		program.printArray(a1);
		program.printArray(a2);
		program.printArray(a3);
		program.printArray(a4);
		program.printArray(a5);
		program.printArray(a6);
		program.printArray(a7);
	}

	private void printArray(int[] a) {
		for (Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void insertionSort(int[] a) {
		int i = 0;
		while (i < a.length) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					int t = a[i];
					shift(a, i, j);
					a[j] = t;
				}
			}
			i++;
		}
	}

	private void shift(int[] a, int i, int j) {
		while (i > j) {
			a[i] = a[i - 1];
			i--;
		}
	}
}
