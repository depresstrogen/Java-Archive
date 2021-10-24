/**
 * |------------------|
 * | Riley Power      |
 * | November 26 2019 |
 * |------------------|
 */


import java.util.Scanner;
public class NumWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input;
    String onesDigit = "";
    
    System.out.print("Enter a number:   ");
    input = sc.nextInt();
    
    switch(input % 10){
      case 0:
        onesDigit = "zero";
        break;
      case 1:
        onesDigit = "one";
        break;
      case 2:
        onesDigit = "two";
        break;
      case 3:
        onesDigit = "three";
        break;
      case 4:
        onesDigit = "four";
        break;
      case 5:
        onesDigit = "five";
        break;
      case 6:
        onesDigit = "six";
        break;
      case 7:
        onesDigit = "seven";
        break;
      case 8:
        onesDigit = "eight";
        break;
      case 9:
        onesDigit = "nine";
        break;
      default:
        onesDigit = "null";
    }
    
    System.out.println("The last digit of " + input + " is " + onesDigit);
  }
}