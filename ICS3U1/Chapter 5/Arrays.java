import java.util.Scanner;
public class Arrays {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int input = sc.nextInt();
   int[] boxes = new int[]{0, 100, 500, 1000, 5000};
   
   
   System.out.println(boxes[input]);
  }
}