import java.util.Scanner;
public class shifty {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double n = sc.nextInt(), k = sc.nextInt(), sum = 0;
    for (; k  >= 0; k --) {
      sum = sum + (n * Math.pow(10, (k)));
    }
    int ans = (int) sum;
    System.out.println(ans);
  }
}