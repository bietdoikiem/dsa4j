package sorts.selection_sort;

import java.util.Arrays;

public class Implementation {
  public static void main(String[] args) {
    int[] intArr = new int[] { 23, 78, 45, 8, 32, 56 };
    selectionSort(intArr); // Sort the array!
    System.out.println("Sorted array: " + Arrays.toString(intArr));
  }

  /**
   * Apply Selection Sort for the integer array
   * 
   * @param arr Array to be sorted
   */
  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIdx = i;
      for (int j = i + 1; j < arr.length; j++) {
        // Find the smallest value (If Found)
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }
      // Swap if the lesser value than initialized min value is found!
      if (arr[minIdx] != arr[i]) {
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
      }
    }
  }
}
