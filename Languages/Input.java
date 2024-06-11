//This class holds various input methods to be used in Language

//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Input { // Beginning of Program
    
    public static String promptS() {//This is used whenever the program needs the user to input a String
        
        //These are basic variables used for temporary tasks
        boolean valid = false;
        String output = "";

        Scanner input;//The input is made with this
        
        do {//If the input fails the check, the loop will restart   
                    
            input = new Scanner(System.in);//This scanner is assigned here
            
            try {//This will check if the input is a String
                
                output = input.nextLine().trim();
                Double.parseDouble(output);//This checks if the input is a number
                
                System.out.print("Not a valid input! Please try again : ");
                input.close();
                
                continue;//If the input is a number, the loop is reset
                
            }catch(Exception e) {//If an error is found 
                
                input.close();
                valid = true;//The input is a string, and is valid
                
            }//END of check String
                       
        }while(! valid);//END of input String
        
        return output;//The output is returned
        
    }//END of promptS()
    
    
    public static int promptI() {//This is used whenever the program needs the user to input a Integer
        
        //These are basic variables used for temporary tasks
        boolean valid = false;
        int output = 0;

        Scanner input;//The input is made with this
        
        do {//If the input fails the check, the loop will restart   
                    
            input = new Scanner(System.in);//This scanner is assigned here
            
            try {//If it is not "random", this will check if the input is an Double value
                
                output = Integer.parseInt(input.nextLine().trim());//The input will be turned into an Integer value
                input.close();

                valid = true;//If no errors are received, the input is valid
                
            }catch(Exception e) {//If an error is found
                
                System.out.print("Not a valid number! Please input again : ");
                
                input.close();
                continue;//The loop will restart
                
            }//End of check Double
                       
        }while(! valid);//END of input Double
        
        return output;//The output is returned
        
    }//END of promptI()
    
    
    public static double promptD() {//This is used whenever the program needs the user to input a Double
        
        //These are basic variables used for temporary tasks
        boolean valid = false;
        double output = 0;

        Scanner input;//The input is made with this
        
        do {//If the input fails the check, the loop will restart   
                    
            input = new Scanner(System.in);//This scanner is assigned here
            
            try {//If it is not "random", this will check if the input is an Double value
                
                output = Double.parseDouble(input.nextLine().trim());//The input will be turned into a Double value
                input.close();

                valid = true;//If no errors are received, the input is valid
                
            }catch(Exception e) {//If an error is found
                
                System.out.print("Not a valid number! Please input again : ");
                
                input.close();
                continue;//The loop will restart
                
            }//End of check Double
                       
        }while(! valid);//END of input Double
        
        return output;//The output is returned
        
    }//END of promptD()
    
    
    public static boolean askUser() {//This is used whenever the user wants to calculate again
        
        //These are basic variables used for temporary tasks
        String output;
        boolean valid;
         
        do{//This loops until the user makes a valid input
            
            output = promptS().trim();//This will hold a valid String
        
            if(output.toLowerCase().equals("yes")) {//If the user says yes
                
                return false;//False is returned
                
            }else if(output.toLowerCase().equals("no")) {//If the user says no
                
                return true;//True is returned
                
            }else {//Else the input as invalid
                
                System.out.print("Invalid input! [YES] [NO] : ");
                valid = false;//The loop is reset
                
            }//END of ask user
            
        }while(! valid);//END of input choice
        
        System.exit(1);//If something goes wrong, the program is ended
        return false;
        
    }//END of askUser()
    
} // END of Class Input
