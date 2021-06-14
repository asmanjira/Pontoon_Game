import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class Demo extends JFrame implements ActionListener,MouseListener
{
    private JPanel topPanel, InfoPanel, bottomPanel;
    private JLabel Player, Total, Info;			
    private JButton newGame;
    private Button[][] buttons;
    public int[][] container;
    public int player;
    private int x,y;
    private int total;
    public Demo(int x, int y)
    {
        this.x =x;
        this.y =y;
        container = new int[5][5];
        this.setTitle("GAME OF PONTOON");
        
        InfoPanel = new JPanel();  //this gives the Information on the top panel
        
        topPanel = new JPanel();    //displays the New Game button, players turn and Current Total
        topPanel.setLayout(new BorderLayout());
        
        bottomPanel = new JPanel();    // displays the bottom buttons 
        bottomPanel.setLayout(new GridLayout(x,y));
        
        Info = new JLabel("Keep the Total below 22, Press New Game to begin");
        Player = new JLabel("Player:");
	newGame = new JButton("New Game");
	newGame.addActionListener(this);
	Total = new JLabel("Current Total:");
	
	// adding components to the top panel
	topPanel.add( Player , BorderLayout.CENTER);
	topPanel.add ( newGame, BorderLayout.WEST);
	topPanel.add( Total, BorderLayout.EAST);
	
	// adding th info panel 
	InfoPanel.add( Info);
	
	// creating buttons 
	buttons = new Button[x][y];
	for (int i=0; i<5; i++)
	{
	    for(int j=0; j<5; j++)
	    {
	        buttons [i][j] = new Button(i,j);
	        buttons [i][j].setSize(100,100);
	        
	        buttons[i][j].addMouseListener(this);
	        
	        buttons [i][j].setText("-");
	        bottomPanel.add( buttons[i][j],new GridLayout());
	    }
	}
	   
	// setting up the content pane 
	getContentPane().setLayout( new BorderLayout());
        getContentPane().add( InfoPanel, BorderLayout.NORTH);
	getContentPane().add( topPanel, BorderLayout.CENTER);
	getContentPane().add( bottomPanel, BorderLayout.SOUTH);
	pack();
	
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
	setResizable( false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent aevt)
    {
        Object selected = aevt.getSource();
        if(selected.equals( newGame))
        {
            Total.setText("Current Total :");
            total = 0;  //display the total
            Info.setText("Keep the Total below 22, Press New Game to begin");
            for (int i=0; i<5; i++)
            {
                for(int j=0; j<5; j++)
                {
                    int numbers = (int)(Math.random()*6);
                    player = (int)(Math.random()*2);
                    player++;
                    Player.setText("Player :"+player);
                    buttons[i][j].setXcoord(i);
                    buttons[i][j].setYcoord(j);
                    buttons [i][j].setNumbers(i,j,numbers);
                    buttons [i][j].setText(String.valueOf(numbers));
                    buttons [i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    public void mouseClicked(MouseEvent mevt)
    {
        Object selected = mevt.getSource();
        
        if (selected instanceof Button)
        {
            Button button = (Button) selected;
            int x = button.getXcoord();
            int y = button.getYcoord();
            int n = button.getNumber(x,y);
            buttons[x][y].setEnabled(false);
            if (player ==1)
            {
                button.setBackground(Color.RED);
                total= total+n;
                buttons[x][y].setEnabled(false);
                if(total>21)
                {
                    Info.setText("Well Done! Player 2 Wins. Press New Game to Start Again"); 
                }
                Player.setText("Player : 2");
                player = 2;
            }
            else
            {
                button.setBackground(Color.YELLOW);
                total= total+n;
                buttons[x][y].setEnabled(false);
                if(total>21)
                {
                    Info.setText("Well Done! Player 1 Wins. Press New Game to Start Again"); 
                }
                Player.setText("Player : 1");
                player =1;
            }
            Total.setText("Current Total"+total);
        }
    }
    
    public void mouseEntered(MouseEvent arg0){}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
}
