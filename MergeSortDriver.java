import java.util.Arrays;

public class MergeSortDriver {
	public static void main(String[] args) {
		MergeSortDriver program = new MergeSortDriver();
		
		int[] input = new int[] { 7, -1, 2, 5, 11 };
		program.mergeSort(input);

		program.printArray(input);
		
		assert Arrays.equals(new int[] { -1, 2, 5, 7, 11 }, input);
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

			for (int i = 0, j = splitPoint + 1; i <= splitPoint && j < a.length;) {
				if (a[i] < a[j]) {
					i++;
				} else {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
					j++;
				}
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
		if(length > 2) {
			int splitPoint = length % 2 == 0 ? length / 2 - 1: length / 2;

			mergeSort(a, start, start + splitPoint);
			mergeSort(a, start + splitPoint + 1, end);
					
			for (int i = start, j = splitPoint + 1; i <= splitPoint && j <= end;) {
				if (a[i] < a[j]) {
					i++;
				} else {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
					j++;
				}
			}	
		} else if (length == 2 && a[start] > a[end]) {
			int t = a[start];
			a[start] = a[end];
			a[end] = t;
		}
	}
}
