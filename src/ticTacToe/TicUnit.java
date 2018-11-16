package ticTacToe;

public class TicUnit {
	public static final int EMPTY = 0, XSTATE = 1, OSTATE = 2;
	private int state;
	
	public TicUnit() {
		state = 0;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String toString() {
		if (state==0) {
			return " ";
		} else if (state==1) {
			return "X";
		} else {
			return "O";
		}
	}
}
