//Anas Ahmad

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;


public class board extends JFrame implements ActionListener
{
	
	private static int [][] dimensions = new int[20][10];				//the dimensions of the 20x10 grid
	private JLabel [][] mainboard = new JLabel[20][10];			//jlabels on top of the grid
	protected static ArrayList<tetromino> allTetrominos = new ArrayList<tetromino>();
	
	private JPanel head;
	private JPanel boardPanel;
	private JMenuBar menubar;							//Menu bar in top of window
	private JMenu Game;									//Game menu
	private JMenuItem Start_Restart;					//Start/restart menu item
	private JMenuItem eXit;								//exit menu item
	private JMenuItem heLp;								//help menu item
	private JMenuItem About;							//about menu item
	
	private GridLayout layout;							//Make the blocks align

	private JLabel timeText;							//Text notice for time
	private JLabel time;								//time
	private JLabel pointsText;							//Text notice for points
	private JLabel points;	//points
	
	private boolean gaming = true;						//Toggle if the game operation is allowed
	private boolean started = false;					//Toggle if game started to show time
	private long startTime;								//Time started game action
	private int timer = 0;								//timer
	private int score = 0;								//Store the final score of this round
	
	public static boolean isLeft;
	public static boolean isRight;
	public static boolean rotate;
	public static boolean counterRotate;
	
	
	public board()
	{
		super("Tetris");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		menubar = new JMenuBar();
		c.add(menubar);
		
		Game = new JMenu("Game");
		Game.setMnemonic('G');
		menubar.add(Game);
		
		
		Start_Restart = new JMenuItem("Start/Restart");
		KeyStroke ctrlR = KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		Start_Restart.setAccelerator(ctrlR);
		Start_Restart.addActionListener(this);
		Game.add(Start_Restart);
		
		heLp = new JMenuItem("Help");
		KeyStroke ctrlL = KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		heLp.setAccelerator(ctrlL);
		heLp.addActionListener(this);
		Game.add(heLp);
		
		About = new JMenuItem("About");
		KeyStroke ctrlA = KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		About.setAccelerator(ctrlA);
		About.addActionListener(this);
		Game.add(About);
		
		eXit = new JMenuItem("Exit");
		KeyStroke ctrlX = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		eXit.setAccelerator(ctrlX);
		eXit.addActionListener(this);
		Game.add(eXit);
		
		setJMenuBar(menubar);
		
		head = new JPanel();
		c.add(head);
		
		timeText = new JLabel("Time:");
		head.add(timeText);
		
		time = new JLabel("0");
		head.add(time);
		
		pointsText = new JLabel("Points:");
		head.add(timeText);
		
		points = new JLabel("00000");
		head.add(points);
		
		layout = new GridLayout(20,10);
		boardPanel = new JPanel();
		boardPanel.setLayout(layout);
		c.add(boardPanel);
		
		isLeft = false;
		isRight = false;
		rotate = false;
		counterRotate = false;
		
		
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 10; j++)
				{
					dimensions[i][j] = 0;
					mainboard[i][j] = new JLabel();
					mainboard[i][j].setPreferredSize(new Dimension(30, 30));
					//mainboard[i][j].setForeground(Color.white);
					//mainboard[i][j].setBackground(Color.black);
					//mainboard[i][j].setOpaque(true);
					boardPanel.add(mainboard[i][j]);
				}
		
		
		colorScreen();
		setSize(360,700);
		show();
		board temp = this;
		
		//Set timer to refresh time count
		Timer gameTimer = new Timer(250, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				time.setText("" + timer++);
				pointsText.setText("" + score);

				colorScreen();
			}
		});
		
		gameTimer.start();
	
		this.addKeyListener(new keyb());

	}

	
	public static void main(String[] args)
	{
		board tetris = new board();
		newTetro(tetris);
		moveDown(tetris);		
	}
	
	public static int[][] getDimensions()
	{
		return dimensions;
	}
	
	public void setInDimensions(int x[], int y[], int value)			//setting the right value of the specific tetromino
	{
		for(int i = 0; i < 4; i++)
				dimensions[x[i]][y[i]] = value;							
	}
	
	public void setInColors(int x[], int y[], Color color)				//setting the right color according to the specific tetromino
	{
		for(int i = 0; i < 4; i++)
			{
				mainboard[x[i]][y[i]].setBackground(color);
				mainboard[x[i]][y[i]].setOpaque(true);
			}
	}
	
	public boolean didCollide(int x[], int y[], int numberAssigned)
	{
		for(int i = 0; i < 4; i++)
		{
			if(x[i] < 0 || x[i] > 19 || y[i] < 0 || y[i] > 9)			//if it has crossed the borders
			{
				System.out.println("touched the border");
				return true;
			}
			

			
			if(dimensions[x[i]][y[i]] != 0 && dimensions[x[i]][y[i]] != numberAssigned)								//if there is something else present at that place
				{
				System.out.println("collided with tetro");
				return true;
				}
		}
	
		return false;
	}
	
	public boolean gameover(int x[], int y[])
	{
		for(int i = 0; i < 4; i++)
		{
			System.out.println("gameover -> x[" + i + "]: " + x[i] + " " + "y[" + i + "]: " + y[i]);
			if(x[i] == 0 && dimensions[x[i]][y[i]] != 0)
				return true;
		}
		return false;
	}
	
	
	public static void moveLeft(board temp)
	{
		board.isLeft = false;
		if(allTetrominos.get(allTetrominos.size() - 1).canLeft(temp) == true)
			allTetrominos.get(allTetrominos.size() - 1).moveLeft(temp);	
		
	}
	
	
	public static void moveRight(board temp)
	{
		board.isRight = false;
		if(allTetrominos.get(allTetrominos.size() - 1).canRight(temp) == true)
			allTetrominos.get(allTetrominos.size() - 1).moveRight(temp);	
		
	}
	
	public static void doRotate(board temp)
	{
		board.rotate = false;
		allTetrominos.get(allTetrominos.size() - 1).Clockwise(temp);
	}
	
	public static void doAntiRotate(board temp)
	{
		board.counterRotate = false;
		allTetrominos.get(allTetrominos.size() - 1).antiClockwise(temp);
	}
	
	public static boolean isbottomfilledFull()
	{
			for(int j = 0; j < 10; j++)
				if(getDimensions()[19][j] == 0)
					return false;
			
			return true;		
	}
	
	public static void bottomFill()
	{
		if(isbottomfilledFull() == true)
		{
			for(int i = 19; i > 1; i++)
			{
				for(int j = 0; j < 10; j++)
				{
			    getDimensions()[i][j] = getDimensions()[i- 1][j];
				}	
			}
		}
	}
	
	public static void moveDown(board temp)
	{
		Timer gameTimer = new Timer(250, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(isLeft == true)
					moveLeft(temp);
				
				if(isRight == true)
					moveRight(temp);
				
				if(rotate == true)
					doRotate(temp);
				
				if(counterRotate == true)
					doAntiRotate(temp);
				
				System.out.println(rotate);
				
				bottomFill();
				
				allTetrominos.get(allTetrominos.size() - 1).oneDown(temp);
				if(allTetrominos.get(allTetrominos.size() - 1).getReachedBottom() == true)
					{
						newTetro(temp);
						
						if((allTetrominos.get(allTetrominos.size() - 1).getGameover() == true))
						{	
							((Timer)e.getSource()).stop();
						}
						
						if(allTetrominos.get(allTetrominos.size() - 1).getCollided() == true)
							{
							allTetrominos.remove(allTetrominos.size() - 1);
							System.out.println("REMOVED");
							}
					}
						//else
							//moveDown(temp);
						
			}
				
		});
		
		gameTimer.start();
	}
	
	
	public void colorScreen()
	{
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				switch(dimensions[i][j])
				{
				case 0:
					mainboard[i][j].setBackground(Color.black);
					mainboard[i][j].setForeground(Color.white);
					//mainboard[i][j].setText("0");
					break;
					
				case 1:
					mainboard[i][j].setBackground(Color.red);
					mainboard[i][j].setForeground(Color.white);
					//mainboard[i][j].setText("1");
					break;
					
				case 2:
					mainboard[i][j].setBackground(Color.gray);
					mainboard[i][j].setForeground(Color.white);
					//mainboard[i][j].setText("2");
					break;
					
				case 3:
					mainboard[i][j].setBackground((Color.blue).brighter());
					//mainboard[i][j].setText("3");
					break;
					
				case 4:
					mainboard[i][j].setBackground(Color.yellow);
					//mainboard[i][j].setText("4");
					break;
					
				case 5:
					mainboard[i][j].setBackground((Color.pink).darker());
					//mainboard[i][j].setText("5");
					break;
					
				case 6:
					mainboard[i][j].setBackground(Color.blue);
					//mainboard[i][j].setText("6");
					break;
					
				case 7:
					mainboard[i][j].setBackground((Color.green).brighter());
					//mainboard[i][j].setText("7");
					break;
				
				
				case 9:
					mainboard[i][j].setBackground((Color.black).darker());
					mainboard[i][j].setForeground(Color.white);
					//mainboard[i][j].setText("0");
					break;
				}
				mainboard[i][j].setOpaque(true);
			}
		}
		
	}
	
	public int getScore()											//still have to make this function
	//Return the score number in any case
	{
		if(started && gaming)
		//Game in progress
			return (int)((System.currentTimeMillis() - startTime)/1000);
		else if(started && !gaming)
		//Game won, stop refresh
			return score;
		else
			return 0;
	}
	
	
	public static void newTetro(board temp)
	{
		System.out.println("entered newtetro");
		
		Random random = new Random();
		int rand = random.nextInt(7) + 1;
		int rand1 = random.nextInt(6) + 2;

		
		switch(rand)
		{
		case 1:
			I i = new I(rand1, 0, temp);
			allTetrominos.add(i);
			System.out.println("new tetro " + 1);
			break;
			
		case 2:
			T t = new T(rand1, 0, temp);
			allTetrominos.add(t);
			System.out.println("new tetro " + 2);
			break;
			
		case 3:
			O o = new O(rand1, 0, temp);
			allTetrominos.add(o);
			System.out.println("new tetro " + 3);
			break;
			
		case 4:
			L l = new L(rand1, 0, temp);
			allTetrominos.add(l);
			System.out.println("new tetro " + 4);
			break;
			
		case 5:
			J j = new J(rand1, 0, temp);
			allTetrominos.add(j);
			System.out.println("new tetro " + 5);
			break;
			
		case 6:
			S s = new S(rand1, 0, temp);
			allTetrominos.add(s);
			System.out.println("new tetro " + 6);
			break;
			
		case 7:
			Z z = new Z(rand1, 0, temp);
			allTetrominos.add(z);
			System.out.println("new tetro " + 7);
			break;
			
		
		}
		
	}
	

	public void keyPressed (KeyEvent e, board temp){
    	int keyCode = e.getKeyCode();
	    
    	switch( keyCode ) { 
	        case 37:
	        	System.out.println("left arrow");
				board.moveLeft(temp);
	        	break;
	        case 38:
	        	System.out.println("up arrow");
	            break;
	            
	        case 39:
	        	System.out.println("right arrow");
	            
	        	break;
	        case 40:
	        	System.out.println("down arrow");
	            
	        	break;}
    		
    	}
	
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource() == Start_Restart)
	
		
		if(e.getSource()==eXit)
			System.exit(0);
		
		if(e.getSource()==heLp)
			JOptionPane.showMessageDialog(null, "The rules in Tetris are simple:\n"); //have to complete.
					
		
		
		if(e.getSource()==About)
			JOptionPane.showMessageDialog(null, "Programmed by Ibraheim and Anas, 2016.04.25");
		
	}


	//@Override
	//public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	//}



	
	
}


class keyb implements KeyListener{
	
	
    public void keyPressed (KeyEvent e){
    	int keyCode = e.getKeyCode();
//	    board.isLeft = false;
//	    board.isRight = false;
    	
    	
    	
    	switch( keyCode ) { 
	        case 37:
	        	System.out.println("left arrow");
				board.isLeft = true;
	        	break;
	        case 67:
	        	System.out.println("c");
	        	board.counterRotate = true;
	        	break;
	            
	        case 39:
	        	System.out.println("right arrow");
	            board.isRight = true;
	        	break;
	        case 82:
	        	System.out.println("r");
	            board.rotate = true;
	        	break;}
    		
    	}
    public void keyReleased (KeyEvent e){}
    public void keyTyped (KeyEvent e){}
    }