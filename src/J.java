//Anas Ahmad

public class J extends tetromino{			//5 to J
	
	
	public J(int topleftx, int toplefty, board temp)
	{	
		super("J", topleftx, toplefty, temp);	
	}
	
	
	public int[] getDimensionsx()
	{
		return horizontal;
	}
	
	public int[] getDimensionsy()
	{
		return vertical;
	}

//	public void oneDown(board temp)
//	{
//		int [][] tmp = temp.getDimensions();
//		
//		if(tmp[horizontal[0]][vertical[0] + 1] == 1 || tmp[horizontal[1]][vertical[1] + 1] == 1 || tmp[horizontal[2]][vertical[2] + 1] == 1 ||tmp[horizontal[3]][vertical[3] + 1] == 1)
//			return;
//		
//		for(int i = 0; i < 4; i++)
//			vertical[i]++;
//		
//		temp.setInDimensions(horizontal, vertical, 0);
//		temp.setInDimensions(horizontal, vertical, 5);
//		
//	}
	
}