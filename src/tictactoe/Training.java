package tictactoe;

import java.util.ArrayList;

public class Training {
	GameTree decision;
	GameTreeNode node;
	GameBoard p;
	int count;

	public Training() {
		count=0;
	}

	public void run() {
		p = new GameBoard();
		node = new GameTreeNode();
		decision=new GameTree(node);
		gameRec(node);

	}

	private void gameRec(GameTreeNode curr) {
		/**
		 * 0=not finished 1=p1 wins 2=p2 wins 3=draw
		 */
		int result = p.getResult();
		if (result > 0) {
			curr.updateScore(result);
			System.out.println(""+count+" Game Over, result="+result);
			count++;
		} else {
			ArrayList<Integer> possibleMoves = p.getPossibleMoves();
			//System.out.println(possibleMoves);
			for (int i : possibleMoves) {
				int opposite = 1;
				if (curr.player == 1) {
					opposite = 2;
				}
				GameTreeNode newNode = new GameTreeNode(curr, opposite, i);
				curr.addChild(newNode, i);
				p.setMove(i, opposite);
				gameRec(newNode);
				p.revertMove(i);
			}

		}
	}

}
