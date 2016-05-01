package game;

public class Board 
{
	int row = 3;
	int col = 3;
	Spot[][] game;
	
	public Board()
	{
		game = new Spot[3][3];
		for(int i = 0; i<3;i++)
		{
			for(int j = 0; j<3;j++)
			{
				game[i][j] = new Spot(i,j);
			}
		}
	}
	
	public void setMove(int r,int c,char move)
	{
		game[r][c].setData(move);
		
	}
	
	
	public boolean isDraw()
	{
		for(int i = 0; i<3;i++)
		{
			for(int j = 0; j<3;j++)
			{
				
				if(game[i][j].getData() == ' ')
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean winLose(char player, int r, int c)//to be called by move passing in last move
	{
		if((game[r][0].getData() == player) &&  ((game[r][1].getData()) == player) &&  (game[r][2].getData() == game[r][1].getData()))
		{
			return true;
		}
		else
			if((game[0][c].getData() == player) && (game[1][c].getData() == player) &&  (game[2][c].getData() == game[1][c].getData()))
			{
				return true;
			}
			else
				if((game[0][0].getData() == player) && (game[1][1].getData()== player) &&  (game[2][c].getData() == game[2][2].getData()))
				{
					return true;
				}
				else
					if((game[0][2].getData() == player) && (game[1][1].getData()== player) &&  (game[1][1].getData() == game[2][0].getData()))
					{
						return true;
					}
					else
						return false;
		
	}
	
	public String toString()
	{
		String boardState = new String();
		for(int i = 0; i<3;i++)
		{
			for(int j = 0; j<3;j++)
			{
				if(j == 2)
				{
					if(i != 2)
					{
					boardState += game[i][j].toString() + "\n-----------\n";
					}
					
					else
					{
						boardState += game[i][j].toString();
					}
				}
				else
				{
					boardState += game[i][j].toString() + "|";
				}
				
			}
		}
		return boardState;
	}
}
