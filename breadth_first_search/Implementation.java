package breadth_first_search;

import java.util.ArrayList;

import data_structures.ArrayQueue;
import data_structures.BinaryNode;
import data_structures.BinaryTree;

public class Implementation {
  public static void main(String[] args) {
    // Implementation
    // Construct an integer binary tree
    IntegerBinaryTree intTree = new IntegerBinaryTree();
    intTree.add(50);
    intTree.add(17);
    intTree.add(72);
    intTree.add(12);
    intTree.add(23);
    intTree.add(54);
    intTree.add(76);
    traverseBinaryTreeBFS(intTree);
  }

  public static void traverseBinaryTreeBFS(IntegerBinaryTree tree) {
    // Dequeue -> Switch to that dequeued item's pointer
    // Enqueue each of the left & right nodes of current pointer
    ArrayQueue<BinaryNode<Integer>> queue = new ArrayQueue<BinaryNode<Integer>>(100); // Init queue
    ArrayList<BinaryNode<Integer>> visited = new ArrayList<BinaryNode<Integer>>(); // Init visited nodes
    System.out.print("Level-Order Tree Traversal: ");
    // Enqueue tree roots
    BinaryNode<Integer> root = tree.root;
    queue.enqueue(root);
    while (!(queue.isEmpty())) {
      // Update pointer to current pointer
      BinaryNode<Integer> curr = queue.dequeue();
      // Add to visited node if not visited before
      if (!(visited.contains(curr))) {
        visited.add(curr);
        System.out.print(curr.data + " ");
      }
      // Enqueue its leaves (Enqueue from left -> right)
      if (curr.left != null) {
        queue.enqueue(curr.left);
      }
      if (curr.right != null) {
        queue.enqueue(curr.right);
      }
    }
  }
}

class IntegerBinaryTree extends BinaryTree<Integer> {

  private BinaryNode<Integer> addRecursive(BinaryNode<Integer> current, Integer data) {
    if (current == null) {
      return new BinaryNode<Integer>(data);
    }
    if (data < current.data) {
      current.left = addRecursive(current.left, data);
    } else if (data > current.data) {
      current.right = addRecursive(current.right, data);
    } else {
      return current;
    }
    return current;
  }

  public void add(Integer data) {
    this.root = addRecursive(root, data);
  }
}