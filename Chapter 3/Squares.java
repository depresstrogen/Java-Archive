import java.util.*;

public class Squares {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
      int a = in.nextInt();
      double b = Math.sqrt(a);
      System.out.println("The largest square has side length " + (int)b + ".");
  }
}