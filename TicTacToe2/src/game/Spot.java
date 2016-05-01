package game;

/*
 * the spot class is used for board. the board is made of a 2d array of spots
 * 
 */
public class Spot {
	char data;
	int row;
	int col;
	
	public Spot(int r, int c)
	{
		data = ' ';
		row = r;
		col = c;
	}
	
	public void setData(char d)
	{
		data = d;
		
	}
	
	public char getData()
	{
		return data;
	}
	
	public String toString()
	{
		String s = new String();
		if(data == 'X')
		{
			s = " X ";
		}
		else 
			if(data == 'O')
			{
				s = " O ";
			}
			else
				s = "   ";
		return s;
		
	}

}
