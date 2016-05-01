package game;

import java.util.*;

public class AiPlayer {
	char player;
	Spot[][] board;
	char opponent;

	public AiPlayer(Board tic)
	{
		board = tic.game;//this gives the board to the ai player.

	}

	public void setPlay(char team)//sets the player and the opponent
	{	
		player = team;
		if(team == 'X')
		{
			opponent = 'O';
		}
		else
		{
			opponent = 'X';
		}

	}

	public int[] move()//this will call the minimax to generate the moves and choose.
	{
		int[] mover = minimax(0,player);
		int[] realMove = new int[2];
		realMove[0] = mover[1];
		realMove[1] = mover[2];
		return  realMove;


	}

	public int[] minimax(int depth,char currentPlayer)
	{
		List<int[]> availMoves = new ArrayList<int[]>();
		int miniMaxer;//max when calculating our moves min when calculating opponents moves.
		int score;//current score of where we are.
		int brow = -1;// best row we can choose.
		int bcol = -1;//best column we can choose. 
		if(player == currentPlayer)//if it is this ai then we want to maximize else we minimize.
		{
			miniMaxer = Integer.MAX_VALUE;
		}
		else
		{
			miniMaxer = Integer.MIN_VALUE;
		}
		availMoves = generateMoves();
		
		if(availMoves.isEmpty() || depth == 2)
		{
			miniMaxer = scorer();
		}
		else
		{
		for(int i = 0; i< availMoves.size();i++)
		{
			int[] tryer = availMoves.get(i);
			board[tryer[0]][tryer[1]].setData(currentPlayer);
			if(currentPlayer == player)
			{
				score = minimax(depth + 1,opponent)[0];
				if(score > miniMaxer)
				{
					miniMaxer = score;
					brow = tryer[0];
					bcol = tryer[1];
				}
			}
			else
			{
				score = minimax(depth + 1, player)[0];
				if(score < miniMaxer)
				{
					miniMaxer = score;
					brow = tryer[0];
					bcol = tryer[1];
				}
			}
			board[tryer[0]][tryer[1]].setData(' ');
		}
		}
				return new int[] {miniMaxer, brow, bcol};
	}

	public List<int[]> generateMoves()
	{
		List<int[]> moves = new ArrayList<int[]>(); 
		for(int i = 0; i<3;i++)
		{
			for(int j = 0; j<3; j++)
			{
				if(board[i][j].getData() == ' ')
				{
					
				}
			}
		}
		return moves;
	}
	
	private int scorer() {
		int score = 0;
		// Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
		score += scoreLine(0, 0, 0, 1, 0, 2);  // row 0
		score += scoreLine(1, 0, 1, 1, 1, 2);  // row 1
		score += scoreLine(2, 0, 2, 1, 2, 2);  // row 2
		score += scoreLine(0, 0, 1, 0, 2, 0);  // col 0
		score += scoreLine(0, 1, 1, 1, 2, 1);  // col 1
		score += scoreLine(0, 2, 1, 2, 2, 2);  // col 2
		score += scoreLine(0, 0, 1, 1, 2, 2);  // diagonal
		score += scoreLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
		return score;
	}
	
	private int scoreLine(int row1, int col1, int row2, int col2, int row3, int col3) {
		int score = 0;

		// First cell
		if (board[row1][col1].getData() == player) {
			score = 1;
		} else if (board[row1][col1].getData() == opponent) {
			score = -1;
		}

		// Second cell
		if (board[row2][col2].getData() == player) {
			if (score == 1) {   // cell1 is player
				score = 10;
			} else if (score == -1) {  // cell1 is opponent
				return 0;
			} else {  // cell1 is empty
				score = 1;
			}
		} else if (board[row2][col2].getData() ==opponent) {
			if (score == -1) { // cell1 is opponent
				score = -10;
			} else if (score == 1) { // cell1 is player
				return 0;
			} else {  // cell1 is empty
				score = -1;
			}
		}

		// Third cell
		if (board[row3][col3].getData() == player) {
			if (score > 0) {  
				score *= 10;
			} else if (score < 0) { 
				return 0;
			} else {  
				score = 1;
			}
		} else if (board[row3][col3].getData() == opponent) {
			if (score < 0) {  
				score *= 10;
			} else if (score > 1) {  
				return 0;
			} else { 
				score = -1;
			}
		}
		return score;
	}

}

