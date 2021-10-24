import java.util.Scanner;
  public class RPS {
  public static void main(String[] args) {
    int user, computer;
    String msg;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Your input\n" +
                       "1. Rock \n" +
                       "1. Paper \n" +
                       "1. Scissors");
    user = sc.nextInt();
    computer = (int) ((3 - 1 + 1) * Math.random() + 1);
    switch (user) {
      case 1:
        System.out.println("User: Rock");
        break;
      case 2:
        System.out.println("User: Paper");
        break;
      case 3:
        System.out.println("User: Scissors");
        break;
      default:
        System.out.println("Incorrect");
        break;
    }
    
    switch (computer) {
      case 1:
        System.out.println("Computer: Rock");
        break;
      case 2:
        System.out.println("Computer: Paper");
        break;
      case 3:
        System.out.println("Computer: Scissors");
        break;
    }
    if (user == 1 && computer == 3) {
      msg = "User wins!";
    } else if (user == 2 && computer == 1) {
      msg = "User wins!";
    } else if (user == 3 && computer == 2) {
      msg = "User wins!";
    } else if (user == computer) {
      msg = "Tie";
    } else {
      msg = "Computer Wins";
    }
    
    System.out.println(msg);
  }
}