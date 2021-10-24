import java.util.Scanner;
public class Digits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input 2 digit number :");
    int twodigit = sc.nextInt();
    int tensdigit = twodigit / 10;
    int onesdigit = twodigit % 10;
    System.out.println("Tens: " + tensdigit);
    System.out.println("Ones: " + onesdigit);
  }
}