import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InsertionSortMain {
	public static void main(String[] args) {
		InsertionSortMain program = new InsertionSortMain();
		
		List<Integer> sortedList1 = program.insertionSort(new int[]{3, 2, 1});		
	
		List<Integer> sortedList2 = program.insertionSort(new int[]{1, 2, -1});

		List<Integer> sortedList3 = program.insertionSort(new int[]{1, 101, 100});

		List<Integer> sortedList4 = program.insertionSort(new int[]{1, 2, 1, 3});

		List<Integer> sortedList5 = program.insertionSort(new int[]{0, 1, 2, 3});

		List<Integer> sortedList6 = program.insertionSort(new int[]{12, 11, 14, 15, 6});		
		
		List<Integer> sortedList7 = program.insertionSort(new int[]{4, 3, 2, 10, 12, 1, 5, 6});
		System.out.println(sortedList1.toString());
		System.out.println(sortedList2.toString());
		System.out.println(sortedList3.toString());
		System.out.println(sortedList4.toString());
		System.out.println(sortedList5.toString());
		System.out.println(sortedList6.toString());
		System.out.println(sortedList7.toString());
	}
	
	/* Takes elements from list one by one and inserting them in
         * in their correct position into a new sorted list
         */
	public List<Integer> insertionSort(int[] list) {
		if (list.length == 0) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		sortedArray.add(list[0]);
		
		boolean inserted = false;
			
		for (int i = 1; i < list.length; i++) {
			int sortedArrayIndex = 0;
			do {	
				if (list[i] <= sortedArray.get(sortedArrayIndex)) {
					sortedArray.add(sortedArrayIndex, list[i]);
					inserted = true;
				} else if (sortedArrayIndex + 1 < sortedArray.size() &&
					   list[i] > sortedArray.get(sortedArrayIndex) && 
				           list[i] < sortedArray.get(sortedArrayIndex + 1)) {
					sortedArray.add(sortedArrayIndex + 1, list[i]);
					inserted = true;
				} else if (sortedArrayIndex == sortedArray.size() - 1) {
					sortedArray.add(list[i]); inserted = true;
				}
				sortedArrayIndex++;
			} while (!inserted && sortedArrayIndex < sortedArray.size());
			inserted = false;
		}
		return sortedArray;
	}	
}
