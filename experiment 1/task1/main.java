package task1;

public class main {
	public static int[] shuffle(int num) {
		int[] accounts = new int[num];
		for(int i = 0; i < num; i++) {
			accounts[i] = (int)(1+Math.random()*(51));
		}
		return accounts;
	}
	public static void main(String[] args) {
		Card[] cards = new Card[52];
		String[] suits = {"Heart", "Spade", "Diamond", "Club"};
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 13; i++) {
				cards[13*j+i] = new Card(i+1, suits[j]);
//				cards[i].getter();
			}
		}
		int num = 5;
		int[] shuf = shuffle(num);
		for(int i = 0; i < num; i++) {
			cards[shuf[i]].getter();
			cards[shuf[i]].change_state();
		}
	}
}
