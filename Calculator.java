// Assignment 2: Calculator - By Will Croll


/* Program Summary: This program is designed to utilize classes and functions/methods in Java.
 * It will take 3 inputs from the user, a number, the arithmetic operator it will operate with,
 * and the second number. The equation will be carried out and displayed to the user
 * Any incorrect input will checked for and will ask the user to try another input.
*/


/* Important (KEY) Program Elements Used:
 - Comments
 - Variables and declaration (double, char, int, boolean)
 - Strings and concantenation
 - System.out.println()
 - ==, >= and <= comparisons
 - Increment (++)
 - Classes and constructors (new)
 - Methods and functions (return)
 - \n
 - if/else statements
 - switch/case/beak/default statements
 - do/while statements
 - Arithmetic Operators (+, -, *, /, %)
 - .next() and .hasNext() and number equivalents
 - import, java.util, and Scanner
 - try/catch with Thread.sleep()
 */

import java.util.Scanner; // This line of code is placed outside of the class to import the Scanner class from java.util

public class Calculator { // Beginning of Program
    
    //These are all instance variables that can be accessed by new instances of the Calculator class
    double first;//These will hold the two numbers and operator to use in the Calculator methods
    char second;
    double third;
    
    //Calculator Constructor || myCalculator will be an instance of this, using the inputs as parameters
    public Calculator(double a, char op, double b) {
        first = a;
        second = op;
        third = b;
    }//END of Calculator Constructor
    
    //Calculator Methods || All of these are calculations to be carried out by myCalculator
    public double add(double a, double b) {//An addition equation
        return (a + b);
    }//END of add Method
    
    public double subtract(double a, double b) {//An subtraction equation
        return (a - b);
    }//END of subtract Method
    
    public double multiply(double a, double b) {//An multiplication equation
        return (a * b);
    }//END of multiply Method
    
    public double divide(double a, double b) {//An division equation
        return (a / b);
    }//END of divide Method
    
    public double modulo(double a, double b) {//An modulus equation
        return (a % b);
    }//END of modulo Method
    
    
    
    //Public Functions || These are not methods partial to the Calculator class, but functions accessible throughout the program
    public static boolean valueCheck(double input){//This will be used inside the next function, and checks if the number is within the specifications
        if((input >= -1000) && (input <= 1000) && (input != 0)) {
            return true;
        }else {
            return false;
        }//END of value check
    }//END of valueCheck Function
    
    public static double checkNum() {//This will be used to take the input, and check if the number is a double; then it will return the value
        System.out.println("Please input a whole number between -1000 and 1000. Do not input 0, words, or symbols.");
        
        //These are variables used locally within the function for menial tasks
        boolean valid;
        double output;
        String fail;
        int i = 0;
        
        do{//Beginning of a do/while loop
            Scanner input = new Scanner(System.in);//This scanner is declared here to be reset with every loop until a valid number is input
            i++;//Increment
            
            if(input.hasNextDouble()) {//This will check if the input is a number
                output = input.nextDouble();//output will be set to the input
                
                if(valueCheck(output)) {//This will call for valueCheck()
                    
                    System.out.println("The number "+"\""+ output +"\""+" is valid.\n\n");
                    
                    input.close();//Closes the scan
                    return output;//This will end the function, returning the value to be saved in the specified variable
                    
                }else {//If valueCheck() returns false, the program will take a different input
                    
                    System.out.println("\""+ output +"\""+ " is not a valid number. Please input again.");
                    if(i == 3) {System.out.println("Can you read instructions?");}//Secret message if user fails 3 times
                    
                    valid = false;
                }//END of check value
                
            }else {//If not, the program will loop and take a different input
                fail = input.next();
                
                System.out.println("\""+ fail +"\""+" is not a number. Please input again.");
                if(i == 3) {System.out.println("Can you read instructions?");}//Secret message if user fails 3 times
                
                valid = false;
            }//END of check number
            
        }while(valid == false);//If the input fails the check, it will be sent to the beginning
        
        return 0;//If something goes wrong, 0 will be returned
    }//END of checkNum Function
    
    public static boolean operatorCheck(char input) {//This will be used in the next function, and checks if the input matches an operator
        switch(input) {//This will be used to search the different cases, and if it matches the input it will return true
            case '+': return true;
            
            case '-': return true;
            
            case '*': return true;
           
            case '/': return true;
            
            case '%': return true;
            
            default: return false;
        }//END of check operator
    }//END of operatorCheck Function
    
    public static char checkChar() {//This will be used to take an input, check if it's is a char and valid operator, and return the value
        System.out.println("Please input an operator to calculate with. Please choose from +, -, *, /, and %");
        
        //These are variables used locally within the function for menial tasks
        boolean valid;
        char output;
        double fail;
        int i = 0;
        
        do{//Beginning of a do/while loop
            Scanner input = new Scanner(System.in);//This scanner is declared here to be reset with every loop until a valid number is input
            i++;//Increment
            
            if(input.hasNext()) {//This will check if the input is a String/char
                output = input.next().charAt(0);//output will be set to the input
                
                if(operatorCheck(output)){//This will call operatorCheck()
                    
                    System.out.println("The operator "+"\""+ output +"\""+" is valid.\n\n");
                    
                    input.close();//Closes the scan
                    return output;//This will end the function, returning the value to be saved in the specified variable
                    
                }else {//If operatorCheck() returns false, the program will take a different input
                    
                    System.out.println("\""+ output +"\""+" is not a valid operator. Please input again.");
                    if(i == 3) {System.out.println("Can you read instructions?");}//Secret message if user fails 3 times
                    
                    valid = false;
                }//END of check operator
                
            }else {//If not, the program will loop and take a different input
                fail = input.nextDouble();
                
                System.out.println("\""+ fail +"\""+" is not a valid operator. Please input again.");
                if(i == 3) {System.out.println("Can you read instructions?");}//Secret message if user fails 3 times
                
                valid = false;
            }//END of check char
            
        }while(valid == false);//If the input fails the check, it will be sent to the beginning
        
        return ' ';//If something goes wrong, a blank char will be returned
    }//END of checkChar Function
    
    public static boolean tryAgain() {//This will be used when asking the user to do another calculation
        String valid;//Basic variable used to store input
        Scanner question = new Scanner(System.in);//New scanner for taking user input
        
        if(question.hasNext()) {
            valid = question.next();//A valid string will be stored here
            
            if(valid.toLowerCase().equals("yes")) {//Checks if the string is yes or no
                System.out.println("\n\n");
                return true;
            }else if(valid.toLowerCase().equals("no")) {
                System.out.println("\n\nThank you for using the Calculator Program!");
                return false;
            }else {//Ends program is false
                System.out.println("Invalid input. Program ending...");
                return false;
            }//End of check answer
            
        }else {//Ends program if invalid input
            System.out.println("Invalid input. Program ending...");
            return false;
        }//END of check string
        
    }//END of tryAgain Function
    
    
    public static void main (String[] args) { // Beginning of Main
        //Welcome message
        System.out.println("Welcome to the Calculator Program, made by Will Croll.\nThis program will take two numbers and an operator and do the math!\n\n");
        
        do{//This do/while loop will execute the entire program as many times as the user wants
        
            // Variable Declarations || All main variables used in the program are declared here, but not yet assigned
            double numA;//First number
            double numB;//Second number
            char operator;//Arithmetic operator
    
            Calculator myCalculation;//New instance of the Calculator class
            
            
            // Beginning of Main Block of Code || All main functions/methods are called here
            
            //Here 3 inputs will be taken, they will be checked, and then assigned to these variables
            numA = checkNum();
            operator = checkChar();
            numB = checkNum();
    
            myCalculation = new Calculator(numA, operator, numB);//This new instance will write over it's instance variables with it's unique values
            // End of Main Block of Code
            
            
            
            //User Interface || All the outputs to the user (After the welcome and inputs) are written here
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Used to create a cool momentary break in execution
            
            //Below is the final calculation, which accesses myCalculation's methods and outputs the final equation
            switch(myCalculation.second) {//This searches which arithmetic operation to be carried out
                
                case '+': System.out.println(numA +" "+ operator +" "+ numB +" = "+ myCalculation.add(myCalculation.first, myCalculation.third));
                System.out.println("Your answer is: "+ myCalculation.add(myCalculation.first, myCalculation.third));//Addition equation
                break;
                
                case '-': System.out.println(numA +" "+ operator +" "+ numB +" = "+ myCalculation.subtract(myCalculation.first, myCalculation.third));
                System.out.println("Your answer is: "+ myCalculation.subtract(myCalculation.first, myCalculation.third));//Subtraction equation
                break;
                
                case '*': System.out.println(numA + " "+ operator +" "+ numB +" = "+ myCalculation.multiply(myCalculation.first, myCalculation.third));
                System.out.println("Your answer is: " + myCalculation.multiply(myCalculation.first, myCalculation.third));//Multiplication equation
                break;
                
                case '/': System.out.println(numA + " "+ operator +" "+ numB + " = " + myCalculation.divide(myCalculation.first, myCalculation.third));
                System.out.println("Your answer is: " + myCalculation.divide(myCalculation.first, myCalculation.third));//Division equation
                break;
                
                case '%':System.out.println(numA +" "+ operator +" "+ numB +" = "+ myCalculation.modulo(myCalculation.first, myCalculation.third));
                System.out.println("Your answer is: "+ myCalculation.modulo(myCalculation.first, myCalculation.third));//Modulus equation
                break;
                
                default: System.out.println("Something went wrong! Please try again.");//If all else fails, this will be outputted
                
            }//END of switch statement
            
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Used to create a cool momentary break in execution
            
            System.out.println("\n\nWould you like to do another calculation? Input \"Yes\" or \"No\"");//Final thank you output


        }while(tryAgain());//The program will call tryAgain() and ask if the user wants to calculate again
        
    } // END of Main
} // END of Class Calculator
//END of Program


/* Notes:
- doubles are used instead of integers to allow for decimals in calculations
- try/catch statements are put on one line since I have yet to fully understand them
- The number limit is set since the variables can't handle extremely large numbers
- I made the proccess a bit more complicated than it could have been just to prove my knowledge of instance variables and methods
*/

