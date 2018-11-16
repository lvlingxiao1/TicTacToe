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
		boolean i = false, i2 = false;
		if (((x == 0 && y == 0) || (x == 1 && y == 1) || (x == 2 && y == 2))) {
			i = (icUnits[1][1].getState() == icUnits[0][0].getState() && icUnits[2][2].getState() == icUnits[1][1].getState());
		}
		if (((x == 2 && y == 0) || (x == 1 && y == 1) || (x == 0 && y == 2))) {
			i2 = (icUnits[1][1].getState() == icUnits[0][0].getState() && icUnits[2][2].getState() == icUnits[1][1].getState());
		}
		return (icUnits[x][0].getState() == icUnits[x][1].getState() && icUnits[x][0].getState() == icUnits[x][2].getState()) ||
				(icUnits[0][y].getState() == icUnits[1][y].getState() && icUnits[0][y].getState() == icUnits[2][y].getState()) ||
				i || i2;
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
	
	public ArrayList<Integer> getPossibleMoves() {
		ArrayList<Integer> a=new ArrayList<Integer>();
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if (icUnits[i][j].getState()==0) {
					a.add(i*3+j);
				}
			}
		}
		return a;
	}
	
	public String toString() {
		String stringForm = "";
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				stringForm += icUnits[i][j].getState() + "  ";
			}
			stringForm += "\n";
		}
		return stringForm;
	}
}
