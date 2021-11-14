package depth_first_search;

import data_structures.BinaryNode;
import data_structures.BinaryTree;

public class Implementation {
  public static void main(String[] args) {
    /**
     * Traverse binary tree in In-order fashion using Depth-first search
     */
    IntegerBinaryTree intTree = new IntegerBinaryTree();
    intTree.add(50);
    intTree.add(17);
    intTree.add(72);
    intTree.add(12);
    intTree.add(23);
    intTree.add(54);
    intTree.add(76);
    traverseBinaryTreeDFS(intTree);
  }

  public static void traverseBinaryTreeDFS(IntegerBinaryTree tree) {
    System.out.print("In-Order Tree traversal: ");
    printInOrder(tree.root);
  }

  public static void printInOrder(BinaryNode<Integer> node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");
    printInOrder(node.left);
    printInOrder(node.right);
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