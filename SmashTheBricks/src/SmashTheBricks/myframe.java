package SmashTheBricks;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class myframe extends JFrame {
myframe(){
	setTitle("frame title");
	setResizable(false);
	setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    setSize(500,500);
	setVisible(true);
	ImageIcon image=new ImageIcon("s1.png");
	setIconImage(image.getImage());
	this.getContentPane().setBackground(new Color(0x123456));
}
}
