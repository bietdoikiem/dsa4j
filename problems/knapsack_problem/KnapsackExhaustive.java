package problems.knapsack_problem;

public class KnapsackExhaustive {
  public static void main(String[] args) {
    /**
     * The Knapsack Problem:
     * Find the most valuable subset of items to put in the knapsack without
     * exceeding the capacity of the knapsack.
     */
    Item[] items = new Item[] { new Item(60, 10), new Item(100, 20), new Item(120, 35), new Item(200, 45) };
    int capacity = 60;
    int last = items.length - 1;
    System.out.println("Optimal value of items put in the knapsack: " + solve(last, items, capacity));
  }

  /**
   * Recursive function to calculate optimal value of item subsets that can be put
   * in the knapsack.
   * 
   * Time complexity: O(2^n)
   * 
   * @param last         Last item index
   * @param items        Item list including its weight
   * @param capacityLeft Current capacity left of the knapsack
   * @return Optimal (maximum) value
   */
  public static int solve(int last, Item[] items, int capacityLeft) {
    // Check if the there is no item left || no space left to put the item in
    if (last < 0 || capacityLeft == 0) {
      return 0;
    }

    // Check if the weight of current nth item is exceeding capacityLeft
    if (items[last].weight > capacityLeft) {
      // Calculate total value without the last considered item
      return solve(last - 1, items, capacityLeft);
    }

    // Check & calculate two possible cases
    int notIncluded = solve(last - 1, items, capacityLeft);
    int included = solve(last - 1, items, capacityLeft - items[last].weight) + items[last].value;

    // Acquire the optimal (maximum) value between two case
    int optimalValue = Math.max(notIncluded, included);

    return optimalValue;
  }
}
