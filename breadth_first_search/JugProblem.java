package breadth_first_search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class JugProblem {
  public static void main(String[] args) {
    /**
     * Problem description: Write a program that prints out the steps to get exactly
     * N liters of water from 2 jugs of X and Y liters.
     * 
     * For example, if X = 3, Y = 5, N = 4:
     */
    bfs(4);
  }

  public static void bfs(int N) {
    HashSet<State> visited = new HashSet<>();
    State initialState = new State(0, 0, "Initial state");
    visited.add(initialState); // Add visit note
    boolean found = false; // If path is found
    ArrayQueue<StateNode> queue = new ArrayQueue<StateNode>(StateNode.class, 100); // Maximum 100 nodes
    queue.enqueue(new StateNode(initialState, null)); // Add explore node to queue

    while (!(queue.isEmpty())) {
      StateNode node = queue.dequeue();
      State current = node.state;
      if (current.x == N || current.y == N) {
        printSteps(node);
        found = true;
        break;
      }

      for (State nextState : current.generateStates()) {
        if (!visited.contains(nextState)) {
          visited.add(nextState);
          queue.enqueue(new StateNode(nextState, node));
        }
      }
    }
    if (!found) {
      System.out.printf("Cannot get %d litters of water from %d and %d jugs\n", N, State.X, State.Y);
    }

  }

  public static void printSteps(StateNode node) {
    StringBuilder builder = new StringBuilder();
    // Build the steps backward
    while (node != null) {
      State state = node.state;
      builder.insert(0, state.x + " " + state.y + ": " + state.desc + '\n');
      node = node.parent;
    }
    System.out.println(builder.toString());
  }
}

class State {
  static int X = 3;
  static int Y = 5;

  // Current amount
  public int x, y;

  // How to reach to this state (Optional)
  public String desc;

  public State(int x, int y) {
    this.x = x;
    this.y = y;
    this.desc = "";
  }

  public State(int x, int y, String desc) {
    this.x = x;
    this.y = y;
    this.desc = desc;
  }

  @Override
  public int hashCode() {
    // Return consistent hash code for equal comparison of State object
    return 1;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof State))
      return false;
    State s2 = (State) o;
    return (this.x == s2.x && this.y == s2.y);
  }

  public ArrayList<State> generateStates() {
    ArrayList<State> states = new ArrayList<State>();
    /// List of steps to fill the two jugs x, y
    // Fill first jug
    if (x != X)
      states.add(new State(X, y, "Fill first jug"));
    // Fill second jug
    if (x != Y)
      states.add(new State(x, Y, "Fill second jug"));
    // Pour out first jug
    if (x == X)
      states.add(new State(0, y, "Pour out first jug"));
    // Pour out second jug
    if (y == Y)
      states.add(new State(x, 0, "Pour out second jug"));
    // Pour from first jug to second jug
    if (y != Y && x > 0)
      states.add(new State(Math.max(0, x + y - Y), Math.min(Y, x + y), "Pour from first jug to second jug"));
    if (x != X && y > 0)
      states.add(new State(Math.min(X, x + y), Math.max(0, x + y - X), "Pour from second jug to first jug"));
    return states;
  }
}

class StateNode {
  State state;
  StateNode parent;

  public StateNode(State s, StateNode p) {
    this.state = s;
    this.parent = p;
  }
}

/*
 * Queue implemented with array ref:
 * https://github.com/bietdoikiem/ds4j/blob/main/ArrayQueue.java *
 */
class ArrayQueue<T> {
  protected int capacity;
  protected int size;
  protected T[] array;

  public ArrayQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.array = (T[]) new Object[capacity];
  }

  /**
   * Constructor for extension/inheritance of child's type
   * 
   * @param clazz    Class name
   * @param capacity Capacity of array
   */
  public ArrayQueue(Class<T> clazz, int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.array = (T[]) Array.newInstance(clazz, capacity);
  }

  /**
   * Get the current size of the queue
   * 
   * @return
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Check if the queue is currently empty
   * 
   * @return True if empty | False if not
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Check if the queue is full
   * 
   * @return True if empty | False if not
   */
  public boolean isFull() {
    return size == capacity;
  }

  /**
   * Enqueue an item to the queue | Time complexity: O(1)
   * 
   * @param item
   * @return
   */
  public T enqueue(T item) {
    // CASE 1: If queue is full
    if (isFull()) {
      System.out.println("ERROR! The queue is currently full!");
      return null;
    }
    // CASE 2: If queue is still insert-able
    size++;
    array[size - 1] = item;
    return item;
  }

  /**
   * Dequeue an item from the queue | Time complexity: O(n)
   * 
   * @return Dequeued item
   */
  public T dequeue() {
    if (isEmpty()) {
      System.out.println("ERROR! The queue is currently empty");
      return null;
    }
    T poppedItem = array[0];
    // Shift all items to left
    for (int i = 0; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    // Set null to last dangling item in queue
    array[size - 1] = null;
    size--;
    return poppedItem;
  }

  /**
   * Peek at the first item in the queue | Time complexity: O(1)
   * 
   * @return Item
   */
  public T peekFront() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return null;
    }
    return array[0];
  }

  /**
   * Peek at the last item of the queue | Time complexity: O(1)
   * 
   * @return
   */
  public T peekRear() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return null;
    }
    return array[size - 1];
  }

  /**
   * Display all the items currently in the queue | Time complexity: O(n)
   */
  public void display() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return;
    }
    System.err.print("Current queue: ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.print("\n");
  }

}