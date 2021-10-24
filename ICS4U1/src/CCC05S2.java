import java.util.Scanner;
public class CCC05S2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   
    int screenCornerX = sc.nextInt();
    int screenCornerY = sc.nextInt();
    int mouseX = 0;
    int mouseY = 0;
    int mouseChangeX;
    int mouseChangeY;
    boolean notZero = true;
    mouseChangeX = sc.nextInt();
    mouseChangeY = sc.nextInt();
    while (notZero) {
      mouseX += mouseChangeX;
      mouseY += mouseChangeY;
      
      if (mouseX < 0) {
        mouseX = 0;
      }
      if (mouseX > screenCornerX) {
        mouseX = screenCornerX;
      }
      
      if (mouseY < 0) {
        mouseY = 0;
      }
      if (mouseY > screenCornerY) {
        mouseY = screenCornerY;
      }
      
      System.out.println(mouseX + " " + mouseY);
      
      if(sc.hasNextInt()) {
    	  mouseChangeX = sc.nextInt();
      }
      
      if(sc.hasNextInt()) {
    	  mouseChangeY = sc.nextInt();
      }
      
      mouseChangeY = sc.nextInt();
      if(mouseChangeX == 0 && mouseChangeY == 0) {
        notZero = false;
      }
    }
  }
}