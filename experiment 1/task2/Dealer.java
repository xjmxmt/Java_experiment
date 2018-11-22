package task2;

import java.util.Scanner;

import task1.Card;

public class Dealer {
	String[] suits = {"Heart", "Spade", "Diamond", "Club"};
	private int[] state_flags = new int[52];
	
	public Dealer() {
		for(int i = 0; i< 52; i++) {
			// 设卡片还没有被取走时值为0
			state_flags[i] = 0;			
		}
	}
	
	public int[] shuffle(int num) {
		int[] accounts = new int[num];
		for(int i = 0; i < num; i++) {
			int tmp = (int)(1+Math.random()*(51));
			while(state_flags[tmp] == 1) {
				tmp = (int)(1+Math.random()*(51));
			}
			accounts[i] = tmp;
			state_flags[tmp] = 1;
		}
		return accounts;
	}
	
	public Card[] deal(int flag){		
		int num = 0;
		
		Card[] cards = new Card[52];
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 13; i++) {
				cards[13*j+i] = new Card(i+1, suits[j]);
//				cards[i].getter();
			}
		}
		
		if(flag == 0) {
			// 2个玩家都在要牌
			Card[] pcards = new Card[2];
			num = 2;
			int[] shuf = shuffle(num);
			for(int i = 0; i < num; i++) {
				cards[shuf[i]].change_state();
				pcards[i] = cards[shuf[i]];
			}
			return pcards;
		}else if(flag == 1) {
			// 1个玩家还在要牌
			Card[] pcards = new Card[1];
			num = 1;
			int[] shuf = shuffle(num);
			for(int i = 0; i < num; i++) {
				cards[shuf[i]].change_state();
				pcards[i] = cards[shuf[i]];
			}
			return pcards;
		}else return null;
	}
	
	public int playing(Computer player1, Player player2) {
		Boolean flag1 = false, flag2 = false;
		int win = 1;
		int lose = 0;
		int draw = 2;
		
		Card[] tmp0 = new Card[2];
		tmp0 = deal(0);
		player1.setter(tmp0[0]);
		player2.setter(tmp0[1]);
//		System.out.println("Computer takes "+ tmp0[0].get_rank() + "(hidden)");
		System.out.println("Player takes "+ tmp0[1].get_rank() + "(hidden)");
		
		while(true) {
			if(flag1 & flag2) {
				int res1 = player1.print_result();
				int res2 = player2.print_result();
				if(res1 > 21 & res2 < 21) {
					System.out.println("Player wins");
					System.out.println("Computer has "+ res1 +", Jack has " + res2);
					return win;
				}else if(res1 < 21 & res2 > 21) {
					System.out.println("Computer wins");
					System.out.println("Computer has "+ res1 +", Jack has " + res2);
					return lose;
				}else if(res1 > 21 & res2 > 21) {
					System.out.println("Draw");
					System.out.println("Computer has "+ res1 +", Jack has " + res2);
					return draw;
				}else if(res1 > res2) {
					System.out.println("Computer wins");
					System.out.println("Computer has "+ res1 +", Jack has " + res2);
					return lose;
				}else if(res1 < res2) {
					System.out.println("Player wins");
					System.out.println("Computer has "+ res1 +", Jack has " + res2);
					return win;
				}else if(res1 == res2) {
					System.out.println("Draw");
					System.out.println("Computer has "+ res1 +", Jack has " + res2);
					return draw;
				}
			}else if(flag1 == false & flag2 == true) {
				Card[] tmp = new Card[1];
				tmp = deal(1);
				Boolean tmp_flag = player1.set_or_not(tmp[0]);
				flag1 = tmp_flag;
				System.out.println("Computer takes "+ tmp[0].get_rank());
				
			}else if(flag1 == true & flag2 == false) {
				Card[] tmp = new Card[1];
				tmp = deal(1);
				player2.setter(tmp[0]);
				System.out.println("Player takes "+ tmp[0].get_rank());
				System.out.println("请玩家输入数字0：表示继续要牌，数字1：表示不再要牌");
				Scanner in =new Scanner(System.in);
                int a=in.nextInt();
                if(a == 1) {
                	flag2 = true;
                }
				
			}else if(!flag1 & !flag2) {
				Card[] tmp = new Card[2];
				tmp = deal(0);
				Boolean tmp_flag = player1.set_or_not(tmp[0]);
				flag1 = tmp_flag;
				player2.setter(tmp[1]);
				System.out.println("Computer takes "+ tmp[0].get_rank());
				System.out.println("Player takes "+ tmp[1].get_rank());
				System.out.println("请玩家输入数字0：表示继续要牌，数字1：表示不再要牌");
				Scanner in =new Scanner(System.in);
                int a=in.nextInt();
                if(a == 1) {
                	flag2 = true;
                }
			}			
		}
	}
}
