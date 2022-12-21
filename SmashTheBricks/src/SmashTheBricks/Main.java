package SmashTheBricks;
import javax.swing.*;
public class Main{
    public static void main(String[]args){
        JFrame frame=new JFrame();
        gamePlay gameplay=new gamePlay();
        frame.setBounds(10,10,700,600);
        frame.setTitle("Smash The Bricks");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
    }
}
