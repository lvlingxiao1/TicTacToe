package ticTacToe;

public class GameTreeNode{
	GameTreeNode[] child;
	int score;
	int level;
	public GameTreeNode() {
		child=new GameTreeNode[9];
	}
	public void genTree() {
		GameTreeNode x;
		if (level<9) {
			for (int i=0;i<9;i++) {
				x=new GameTreeNode();
				x.level=level+1;
				x.genTree();
			}
		}
	}
}