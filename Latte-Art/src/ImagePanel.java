import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 5579096266467300254L;
	
	private BufferedImage image;
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		this.repaint();
	}
	
	  public static BufferedImage imageToBufferedImage(Image im) {
		     BufferedImage bi = new BufferedImage
		        (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
		     Graphics bg = bi.getGraphics();
		     bg.drawImage(im, 0, 0, null);
		     bg.dispose();
		     return bi;
		  }
	
    public ImagePanel() {
        try {                
            image = ImageIO.read(new File("Resource/logo.png"));
         } catch (IOException ex) {
              MainWindow.getStatusBar().setMessage("Nie można znaleźć: logo_mini.png");
         }
    }
    
    public void loadImage(File file) {
        try {                
            image = ImageIO.read(file);  
            this.repaint();
         } catch (IOException ex) {
              MainWindow.getStatusBar().setMessage("Nie można znaleźć: " +
            		  								file.getPath());
         }
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        int x = 0;
        int y = 0;
        if (this.getWidth() > image.getWidth()) {
        	x = (this.getWidth()-image.getWidth())/2;
        }
        if (this.getHeight() > image.getHeight()) {
        	y = (this.getHeight()-image.getHeight())/2;
        }
        g.drawImage(image, x, y, null);
     //   g.drawRect(x, y, image.getWidth(), image.getHeight());
    //    g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
        
    }

}