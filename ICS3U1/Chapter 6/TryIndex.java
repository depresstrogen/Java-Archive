import java.util.Scanner;
public class TryIndex{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    System.out.print(name.charAt(0));
    
    int space = name.indexOf(" ");
    System.out.print(name.charAt(space + 1));
    for (int i = 0; i < name.length();) {
      i = name.indexOf(" ", space);
      System.out.println(name.charAt(i + 1));
    }
  }
}