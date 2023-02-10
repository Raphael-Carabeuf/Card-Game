// Class 5/7
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardPicture extends JPanel {

    //attribute
    private final BufferedImage imgcard;

    public CardPicture(int i) {
        BufferedImage[] cardlist = new BufferedImage[32];
        try {
                if (i==0){
                    cardlist[0] = ImageIO.read(new File("img/7_spades.png"));}
                else if (i==1){
                    cardlist[1] = ImageIO.read(new File("img/8_spades.png"));}
                else if (i==2){
                cardlist[2] = ImageIO.read(new File("img/9_spades.png"));}
                else if (i==3){
                cardlist[3] = ImageIO.read(new File("img/10_spades.png"));}
                else if (i==4){
                cardlist[4] = ImageIO.read(new File("img/Jack_spades.png"));}
                else if (i==5){
                cardlist[5] = ImageIO.read(new File("img/Queen_spades.png"));}
                else if (i==6){
                cardlist[6] = ImageIO.read(new File("img/King_spades.png"));}
                else if (i==7){
                cardlist[7] = ImageIO.read(new File("img/Ace_spades.png"));}
                else if (i==8){
                cardlist[8] = ImageIO.read(new File("img/7_hearts.png"));}
                else if (i==9){
                cardlist[9] = ImageIO.read(new File("img/8_hearts.png"));}
                else if (i==10){
                cardlist[10] = ImageIO.read(new File("img/9_hearts.png"));}
                else if (i==11){
                cardlist[11] = ImageIO.read(new File("img/10_hearts.png"));}
                else if (i==12){
                cardlist[12] = ImageIO.read(new File("img/Jack_hearts.png"));}
                else if (i==13){
                cardlist[13] = ImageIO.read(new File("img/Queen_hearts.png"));}
                else if (i==14){
                cardlist[14] = ImageIO.read(new File("img/King_hearts.png"));}
                else if (i==15){
                cardlist[15] = ImageIO.read(new File("img/Ace_hearts.png"));}
                else if (i==16){
                cardlist[16] = ImageIO.read(new File("img/7_diamonds.png"));}
                else if (i==17){
                cardlist[17] = ImageIO.read(new File("img/8_diamonds.png"));}
                else if (i==18){
                cardlist[18] = ImageIO.read(new File("img/9_diamonds.png"));}
                else if (i==19){
                cardlist[19] = ImageIO.read(new File("img/10_diamonds.png"));}
                else if (i==20){
                cardlist[20] = ImageIO.read(new File("img/Jack_diamonds.png"));}
                else if (i==21){
                cardlist[21] = ImageIO.read(new File("img/Queen_diamonds.png"));}
                else if (i==22){
                cardlist[22] = ImageIO.read(new File("img/King_diamonds.png"));}
                else if (i==23){
                cardlist[23] = ImageIO.read(new File("img/Ace_diamonds.png"));}
                else if (i==24){
                cardlist[24] = ImageIO.read(new File("img/7_clubs.png"));}
                else if (i==25){
                cardlist[25] = ImageIO.read(new File("img/8_clubs.png"));}
                else if (i==26){
                cardlist[26] = ImageIO.read(new File("img/9_clubs.png"));}
                else if (i==27){
                cardlist[27] = ImageIO.read(new File("img/10_clubs.png"));}
                else if (i==28){
                cardlist[28] = ImageIO.read(new File("img/Jack_clubs.png"));}
                else if (i==29){
                cardlist[29] = ImageIO.read(new File("img/Queen_clubs.png"));}
                else if (i==30){
                cardlist[30] = ImageIO.read(new File("img/King_clubs.png"));}
                else {
                cardlist[31] = ImageIO.read(new File("img/Ace_clubs.png"));}
            } catch (IOException e){
                e.printStackTrace();
            }
            imgcard = cardlist[i];
            repaint();
    }

    //painting precisely a card
    public void paint(Graphics g) {
        g.drawImage(imgcard,10,0,imgcard.getWidth()/10,imgcard.getHeight()/10,null);
    }
}