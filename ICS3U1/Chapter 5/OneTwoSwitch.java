import java.util.Scanner;
public class OneTwoSwitch {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    switch(num) {
      case 0:
      case 1:
      case 2:
        System.out.println("E");
        break;
      case 3:
      case 4:
        System.out.println("E but better");
        break;
      case 5:
      case 6:
        System.out.println("E but much better");
        break;
    }
  }
}