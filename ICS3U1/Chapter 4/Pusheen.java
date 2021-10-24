import java.util.Scanner;
import java.text.NumberFormat;
public class Pusheen {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    NumberFormat decimal = NumberFormat.getNumberInstance();
    decimal.setMaximumFractionDigits(1);
    decimal.setMinimumFractionDigits(1);
    int numGrades = sc.nextInt();
    int count = 0;
    int grade;
    int totalBefore = 0;
    double total;
    while (count != numGrades) {
      grade = sc.nextInt();
      totalBefore = totalBefore + grade;
      count ++;
    }
    total = totalBefore / numGrades;
    System.out.println(decimal.format(total));
  }
}