import java.util.Scanner;
public class sixteen {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numcases = sc.nextInt();
    int count = 1;
    double firstnum;
    double secondnum;
    long product;
    long realproduct;
    while (count <= numcases) {
      firstnum = sc.nextDouble();
      secondnum = sc.nextDouble();
      product = sc.nextLong();
      realproduct = (long) firstnum * (long)secondnum;
      System.out.println(product);
      System.out.println(realproduct);
      if (product != realproduct) {
        System.out.println("16 BIT S/W ONLY");
      } else {
        System.out.println("POSSIBLE DOUBLE SIGMA");
      }
      count = count + 1;
    }
  }
}