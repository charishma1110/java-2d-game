package SmashTheBricks;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class gamePlay extends JPanel implements KeyListener,ActionListener{
	private boolean play=false;
    private int score=0;
    private int totalBricks=21;
    private Timer timer;
    private int delay=0;
    private int player=310;
    private int ballposX=120;
    private int ballposY=350;
    private int balldirnX=-1;
    private int balldirnY=-2;
    private map m;
	public void actionPerformed(ActionEvent e){
        timer.start();
        if(play){
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(player,550,100,8))){
                balldirnY=-balldirnY;
            }
            A:for(int i=0;i<m.mp.length;i++) {
            	for(int j=0;j<m.mp[0].length;j++) {
            		if(m.mp[i][j]>0) {
            			int brickx=j*m.brickwidth+80;
            			int bricky=i*m.brickheight+50;
            			int brickwidth=m.brickwidth;
            			int brickheight=m.brickheight;
            			Rectangle rect=new Rectangle(brickx,bricky,brickwidth,brickheight);
            			Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
            			Rectangle brickRect=rect;
            			if(ballRect.intersects(brickRect)) {
            				m.setBrickValue(0, i, j);
            				totalBricks--;
            				score+=10;
            				if(ballposX+19<=brickRect.x || ballposX+1>=brickRect.x+brickRect.width) {
            					balldirnX=-balldirnX;
            				}else {
            					balldirnY=-balldirnY;
            				}
            				break A;
            			}
            		}
            	}
            }
            ballposX+=balldirnX;
            ballposY+=balldirnY;
            if(ballposX<0){
                balldirnX=-balldirnX;
            }
            if(ballposY<0){
                balldirnY=-balldirnY;
            }
            if(ballposX>670){
                balldirnX=-balldirnX;
            }
        }
        repaint();
    }
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(player>=600){
                player=600;
            }else{
                moveRight();
            }

        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(player<10){
                player=10;
            }else{
                moveLeft();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
        	if(!play) {
        		play=true;
        		ballposX=120;
        		ballposY=350;
        		balldirnX=-1;
        		balldirnY=-2;
        		player=310;
        		score=0;
        		totalBricks=21;
        		m=new map(3,7);
        		repaint();
        	}
        }

	}
    public void moveRight(){
        play=true;
        player+=20;
    }
    public void moveLeft(){
        play=true;
        player-=20;
    }
	public void keyReleased(KeyEvent e){}
    public gamePlay(){
    	m=new map(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
        g.setColor(new Color(0x9B5BA6));
        g.fillRect(1,1,692,592);
        m.draw((Graphics2D)g);
        g.setColor(new Color(0xFFF04D));
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);
        g.setColor(new Color(0xFFEF00));
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("Score:"+score, 500, 30);
        g.setColor(new Color(0xFAAFBA));
        g.fillRect(player,550,100,8);
        g.setColor(new Color(0xFAAFBA));
        g.fillOval(ballposX,ballposY,20,20); 
        if(totalBricks<=0) {
        	play=false;
        	balldirnX=0;
        	balldirnY=0;
            g.setColor(new Color(0xFFEF00));
        	g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("You won",190,300);
            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press Enter to play again",230,350);
        }
        if(ballposY>570) {
        	play=false;
        	balldirnX=0;
        	balldirnY=0;
            g.setColor(new Color(0xFFEF00));
        	g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over",190,300);
            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press Enter to play again",230,350);
        }
        g.dispose();
    }

}