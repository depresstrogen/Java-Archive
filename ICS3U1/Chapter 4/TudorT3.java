import java.util.Scanner;

public class TudorT3 {
  public static void main(String[] args) {
   
    Scanner sc = new Scanner(System.in);
    long drink = sc.nextLong();
    long loyalty = sc.nextLong();
    long purchaced = drink - (drink / (loyalty + 1));
    System.out.println(purchaced);
  }
}