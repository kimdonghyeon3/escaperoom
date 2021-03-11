package escaperoom;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Hint extends JFrame {
	
	  private Image screenImage;
	   private Graphics screenGraphic;
	   private Image background;
	   
	   public Hint(String hintimage) {
	         setTitle("Hint");
	            setSize(Main.HSCREEN_WIDETH, Main.HSCREEN_HEIGHT);
	            setResizable(false);
	            setLocationRelativeTo(null);
	            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            setVisible(true);
	            
	            background = new ImageIcon(Main.class.getResource("../images/" + hintimage)).getImage();
	                  
	         }
	         public void paint(Graphics g) {
	            screenImage = createImage(Main.HSCREEN_WIDETH, Main.HSCREEN_HEIGHT);
	            screenGraphic = screenImage.getGraphics();
	            screenDraw(screenGraphic);
	            g.drawImage(screenImage, 0, 0, null);
	         }

	         public void screenDraw(Graphics g) {
	            g.drawImage(background, 0, 0, null);
	            this.repaint();
	         }
}