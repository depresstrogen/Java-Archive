// Riley Power

import java.text.NumberFormat;

public class numForm {
  public static void main(String[] args) {
    NumberFormat money = NumberFormat.getCurrencyInstance();
    NumberFormat percent = NumberFormat.getPercentInstance();
    NumberFormat integer = NumberFormat.getIntegerInstance();
    
    int x = 6;
    int y = 9;
    
    money.setMinimumFractionDigits(x);     // Show to x decmal places
    integer.setMinimumIntegerDigits(y);    // Pad number until it is y length long
    
    System.out.println(money.format(21.69));
    System.out.println(percent.format(0.69420));
    System.out.println(integer.format(69));
  }
}