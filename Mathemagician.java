// Assignment 1: Mathemagician - By Will Croll


/* Program Summary: This program is designed to utilize Arithmetic Operators in Java.
 * It uses a magic equation to turn any (User inputted) number into 3, and will
 * return the answer to the user while walking through the process for them.
 * Any incorrect input will checked for and end the program.
*/


/* Important (KEY) Program Elemnts Used:
 - Comments
 - Integer variables and declaration
 - System.out.println()
 - >= and <= comparisons
 - Classes (new)
 - \n
 - if/else statements
 - Arithmetic Operators (+, -, *, /)
 - Long equations
 - System.exit(0)
 - .nextInt() and .hasNextInt()
 - import, java.util, and Scanner
 - try/catch with Thread.sleep()
 */

import java.util.Scanner; // This line of code is placed outside of the class to import the Scanner class from java.util

public class Mathemagician { // Beginning of Program
    public static void main (String[] args) { // Beginning of Main
        
        
        // Variable Declarations || All main variables used in the program are declared here, but not yet assigned
        int myNumber;//The primary number used in calculations from the user
        int stepOne, stepTwo, stepThree, stepFour, stepFive;//Different steps used in calculation, one variable per step
        int stepSix;//The last step will result become 3 no matter what
        int extra;//An extra variable used to streamline the equation
        
        Scanner num = new Scanner(System.in);//This will set a Scanner class to take the user's primary input

        
        
        // Beginning of Main Block of Code || All calculations 
        System.out.println("Welcome to the Mathemagician Program, made by Will Croll.\nThis program will take any number and magically turn it into 3! \n");
        System.out.println("Please input a whole number between -1000 and 1000. Words and symbols will end the program.");
        //Welcome message put before code so input can be calculated
        
        
        if(num.hasNextInt()) {//This if/else block will take the input and check if it's an integer
            
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            //These try/catch statements are used to create "breaks" in the execution just to make it look fancy
            System.out.println("Input read succesfully.");
            
        }else {//If the input fails the check, the program will end
            
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            System.out.println("Invalid input. Please try again.");
            try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            System.exit(0);//This will end the program and take the user to the project screen
            
        }//END of integer check
        myNumber = num.nextInt();//If the input passes the check, the value will be assigned to a variable so it can be manipulated
        
        
        if((myNumber >= -1000) && (myNumber <= 1000)) {//This if/else is another check, this time to see if the number is within the parameters
            
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            System.out.println("Input is verified.");
            
        }else {//If the number fails the check, the program will end
            
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            System.out.println("Invalid number. Please try again.");
            try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            System.exit(0);//This will end the program and take the user to the project screen
            
        }//END of limit check
        stepOne = myNumber * myNumber;//All these steps carry out the different calculations of the process
        stepTwo = stepOne + myNumber;//These variables are helpful for displaying the current value when the process is printed out to the user
        stepThree = stepTwo / myNumber;
        stepFour = stepThree + 17;
        stepFive = stepFour - myNumber;
        stepSix = stepFive / 6;//The final value, 3, will be stored in this variable
        
        
        extra = ((myNumber * myNumber + myNumber) / myNumber + 17 - myNumber) / 6;/*Here, I simplified the process of the equation.
        * In actual coding, this is much more efficient then making multiple variables for every step
        * To prove this method also works, the 'extra' variable will be used in the final output and will read 3
        */
        // End of Main Block of Code
        
        
        
        //User Interface || All the oututs to the user (After the welcome) are written here
        try{Thread.sleep(1500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//More fancy pauses
        System.out.println("Your number is: " + myNumber +"\n");//This confirms to the user the number they inputted
        
        //Every step here walks the user through the process of the equation
        try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println(myNumber + " multiplied by itself equals: " + stepOne + "...");
        try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println(stepOne + " plus " + myNumber + " equals: " + stepTwo + "...");
        try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println(stepTwo + " divided by " + myNumber + " equals: " + stepThree + "...");
        try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println(stepThree + " plus 17 equals: " + stepFour + "...");
        try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println(stepFour + " minus " + myNumber + " equals: " + stepFive + "...");
        try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println(stepFive + " divided by 6 equals: " + stepSix + ".\n");//The final step
        
        //Final few outputs
        try{Thread.sleep(1500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println("And would you look at that, the magic number is: " + extra + "!\n");//Primary output should read 3 no matter what
        //'Extra' is used instead of stepSix to show that it works better 
        try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        System.out.println("Thank you for using the Mathemagician Program!");//Thank you message
        
        
        
    } // END of Main
} // END of Class Mathemagician
//END of Program


/*
- try/catch statements are put on one line since I have yet to fully understand them
- The integer limit is set since the variables can't handle larger numbers
- if/else statements work the exact same as JavaScript which is great
*/

