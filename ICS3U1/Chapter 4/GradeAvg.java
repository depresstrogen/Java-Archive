import java.util.Scanner;
public class GradeAvg {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int one = sc.nextInt();
    int two = sc.nextInt();
    int three = sc.nextInt();
    int four = sc.nextInt();
    int five = sc.nextInt();
    double ans = (one + two + three + four + five) / 5;
    System.out.println(ans);
  }
}