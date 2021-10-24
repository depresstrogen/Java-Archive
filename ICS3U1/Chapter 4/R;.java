/**
 * Riley Power
 * November 6 2019
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class HospitalParking {
  public static void main(String[] args) {
    
   // Declaration
   Scanner sc = new Scanner(System.in); 
   NumberFormat money = NumberFormat.getCurrencyInstance();
   int price;
   
   // Input
   System.out.println("How many minutes have elapsed?");
   int minutes = sc.nextInt();
   
   // Processing
   if (minutes % 30 == 0) {
     price = minutes / 30 * 5;
   }
   else {
     price = (minutes / 30 + 1) * 5;
   }
   
   // Output
   System.out.println("Your parking charge is "+ money.format(price));
   
  }// Main
}// HospitalParking