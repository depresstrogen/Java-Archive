import java.util.Scanner;
public class rectt {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int length, width, per;
    System.out.println("Enter the length");
    length = sc.nextInt();
    System.out.println("Enter the width");
    width = sc.nextInt();
    per = 2 * (length + width);
    System.out.println("The perimiter is " + per);
  }
}