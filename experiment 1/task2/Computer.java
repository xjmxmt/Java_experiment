package task2;

import task1.Card;

public class Computer extends Player{
	public Card[] pcards = new Card[26];
	public int flag = 0;
	String[] suits = {"Heart", "Spade", "Diamond", "Club"};		
	
	public int get_rank(int i) {
		int res = (int) pcards[i].get_rank();
		return res;
	}
	
	public void setter(Card c) {
		pcards[flag] = c;
		flag++;
	}
	
	public int print_result() {		
		int res = 0;
		for(int i = 0; i < flag; i++) {
			res += get_rank(i);
		}
		return res;
	}
	
	public Boolean set_or_not(Card c) {
		pcards[flag] = c;
		flag++;
		int tmp_res = print_result();
		if(tmp_res > 18) {
			// 下一轮不再要牌
			return true;
		}
		return false;
	}
}
