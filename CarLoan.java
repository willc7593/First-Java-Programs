// Assignment 4: Car Loan - By Will Croll


/* Program Summary: This program is designed to utilize conditional statements 
- It will take the car's brand, loan amount needed, down payment, intrest rate, and years to pay off
- Then it calculates how much the user needs to pay per month and return it to them
- It also prints a monthly documentation of the payment, to an inccrement of the user's choosing
*/


/* Important (KEY) Program Elemnts Used:
 - Comments
 - Variables and declaration (double, int, boolean)
 - Strings and concantenation
 - System.out.println() and .print()
 - ==, >= and <= comparisons
 - && and || comparisons
 - .equals()
 - Increment (++)
 - Math.round()
 - Classes and constructors (new)
 - Methods and functions (return)
 - \n
 - if/if else/else statements
 - switch/case/dafault statements
 - do/while loops
 - for loops
 - Arithmetic Operators (+, -, *, /)
 - .next() and .hasNext() and number equivalents
 - .toUpperCase() and .toLowerCase()
 - String.format("%.2f")
 - Data type casting
 - import, java.util, and Scanner
 - try/catch with Thread.sleep()
*/

import java.util.Scanner; // This line of code is placed outside of the class to import the Scanner class from java.util

public class CarLoan { // Beginning of Program
    
    // Instance Variables || These are all properties a new instance of CarLoan will inherit and write new values over
    
    //These variables will hold what their names imply, their values assigned by the user
    double loan, downPay, remaining;
    double intrestRate;
    double lengthYear, lengthMonth;
    
    String brand;//This holds the name of the brand the car is made by
    
    //CarLoan Constructor || The users loan will be made into an instance of CarLoan with this
    public CarLoan(String b, double p, double d, double r, double y) {
        
        //All inputted values are assigned to instance variables
        brand = b;
        
        loan = p;
        downPay = d;
        remaining = loan - downPay;
        
        lengthYear = y;
        lengthMonth = lengthYear*12;
        intrestRate = r;
        
    }//END of CarLoan Constructor
    
    
    // CarLoan Methods || These are calculations that can be performed on the loan
    
    public double findMonthly() {//This will find how much the user needs to pay per month (Not including intrest)
      
        return remaining / lengthMonth;
        
    }//END of findMonthly()
    
    public double includingIntrest(double num) {//This will return the desired value when it includes the intrest rate
         
        return (num * intrestRate)/100;
        
    }//END of includingIntrest()
    
    
    // Global Functions || These are functions to be used globally
    
    public static boolean valueCheck(double input, double limit){//This will be used inside the next function, and checks if the number is within the specifications
        
        if((input <= limit) && (input > 0)) {//If the input his under the limit and greter than (But not equal to) 0
            
            return true;
            
        }else {//Else it will return false
            
            return false;
            
        }//END of value check
        
    }//END of valueCheck Function
    
    
    public static double checkNum(String unitA, double limit, String context, String unitB) {//This will be used to take the input, and check if the number is a double; then it will return the value
        
        //These are variables used locally within the function for menial tasks
        boolean valid;
        double output;
        String fail;

        Scanner input;//Input will be made here
        
        System.out.print("Please input "+ context +". The limit is:"+ unitA + String.format("%.2f",limit) + unitB +": ");//A message prompt to the user
        do{//If the input fails the check, the loop will restart
            
            input = new Scanner(System.in);//This scanner is assigned here to be reset with every loop until a valid number is input
            
            if(input.hasNextDouble()) {//This will check if the input is a number
                
                output = input.nextDouble();//output will be set to the input
                
                if(valueCheck(output, limit)) {//This will call for valueCheck()
                    
                    System.out.println("The number "+"\""+ output +"\""+" is valid.\n\n");
                    
                    input.close();//Closes the scan
                    return output;//This will end the function, returning the value to be saved in the specified variable
                    
                }else {//If valueCheck() returns false, the program will take a different input
                    
                    System.out.print("\""+ output +"\""+ " is not a valid number! Please input again : ");
                    valid = false;
                    
                }//END of check value
                
            }else {//If not, the program will loop and take a different input
                
                fail = input.next();//The invalid string will be stored here to present to the user
                System.out.print("\""+ fail +"\""+" is not a number! Please input again : ");

                valid = false;
                
            }//END of check number
            
        }while(valid == false);//END of input loop
        
        return 0;//If something goes wrong, 0 will be returned
        
    }//END of checkNum Function
  
    
    public static boolean isGreater(double l, double d) {//This will check for if the inputted down payment is higher than the loan before they are asisgned
        
        if(d >= l) {//If the down payment is higher
            
            System.out.print("Your down payment cannot be higher than your loan! Please try again.\n\n\n");
            return true;
            
        }else {//Else the program continues
            
            System.out.print("The car can be paid for.\n\n\n");
            return false;
            
        }//END of greater check
        
    }//END of isGreater()
    
    
    public static String checkBrand() {//This will take the user's input and check if it matches the car brands presented; it will return the brand if true
        
        //These are variables used locally within the function for menial tasks
        boolean valid;
        String output;
        double fail;

        Scanner input;//Input will be made here
        
        System.out.println("Please input the brand of car you want to purchase from. Your options:");
        System.out.print("[TOYOTA] [CHEVROLET] [HONDA] [VOLKSWAGEN] [JEEP] [MISTSUBISHI] [FORD] [BMW] [FERARRI] [MAZDA] : ");//These are the valid brands
        do{//If the input fails the check, the loop will restart
            
            input = new Scanner(System.in);//This scanner is assigned here to be reset with every loop until a valid number is input
            
            if(input.hasNext()) {//This will check if the input is a number
                
                output = input.next().toUpperCase();//output will be set to the input
                
                switch(output) {//This switch statement checks through all the available car brands
                    
                    //For every case with a brand, it will return the selected brand to the user, 
                    //Return the cost of the car,
                    //And return the output
                   
                    case "TOYOTA": System.out.println("\nYou chose: "+"\""+ output +"\""); 
                    input.close();
                    return output;

                    case "CHEVROLET": System.out.println("\nYou chose: "+"\""+ output +"\"n\n");
                    input.close();
                    return output;

                    case "HONDA": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    case "VOLKSWAGEN": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    case "JEEP": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    case "MITSUBISHI": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    case "FORD": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;
                    
                    case "BMW": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    case "FERARRI": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    case "MAZDA": System.out.println("\nYou chose: "+"\""+ output +"\"\n\n");
                    input.close();
                    return output;

                    default : System.out.print("Sorry, we don't have that brand for sale! Please make another selection : ");//If the input is invalid,
                    valid = false;//The loop runs again
                    
                }//END of check brand
                
            }else {//If not, the program will loop and take a different input
                
                fail = input.nextDouble();//The invalid string will be stored here to present to the user
                System.out.print("\""+ fail +"\""+" is not a valid input! Please input again : ");

                valid = false;//The loop wil run again
                
            }//END of check number
            
        }while(valid == false);//END of input loop
        
        return "Car";//If something goes wrong, 0 will be returned
        
    }//END of checkBrand()
    
    
    public static double checkCost(String input) {//If the user wants to use the car brand's specific price, this simply returns the car's price
        
        switch(input) {//This switch statement checks through all the available car brands
                    
            //For every case with a brand, the specific price is output to the user
            //And return the specific price
                   
            case "TOYOTA": System.out.println("\nA Toyota will cost: $31,358.75\n\n");
            return 31358.75;

            case "CHEVROLET": System.out.println("\nA Chevrolet will cost: $42,412.5\n\n");
            return 42412.5;

            case "HONDA": System.out.println("\nA Honda will cost: $28,513.75\n\n");
            return 28513.75;

            case "VOLKSWAGEN": System.out.println("\nA Volkswagen will cost: $22,432\n\n");
            return 22432;

            case "JEEP": System.out.println("\nA Jeep will cost: $35,306.25\n\n");
            return 35306.25;

            case "MITSUBISHI": System.out.println("\nA Mitsubishi will cost: $28,500\n\n");
            return 28500;

            case "FORD": System.out.println("\nA Ford will cost: $36,326.75\n\n");
            return 36326.75;
                    
            case "BMW": System.out.println("\nA BMW will cost: $69,057.14\n\n");
            return 69057.14;

            case "FERARRI": System.out.println("\nA Ferarri will cost: $276,550\n\n");
            return 276550;

            case "MAZDA": System.out.println("\nA Mazda will cost: $27,265\n\n");
            return 27265;

            default : System.out.println("\nSomething went wrong! Whoops!");
            return 0; 
            
        }//END of check brand
        
    }//END of checkCost()
    
    public static boolean askUser() {
        
        //These are variables used locally within the function for menial tasks
        boolean valid;
        double fail;
        String output;

        Scanner input;//Input will be made here
        
        System.out.print("Do you want to calculate a custom car price or a pre-determined price related to your brand? [CUSTOM] [BRAND] : ");//A message prompt to the user
        do{//If the input fails the check, the loop will restart
            
            input = new Scanner(System.in);//This scanner is assigned here to be reset with every loop until a valid number is input
            
            if(input.hasNext()) {//This will check if the input is a number
                
                output = input.next();//output will be set to the input
                
                if(output.toLowerCase().equals("custom")) {//This will call for valueCheck()
                    
                    input.close();//Closes the scan
                    return true;//This will end the function, returning the true
                    
                }else if(output.toLowerCase().equals("brand")) {
                    
                    input.close();//Closes the scan
                    return false;//This will end the function, returning false
                    
                }else {//If valueCheck() returns false, the program will take a different input
                    
                    System.out.print("\""+ output +"\""+ " is not a valid input! Please input again : ");
                    valid = false;
                    
                }//END of check value
                
            }else {//If not, the program will loop and take a different input
                
                fail = input.nextDouble();//The invalid string will be stored here to present to the user
                System.out.print("\""+ fail +"\""+" is not a valid input! Please input again : ");

                valid = false;
                
            }//END of check number
            
        }while(valid == false);//END of input loop
        
        return false;//If something happens, flase is returned
        
    }//END of askUser()
    
    // CarLoan Main Execution || All the main blocks of code for the program are run here
    
    public static void main (String[] args) { // Beginning of Main
        
        
        // Variable Declarations || While there are instance variables for the car loan, there are temporary and important variables declared here
        
        //These will temporarily hold the input of the user
        double cost, down, rate, years;  
        String model;
        
        //These are primarily used in calculation and output to the user
        double monthlyBalance, monthlyPayment, intrest;
        double totalPayment = 0;
        double totalLeft;
        
        //These are incrementors used in the primary output loop 
        int inc;
        int incTot;
        
        CarLoan myCar;//This is the new instance of the CarLoan class used in the calculation
        
        
        // Beginning of Main Block of Code || The main inputs are taken and assigned here, and the main calculations on the loan are carried out
        
        //Welcome message
        System.out.println("Welcome to the Car Loan Calculator, made by Will Croll.");
        System.out.println("This program will take the parameters of your car loan and calculate how much you need to pay per month!\n\n");
        try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
        
        model = checkBrand();//This will take the users input for the car brand
        
        if(askUser()) {
            
            cost = checkNum(" $", 500000, "the price of the car (The amount to loan)", " ");
            
        }else{
            
            cost = checkCost(model);
            
        }//END of check cost type
        
        do{//Since the down payment cannot be higher or equal to the loan, this loop will continually take the user's input until it'svalid
            
           down = checkNum(" $", 5000, "your beginning down payment", " ");//Takes the down payment

        }while(isGreater(cost, down));//END of input loop
        
        rate = checkNum(" ", 15, "the interest rate of your loan","% ");//Takes the intrest rate
        years = checkNum(" ", 7, "the amount of years you want to pay for", " years ");//Takes the amount of years
              
        myCar = new CarLoan(model, cost, down, rate, years);//The new values are assigned to myCar
        
        //Here are the main calculations carried out
        monthlyBalance = myCar.findMonthly();//This finds how much is payed per month WTHOUT intrest
        monthlyPayment = monthlyBalance + myCar.includingIntrest(monthlyBalance);//Finds monthly pay WITH intrest
        totalLeft = myCar.remaining + myCar.includingIntrest(myCar.remaining);//Finds how much total money is owed including intrest
        
        // End of Main Block of Code
        
        
        
        // User Interface || The primary outputs to the user are recorded here
        
        System.out.println("The total loan will cost: $"+ String.format("%.2f",totalLeft));//Returns total amount
        System.out.println("Every month, you will have to pay: $"+ String.format("%.2f",monthlyPayment) +"\n\n");//Returns monthly amount
        try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
        
        System.out.print("Your monthly payment will now be printed out to you. ");
        
        inc = (int) Math.round(checkNum(" ", myCar.lengthMonth, "how many months to increment by", " months"));//This asks for an increment of months
        incTot = inc;
        //Since the user can input a decimal, the value is cast to an integer
        
        System.out.println("\n****************************************************************");
        for(int i = 1; i <= myCar.lengthMonth; i++) {//This loop runs until it meets the total amount of months
            
            //Every loop, the total paid inrceases and total left decreases accordingly
            totalPayment += monthlyPayment;
            totalLeft -= monthlyPayment;
            
            if((i == incTot) || (i == myCar.lengthMonth)) {//The amount is only output if it lines up with the user-chosen incrementor
                
                System.out.println("\nMonth "+ i + ": TOTAL PAID: $"+ String.format("%.2f",totalPayment) +" / TOTAL LEFT: $"+ String.format("%.2f",totalLeft));
                try{Thread.sleep(500);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
                
                incTot += inc;//The monthly increment is increased
                
            }//END of check output
            
        }//END of monthly loop
        System.out.println("\n*****************************************************************");

        System.out.println("\n\nThanks for using the Car Loan Calculator Program! Good luck purchasing your "+ myCar.brand +"!");//Thank you message

    }// END of Main
}// END of Class CarLoan
//END of Program


/* Notes:
- Sometimes the 0.00 when months are outputted comes out as -0.00?
- Users may input a decimal to increment each month by, so the months are casted to an int just for clean formatting purposes
- If I was smarter less functions would have to be created, but for now it works fine
*/
