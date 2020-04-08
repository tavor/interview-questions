import java.util.Arrays;

public class MergeSortDriver {
	public static void main(String[] args) {
		MergeSortDriver program = new MergeSortDriver();
		
		int[] input = new int[] { 7, -1, 2, 5, 11 };
		program.mergeSort(input);
		
		int[] oneElement = new int[1];
		program.mergeSort(oneElement);

		int[] allSame = new int[] { 1, 1 };
		program.mergeSort(allSame);

		int[] reverseSorted = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		program.mergeSort(reverseSorted);

		int[] duplicates = new int[] { 10, 9, 8, 10, 6, 5, 4, 3, 2, 1 };
		program.mergeSort(duplicates);

		assert Arrays.equals(new int[] { -1, 2, 5, 7, 11 }, input);
		assert Arrays.equals(new int[1], oneElement);
		assert Arrays.equals(new int[] { 1, 1 }, allSame);
		assert Arrays.equals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, reverseSorted);
		assert Arrays.equals(new int[] { 1, 2, 3, 4, 5, 6, 8, 9, 10, 10}, duplicates);
	}

	public void mergeSort(int[] a) {
		if (a.length < 2) {
			return;
		}
		if (a.length == 2) {
			if (a[0] > a[1]) {
				int t = a[0];
				a[0] = a[1];
				a[1] = t;	
			}
		}

		if (a.length > 2) {
			int splitPoint = a.length % 2 == 0 ? a.length / 2 - 1 : a.length / 2;
			mergeSort(a, 0, splitPoint);
			mergeSort(a, splitPoint + 1, a.length - 1);
		
			int j = splitPoint + 1, i = 0;
			while (j < a.length) {
				for (;i < j; i++) {
					if (a[i] > a[j]) {
						break;
					}
				}
				int t = a[j], k = j;
				for (;k > i; k--) {
					a[k] = a[k - 1];
				}
				a[k] = t;
				j++; i++;
			}
		}
	}	

	public void printArray(int[] a) {
		for(int x = 0; x < a.length; x++) {
			System.out.print(a[x] + " ");
		}
		System.out.println();
	}

	private void mergeSort(int[] a, int start, int end) {
		int length = end - start + 1;
		if (length > 2) {
			int splitPoint = length % 2 == 0 ? length / 2 - 1: length / 2;

			mergeSort(a, start, start + splitPoint);
			mergeSort(a, start + splitPoint + 1, end);

			int j = start + splitPoint + 1, i = start;
			while (j < end + 1) {
				for (;i < j; i++) {
					if (a[i] > a[j]) {
						break;
					}
				}
				int t = a[j], k = j;
				for (;k > i; k--) {
					a[k] = a[k - 1];
				}
				a[k] = t;
				j++; i++;
			}
		} else if (length == 2 && a[start] > a[end]) {
			int t = a[start];
			a[start] = a[end];
			a[end] = t;
		}
	}
}
