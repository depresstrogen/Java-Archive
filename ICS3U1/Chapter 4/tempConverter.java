import java.util.Scanner;
public class tempConverter{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int fah = sc.nextInt();
    double cel = ((fah - 32) * 5/9);
    System.out.println(cel);
  }
}