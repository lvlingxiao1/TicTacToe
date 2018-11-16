package ticTacToe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AiInfo {
	int[] used, wins;
	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();
	ArrayList<Double> percent = new ArrayList<Double>();
	
	public AiInfo() throws NumberFormatException, IOException {
		FileReader fr = new FileReader("aiScore.txt");
		BufferedReader scoreF = new BufferedReader(fr);
		int score;
		used = new int[9];
		wins = new int[9];
		for (int i = 0; i < 9; i ++) {
			score = Integer.parseInt(scoreF.readLine());
			used[i] = score;
		}
		for (int i = 0; i < 9; i ++) {
			score = Integer.parseInt(scoreF.readLine());
			wins[i] = score;
		}
		setMoves();
	}
	
	public void setMoves() {
		x = new ArrayList<Integer>();
		y = new ArrayList<Integer>();
		percent = new ArrayList<Double>();
		
		for(int i = 0; i < 9; i ++ ) {
			x.add(i%3);
			y.add(i/3);
			percent.add((double)wins[i] / used[i]);
		}
		
	}
	
	public int[] getBestMove(TicPuzzle tp) {
		TicUnit[][] ticUnits = tp.getIcUnits();
		for(int i = 0; i < x.size(); i ++ ) {
			if (ticUnits[x.get(i)][y.get(i)].getState() == 0) {
				return new int[]{x.get(i),y.get(i)};
			}
		}
		return new int[] {0,0};
	}

}
