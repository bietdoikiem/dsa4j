package sorts.bubble_sort;

import java.util.Arrays;

public class Implementation {
  public static void main(String[] args) {
    // 1. Normal Bubble Sort
    int[] intArr = new int[] { 10, 8, 9, 14, 17 };
    int[] secondIntArr = new int[] { 10, 8, 9, 14, 17 };
    bubbleSort(intArr);
    System.out.println("Sorted Array: " + Arrays.toString(intArr));
    improvedBubbleSort(secondIntArr);
    System.out.println("Sorted Array (Improved Version): " + Arrays.toString(secondIntArr));
    // 2. Improved Bubble Sort
    // Init sequential arrays
    final int MAX_SEQUENCE_NUMBER = 100000;
    int[] firstSequentialArr = new int[MAX_SEQUENCE_NUMBER];
    int[] secondSequentialArr = new int[MAX_SEQUENCE_NUMBER];
    for (int i = 0; i < MAX_SEQUENCE_NUMBER; i++) {
      firstSequentialArr[i] = i + 1;
      secondSequentialArr[i] = i + 1;
    }
    long firstStartTime = System.currentTimeMillis();
    bubbleSort(firstSequentialArr);
    System.out.println("Normal Bubble Sort Elapsed Time: " + (System.currentTimeMillis() - firstStartTime) + " (ms)");
    long secondStartTime = System.currentTimeMillis();
    improvedBubbleSort(secondSequentialArr);
    System.out
        .println("Improved Bubble Sort Elapsed Time: " + (System.currentTimeMillis() - secondStartTime) + " (ms)");
  }

  /**
   * Bubble Sort integer array. Time complexity: O(n^2) - Best & Worst Case
   * 
   * @param arr Array to be sorted
   */
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  /**
   * Improved bubble sort algorithm to detect already-sorted array.
   * Time complexity: O(n^2) - Worst case, O(n) - Best case
   * 
   * @param arr
   */
  public static void improvedBubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean isSorted = false;
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          isSorted = true;
        }
      }
      if (isSorted == false) {
        break;
      }
    }
  }
}
