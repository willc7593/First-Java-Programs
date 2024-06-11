
/**
 * Title: WarmUp
 *
 * Summary: A Basic Program to indtoduce some ideas / concepts
 * 
 * Program Elements List: strings, ints, mathmatical operators, conditionals 
 * 
 */

// Imported Libraries Below. None used in this program

public class WarmUp
{
    // Global Variables
    private int w; // Not used in this program, Used in an imported method


    
    /**
     * Print a msg/warning for the user here.....
     * to make the interface meaningful 
     * 
     * It will show up in the Shell/GUI upon execution
     */
    public static void main(String[] args)
    {
        // Local Variables
        int x = 1; // primary inputs for calculation
        int y = 2;
        int z;
        String q; // Used for output to the user

        
        //User Interface: Welcoming Msg
        System.out.println("Welcome to the Warm-Up");
        System.out.println("Are you Ready for a Workout????");
        System.out.println("Gonna Flex those Coding Muscles");
        System.out.println("Lets Do Some Math!!!!!!");
        System.out.println(); System.out.println(); System.out.println();
        
        
        z = x + y; // Primary calculation in the program

        
        if (z == 3) { //Conditional used for Testing the output before reporting it to the user
            q = ("I am Freaking Amazing");
        
        } else if (z == 1) {
            q = ("NOOOT!!!!! My Kung Fu is not Strong");
            
        } else {
            q = ("an error has occurred in the z conditional");
            
        } // End of Z Conditional
        
        
        //User Interface: Output and Farewell
        System.out.println("Now I will impress you with my mathmatical skills");
        System.out.println();
        System.out.println("Do you know what "+ x + " + " + y + " is?");
        System.out.println("I do, cause " + q + ". \n\nThe Answer is: " + z); // primary output for the user
        System.out.println(); System.out.println();
        System.out.println("Look at Me, Look at What I Can Do"); 
        
    } // End of Main
} // End of Class
// End of Program


/*
 * Notes: 
 * 
 * 
 * Testing Statements:
 * 
 * 
 * */

