package searches.depth_first_search;

public class MazeProblem {

  public static void main(String[] args) {
    /**
     * Problem Description: Given a maze as a 2D matrix of characters, one must find
     * the path originating from the source 'S' to the end 'E' in order to solve the
     * maze. Remember the maze is also filled with tons of obstacles marked as
     * asterisk (*), so please try to avoid them and complete the escape safely!
     * NOTE: There are some mazes that are unsolvable!
     */
    char[][] maze = new char[3][4]; // 3 x 4 maze
    // Populate sample maze
    // 1st Row
    maze[0][0] = 'S';
    maze[0][1] = '.';
    maze[0][2] = '.';
    maze[0][3] = '*';
    // 2nd Row
    maze[1][0] = '*';
    maze[1][1] = '.';
    maze[1][2] = '.';
    maze[1][3] = '*';
    // 3rd Row
    maze[2][0] = '*';
    maze[2][1] = '.';
    maze[2][2] = '.';
    maze[2][3] = 'E';

    // Display maze
    System.out.println("Maze #1 Problem:");
    display(maze);

    // Solve maze
    System.out.println("Solution:");
    solveMaze(maze);

    // Populate unsolvable maze
    char[][] unsolvableMaze = new char[3][4];
    // 1st Row
    unsolvableMaze[0][0] = 'S';
    unsolvableMaze[0][1] = '.';
    unsolvableMaze[0][2] = '.';
    unsolvableMaze[0][3] = '.';
    // 2nd Row
    unsolvableMaze[1][0] = '*';
    unsolvableMaze[1][1] = '*';
    unsolvableMaze[1][2] = '*';
    unsolvableMaze[1][3] = '*';
    // 3rd Row
    unsolvableMaze[2][0] = '.';
    unsolvableMaze[2][1] = '.';
    unsolvableMaze[2][2] = '.';
    unsolvableMaze[2][3] = 'E';

    // Display unsolvable Maze
    System.out.println("Maze #2 Problem:");
    display(unsolvableMaze);

    System.out.println("Solution:");
    solveMaze(unsolvableMaze);
  }

  /* * Declaration of constants * */
  static final String ROW_SEPARATOR = "\n \n";
  static final String COL_SEPARATOR = "\t";
  static final char EMPTY_CHAR = '\u0000';
  static final char OBSTACLE_CHAR = '*';
  static final char START_CHAR = 'S';
  static final char END_CHAR = 'E';
  static final char GONE_CHAR = 'G';

  /**
   * Display the maze
   * 
   * @param maze
   */
  public static void display(char[][] maze) {
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[0].length; j++) {
        System.out.print(maze[i][j] + COL_SEPARATOR);
      }
      System.out.print(ROW_SEPARATOR);
    }
  }

  /**
   * Solve the maze utility
   * 
   * @param maze Maze to be solved
   * @return True if is solvable | False if NOT
   */
  public static boolean solveMaze(char[][] maze) {
    char[][] solution = new char[maze.length][maze[0].length];
    if (!(exploreMaze(maze, solution, 0, 0))) {
      System.out.println("ERROR! The maze is not solvable!");
      return false;
    }
    System.out.println("SUCCESS! The maze is solved! Here's the path:");
    display(solution); // Display solution path
    return true;
  }

  private static boolean exploreMaze(char[][] maze, char[][] solution, int x, int y) {
    // Check if the END has been reached safely
    if (isSafe(x, y, maze) && maze[x][y] == END_CHAR) {
      solution[x][y] = END_CHAR;
      return true;
    }
    // Recurse to possible paths safely
    if (isSafe(x, y, maze)) {

      // Check if path has been visited
      if (solution[x][y] == GONE_CHAR) {
        return false;
      }
      // Mark current path as GONE || Mark as START if it's end beginning point
      if (maze[x][y] == START_CHAR) {
        solution[x][y] = START_CHAR;

      } else {
        solution[x][y] = GONE_CHAR;

      }
      /// Begin explore all possible directions
      // Go UP
      if (exploreMaze(maze, solution, x + 1, y)) {
        return true;
      }
      // Go DOWN
      if (exploreMaze(maze, solution, x - 1, y)) {
        return true;
      }
      // Go RIGHT
      if (exploreMaze(maze, solution, x, y + 1)) {
        return true;
      }
      // Go LEFT
      if (exploreMaze(maze, solution, x, y - 1)) {
        return true;
      }

      // If all directions failed -> Backtracking by un-marking 'G'
      solution[x][y] = EMPTY_CHAR;
    }
    return false;
  }

  private static boolean isSafe(int x, int y, char[][] maze) {
    final int MAX_ROW = maze.length;
    final int MAX_COL = maze[0].length;
    return x >= 0 && y >= 0 && x < MAX_ROW && y < MAX_COL && maze[x][y] != OBSTACLE_CHAR;
  }

}