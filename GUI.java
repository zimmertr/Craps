import javax.swing.*;
import java.awt.*;
import java.applet.*; 
import java.awt.event.*;

/**
 * This is the GUI made for the Craps game in this class.
 * 
 * @author TJ Zimmerman 
 * @version 1.01
 */

public class GUI extends JPanel
{
    /** Creates two gvdie objects and a new Craps game. */
    private GVdie d1, d2;
    private Craps crapsgame;

    /** Creates the labels for the panel, itself. */
    private JLabel message;
    private JLabel credits;
    private JLabel currentpoint;

    /** Creates the buttons for the panel, itself. */
    private JButton comeOut;
    private JButton roll;
    private JButton reset;
    private JButton exit;

    /**
     * This method creates and places all of the labels and buttons.
     * It also starts the actionlisteners for the buttons and colors 
     * in the background of the panel while sizing it appropreitly. 
     */
    public GUI ()
    {
        /** Makes 3 more JPanels for borderlayout purposes. */
        JPanel bottom = new JPanel();
        JPanel middle = new JPanel();
        JPanel top = new JPanel();

        /** Creates a new font so that the Message can be bold
         * and more heading-like. 
         */
        Font bold = new Font("Arial", Font.BOLD,15);

        /** Instantiates a new game and both of the dice. */
        crapsgame = new Craps();
        d1 = crapsgame.getDie(1);
        d2 = crapsgame.getDie(2);

        /**Customizes the window to look nice. */
        setPreferredSize(new Dimension(400, 200)); //window size
        bottom.setBackground(Color.white); //panel background color.
        middle.setBackground(Color.white); //panel background color.
        top.setBackground(Color.white); //panel background color.
        setLayout (new BorderLayout()); //creates a new borderlayout.

        /** Sets the label for amount of credits */
        credits = new JLabel ("Credits: " + crapsgame.getCredits());

        /** Sets the label for the current point. */
        currentpoint = new JLabel ("Current Point: " 
            + crapsgame.getPoint());

        /** Sets the default welcome message. */
        message = new JLabel ("Welcome to Craps!");
        message.setFont(bold);

        /**Creates buttons for the panel. */
        comeOut = new JButton("Come Out");
        roll = new JButton("Roll");
        reset = new JButton("Reset Game");
        exit = new JButton("Exit Game");

        /**Makes a new game called crapsgame and sets the text
         * approprietly
         */
        crapsgame = new Craps();
        message.setText(crapsgame.getMessage());

        /**Adds the message to the panel. */
        top.add (message);
        bottom.add (credits);

        /**Gets the middle that are called for. */
        d1 = crapsgame.getDie(1);
        d2 = crapsgame.getDie(2);

        /** Sets up the listeners for the buttons. */
        ButtonListener listener = new ButtonListener();
        comeOut.addActionListener(listener);
        roll.addActionListener(listener);
        reset.addActionListener(listener);
        exit.addActionListener(listener);

        /** Sets the button greying-out up. */
        comeOut.setEnabled(true);
        reset.setEnabled(true);
        exit.setEnabled(true);
        roll.setEnabled(false);

        /**Adds the buttons to the panel. */
        bottom.add (comeOut);
        bottom.add (roll);
        bottom.add (reset);
        bottom.add (exit);

        /** Adds the Credits Label to the panel. */
        middle.add (credits);

        /**Adds the dice pictures to the panel. */
        middle.add (d1);
        middle.add (d2);

        /** adds the current point label to the panel. */
        middle.add (currentpoint);

        /**Adds the new Panels to the JFrame. */
        add (bottom, BorderLayout.SOUTH);
        add (middle, BorderLayout.CENTER);
        add (top, BorderLayout.NORTH);
    }

    /**
     * This subclass is used to gray out buttons if they should not
     * currently be usable.
     */

    private class ButtonListener implements ActionListener {

        /**
         * This method controls the greying out of buttons and which 
         * turns they are greyed out.
         */
        public void actionPerformed(ActionEvent event) {
            roll.setEnabled(false); //Sets roll to greyed out by default.

            /** 
             * This loop controls what come after a button is pushed.
             */
            if (crapsgame.credits > 0)
            {
                if (event.getSource() == comeOut)
                {
                    crapsgame.comeOut();
                }

                else if (event.getSource() == roll) 
                {    
                    crapsgame.roll();
                }

                /**
                 * Resets all variables to defaults
                 */
                else if (event.getSource() == reset) 
                {
                    crapsgame.reset();
                }

                /**
                 * exits out of the game.
                 */
                else if (event.getSource() == exit)
                {
                    crapsgame.exit();
                }

                /** 
                 * This loop controls the greying out of the buttons.
                 */
                if (crapsgame.okToRoll())
                {
                    roll.setEnabled(true);
                    comeOut.setEnabled(false);
                }
                else
                {
                    roll.setEnabled(false);
                    comeOut.setEnabled(true);
                }
            }

            /**
             * If you're out of credits, roll and comeout grey out 
             * and you have to choose reset the continue. This will 
             * set all variables back to the original values.
             */
            else 
            {
                message.setText("You're out of credits! Press Reset"
                    + " Game to play again!");
                roll.setEnabled(false);
                comeOut.setEnabled(false);
            }

            //Keeps the Credits jlabel updated.
            credits.setText("Credits: " + crapsgame.getCredits()); 
            //Keeps the current point jlabel updated.
            currentpoint.setText("Current Point: " + crapsgame.getPoint()); 
            //Keeps the message jlabel updated.
            message.setText(crapsgame.getMessage()); 
        }
    }

    /**
     * This main method is meant to test the gui to make sure it is 
     * functioning correctly and according the logic stated above.
     */
    public static void main(String args[])
    {
        JFrame frame = new JFrame ("A Game of Craps!");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        frame.setVisible(true);
    }
}

