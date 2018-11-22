package task1;

public class Card {
	private Integer rank;
	private String suit;
	private Boolean taken;
	
	public Card(int r, String s) {
		setter(r, s);
		taken = false;
	}
	
	private void setter(int r, String s) {
		rank = r;
		suit = s;
	}
	
	public void getter() {
		System.out.println("RANK & SUIT: " + rank.toString() + "-" + suit);
	}
		
	public int get_rank() {
		return (int) rank.intValue();
	}
	
	public String get_suit() {
		return suit;
	}
	
	public void change_state() {
		this.taken = !taken;
	}
}
