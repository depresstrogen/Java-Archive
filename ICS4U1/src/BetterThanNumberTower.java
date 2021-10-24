
public class BetterThanNumberTower {
	public static void main(String[] args) {
		int playerSum = 0;
		int dealerSum = 0;
		int count = 0;

		String[] shapes = { "spades", "hearts", "diamonds", "clubs" };
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] deck = new int[52];

		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}

		for (int i = 0; i < deck.length; i++) {
			int index = (int) (Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		} // this shuffles

		System.out.println("Your cards are:");
		for (int player = 0; player < 2; player++) {
			int num = nums[deck[player] % 13];
			String shape = shapes[deck[player] / 13];
			count++;
			System.out.println(numToCard(num) + " of " + shape);
			playerSum += num;
		}
		System.out.println("Your total is " + playerSum);

		System.out.println("Dealers cards are:");
		int num = 0;
		String shape = "";
		for (int dealer = count; dealer < count + 2; dealer++) {
			num = nums[deck[dealer] % 13];
			shape = shapes[deck[dealer] / 13];
			dealerSum += num;
		}
		System.out.println(num + " of " + shape);
		System.out.println("Dealers total is " + dealerSum);
		count += 2;

		System.out.println("Your cards are:");
		for (int player = count; player < count + 1; player++) {
			int num1 = nums[deck[player] % 13];
			String shape1 = shapes[deck[player] / 13];
			System.out.println(numToCard(num1) + " of " + shape1);
			playerSum += num1;
		}
		
		System.out.println("Your total is " + playerSum);
		count += 1;
	}
	
	public static String numToCard(int card) {
		String cardName = "";
		
		switch(card) {
		case 1:
			cardName = "Ace";
			break;
		case 11:
			cardName = "Jack";
			break;
		case 12:
			cardName = "Queen";
			break;
		case 13:
			cardName = "King";
			break;
		default:
			cardName = "" + card;
		}
		return cardName;
	}
}
