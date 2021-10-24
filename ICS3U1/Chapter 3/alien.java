import java.util.Scanner;
import java.lang.Number;

public class alien {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numa = sc.nextInt();
    int numb = sc.nextInt();
    if (numa >= 3 && numb <= 4) {
      System.out.println("TroyMartian");
    }
    if (numa <= 6 && numb >= 2) {
      System.out.println("VladSaturnian");
    }
    if (numa <= 2 && numb <= 3) {
      System.out.println("GraemeMercurian");
    }
  }
}