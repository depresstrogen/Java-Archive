import java.util.Scanner;

public class nextline {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = b - a;
    System.out.println(b + c);
  }
}