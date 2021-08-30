package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class implements flip sorting of an array of Integers.
 * 
 * @author Geethu Harish
 *
 */
public class FlipSort {

	// output list saving the indices where the array gets flipped
	static List<Integer> flippedIndices = new ArrayList();

	/**
	 * This method reverses the arr[0..i]
	 * 
	 * @param arr
	 * @param i
	 */
	static void flip(int arr[], int i) {

		flippedIndices.add(i + 1);
		// Generating snapshot of array before the flip
		// to output below
		String beforeFlip = Arrays.toString(arr);
		int temp, start = 0;
		while (start < i) {
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			start++;
			i--;
		}

		System.out.println(String.format("Flipped Array: %s -> %s", beforeFlip, Arrays.toString(arr)));
	}

	
	/**
	 * This method returns the index of the maximum element in the arr[0..n-1]
	 * @param arr
	 * @param n
	 * @return
	 */
	static int findMax(int arr[], int n) {
		int mi, i;
		for (mi = 0, i = 0; i < n; ++i)
			if (arr[i] > arr[mi])
				mi = i;
		return mi;
	}

	/**
	 * This method sorts the given array based on the following conditions. Given an
	 * array of integers arr, sort the array by performing a series of flips.
	 * 
	 * In one flip we do the following steps:
	 * 
	 * Choose an integer k where 1 <= k <= arr.length. Reverse the sub-array
	 * arr[1...k]. For example, if arr = [3,2,1,4] and we performed a flip choosing
	 * k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the flip at
	 * k = 3.
	 * 
	 * Return the k-values corresponding to a sequence of flips that sort arr.
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	static void flipSort(int arr[]) {

		int n = arr.length;
	
		// Start by checking the first and the last element of the array.
		int firstElement = arr[0];
		int lastElement = arr[n - 1];
		if (firstElement > lastElement) {
		// flip the array if the firstElement is greater than the last element
			flip(arr, n - 1);
		}

		for (int curr_size = n; curr_size > 1; --curr_size) {
			// Find index of the
			// maximum element in
			// arr[0..curr_size-1]
			int mi = findMax(arr, curr_size);

			
			if (mi != curr_size - 1) {
				// To move at the end,
				// first move maximum
				// number to beginning
				
			
				// unless it is already at index position 0
				// (so we can skip the first flip):
				if (mi != 0) {
					flip(arr, mi);
				}

				// Now move the maximum
				// number to end by
				// reversing current array

				flip(arr, curr_size - 1);

			}
		}

	}

	/**
	 * Main function to check the flipsort method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// int arr[] = { 8, 6, 4, 2, 1, 3, 5, 7 };
		 int arr[] = {3,2,4,1};
		//int arr[] = { 1, 2, 3 };

		flipSort(arr);

		System.out.println("Input => Sorted Array: ");
		System.out.println(Arrays.toString(arr));

		System.out.println("Output => Flipped indices: ");
		System.out.println(Arrays.toString(flippedIndices.toArray()));
	}

}