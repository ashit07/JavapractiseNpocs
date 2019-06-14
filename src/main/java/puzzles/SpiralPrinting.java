package puzzles;

/**
 * 
 * @author ashijune
 * 
 *         Problem: Write a program to print a 2D array (n x m) in spiral order (clockwise)
 * 
 *         INPUT SAMPLE:
 * 
 *         Your program should accept as its first argument a path to a filename. The input file
 *         contains several lines. Each line is one test case. Each line contains three items
 *         (semicolon delimited). The first is 'n'(rows), the second is 'm'(columns) and the third
 *         is a single space separated list of characters/numbers in row major order. E.g.
 * 
 *         3;3;1 2 3 4 5 6 7 8 9 OUTPUT SAMPLE:
 * 
 *         Print out the matrix in clockwise fashion, one per line, space delimited. E.g.
 * 
 *         1 2 3 6 9 8 7 4 5
 */
public class SpiralPrinting {
  int[][] getArr(int rows, int cols, String numbers) {
    int[][] arrNew = new int[rows][cols];
    String[] arrNumbersString = numbers.trim().split(" ");
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        arrNew[i][j] = Integer.parseInt(arrNumbersString[count]);
        count++;
      }

    }
    return arrNew;
  }

  void displayArr(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println(arr.length);
  }

  void convertToSpiral(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;
    int x = 0, y = 0;
    int[][] arrTemp = new int[rows][cols];
    for (int i = 0; i < arrTemp.length; i++) {
      for (int j = 0; j < arrTemp[i].length; j++) {
        if (y <= (cols - 1)) {
          arrTemp[i][j] = arr[x][y];
          y++;
        } else if ((x <= y) && (x <= rows - 1)) {
          arrTemp[i][j] = arr[x][y];
        }

      }
    }
    displayArr(arrTemp);

  }

  void addToArray(int x, int y, int value) {

  }

  public static void main(String[] args) {
    SpiralPrinting obj = new SpiralPrinting();
    int[][] arr = obj.getArr(3, 3, "1 2 3 4 5 6 7 8 9");
    // obj.displayArr(arr);
    obj.convertToSpiral(arr);

  }
}
