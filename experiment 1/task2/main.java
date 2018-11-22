package task2;

import java.util.Scanner;
import task1.Card;

public class main {
	public static int playGame(Computer player1, Player player2, Dealer dealer) {
		int res = 0;
		res = dealer.playing(player1, player2);
		return res;
	}
	
	public static int makeBet(Player player2, int asset2) {
		int tmp_asset = 0;
		while(true) {
			System.out.println("请玩家输入下注金额0~" + asset2);
			Scanner in =new Scanner(System.in);
	        int a=in.nextInt();
	        if((a > 0 | a == 0) & (a < asset2 | a == asset2)) {
	        	tmp_asset = 2 * a;
	        	System.out.println("玩家下注金额为：" + a);
	        	break;
	        }else {
	        	System.out.println("金额有误，请重新输入");
	        }
		}
		return tmp_asset;
	}
	
	public static void main(String[] args) {
		Card[] cards = new Card[52];
		String[] suits = {"Heart", "Spade", "Diamond", "Club"};
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 13; i++) {
				cards[13*j+i] = new Card(i+1, suits[j]);
			}
		}
		
		int asset1 = 1000;
		int asset2 = 1000;
		
		Dealer dealer = new Dealer();
		Computer player1 = new Computer();
		Player player2 = new Player();
		
		while(true) {
			int tmp_asset = makeBet(player2, asset2);
			int tmp_res = playGame(player1, player2, dealer);
			if(tmp_res == 1) {
				asset2 += tmp_asset;
			}else {
				asset2 -= tmp_asset / 2;
			}
			System.out.println("玩家目前资产为：" + asset2);
			if(asset2 == 0 | asset2 < 0) {
				System.out.println("玩家破产，游戏结束");
				break;
			}
			if(asset2 > 2000 | asset2 == 2000) {
				System.out.println("玩家赚到了2000，游戏结束");
				break;
			}
			System.out.println("游戏继续");
		}
		
	}
}
