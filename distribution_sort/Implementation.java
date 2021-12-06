package distribution_sort;

import java.util.Arrays;

public class Implementation {
  public static void main(String[] args) {
    // Implementation
    int[] intArr = new int[] { 1, 2, 1, 2, 3, 4, 3, 3, 4 };
    int[] frequencyArr = new int[4]; // NOTE: 4 Distinct values (1, 2, 3, 4) => O(n max) = O(4)
    // Update frequency array => O(n) => O(7)
    for (int i = 0; i < intArr.length; i++) {
      switch (intArr[i]) {
        case 1:
          frequencyArr[0] += 1;
          break;
        case 2:
          frequencyArr[1] += 1;
          break;
        case 3:
          frequencyArr[2] += 1;
          break;
        case 4:
          frequencyArr[3] += 1;
          break;
        default:
          break;
      }
    }
    // Cumulative-calculated array based on frequency array => O(n max) = O(4)
    for (int i = 1; i < frequencyArr.length; i++) {
      frequencyArr[i] += frequencyArr[i - 1];
    }
    int[] sortedArr = new int[intArr.length];
    // Copy elements from frequency to the new "sorted" array => O(n) = O(7)
    for (int i = 0; i < sortedArr.length; i++) {
      // Partition by index range of cumulative array
      if (i >= 0 && i < frequencyArr[0]) {
        sortedArr[i] = 1;
      } else if (i >= frequencyArr[0] && i < frequencyArr[1]) {
        sortedArr[i] = 2;
      } else if (i >= frequencyArr[1] && i < frequencyArr[2]) {
        sortedArr[i] = 3;
      } else {
        sortedArr[i] = 4;
      }
    }
    // Print out distribute-sorted array
    System.out.println(Arrays.toString(sortedArr));
    // Total time complexity: 2O(n) + 2O(n max) = O(n) + O(n max) in the worst case
  }
}
