import java.util.Scanner;
public class distance{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double first = sc.nextDouble();
    double second = sc.nextDouble();
    double third = sc.nextDouble();
    double ans = first + second + third;
    System.out.println(ans);
  }
}