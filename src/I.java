//Anas Ahmad

public class I extends tetromino{                  // 1 for I
	
	private int position;
	
	public I(int topleftx, int toplefty, board temp)
	{	
		super("I", topleftx, toplefty, temp);	
		position = 0;
	}
	
	public int[] getDimensionsx()
	{
		return horizontal;
	}
	
	public int[] getDimensionsy()
	{
		return vertical;
	}
	
	
	public void Clockwise(board temp)									//can it go clockwise without colliding
	{
		int temp1 [] = new int [4];
		int temp2 [] = new int [4];
		
		if(Math.abs(position) % 2 == 0)
		{
			temp2[0] = horizontal[0] - 1;
			temp2[1] = horizontal[1];
			temp2[2] = horizontal[2] + 1;
			temp2[3] = horizontal[3] + 2;
			
			temp1[0] = vertical[0] + 2;
			temp1[1] = vertical[1] + 1;
			temp1[2] = vertical[2];
			temp1[3] = vertical[3] - 1;
		}
		
		else if(Math.abs(position) % 2 == 1)
		{
			temp2[0] = horizontal[0] + 1;
			temp2[1] = horizontal[1];
			temp2[2] = horizontal[2] - 1;
			temp2[3] = horizontal[3] - 2;
			
			temp1[0] = vertical[0] - 2;
			temp1[1] = vertical[1] - 1;
			temp1[2] = vertical[2];
			temp1[3] = vertical[3] + 1;
		}
		
		if(temp.didCollide(temp1, temp2, 1))
			return;
		
		position++;
		
		temp.setInDimensions(vertical, horizontal, 0);
		
		vertical = temp1;
		horizontal = temp2;
		
		temp.setInDimensions(vertical, horizontal, 1);
	}

	
	public void antiClockwise(board temp)								//can it go anti clockwise without colliding
	{
		int temp1 [] = new int [4];
		int temp2 [] = new int [4];
		
		if(Math.abs(position) % 2 == 0)
		{
			temp2[0] = horizontal[0] - 1;
			temp2[1] = horizontal[1];
			temp2[2] = horizontal[2] + 1;
			temp2[3] = horizontal[3] + 2;
			
			temp1[0] = vertical[0] + 2;
			temp1[1] = vertical[1] + 1;
			temp1[2] = vertical[2];
			temp1[3] = vertical[3] - 1;
		}
		
		else if(Math.abs(position) % 2 == 1)
		{
			temp2[0] = horizontal[0] + 1;
			temp2[1] = horizontal[1];
			temp2[2] = horizontal[2] - 1;
			temp2[3] = horizontal[3] - 2;
			
			temp1[0] = vertical[0] - 2;
			temp1[1] = vertical[1] - 1;
			temp1[2] = vertical[2];
			temp1[3] = vertical[3] + 1;
		}
		
		
		if(temp.didCollide(temp1, temp2, 1))
			return;

		position++;

		
		temp.setInDimensions(vertical, horizontal, 0);
		
		vertical = temp1;
		horizontal = temp2;
		
		temp.setInDimensions(vertical, horizontal, 1);		
	}
	
	
	
//	public void Clockwise(board temp)
//	{
//		if(canClockwise(temp) == false)
//			return;
//		
//		
//		temp.setInDimensions(vertical, horizontal, 0);
//		
//		if(Math.abs(position) % 2 == 0)
//		{
//			horizontal[0] = horizontal[0] - 1;
//			horizontal[1] = horizontal[1];
//			horizontal[2] = horizontal[2] + 1;
//			horizontal[3] = horizontal[3] + 2;
//			
//			vertical[0] = vertical[0] + 2;
//			vertical[1] = vertical[1] + 1;
//			vertical[2] = vertical[2];
//			vertical[3] = vertical[3] - 1;
//		}
//		
//		else if(Math.abs(position) % 2 == 1)
//		{
//			horizontal[0] = horizontal[0] + 1;
//			horizontal[1] = horizontal[1];
//			horizontal[2] = horizontal[2] - 1;
//			horizontal[3] = horizontal[3] - 2;
//			
//			vertical[0] = vertical[0] - 2;
//			vertical[1] = vertical[1] - 1;
//			vertical[2] = vertical[2];
//			vertical[3] = vertical[3] + 1;
//		}
//	
//		temp.setInDimensions(vertical, horizontal, 1);
//		
//		position++;
//	}
	
//	public void antiClockwise(board temp)
//	{
//		
//		temp.setInDimensions(vertical, horizontal, 0);
//		
//		if(Math.abs(position) % 2 == 0)
//		{
//			horizontal[0] = horizontal[0] - 1;
//			horizontal[1] = horizontal[1];
//			horizontal[2] = horizontal[2] + 1;
//			horizontal[3] = horizontal[3] + 2;
//			
//			vertical[0] = vertical[0] - 2;
//			vertical[1] = vertical[1] - 1;
//			vertical[2] = vertical[2];
//			vertical[3] = vertical[3] + 1;
//		}
//		
//		else if(Math.abs(position) % 2 == 1)
//		{
//			horizontal[0] = horizontal[0] + 1;
//			horizontal[1] = horizontal[1];
//			horizontal[2] = horizontal[2] - 1;
//			horizontal[3] = horizontal[3] - 2;
//			
//			vertical[0] = vertical[0] + 2;
//			vertical[1] = vertical[1] + 1;
//			vertical[2] = vertical[2];
//			vertical[3] = vertical[3] - 1;
//		}
//		
//		temp.setInDimensions(vertical, horizontal, 1);
//		
//		position--;
//		
//	}
	
	
}