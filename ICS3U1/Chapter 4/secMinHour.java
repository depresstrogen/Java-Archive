import java.util.Scanner;
public class secMinHour {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int seconds = sc.nextInt();
    int minutes = (int)(seconds / 60);
    int hours = (int)(minutes / 60);
    System.out.println("Hours: " + hours);
    System.out.println("Minutes: " + minutes);
    System.out.println("Seconds: " + seconds);
  }
}