import java.util.Scanner;
public class timeConversion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hours, minutes;
    System.out.print("Enter the time in minutes: ");
    int number = sc.nextInt();
    hours = number / 60;
    number = number %  60;
    System.out.println("The time is: " + hours + ":" + number);
  }
}