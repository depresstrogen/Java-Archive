import java.util.Scanner;
import java.lang.Number;

public class illuminati {
  public static void main(String[] args) {
    int value = 0;
    Scanner sc = new Scanner(System.in);
    int numa = sc.nextInt();
    int numb = sc.nextInt();
    int numc = sc.nextInt();
    if (numa + numb + numc != 180){
      System.out.println("Error");
    } else if (numa == numb && numb == numc) {
      System.out.println("Equilateral");
    } else if (numa != numb && numb != numc && numa != numc ) {
      System.out.println("Scalene");
    } else {
      System.out.println("Isosceles");
    }
  }
}