import java.util.Scanner;
public class L00P5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long money = sc.nextLong();
    long og = money;
    long desired = sc.nextLong();
    int i = 0;
    while (money < desired) {
      money *= 1.03;
      i ++;
    }
    System.out.println("Starting with $" + og + " you would need to wait " + i + " years to get $" + desired);
  }
}