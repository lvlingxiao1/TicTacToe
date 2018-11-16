package ticTacToe;

public class GameTree {
	GameTreeNode root;
	public GameTree() {
		root=new GameTreeNode();
		root.level=0;
		root.genTree();
	}
}
