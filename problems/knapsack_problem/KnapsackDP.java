package problems.knapsack_problem;

public class KnapsackDP {
  public static void main(String[] args) {
    /**
     * The Knapsack Problem:
     * Find the most valuable subset of items to put in the knapsack without
     * exceeding the capacity of the knapsack.
     */
    Item[] items = new Item[] { new Item(60, 10), new Item(100, 20), new Item(120, 35), new Item(200, 45) };
    int capacity = 60;
    int last = items.length - 1;
    System.out.println("Optimal value of items put in the knapsack: " + "");
  }

  public static void solve(int last) {

  }

}
