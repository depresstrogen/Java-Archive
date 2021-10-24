import java.util.Scanner;
public class mileToKM {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int mile = sc.nextInt();
    int km = (int)((mile * 1.60935) * 1000);
    System.out.println((double)km / 1000);
  }
}