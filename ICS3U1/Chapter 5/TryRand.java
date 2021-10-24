public class TryRand {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
    int die1 = (int)((6 - 1 + 1) * Math.random() + 1);
    int die2 = (int)((6 - 1 + 1) * Math.random() + 1);
    System.out.println(die1 + die2);
    }
  }
}