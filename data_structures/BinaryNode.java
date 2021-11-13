package data_structures;

public class BinaryNode<T> {
  public T data;
  public BinaryNode<T> left, right;

  public BinaryNode() {
  }

  public BinaryNode(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
