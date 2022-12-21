package SmashTheBricks;
import javax.swing.*;
import java.awt.*;
public class map {
	public int mp[][];
	public int brickwidth;
	public int brickheight;
	public map(int row,int col) {
		mp=new int[row][col];
		for(int i=0;i<mp.length;i++) {
			for(int j=0;j<mp[0].length;j++) {
				mp[i][j]=1;
			}
		}
		brickwidth=540/col;
		brickheight=150/row;
	}
	public void draw(Graphics2D g) {
		for(int i=0;i<mp.length;i++) {
			for(int j=0;j<mp[0].length;j++) {
				if(mp[i][j]>0) {
					g.setColor(new Color(0xFFFFFF));
					g.fillRect(j*brickwidth+80, i*brickheight+50,brickwidth , brickheight);
					g.setStroke(new BasicStroke(3));
					g.setColor(new Color(0x9B5BA6));
					g.drawRect(j*brickwidth+80, i*brickheight+50,brickwidth , brickheight);
					
				}
			}
		}
	}
	public void setBrickValue(int value,int row,int col) {
		mp[row][col]=value;
	}

}
