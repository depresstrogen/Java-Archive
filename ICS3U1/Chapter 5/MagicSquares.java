import java.util.Scanner;
public class MagicSquares {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input, magicNum = 0;
    int magic = 0;
    int[][] array = new int[4][4];
    for (int i = 0; i <= 3; i ++) {
      for (int j = 0; j <= 3; j ++) {
        input = sc.nextInt();
        array[j][i] = input;
      }
    }
    
    magicNum = array[0][0] + array[1][0] + array[2][0] + array[3][0];
    
    for (int i = 0; i < 4; i ++) {
      if (magic + array[0][i] + array[1][i] + array[2][i] + array[3][i] != magicNum) {
        magic ++;
      }
      if (magic + array[i][0] + array[i][1] + array[i][2] + array[i][3] != magicNum) {
        magic ++;
      }
    }
    if (magic == 0) {
      System.out.println("magic");
    } else {
      System.out.println("not magic");
    }
  }
}