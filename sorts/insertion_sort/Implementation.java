package sorts.insertion_sort;

import java.util.Arrays;

public class Implementation {
  public static void main(String[] args) {
    int[] intArr = new int[] { 85, 12, 59, 45, 72, 51 };
    insertionSort(intArr);
    System.out.println("Sorted Array:" + Arrays.toString(intArr));
  }

  /**
   * Insertion Sort the integer array. Time complexity: Worst case O(n^2), Best
   * Case O(n)
   * NOTE: We SHIFT the elements not SWAP!
   * 
   * @param arr
   */
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }
}
