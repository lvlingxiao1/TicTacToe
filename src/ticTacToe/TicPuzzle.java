package ticTacToe;

import java.util.ArrayList;

public class TicPuzzle {
	private TicUnit[][] icUnits = new TicUnit[3][3];
	
	public TicPuzzle() {
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				icUnits[i][j] = new TicUnit();
			}
		}
	}
	
	public boolean isWinner(int x, int y, int state) {
		return (icUnits[x][0].getState() == icUnits[x][1].getState() && icUnits[x][0].getState() == icUnits[x][2].getState()) ||
				(icUnits[0][y].getState() == icUnits[1][y].getState() && icUnits[0][y].getState() == icUnits[2][y].getState()) ||
				((x != 1 && y != 1) || (x == 1 && y == 1) && ((icUnits[1][1].getState() == icUnits[0][0].getState() && icUnits[2][2].getState() == icUnits[1][1].getState()) ||
						(icUnits[1][1].getState() == icUnits[0][2].getState() && icUnits[1][1].getState() == icUnits[2][0].getState())));
	}
	
	public int setMove(int x, int y, int state) {
		if (icUnits[x][y].getState() == 0) {
			icUnits[x][y].setState(state);
		}else {
			return -1;
		}
		if (isWinner(x,y,state)) {
			return state;
		}
		return 0;
	}
	
	public TicUnit[][] getIcUnits(){
		return icUnits;
	}
	
	public String toString() {
		String stringForm = "";
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				stringForm += icUnits[i][j] + "  ";
			}
			stringForm += "\n";
		}
		stringForm += "============================";
		return stringForm;
	}
}
