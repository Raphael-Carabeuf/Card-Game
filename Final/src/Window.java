// Class 4/7 (the big one)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class Window extends JFrame {

    //attributes
    private DeckOfCards myDeck = new DeckOfCards(); //the shuffled deck of card :)
    private final JLabel background; //the background
    private final JPanel backred = new BackPicture(1); //the red back image of pictures
    private int cc; //current card used during the game
    private CardPicture cp; //current picture used during the game
    private JPanel p; //current panel used during the game
    protected JPanel s7,s8,s9,s10,sJ,sQ,sK,sA,h7,h8,h9,h10,hJ,hQ,hK,hA,d7,d8,d9,d10,dJ,dQ,dK,dA,c7,c8,c9,c10,cJ,cQ,cK,cA; //the 32 panels for cards
    protected CardPicture z0,z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24,z25,z26,z27,z28,z29,z30,z31; //the 32 cards pictures
    protected JPanel drawpile1, drawpile2, drawpile3, drawpile4; //the 4 drawpiles panels
    protected int stop, stop2, stop3, stop4; //to stop my drawpiles events
    protected int stops7, stops8, stops9, stops10, stopsJ, stopsQ, stopsK, stopsA; //to stop the spades panels
    protected int stoph7, stoph8, stoph9, stoph10, stophJ, stophQ, stophK, stophA; //to stop the hearts panels
    protected int stopd7, stopd8, stopd9, stopd10, stopdJ, stopdQ, stopdK, stopdA; //to stop the diamonds panels
    protected int stopc7, stopc8, stopc9, stopc10, stopcJ, stopcQ, stopcK, stopcA; //to stop the clubs panels
    private final boolean check1 = true, check2 = true, check3 = true; //checking the state of the game's draw piles
    private final boolean[] checks = { check1, check2, check3 }; //array with the 3 checks
    private final JPanel[] pan = {
            s7,s8,s9,s10,sJ,sQ,sK,sA,h7,h8,h9,h10,hJ,hQ,hK,hA,d7,d8,d9,d10,dJ,dQ,dK,dA,c7,c8,c9,c10,cJ,cQ,cK,cA
    }; //array with the 32 panels
    private final CardPicture[] imgs = {
            z0,z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,z23,z24,z25,z26,z27,z28,z29,z30,z31
    }; //array with the 32 cards pictures
    private final JPanel[] draw = { drawpile1, drawpile2, drawpile3, drawpile4 }; //array with the 4 drawpiles
    private final Integer[] stopdraw = {stop, stop2, stop3, stop4}; //array with the 4 drawpile's stops
    private final Integer[] allStop = { //array with all the stops
            stops7, stops8, stops9, stops10, stopsJ, stopsQ, stopsK, stopsA,
            stoph7, stoph8, stoph9, stoph10, stophJ, stophQ, stophK, stophA,
            stopd7, stopd8, stopd9, stopd10, stopdJ, stopdQ, stopdK, stopdA,
            stopc7, stopc8, stopc9, stopc10, stopcJ, stopcQ, stopcK, stopcA }; //array with the 32 stops for the 32 panels
    private boolean hardMode = false; //when true, hard mode is activated ;)
    private final JComboBox<String> lg; //new combobox to select the language
    private String language = "English"; //new String for the language
    private JRadioButton hard; //new button (for hard mode)
    private JTextField results; //new text field
    private String[] names; //Array with the rank of the cards

    public Window() {
        //creating the frame
        setSize(1920, 1080); //the size of the window
        //setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //How to close the window
        setVisible(true); //making the window visible (quite important)

        //set background
        JPanel cp = (JPanel) this.getContentPane(); //to get the entire panel of the window
        background = new JLabel(new ImageIcon("img/Background.jpg")); //creating a new image
        cp.add(background); //adding this image to the entire panel
        background.setLayout(new FlowLayout(FlowLayout.CENTER, this.getWidth() * 99, this.getHeight() / 5)); //setting a layout and giving him special properties

        //the home page infos
        background.add(info1()); //call the info1() method

        //the home page Button
        JButton start = new JButton("START"); //new button
        start.setFont(new Font("Serif", Font.BOLD, 20)); //customizing START (font and size)
        start.setForeground(Color.BLUE); //making START blue
        start.setBackground(Color.GREEN); //making the button green
        start.setPreferredSize(new Dimension(180, 45)); //setting size to the button
        start.addActionListener(this::gameStarted); //when clicked, call my biggest method: gameStarted()
        background.add(start); //adding the button to the background

        //the ComboBox
        String[] languages = {"English", "Français", "Čeština"}; //new Array with 3 languages :)
        lg = new JComboBox(languages); //new combo box with the languages Array
        lg.setFont(new Font("Serif", Font.PLAIN, 16));
        lg.addActionListener(this::changeLanguage); //call changeLanguage()

        //refresh
        validate();
    }

    //the home page info method
    private JPanel info1() {
        JPanel p1 = new JPanel(); //the info panel in the home page
        p1.setLayout(new BorderLayout()/*(FlowLayout.CENTER, p1.getWidth()*99, p1.getHeight()/5)*/); //setting a layout and giving him special properties
        p1.setBackground(Color.ORANGE); //adding a color on this info panel
        p1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //making some space in the borders
        p1.setPreferredSize(new Dimension(310, 246)); //the size of this panel

        JLabel title = new JLabel("Patience: Grid", SwingConstants.CENTER); //the title text
        title.setFont(new Font("Serif", Font.BOLD, 22)); //customizing the text (font and size)
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //bigger border for the title text
        p1.add(title, BorderLayout.NORTH); //adding the title text to the info panel (on the north)

        JTextArea rules = new JTextArea("""
                *  Patience is a one-player french card game\s
                *  where you have to arrange all the cards in\s
                *  a specific order.\s
                *  in the grid version : Your goal is to\s
                *  reconstitute the entire grid, regarding\s
                *  ranks and suits of cards, but BEFORE\s
                *  finding the 4 Aces !\s
                *  \s
                *  Good Luck !\s
                """); //a text area with the rules of the game
        rules.setFont(new Font("Serif", Font.PLAIN, 16)); //customizing the rules (font and size)
        rules.setForeground(Color.RED); //red color to the rules
        rules.setBackground(Color.CYAN); //cyan color to the rule's background
        rules.setEditable(false); //rules are a text area, but u can't edit it
        p1.add(rules); //adding the text area to the info panel

        return p1;
    }

    //the method to change languages
    private void changeLanguage(ActionEvent e) {
        if (lg.getSelectedItem() == "English"){ //if English selected
            language = "English"; //making language: English
            results.setText("Restart to change the language");
        } else if (lg.getSelectedItem() == "Français"){ //if French selected
            language = "Français"; //making language: French
            results.setText("Redémarre pour changer la langue");
        } else if (lg.getSelectedItem() == "Čeština"){ //if Czech selected
            language = "Čeština"; //making language: Czech
            results.setText("restartujte pro změnu jazyka");
        }
    }

    //the start button method
    private void gameStarted(ActionEvent go) {
        background.removeAll(); //removing all
        System.out.println("game started"); //check on the console
        background.setLayout(new BorderLayout()); //New Layout

        myDeck = new DeckOfCards(); //instantiation of a new DeckOfCard in order to be shuffled differently if we restart the game
        System.out.println("my shuffled deck is: " + myDeck.toPrint()); //checking my shuffled deck

        //Reinitializing values (it is important if we restart the game)
        hardMode = false; //deactivating hard mode
        stopdraw[0] = 1; //making the 1st drawpile clickable
        for (int i=1; i<=3; i++){
            stopdraw[i] = 0;
            checks[i-1] = true; }
        for (int i=0; i<=31; i++){
            allStop[i] = 0;
            if (i==7 || i==15 || i==23 || i==31){
                allStop[i] = 2; }
        }

        //NORTH PANEL
        JPanel p1 = new JPanel(new GridLayout(1, 5, 25, 0)); //new panel (with grid logic)
        p1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //setting border

        //features on the north Panel
        //restart button
        JButton restart = new JButton("Restart"); //new button
        restart.setFont(new Font("Serif", Font.BOLD, 16)); //customizing START (font and size)
        restart.addActionListener(this::gameStarted); //call gameStarted() method (the one we are in)
        p1.add(restart); //add the button to the panel

        //set language button
        p1.add(lg); //adding the ComboBox to the Background

        //easy and hard mode buttons
        ButtonGroup buttonGroup = new ButtonGroup(); //new group of button
        JRadioButton easy = new JRadioButton("Easy mode", true); //new button "easy mode"
        hard = new JRadioButton("Hard mode", false); //new button "hard mode"
        easy.setFont(new Font("Serif", Font.BOLD, 16)); //set font and size
        hard.setFont(new Font("Serif", Font.BOLD, 16)); //set font and size
        buttonGroup.add(easy); //add easy button to the group
        buttonGroup.add(hard); //add hard button to the group
        easy.addItemListener(this::toHardMode); //call toHardMode (last method of this Class)
        hard.addItemListener(this::toHardMode); //call toHardMode (at the really bottom of this page)
        JPanel box1 = new JPanel(); //new panel1
        JPanel box2 = new JPanel(); //new panel2
        box1.add(easy, CENTER_ALIGNMENT); //adding easy button in the center of the panel1
        box2.add(hard, CENTER_ALIGNMENT); //adding hard button in the center of the panel2
        p1.add(box1); //adding panel1 to the north panel
        p1.add(box2); //adding panel2 to the north panel

        //text field with the progress of the game
        results = new JTextField("Draw your first Card !"); //new text field
        results.setFont(new Font("Serif", Font.PLAIN, 13)); //set font and size
        results.setEditable(false); //not editable
        results.setForeground(Color.RED); //set the color of the text
        results.setBackground(Color.CYAN); //set the color of the background
        p1.add(results); //add the text field to the panel

        background.add(p1, BorderLayout.NORTH); //adding the panel to the north

        //LEFT PANEL
        JPanel p3 = new JPanel(new GridLayout(4, 1, 5, 5)); //new panel (with grid logic)
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0)); //making some space in the borders
        p3.setPreferredSize(new Dimension(background.getWidth() / 10, background.getHeight())); //set a size for the panel

        for (int i = 0; i <= 3; i++) {
            JPanel suitpicture = new SuitPicture(i); //instantiation of SuitPicture class
            p3.add(suitpicture); //adding the 4 suit's images to the panel
        }

        background.add(p3, BorderLayout.WEST); //adding the panel to the west

        //SOUTH PANEL
        JPanel p4 = new JPanel(new GridLayout(1, 10, 5, 0)); //new panel (with grid logic)
        p4.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 10)); //making some space in the borders
        p4.setPreferredSize(new Dimension(background.getWidth(), background.getHeight() / 14)); //set a panel's size

        if (Objects.equals(language, "English")) {
            names = new String[]{"Suit", "Seven", "Height", "Nine", "Ten", "Jack", "Queen", "King", "Ace", "Draw pile"}; //new array
        } else if (Objects.equals(language, "Français")) {
            names = new String[]{"Couleur", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi", "As", "Pioche"};
        } else if (Objects.equals(language, "Čeština")) {
            names = new String[]{"Barva", "Sedm", "Osm", "Devět", "Deset", "Komorník", "Královna", "Král", "Eso", "Pick"};
        }
        for (int i = 0; i <= 9; i++) {
            JLabel noun = new JLabel(names[i], SwingConstants.CENTER); //creating a label for each name in the array
            noun.setFont(new Font("Serif", Font.BOLD, 18)); //customizing the names (font and size)
            p4.add(noun); //adding each name in the panel's grid
        }


        background.add(p4, BorderLayout.SOUTH); //adding the panel to the south

        //MIDDLE PANEL
        JPanel p2 = new JPanel(new GridLayout(4, 8, 5, 5)); //new panel (with grid logic)
        p2.setBorder(BorderFactory.createEmptyBorder(15, 5, 10, 10)); //making some space in the borders

        for (int i = 0; i <= 31; i++) {
            imgs[i] = new CardPicture(myDeck.getImgDeck(i)); //32 instantiations of CardPicture Class (to associate all the images)
            pan[i] = new JPanel(new GridLayout(1, 1)); //creating the 32 panels of the game (to put images on, later)
            p2.add(pan[i]);
        }

        for (int i = 0; i <=31; i++) {
            BackPicture bp = new BackPicture(0); //instantiation of Backpicture class (blue)
            pan[i].add(bp); //adding the blue back pictures of the cards to the panels
            if (i == 7 || i == 15 || i == 23 || i == 31) {
                bp.setVisible(false); //The ace's back pictures are not visible
            }
        }

        background.add(p2, BorderLayout.CENTER); //adding the panel to the center

        //RIGHT PANEL
        JPanel p5 = new JPanel(new GridLayout(4, 1, 5, 5)); //new panel (with grid logic)
        p5.setBackground(Color.ORANGE); //adding a color to the panel
        p5.setBorder(BorderFactory.createEmptyBorder(15, 5, 10, 10)); //making some space in the borders
        p5.setPreferredSize(new Dimension(background.getWidth() / 10, background.getHeight())); //the size of the panel

        for (int i = 0; i <= 3; i++) {
            draw[i] = new JPanel(new GridLayout(1, 1)); //creating the 4 drawpiles panels
            draw[i].setBackground(Color.ORANGE); //making them orange
            p5.add(draw[i]); //adding them to the panel
        }

        draw[0].add(backred); //adding the red back picture to the draw pile 1
        for (int i = 1; i <= 3; i++) {
            BackPicture bp = new BackPicture(0); //instantiation of Backpicture class (blue)
            draw[i].add(bp); //adding  the blue back pictures to the drawpiles 2, 3 and 4
        }

        background.add(p5, BorderLayout.EAST); //adding the panel to the east

        if (Objects.equals(language, "English")) {
            restart.setText("Restart");
            easy.setText("Easy mode");
            hard.setText("Hard mode");
            results.setText("Draw your first Card !");
        } else if (Objects.equals(language, "Français")) {
            restart.setText("Recommencer");
            easy.setText("Mode facile");
            hard.setText("Mode difficile");
            results.setText("Piochez votre première carte !");
        } else if (Objects.equals(language, "Čeština")) {
            restart.setText("Restartujte");
            easy.setText("Jednoduchý režim");
            hard.setText("tvrdý režim");
            results.setText("Dotáhněte si svou první kartu!");
        }
        
        revalidate(); //refresh


        //EVENTS (there are 3 events)

            //Draw piles event
        for (int i = 0; i <= 3; i++) { //for loop with 4 iterations
            int j = i;
            int k = ((j+1)*8)-1; //little trick that it was hard to find, to make the code better :)
            draw[i].addMouseListener(new MouseAdapter() { //the 4 drawpiles MouseListeners
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (stopdraw[j] == 1) { //when a drawpile's stop = 1, we can click on it
                        stopdraw[j] = 2; //when clicked, we can't click again
                        p = draw[j]; //current panel for revealing cards = current drawpile
                        cc = k; //current card number (corresponding to the int img attribute in Card class)
                        cp = imgs[k]; //current image associated
                        revealing(); //call revealing() method
                    }
                }
            });
        }

            //Panels event
        for (int i = 0; i<=30; i++){ //for loop with 31 iterations (I don't care about the 32nd because it is an Ace)
            int j = i;
            if (j!=7 || j!=15 || j!=23) { //I forbid the 3 others Aces to be clickable (VERY IMPORTANT LINE, DON'T DELETE IT)
                pan[j].addMouseListener(new MouseAdapter() { //MouseListener for the 28 clickable panels (32 - 4 Aces)
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (allStop[j] == 1) { //clickable only if the panel's stop = 1
                            allStop[j] = 2; //not clickable a 2nd time
                            adding(j); //call the adding() method
                            cc = j; //new current card number
                            cp = imgs[j]; //new current picture
                            revealing(); //call the revealing() method
                        }
                    }
                });
            }    
        }

            //Last event for the end of the game
        for (int i=0; i<=31; i++){ //for loop with 32 iterations
            int j = i;
            pan[j].addMouseListener(new MouseAdapter() { //MouseListener for all the panels
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (allStop[j] == 3){ //only if the panel's stop = 3
                        allStop[j] = 2; //not clickable again
                        cc = j; //new current card number
                        cp = imgs[j]; //new current picture
                        adding(j); //call adding() method
                    }
                }
            });
        }
    }

    //METHODS FOR EVENTS
        //revealing a card
    private void revealing() {
        p.removeAll(); //remove what is on the panel
        p.add(cp); //add a card to the panel
        p.repaint(); //mandatory to well add an image
        revalidate(); //refresh
        if (Objects.equals(language, "English")) { //result in different languages
            results.setText("you pulled a : " + myDeck.deck.get(cc).getRealrank() + " of " + myDeck.getSuitDeck(cc));
        } else if (Objects.equals(language, "Français")) {
            results.setText("Tu as pioché un : " + myDeck.deck.get(cc).getRealrank() + " of " + myDeck.getSuitDeck(cc));
        } else if (Objects.equals(language, "Čeština")) {
            results.setText("vytáhl jsi : " + myDeck.deck.get(cc).getRealrank() + " of " + myDeck.getSuitDeck(cc));
        }
        program(); //call the program() method
    }

        //the whole game logic, the big method
    private void program() {
        if (myDeck.getSuitDeck(cc) == Card.Suit.Spades) { //checking suit of card
            if (myDeck.getRankDeck(cc) == 14) { //checking if card is an Ace
                ifAce(7); } //call the ifAce method
            for (int i = 0; i <= 6; i++) {
                int j = i + 7;
                if (myDeck.getRankDeck(cc) == j) { //checking rank of card
                    allStop[i] = 1; //making the panel clickable by activating his stop
                    addBackred(i); //call addBackred() method
                }
            }
        } else if (myDeck.getSuitDeck(cc) == Card.Suit.Hearts) { //check suit (by using a DeckOfCards class method that use a Card class method :))
            if (myDeck.getRankDeck(cc) == 14) { //check if Ace
                ifAce(15); } //call ifAce()
            for (int i=8; i<=14; i++){
                int j = i - 1;
                if (myDeck.getRankDeck(cc) == j) { //check rank (by using a DeckOfCards class method that use a Card class method :))
                    allStop[i] = 1; //change his stop
                    addBackred(i); //call addBackred()
                }
            }
        } else if (myDeck.getSuitDeck(cc) == Card.Suit.Diamonds) { //check suit
            if (myDeck.getRankDeck(cc) == 14) { //check if Ace
                ifAce(23); } //call ifAce
            for (int i=16; i<=22; i++){
                int j = i - 9;
                if (myDeck.getRankDeck(cc) == j) { //check rank
                    allStop[i] = 1; //change his stop
                    addBackred(i); //call addBackred()
                }
            }
        } else if (myDeck.getSuitDeck(cc) == Card.Suit.Clubs) { //check suit
            if (myDeck.getRankDeck(cc) == 14) { //check if ACe
                ifAce(31); } //call ifAce
            for (int i=24; i<=30; i++){
                int j = i - 17;
                if (myDeck.getRankDeck(cc) == j) { //check rank
                    allStop[i] = 1; //change his stop
                    addBackred(i); //call addBackred
                }
            }
        }
    }

        //add a red back of card
    public void addBackred(int i) {
        if (!hardMode) {
            pan[i].removeAll(); //remove all
            pan[i].add(backred); //add a red back of card
            pan[i].repaint(); //mandatory repainting
            revalidate(); //refresh
        }
    }

        //a method that add the card to a panel
    public void adding(int j) {
        pan[j].removeAll(); //remove all
        pan[j].add(cp); //add a card to the panel
        pan[j].repaint(); //repaint
        revalidate(); //refresh
    }

        //if we draw an Ace
    public void ifAce(int i) {
        pan[i].removeAll(); //remove all
        pan[i].add(cp); //add the ace to the panel
        pan[i].repaint(); //repaint
        if (Objects.equals(language, "English")) { //result in different languages
            results.setText("oh no... you pulled an " + myDeck.deck.get(cc).getRealrank() + " of " + myDeck.getSuitDeck(cc));
        } else if (Objects.equals(language, "Français")) {
            results.setText("oh non... Tu as pioché un " + myDeck.deck.get(cc).getRealrank() + " de " + myDeck.getSuitDeck(cc));
        } else if (Objects.equals(language, "Čeština")) {
            results.setText("oh... vytáhl jsi " + myDeck.deck.get(cc).getRealrank() + " of " + myDeck.getSuitDeck(cc));
        }
        if (checks[0]) { //check if 2nd drawpile exist
            nextDraw(1); //call nextDraw()
        } else if (checks[1]) { //check if 3rd drawpile exist
            nextDraw(2); //call nextDraw()
        } else if (checks[2]) { //check if 4th drawpile exist
            nextDraw(3); //call newtDraw()
        } else { //no drawpiles left
            ArrayList<Integer> count = new ArrayList<>(0); //new ArrayList just to stock elements
            for (int j=0; j<=31; j++){

                if (allStop[j] == 0){ //for all cards who still have their stops = 0
                    allStop[j] = 3; //special state for stops because it's the end of the game
                    count.add(allStop[j]); //adding an element in the ArrayList
                }
            }
            if (count.size()==0){ //if 0 elements
                if (Objects.equals(language, "English")) { //it is won
                    results.setText("YOU WON ! Well done !");
                } else if (Objects.equals(language, "Français")) {
                    results.setText("C'est gagné ! Bien joué ");
                } else if (Objects.equals(language, "Čeština")) {
                    results.setText("Vyhrál jsi ! Výborně !");
                }
            } else if (count.size()==1){ //if 1 element
                if (Objects.equals(language, "English")) { //it is won because the last card is at the right place
                    results.setText("Turn over the last card... YOU WON!");
                } else if (Objects.equals(language, "Français")) {
                    results.setText("Retourne la dernière carte... BRAVO!");
                } else if (Objects.equals(language, "Čeština")) {
                    results.setText("Otočte poslední kartu... BRAVO!");
                }
            } else if (count.size()==2) { //if 2 elements
                if (Objects.equals(language, "English")) { //it is 1/2 chances to won
                    results.setText("It's a 50/50... check if you won!");
                } else if (Objects.equals(language, "Français")) {
                    results.setText("1 chance sur 2 de gagner !");
                } else if (Objects.equals(language, "Čeština")) {
                    results.setText("1 ku 2 šance na výhru !");
                }
            } else { //if more than 2 elements (less than 1/2)
                if (Objects.equals(language, "English")) { //it is less than 1/2 chances to won...
                    results.setText("oh... check the last cards...");
                } else if (Objects.equals(language, "Français")) {
                    results.setText("oh... regarde les dernières cartes");
                } else if (Objects.equals(language, "Čeština")) {
                    results.setText("oh... zkontroluj poslední karty...");
                }
            }
        }
        revalidate(); //refresh (now we really know this refreshing method)
    }

        //prepare the next drawpile after finding an Ace
    public void nextDraw(int i){
        checks[i-1] = false; //changing state of the drawpile
        stopdraw[i] = 1; //making the drawpile clickable
        draw[i].removeAll(); //remove all
        draw[i].add(backred); //add a red back of card
        draw[i].repaint(); //repaint
    }

        //features methods: hard mode
    public void toHardMode(ItemEvent e){
        Object source = e.getSource(); //new object
        hardMode = source == hard; //my IDE made me write this line like that. But it means: when we click on hard button, the hardMode become true
        revalidate(); //refresh
    }
}