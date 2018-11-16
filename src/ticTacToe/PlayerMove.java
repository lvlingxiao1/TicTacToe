package ticTacToe;

import java.util.Scanner;

public class PlayerMove implements CommandMove {
	private TicPuzzle tp = null;
	private Scanner scanner;
	private int state;
	
	public PlayerMove(TicPuzzle tp, int state) {
		this.tp = tp;
		this.state = state;
		scanner=new Scanner(System.in);
	}

	@Override
	public void excute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int move() {
		System.out.println("x: ");
		String xs = scanner.nextLine();
		Integer.parseInt(xs);
		System.out.println("y: ");
		String ys = scanner.nextLine();
		int returnInt =  tp.setMove(Integer.parseInt(xs) - 1, Integer.parseInt(ys) - 1, state);
		System.out.println(tp);
		return returnInt;
	}

	@Override
	public void isWin() {
		System.out.println(state + " Win");
	}

}
