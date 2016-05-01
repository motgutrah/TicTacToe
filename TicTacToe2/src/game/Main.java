package game;

public class Main {
	
	public static void main(String[] args)
	{
		
		Board gameBoard = new Board();
	System.out.println(gameBoard.toString());
	
	AiPlayer ai =  new AiPlayer(gameBoard);
	AiPlayer ai2 =  new AiPlayer(gameBoard);
	ai.setPlay('X');
	ai2.setPlay('O');
	boolean notOver = true;
	int turnTaker =0;
	int[] moveHolder;
	while(notOver)
	{
		if(turnTaker % 2 == 0)
		{
			moveHolder = ai.move();
			gameBoard.setMove(moveHolder[0], moveHolder[1], 'X');
		}
		else
		{
			moveHolder = ai2.move();
			gameBoard.setMove(moveHolder[0], moveHolder[1], 'O');
		}
		
		/*if((gameBoard.winLose('X', moveHolder[0], moveHolder[1]) == true))
		{
			notOver = false;
			System.out.println("X wins");
		}
		else if (( gameBoard.winLose('O', moveHolder[0], moveHolder[1]) == true))
		{
			notOver = false;
			System.out.println("O wins");
		}
		else */if(gameBoard.isDraw() == true)
		{
			notOver = false;
			System.out.println("it is a draw");
		}
		
		
	}
	System.out.println(gameBoard.toString());
	}
}
