import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int obs = sc.nextInt();
    int time = 0;
    int pos = 0;
    double temp = 0;
    double topSpeed  = 0;
    int[][] array = new int[obs][2];
    for (int i = 0; i < obs; i ++) {
      time = sc.nextInt();
      pos = sc.nextInt();
      array[i][0] = time;
      array[i][1] = pos;
      for (int j = 0; j < i; j++) {
        if (j == i) {
        }
        else {
          temp = (double)(array[i][1] - array[j][1]) / (double)(array[i][0] - array[j][0]);
          if (Math.abs(temp) > topSpeed) {
            topSpeed = Math.abs(temp);
          }
          //System.out.println(temp);
        }
      }
    }
//    for (int i = 0; i < obs; i++) {
//      System.out.println(array[i][0] + array[i][1];
//    }
    System.out.println(topSpeed);
  }
}