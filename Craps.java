
/**
 * This is the Craps Game main file in this class. Responsible for most game functions.
 * 
 * @author TJ Zimmerman 
 * @version 1.01
 */

public class Craps
{
    /**Makes objects for each of the two dice. */
    public GVdie d1, d2; 

    /**Initializes and sets the return point of the game to 
     * negative one.
     */
    public int point;

    /**Initializes and sets the games credits to 10.*/
    public int credits;

    /**Sets the inital welcome message to the game.*/
    public String message;

    /**Sets the boolean up that controls which portion of 
     * the game you're on.
     */
    public boolean comeoutlegal;

    /**
     * Constructer sets the variables to paramters.
     */
    public Craps ()
    {
        d1 = new GVdie();
        d2 = new GVdie();

        point = -1;
        credits = 10;
        message = "Hello! Welcome to Craps! Press 'Come Out' to begin!";
        comeoutlegal = true;       

    }

    /**
     * Returns credits for each game.
     * @return credits
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Returns current point for each game.
     * @return point
     */
    public int getPoint()
    {
        return point;
    }

    /**
     * Returns message for each game.
     * @return message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * This sets the credits to amount of amount is greater than 
     * inital credits.
     */
    public void setCredits (int amount)
    {
        if (amount >= 0)
        {
            credits = amount;
        }
    }

    /**
     * This is the primary method that the come out function of the
     * game uses. A nested if then statement incorporates logic into 
     * the game and makes it behave properly.
     */
    public void comeOut()
    {
        int r1 = 0;
        int r2 = 0;

        /**
         * This loop sets your credit score modifiers and what 
         * portion of the game you will continue to.
         */
        if (comeoutlegal && credits >= 1)
        {
            d1.roll();
            d2.roll();
            r1 = d1.getValue();
            r2 = d2.getValue();

            int dt = r1+r2;

            if (dt == 7)
            {
                credits++;
                message = "Rolled 7: +1 credit! Come out, again!";
                //Continue to Come out.
            }

            else if (dt == 11)
            {
                credits++;
                message = "Rolled 11: +1 credit! Come out, again!";
                //Continue to Come out.
            }

            else if (dt == 2)
            {
                credits--;
                message = "Rolled 2: -1 credit. Come out again!";
                //Continue to Come out.
            }

            else if (dt == 3)
            {
                credits--;
                message = "Rolled 3: -1 credit. Come out again!";
                //Continue to Come out.
            }

            else if (dt == 12)
            {
                credits--;
                message = "Rolled 12: -1 credit. Come out again!";
                //Continue to Come out.
            }

            else 
            {
                point = dt;
                comeoutlegal = false;
                message = "You rolled a(n) " + dt + 
                ". Roll out, now!";
                //Move to Roll out.
            }
        }

        else 
        {
            message = "You're out of credits! Press Reset Game to" +
            "play again!";
        }
    }

    /**
     * This is the primary method that the roll function of the game 
     * uses. A nested if then statement incorporates logic into the 
     * game and makes it behave properly.
     */
    public void roll ()
    {
        int r1 = 0;
        int r2 = 0;

        /**
         * This loop sets your credit score modifiers and what 
         * portion of the game you will continue to.
         */
        if (!comeoutlegal)
        {
            d1.roll();
            d2.roll();
            r1 = d1.getValue();
            r2 = d2.getValue();

            int dt = r1+r2;

            if (dt == 7)
            {
                credits--;
                point = -1;
                message = "Rolled 7: -1 credit. Come out now!";
                comeoutlegal = true;
                //Move to Come out.
            }

            else if (dt == point)
            {
                credits++;
                point = -1;
                message = "Rolled point. +1 credit. Come out now!";
                comeoutlegal = true;
                //Move to Come out.
            }

            else 
            {
                message = "Rolled a(n) " + dt + ". Not a 7 or " + point
                + ". Roll again!";
                //Continue to Roll.
            }
        }

        else 
        {
            message = "ERROR, See Roll method to debug!!";
        }
    }

    /**
     * While it wasn't required, I felt like adding a reset method 
     * anyway as it would be very simple and would certainly 
     * enhance the game.
     */
    public void reset()
    {
        point = -1;
        credits = 10;
        message = "Hello! Welcome to Craps! Press 'Come Out' to begin!";
        comeoutlegal = true;  
    }

    /**
     * While it wasn't required, I felt like adding an exit method
     * anyway as it would be very simple and would certainly 
     * enhance the game.
     */
    public void exit()
    {
        System.exit(0);
    }

    /**
     * This method decides whether the roll option should be used or not.
     */
    public boolean okToRoll()
    {
        if (comeoutlegal == false)
        {
            return true;
        }

        else if (comeoutlegal == true)
        {
            return false;
        }

        return comeoutlegal;
    }

    /**
     * This method instantiates the die objects and supplies them with
     * a value.
     */
    public GVdie getDie (int num)
    {
        {
            if(num == 1)
            {
                return d1;  
            }
            else
            {    return d2;
            }
        }
    }

    /**
     * Main Method is used to test the principal logic of the game.
     */
    public static void main (String[] args)
    {
        Craps crapsgame = new Craps();

        crapsgame.getMessage();
        crapsgame.comeOut();
        crapsgame.getMessage();

        /**
         *This loop continues to roll the dice until it is time to move
         *on to comeoutlegal part.
         */
        while (crapsgame.okToRoll())
        {
            crapsgame.roll();
            System.out.println (crapsgame.getMessage());
        }

        System.out.println ( "Total Credits: " + crapsgame.getCredits());
    }
}
