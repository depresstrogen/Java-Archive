import java.util.Scanner;
public class sphereRad {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rad = sc.nextInt();
    double volume = 4/3 * Math.PI * (Math.pow(rad, 3));
    double surface = 4 * Math.PI * (Math.pow(rad, 2));
    System.out.println(volume + "\n" + surface);
  }
}