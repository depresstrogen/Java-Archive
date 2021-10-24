import java.util.Scanner;
public class ColdOutside {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String coldestCity = "";
    int coldestTemp = 200;
    String city = sc.next();
    int temp = sc.nextInt();
    while (city.equals("Waterloo") == false) {
      if (coldestTemp > temp) {
        coldestTemp = temp;
        coldestCity = city;
      }
      city = sc.next();
      temp = sc.nextInt();
    }
    System.out.println(coldestCity);
  }
}