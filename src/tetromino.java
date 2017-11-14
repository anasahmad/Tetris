//Anas Ahmad

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tetromino extends JFrame
{
	private String type;
	private int topx;
	private int topy;
	private int rightmost;
	private int leftmost;
	private boolean collided;
	private int numberAssigned;
	private boolean gameover;
	private boolean reachedBottom;					//reached the bottom or touched another tetromino
	protected int [] vertical = new int[4];					//the vertical and horizontal coordinates of the tetromino
	protected int [] horizontal = new int[4];
	
	
	public tetromino(String typ, int topx, int topy, board temp)
	{
		this.topx = topx;
		this.topy = topy;
		this.type = typ;
		this.reachedBottom = false;
		collided = false;
		gameover = false;
		
		System.out.println("Constructor");
		
		
		switch(type)
		{
		case "I":
			System.out.println("topx: " + topx + "topy: " + topy);
			horizontal[0] = topx;
			horizontal[1] = topx;
			horizontal[2] = topx;
			horizontal[3] = topx;
			
			vertical[0] = topy;
			vertical[1] = topy + 1;
			vertical[2] = topy + 2;
			vertical[3] = topy + 3;
			numberAssigned = 1;
			leftmost = topx;
			rightmost = topx;
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned) == false)
				temp.setInDimensions(vertical, horizontal, 1);
			
			else
				collided = true;
			
			break;
			
		case "T":
			System.out.println("topx: " + topx + "topy: " + topy);

			horizontal[0] = topx;
			horizontal[1] = topx + 1;
			horizontal[2] = topx + 2;
			horizontal[3] = topx + 1;
			
			vertical[0] = topy;
			vertical[1] = topy;
			vertical[2] = topy;
			vertical[3] = topy + 1;
			numberAssigned = 2;
			leftmost = topx;
			rightmost = topx + 2;
			
			
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned) == false)
				temp.setInDimensions(vertical, horizontal, 2);
			
			else
				collided = true;
			
			break;
		
		case "O":
			System.out.println("topx: " + topx + "topy: " + topy);

			horizontal[0] = topx;
			horizontal[1] = topx + 1;
			horizontal[2] = topx;
			horizontal[3] = topx + 1;
			
			vertical[0] = topy;
			vertical[1] = topy;
			vertical[2] = topy + 1;
			vertical[3] = topy + 1;
			numberAssigned = 3;
			leftmost = topx;
			rightmost = topx + 1;
			
			
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned) == false)
				temp.setInDimensions(vertical, horizontal, 3);
			
			else
				collided = true;
			
			break;
		
		case "L":
			System.out.println("topx: " + topx + "topy: " + topy);

			horizontal[0] = topx;
			horizontal[1] = topx;
			horizontal[2] = topx;
			horizontal[3] = topx + 1;
			
			vertical[0] = topy;
			vertical[1] = topy + 1;
			vertical[2] = topy + 2;
			vertical[3] = topy + 2;
			numberAssigned = 4;
			leftmost = topx;
			rightmost = topx + 1;
			
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned) == false)
				temp.setInDimensions(vertical, horizontal, 4);
			
			else
				collided = true;
			
			break;
			
		case "J":
			System.out.println("topx: " + topx + "topy: " + topy);

			horizontal[0] = topx;
			horizontal[1] = topx;
			horizontal[2] = topx;
			horizontal[3] = topx - 1;
			
			vertical[0] = topy;
			vertical[1] = topy + 1;
			vertical[2] = topy + 2;
			vertical[3] = topy + 2;
			numberAssigned = 5;
			leftmost = topx - 1;
			rightmost = topx;
			
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned) == false)
				temp.setInDimensions(vertical, horizontal, 5);
			
			else
				collided = true;
			
			break;
		
		case "S":
			System.out.println("topx: " + topx + "topy: " + topy);

			horizontal[0] = topx;
			horizontal[1] = topx - 1;
			horizontal[2] = topx - 1;
			horizontal[3] = topx - 2;
			
			vertical[0] = topy;
			vertical[1] = topy;
			vertical[2] = topy + 1;
			vertical[3] = topy + 1;
			numberAssigned = 6;
			leftmost = topx - 2;
			rightmost = topx;
			
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned) == false)
				temp.setInDimensions(vertical, horizontal, 6);
			
			else
				collided = true;
			
			break;
			
		case "Z":
			System.out.println("topx: " + topx + "topy: " + topy);

			horizontal[0] = topx;
			horizontal[1] = topx + 1;
			horizontal[2] = topx + 1;
			horizontal[3] = topx + 2;
			
			vertical[0] = topy;
			vertical[1] = topy;
			vertical[2] = topy + 1;
			vertical[3] = topy + 1;
			numberAssigned = 7;
			leftmost = topx;
			rightmost = topx + 2;
			
			if(temp.gameover(vertical, horizontal) == true)
			{
				JOptionPane.showMessageDialog(null, "GAME OVER\n");
				gameover = true;
			
			}
			
			if(temp.didCollide(vertical, horizontal, numberAssigned))
				temp.setInDimensions(vertical, horizontal, 7);
			
			else
				collided = true;
			
			break;
		}
		
		System.out.println("Horizontal[0] " + horizontal[0] + " Vertical[0] " + vertical[0]);
		System.out.println("Horizontal[1] " + horizontal[1] + " Vertical[1] " + vertical[1]);
		System.out.println("Horizontal[2] " + horizontal[2] + " Vertical[2] " + vertical[2]);
		System.out.println("Horizontal[3] " + horizontal[3] + " Vertical[3] " + vertical[3]);

		
		
	}
	
	public String getTheType()
	{
		return this.type;
	}
	
	public int getX()
	{
		return topx;
	}
	
	public int getY()
	{
		return topy;
	}

	public int [] getVertical()
	{
		return vertical;
	}
	
	
	public int [] getHorizontal()
	{
		return horizontal;
	}
	
	public boolean getCollided()
	{
		return collided;
	}
	
	public boolean getReachedBottom()
	{
		return reachedBottom;
	}
	
	public boolean getGameover()
	{
		return gameover;
	}
	
	public int numAssigned()
	{
		return numberAssigned;
	}
	
	
	public boolean canLeft(board temp)
	{
		if(horizontal[0] == 0 || horizontal[1] == 0 || horizontal[2] == 0 || horizontal[3] == 0)
			return false;
		
		int [] temp1 = new int [4];
		for(int i = 0; i < 4; i++)
		{
			temp1[i] = horizontal[i] - 1;
		}
		
		if(temp.didCollide(vertical, temp1, numberAssigned) == true)
			return false;
		
		System.out.println("Can left!");

		return true;
	}
	
	
	public boolean canRight(board temp)
	{
		if(horizontal[0] == 9 || horizontal[1] == 9 || horizontal[2] == 9 || horizontal[3] == 9)
			return false;
		
		int [] temp1 = new int [4];
		for(int i = 0; i < 4; i++)
		{
			temp1[i] = horizontal[i] + 1;
		}
		
		if(temp.didCollide(vertical, temp1, numberAssigned) == true)
			return false;
		
		
		System.out.println("Can right!");
		return true;
	}

	
	

	public boolean moveLeft(board temp)
	{
		if(canLeft(temp) == false)
			return false;
		
		temp.setInDimensions(vertical, horizontal, 0);					//set to zeros on the board.
		
		for(int i = 0; i < 4; i++)
			horizontal[i]--;
		
		
		temp.setInDimensions(vertical, horizontal, numberAssigned);
		return true;
	}
	
	public void moveRight(board temp)
	{
		if(horizontal[0] == 9 || horizontal[1] == 9 || horizontal[2] == 9 || horizontal[3] == 9)
			return;
		
		temp.setInDimensions(vertical, horizontal, 0);
		
		for(int i = 0; i < 4; i++)
			horizontal[i]++;
		
		temp.setInDimensions(vertical, horizontal, numberAssigned);
	}
	
	
	public void Clockwise(board temp)
	{
		
        
	}
	
	public void antiClockwise(board temp)
	{
		
	}
	
	public void oneDown(board temp)
	{
		
		System.out.println("Entered oneDown");
		
		int [][] tmp = temp.getDimensions();
		
		temp.setInDimensions(vertical, horizontal, 0);
		
		
		if(vertical[0] + 1 == 20 || vertical[1] + 1 == 20 || vertical[2] + 1 == 20 || vertical[3] + 1 == 20 || 
				tmp[vertical[0] + 1][horizontal[0]] != 0 || tmp[vertical[1] + 1][horizontal[1]] != 0 || 
				tmp[vertical[2] + 1][horizontal[2]] != 0 || tmp[vertical[3] + 1][horizontal[3]] != 0)
		{
			reachedBottom = true;
		}
			
		
		
		else
		{
			for(int i = 0; i < 4; i++)
			vertical[i]++;
		}
		
		
		switch(type)
		
		{
		
			case "I":
				temp.setInDimensions(vertical, horizontal, 1);
				break;
				
			case "T":
				temp.setInDimensions(vertical, horizontal, 2);
				break;
	
				
			case "O":
				temp.setInDimensions(vertical, horizontal, 3);
				break;
	
				
			case "L":
				temp.setInDimensions(vertical, horizontal, 4);
				break;
	
				
			case "J":
				temp.setInDimensions(vertical, horizontal, 5);
				break;
	
				
			case "S":
				temp.setInDimensions(vertical, horizontal, 6);
				break;
	
				
			case "Z":
				temp.setInDimensions(vertical, horizontal, 7);
				break;

		}
	
		
	}
	
	

}
