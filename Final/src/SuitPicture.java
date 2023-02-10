// Class 7/7
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class SuitPicture extends JPanel {

        //attribute
        private final BufferedImage imgsuit;

    public SuitPicture(int i) {
        BufferedImage[] suitlist = new BufferedImage[4];
        try {
            suitlist[0] = ImageIO.read(new File("img/Spades.png"));
            suitlist[1] = ImageIO.read(new File("img/Hearts.png"));
            suitlist[2] = ImageIO.read(new File("img/Diamonds.png"));
            suitlist[3] = ImageIO.read(new File("img/Clubs.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        imgsuit = suitlist[i];
        repaint();
    }

    //painting precisely a suit image
    public void paint(Graphics g) {
        g.drawImage(imgsuit,25,40,imgsuit.getWidth()/10,imgsuit.getHeight()/10,null);
    }
}