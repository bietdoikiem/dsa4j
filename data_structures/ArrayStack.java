package data_structures;

/*
 * Stack implemented with array ref:
 * https://github.com/bietdoikiem/ds4j/blob/main/ArrayStack.java *
 */
public class ArrayStack<T> {
  public final int maxSize;
  public T[] array;
  public int top = -1; // Index of top element

  public ArrayStack(int maxSize) {
    this.maxSize = maxSize;
    this.array = (T[]) new Object[maxSize];
  }

  /**
   * Check if the stack is empty | Time complexity: O(1)
   * 
   * @return True if empty | False if NOT
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * Push new item to the stack | Time complexity: O(1)
   * 
   * @param item Stack's item to be pushed
   * @return True if success | Throws Stack Overflow error if exceed the maximum
   *         size
   */
  public T push(T item) {
    if (top < (maxSize - 1)) {
      array[++top] = item;
      System.out.println("SUCCESS! Push item to the stack at index: " + top);
      return item;
    }
    // CASE ERROR: Check if we have push exceeding the limit
    System.out.println("ERROR! The stack is full already");
    return null;
  }

  /**
   * Pop the item from top of the stack | Time complexity: O(1)
   * 
   * @return True if success | False if not
   */
  public T pop() {
    // CASE ERROR: Check if we have nothing to pop
    if (top == -1) {
      System.out.println("ERROR! The stack is empty");
      return null;
    }
    // CASE SUCCESS
    T poppedItem = array[top];
    array[top--] = null;
    System.out.println("SUCCESS! Pop item from stack: " + poppedItem);
    return poppedItem;
  }

  /**
   * Peek the item at the top of the stack | Time complexity: O(1)
   * 
   * @return Item at the top of the stack
   */
  public T peek() {
    return array[top];
  }

}