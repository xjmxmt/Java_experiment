package task2;

import task1.Card;;

public class Player {
	public Card[] pcards = new Card[26];
	public int flag = 0;
	String[] suits = {"Heart", "Spade", "Diamond", "Club"};
	
//	private void setter(int r, String s) {
//		Card card = new Card(r, s);
//		pcards[flag] = card;
//		flag++;
//	}
	
	public void setter(Card c) {
		pcards[flag] = c;
		flag++;
	}
	
	public int get_rank(int i) {
		int res = (int) pcards[i].get_rank();
		return res;
	}
	
	public int print_result() {
		int res = 0;
		for(int i = 0; i < flag; i++) {
			res += get_rank(i);
		}
		return res;
	}
}
