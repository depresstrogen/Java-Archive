import java.util.Scanner;
public class Blyat {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String cyka = "";
    int oldSpace = 0;
    cyka = sc.nextLine();
    int space = cyka.indexOf(" ");
    do {
      System.out.println(cyka.substring(oldSpace, space));
      oldSpace = space;
      space = cyka.indexOf(" ", space);
    } while (space != -1);
  }
}