import java.util.Scanner;
public class shifty {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double numa = sc.nextInt(),numb = sc.nextInt(), value = 0;
    while (numb != -1) {
      value = value + (numa * Math.pow(10, (numb)));
      numb = numb - 1;
    }
    System.out.println(value);
  }//Main
}//Class