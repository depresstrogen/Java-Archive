import java.util.Scanner;
public class Office {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    int x = sc.nextInt(), y = sc.nextInt();
    int ogx = x;
    while (x <= y) {
      if ((x - ogx) % 60 == 0) {
        System.out.println("All positions change in year " + x);
      }
      x ++;
    }
  }
}