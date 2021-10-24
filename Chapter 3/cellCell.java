import java.util.Scanner;
import java.lang.Number;

public class cellCell {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double daya = 0;
    double dayb = 0;
    double dayaa = 0;
    double daybb = 0;
    int numa = sc.nextInt();
    int numb = sc.nextInt();
    int numc = sc.nextInt();
    
    if (numa > 100) {
      daya = numa - 100;
      dayaa = daya * 0.25;
    }
    else {
      dayaa = 0;
    }
    
    if (numa > 250) {
      dayb = numa - 250;
      daybb = dayb * 0.45;
    }
    else {
      daya = 0;
    }
    
    daya = dayaa + (numb * 0.15) + (numc *  0.20);
    dayb = daybb + (numb * 0.35) + (numc *  0.25);
    
    double parta = Math.round(daya * 10000) / 100;
    double partb = Math.round(dayb * 10000) / 100;
    
    double ansa = parta / 100;
    double ansb = partb / 100;
    
    System.out.println("Plan A costs " + ansa);
    System.out.println("Plan B costs " + ansb);
    
    if (ansb > ansa) {
      System.out.println("Plan A is cheapest.");
    }
    else if (ansa > ansb) {
      System.out.println("Plan B is cheapest.");
    }
    else {
      System.out.println("Plan A and B are the same price.");
    }
  }
}