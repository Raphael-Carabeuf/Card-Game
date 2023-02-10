// Class 6/7
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackPicture extends JPanel {

    //attribute
    private BufferedImage imgback;

    //creating the back of a card (blue or red)
    public BackPicture(int i) {
        try {
            if (i == 0){
                imgback = ImageIO.read(new File("img/card_blue.png"));
            } else if (i == 1) {
                imgback = ImageIO.read(new File("img/card_red.png"));}
        }
        catch (IOException e) {
                e.printStackTrace();
            }
        repaint();
    }

    //painting precisely the back of a card
    public void paint(Graphics g) {
        g.drawImage(imgback, 10, 0, imgback.getWidth(), imgback.getHeight(), null);
    }
}