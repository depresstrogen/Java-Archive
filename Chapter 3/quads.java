import java.util.Scanner;
import java.lang.Number;

public class quads {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numa = sc.nextInt();
    int numb = sc.nextInt();
    if (numa > 0 && numb > 0){
      System.out.println("1");
    } else if (numa < 0 && numb > 0){
      System.out.println("2");
    } else if (numa < 0 && numb < 0){
      System.out.println("3");
    } else if (numa > 0 && numb < 0){
      System.out.println("4");
    }
  }
}