import java.util.Scanner;
public class RSA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numaog = sc.nextInt();
    int numa = numaog;
    int numb = sc.nextInt();
    int count = numa;
    int countagain = 1;
    int divisors = 0;
    int rsatotal = 0;
    while (numa <= numb) {
      while (count <= numa){
        if (count / numa == 1) {
          divisors += 1;
        }
        count ++;
      }
      numa ++;
      if (divisors == 4) {
       rsatotal += 1; 
      }
      count = 1;
    }
    System.out.println(rsatotal);
  }//Main
}//RSA