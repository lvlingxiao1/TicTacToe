package tictactoe;

import java.io.Serializable;

public class GameTreeNode implements Serializable{
	private static final long serialVersionUID = -2858031780723800001L;
	GameTreeNode[] child;
	int player, numChildren, result, position;
	double winRate,drawRate;
	GameTreeNode parent;
	
	public GameTreeNode() {
		child=new GameTreeNode[9];
		position=-1;
		numChildren=0;
		player=2;
		winRate=0;
		drawRate=0;
	}
	
	public GameTreeNode(GameTreeNode parent, int player, int position) {
		this();
		this.parent=parent;
		this.position=position;
		this.player=player;
	}
	
	public void updateScore(int result) {
		GameTreeNode curr=this;
		this.result=result;
		if (result==player) {
			winRate=1.0;
		} else if (result == 3) {
			drawRate=1.0;
		}
		while (curr.parent!=null) {
			GameTreeNode p=curr.parent;
//			p.drawRate=(p.drawRate*(p.numChildren-1)+curr.drawRate)/p.numChildren;
//			p.winRate=(p.winRate*(p.numChildren-1)+(1-curr.drawRate-curr.winRate))/p.numChildren;
			
			//==========method1===================
			/*
			int count=0;
			double twin=0;
			double tdraw=0;
			boolean instantDeath=false;
			for (int i=0;i<9;i++) {
				if (p.child[i]!=null) {
					if (p.child[i].winRate == 1.0) {
						p.winRate = 0;
						p.drawRate = 0;
						instantDeath = true;
						break;
					}
					twin+=1-p.child[i].winRate-p.child[i].drawRate;
					tdraw+=p.child[i].drawRate;
					count++;
				}
			}
			if (!instantDeath) {
				p.winRate=twin/count;
				p.drawRate=tdraw/count;
			}
			*/
			
			//============method2=====================
			int best=p.getBestChoice();
			p.winRate = 1-p.child[best].winRate - p.child[best].drawRate;
			p.drawRate = p.child[best].drawRate;
			curr=p;
		}	
	}
	
	public int getBestChoice() {
		int bestChoice=-1;
		double bestWinRate = 0, bestDrawRate = 0;
		for (int i=0;i<9;i++) {
			if (child[i]!= null) {
				if (child[i].winRate>bestWinRate) {
					bestWinRate=child[i].winRate;
					bestChoice=i;
				}
			}
		}
		if (bestChoice != -1) {
			return bestChoice;
		}
		for (int i=0;i<9;i++) {
			if (child[i]!= null) {
				if (child[i].drawRate>bestDrawRate) {
					bestDrawRate=child[i].drawRate;
					bestChoice=i;
				}
			}
		}
		if (bestChoice != -1) {
			return bestChoice;
		}
		for (int i=0;i<9;i++) {
			if (child[i]!= null) {
				return i;
			}
		}
		System.out.println("WTF: no available best choice!");
		return -1;
	}

	public void addChild(GameTreeNode newNode, int position) {
		child[position]=newNode;
		numChildren+=1;		
	}
}