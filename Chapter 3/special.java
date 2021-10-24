import java.util.Scanner;
import java.lang.Number;

public class special {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numa = sc.nextInt();
    int numb = sc.nextInt();
    int var = 0;
    if (numa == 2 && numb == 18){
      System.out.println("Special");
    }
    else if (numa == 2 && numb < 18 || numa == 1) {
      System.out.println("Before");
    }
    else {
      System.out.println("After");
    }
  }
}