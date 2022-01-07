package problems.knapsack_problem;

public class KnapsackDP {

  public static int[][] globalCache;

  public static void main(String[] args) {
    /**
     * The Knapsack Problem:
     * Find the most valuable subset of items to put in the knapsack without
     * exceeding the capacity of the knapsack.
     */
    Item[] items = new Item[] { new Item(60, 10), new Item(100, 20), new Item(120, 35), new Item(200, 45) };
    int capacity = 60;
    int last = items.length - 1;
    globalCache = createCache(items.length + 1, capacity + 1);
    System.out.println("Optimal value of items put in the knapsack: " + solve(last, items, capacity));
  }

  public static int solve(int last, Item[] items, int capacityLeft) {
    // Check invalid case if index is below zero || no capacity left
    if (last < 0 || capacityLeft == 0) {
      return 0;
    }

    // Check if current item exceeds weight
    if (items[last].weight > capacityLeft) {
      // Check calculated value in cache
      if (globalCache[last + 1][capacityLeft] != -1) {
        return globalCache[last + 1][capacityLeft];
      }
      return solve(last - 1, items, capacityLeft);
    }

    // Check if it has been stored in cache
    if (globalCache[last + 1][capacityLeft] != -1) {
      return globalCache[last + 1][capacityLeft];
    }

    int notIncluded = solve(last - 1, items, capacityLeft);
    int included = solve(last - 1, items, capacityLeft - items[last].weight) + items[last].value;
    // Store the result of considering n item in cache
    globalCache[last + 1][capacityLeft] = Math.max(notIncluded, included);
    return globalCache[last + 1][capacityLeft];
  }

  public static int[][] createCache(int rows, int cols) {
    // Init cache
    int[][] cache = new int[rows][cols];
    // Pre-fill cache with -1 value
    fill(cache, -1);
    return cache;
  }

  /**
   * Fill matrix with specified value
   * 
   * @param matrix Matrix to be filled
   */
  public static void fill(int[][] matrix, int value) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = value;
      }
    }
  }

  /**
   * Display 2D matrix
   * 
   * @param matrix Matrix to be displayed
   */
  public static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }

}
