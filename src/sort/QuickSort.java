package sort;

public class QuickSort {
 
	private static <T extends Comparable<T>> // For Generic sorting
	int midpoint(T[] list, int low, int high) {
		int left = low + 1;
		int right = high;
		T pivot = list[low];

		while (true) {

			while (left <= right) {
				if (list[left].compareTo(pivot) < 0) {
					left++;
				} else {
					break;
				}
			}
			while (left > right) {
				if (list[right].compareTo(pivot) < 0) {
					break;
				} else {
					right--;
				}
			}
			if (left >= right) {
				break;
			}
			T tmp = list[left];
			list[left] = list[right];
			list[right] = tmp;
			left++;
			right++;
		}
		list[low]=list[left-1];
		list[left-1] = pivot;

		return left-1;
	}

	private static <T extends Comparable<T>> // For Generic sorting
	void sort(T[] list, int low, int high) {
		if (high - low <= 0) {
			return;
		}
		int mid = midpoint(list, low, high);
		sort(list, low, mid - 1);
		sort(list, mid + 1, high);

	}

	public static <T extends Comparable<T>> // For Generic sorting
	void sort(T[] list) {
		if (list.length <= 1) {
			return;
		}
		sort(list, 0, list.length - 1);
	}
}
