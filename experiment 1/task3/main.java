package task3;

import java.util.Scanner;

public class main {
	public static void print_board(int[] record) {
		System.out.println(" ----------- ");
		for(int i = 0; i < 9; i++) {
			System.out.print("|");
			if(record[i] == 1) {
				System.out.print(" O ");
			}else if(record[i] == -1) {
				System.out.print(" X ");
			}else if(record[i] == 0) {
				System.out.print("   ");
			}
			if((i+1) % 3 == 0) {
				System.out.println("|");
				System.out.println(" ----------- ");
			}			
		}
	}
	
	public static int check_result(int r) {
		if(r == 3) {
			return 1;
		}else if(r == -3){
			return 2;
		}else{
			return 0;
		}
	}
	
	public static void print_result(int[] r) {
		Boolean res = false;
		int[] tmp = new int[8];
		tmp[0] = r[0] + r[1] + r[2];
		tmp[1] = r[3] + r[4] + r[5];
		tmp[2] = r[6] + r[7] + r[8];
		tmp[3] = r[0] + r[3] + r[6];
		tmp[4] = r[1] + r[4] + r[7];
		tmp[5] = r[2] + r[5] + r[8];
		tmp[6] = r[0] + r[4] + r[7];
		tmp[7] = r[2] + r[4] + r[6];
 		
		for(int i = 0; i < 8; i++) {
			int check_res = check_result(tmp[i]);
			if(check_res == 1) {
				System.out.println("Player1 win.");
				System.exit(0);
			}else if(check_res == 2) {
				System.out.println("Player2 win.");
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] player1 = new int[5];
		int[] player2 = new int[5];
		int flag = 1;
		int[] record = {0,0,0,0,0,0,0,0,0};
		while(true) {
			System.out.println("请玩家输入坐标（格式为“0 0”）");
			Scanner in =new Scanner(System.in);
	        int a=in.nextInt();
	        int b=in.nextInt();
	        int id = a*3 + b;
	        record[id] = flag;
	        print_board(record);
	        print_result(record);
	        flag = -flag;
		}
        
	}
}
