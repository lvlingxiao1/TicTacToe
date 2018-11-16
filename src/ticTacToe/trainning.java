package ticTacToe;

import java.util.ArrayList;

public class trainning {
	ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
	ArrayList<Integer> moveHistory = new ArrayList<Integer>();
	GameTree score;
	TicPuzzle p;
	
	public void run() {
		p=new TicPuzzle();
		score=new GameTree();
	}
	
	public void gameRec(ArrayList<Integer> possibleMoves, int player, ArrayList<Integer> moveHistory) {
		if (possibleMoves.size()==0) {
			updateScore(moveHistory);
		} else {
			for (int i:possibleMoves) {
				p.setMove(i/3,i%3,player);
				ArrayList<Integer> a=p.getPossibleMoves();
				if (player==1) {
					player=2;
				}else {
					player=1;
				}
				moveHistory.add(i);
				gameRec(a,player,moveHistory);
				moveHistory.remove(moveHistory.size()-1);
			}
			
		}
	}
	
	public void updateScore(ArrayList<Integer> mh) {
		GameTreeNode x=score.root;
		for (int i=0;i<9;i++) {
			x=x.child[i];
			x.score++;
		}
	}
	
}
