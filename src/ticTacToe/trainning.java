package ticTacToe;

import java.util.ArrayList;

public class trainning {
	ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
	int[][][][][][][][][] score=new int[9][9][9][9][9][9][9][9][9];
	TicPuzzle p;
	
	public void run() {
		p=new TicPuzzle();
	}
	
	public void gameRec(ArrayList<Integer> possibleMoves, int player) {
		if (possibleMoves.size()==0) {
			updateScore();
		} else {
			for (int i:possibleMoves) {
				p.setMove(i/3,i%3,player);
			}
			ArrayList<Integer> a=p.getPossibleMoves();
			if (player==1) {
				player=2;
			}else {
				player=1;
			}
			gameRec(a,player);
		}
	}
	
	public ArrayList<Integer> getPossibleMove(){
		return possibleMoves;
	}
	
	public void updateScore() {
		
	}
}
