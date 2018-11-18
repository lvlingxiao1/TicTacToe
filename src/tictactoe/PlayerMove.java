package tictactoe;

import java.util.Scanner;

public class PlayerMove extends CommandMove {

	private Scanner in;
	
	public PlayerMove(GameBoard board, int pNum) {
		super(board,pNum);
		in=new Scanner(System.in);
	}

	@Override
	public int move() {
		boolean inputInvalid=true;
		int x = -1, y = -1;
		while (inputInvalid) {
			try {
				System.out.print("x: ");
				x = Integer.parseInt(in.nextLine());
				System.out.print("y: ");
				y = Integer.parseInt(in.nextLine());
				if (x<1 || x>3 || y<1 || y>3 || !board.isAvailable(x-1,y-1)) {
					System.out.println("Invalid input.");
				} else {
					inputInvalid = false;
				}
			} catch (Exception e) {
				System.out.println("Invalid input.");
			}
		}
		
		int position = (x-1) +(y-1)*3;
		board.setMove(position, pNum);
		System.out.print(board);
		doIWin();
		return position;
	}
}
