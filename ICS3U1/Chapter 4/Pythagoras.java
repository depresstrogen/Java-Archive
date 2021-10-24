import java.text.NumberFormat;
import java.util.Scanner;
public class Pythagoras {
  public static void main(String[] args) {
    //Declaring
    Scanner sc = new Scanner(System.in);
    NumberFormat decimal = NumberFormat.getNumberInstance();
    decimal.setMaximumFractionDigits(3);
    double sideC;
    
    //Input
    System.out.println("Enter side a:");
    double sideA = sc.nextDouble();
    System.out.println("Enter side b:");
    double sideB = sc.nextDouble();
    
    //Processing
    sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    
    //Output
    System.out.println("The hypotenuse measures " + decimal.format(sideC) + " cm");
    
  } // Main
} // First