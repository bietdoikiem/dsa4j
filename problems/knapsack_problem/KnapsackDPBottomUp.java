package problems.knapsack_problem;

/**
 * Bottom-Up (Tabulation) Dynamic Programming solution for the KnapSack Problem
 */
public class KnapsackDPBottomUp {
  public static int[][] globalTable;

  public static void main(String[] args) {
    /**
     * The Knapsack Problem:
     * Find the most valuable subset of items to put in the knapsack without
     * exceeding the capacity of the knapsack.
     */
    Item[] items = new Item[] { new Item(60, 10), new Item(100, 20), new Item(120, 35), new Item(200, 45) };
    int capacity = 60;
    int last = items.length - 1;
    globalTable = createTable(items.length + 1, capacity + 1);
    System.out.println("Optimal value of items put in the knapsack: " + solve(last, items, capacity));
  }

  /**
   * Find the maximum value of items that can be put in the Knapsack
   * 
   * Time complexity: O(n*W) - n: the number of items & W: the maximum capacity of
   * the Knapsack
   * 
   * @param last         Last index of item list
   * @param items        List of items
   * @param capacityLeft Capacity left of the knapsack
   * @return Maximum value
   */
  public static int solve(int last, Item[] items, int capacityLeft) {
    /**
     * Flow to execute:
     * 1. Loop through the table
     * 2. Check if item should be included in the cell =>
     * a. Item not included -> Use the previous cell value
     * b. Item included -> Update the current cell
     */
    return 0;
  }

  public static int[][] createTable(int rows, int cols) {
    // Init cache
    int[][] table = new int[rows][cols];
    // Pre-fill cache with -1 value
    fill(table, -1);
    return table;
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
