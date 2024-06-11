// Assignment 5: School Marks - By Will Croll


/* Program Summary: This program is designed to utilize arrays and loops
- The user will input the number of classmates and their respective names and grades, as well as input their own name and grade
- The program will Take the grades and calculate the average
- It will also order the grades from least to greatest, and find the largest and smallest grades
*/


/* Important (KEY) Program Elemnts Used:
 - Comments
 - Variables and declaration (double, int, char, boolean)
 - Strings and concantenation
 - Arrays and ArrayLists
 - Scanners
 - System.out.println() and .print()
 - .equals(), .concat(), and Arrays.toString()
 - .add(), .get(), .remove(), .indexOf(), and .toString()
 - = and += assignment
 - >, <, ==, >= and <= comparisons
 - &&, ||, and ! comparisons
 - Increment (++)
 - Classes and constructors (new)
 - Methods and functions (return)
 - \n and \u000C
 - if/if else/else statements
 - try/catch statements (continue)
 - do/while loops
 - for and for/each loops 
 - .next() and .hasNext() / .nextInt() and .hasNextInt()
 - .toUpperCase() and .toLowerCase()
 - Math.round() and Math.random()
 - Data type casting (int)
 - import (java.util)
 - Thread.sleep()
 - System.exit(1)
*/


//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class SchoolMarks { // Beginning of Program
    
    // Instance Variables || These are values every instance of a student has
    
    String name;
    char letterGrade;
    double grade;
    boolean isUser = false;
    
    
    // SchoolMarks Methods || Every student will be able to do these
    
    public SchoolMarks(boolean yes) {//This is the SchoolMarks constructor, and dosen't do much except check if the student is the user
    
        if(yes) {//If the student is the user
            
            isUser = true;//isUser is set to true  
            
        }//END of user check
        
    }//END of SchoolMarks Constructor
    
    
    public void getLetter() {//This will check the student's grade and assign a letter grade
        
        if(grade >= 86) {//If it's greater than 86
            
            letterGrade = 'A';//It's an A
            
        }else if(grade >= 76) {//If it's greater than 76
            
            letterGrade = 'B';//It's a B
            
        }else if(grade >= 66) {//If it's greater than 66
            
            letterGrade = 'C';//It's a C
            
        }else if(grade >= 50) {//If it's greater than 50
            
            letterGrade = 'D';//It's a D
            
        }else {//If it's less than 50
            
            letterGrade = 'F';//It's an F
            
        }//END of check grade
        
    }//END of getLetter()
    
    
    public void getName(String context, String[] list) {//This will take the user's input for a grade
        
        //These are basic variables used for temporary tasks
        boolean valid = false;
        String output;

        System.out.print("\nPlease input "+ context +" name within 20 characters [RANDOM] : ");
        
        do {//This will loop until the user makes a valid input
            
            output = promptS();//output will be assigned to an input
            
            if(output.toLowerCase().equals("random")) {//If the input is "random"
                
                output = list[(int) Math.round(Math.random()*13)];//The output will be a random name
               
                System.out.println("\""+ output +"\" is "+ context +" name now.");
                name = output;//The name instance variable is set to the random name
                valid = true;
                
            }else if(output.length() > 20) {//If the input was more than 20 characters
                
                System.out.print("Please input a name WITHIN 20 characters : ");
                valid = false;//The user will have to input again
                
            }else {//If the name is normal
                
                System.out.println("Selected name is: \""+ output +"\".");
                name = output;//The name instance variable is set to the name
                valid = true;
                
            }//END of check name
            
        }while(! valid);//END of input loop
        
    }//END of getName()
    
    
    public void getGrade(String context) {//This will take the user's input for a grade
         
        //These are basic variables used for temporary tasks
        boolean valid = false;
        double output;
        
        System.out.print("\nPlease input "+ context +" grade from 0 to 100 [RANDOM] : ");
        
        do {//This will loop until the user makes a valid input
            
            output = promptD();//output will be assigned to an input
            
            if(output == 12345) {//If the user input "random" (Which is returned as 12345)
                
                output = Math.round(Math.random()*100);//The output will be a random number between 0 and 100
               
                System.out.println("\""+ output +"\" is "+ context +" grade now.");
                grade = output;//The grade instance variable is set to the random grade
                valid = true;
                
            }else if((output < 0) || (output > 100)) {//If the input is less than 0 or greater than 100
                
                System.out.print("Please input a grade FROM 0 TO 100 : ");
                valid = false;//The user will have to input again
                
            }else {//If the grade is normal
                
                System.out.println("Selected grade is: \""+ output +"\".");
                grade = output;//The grade instance variable is set to the grade
                valid = true;
                
            }//END of check grade
            
        }while(! valid);//END of input loop
        
        getLetter();//Now that the grade is assigned, the letter grade can also be found
        
    }//END of getGrade()
   
    
    public void getAverage(double[] grades) {//On the average "student", the average of all grades can be found
        
        double result = 0;//All the grades added up will be put into this
        
        for(double studentGrade : grades) {//For every grade
           
            result += studentGrade;//It will be added to result
            
        }//END of for each grade
        
        grade = Math.round(result/grades.length);//The grade instance variable of average will be set to every grade added up divided by the amount
        getLetter();//Now that the grade is assigned, the letter grade can also be found
        
    }//END of getAverage()

    
    // Global Functions || These are tasks that can be exectued throughout the program
    
    public static double promptD() {//This is used whenever the program needs the user to input a Double
        
        //These are basic variables used for temporary tasks
        boolean valid = false;
        String randoCheck;
        double output = 0;

        Scanner input;//The input is made with this
        
        do {//If the input fails the check, the loop will restart   
                    
            input = new Scanner(System.in);//This scanner is assigned here
            randoCheck = input.nextLine();//The input is temporarily assigned to this to check if it's "random"
            
            if(randoCheck.toLowerCase().equals("random")) {//If the input is "random"
                
                input.close();
                return 12345;//This specific number is returned, used to assign a random grade
                
            }//END of check random
            
            try {//If it is not "random", this will check if the input is an Double value
                
                output = Math.round(Double.parseDouble(randoCheck));//The input will be turned into an Integer value
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
    
    
    public static String promptS() {//This is used whenever the program needs the user to input a String
        
        //These are basic variables used for temporary tasks
        boolean valid = false;
        String output = "";

        Scanner input;//The input is made with this
        
        do {//If the input fails the check, the loop will restart   
                    
            input = new Scanner(System.in);//This scanner is assigned here
            
            try {//This will check if the input is a String
                
                output = input.nextLine();
                Double.parseDouble(output);//This checks if the input is a number
                
                System.out.print("Not a valid sentence! Please input again : ");
                input.close();
                
                continue;//If the input is a number, the loop is reset
                
            }catch(Exception e) {//If an error is found 
                
                input.close();
                valid = true;//The input is a string, and is valid
                
            }//END of check String
                       
        }while(! valid);//END of input String
        
        return output;//The output is returned
        
    }//END of promptS()

    
    public static double[] orderList(double[] list, int num) {//This runs through all the grades and orders them from lowest to highest
        
        double lowest;//This is used as the current lowest of the loop
        double[] output = new double[list.length];//This holds the newly ordered list
        
        ArrayList<Double> input = new ArrayList<Double>();//This holds the inputted list to be sorted
        
        for(double grade : list) {//This adds all the inputted grades into input
            
            input.add(grade);//Adds the current grade

        }//END of set input list
        
        for(int i = 0; i < num; i++) {//This will add the lowest value of each loop to the output
            
            lowest = 100;//This is reset every loop to be used as a starter point
            
            for(double grade : input) {//For every grade in the input list
                
                if(grade <= lowest) {//If it's lower than or equal to the current lowest grade
                 
                    lowest = grade;//It is set to the new current lowest
                    
                }//END of check lower
                
            }//END of check current grade

            output[i] = lowest;//The lowest number is added to the output list
            input.remove(lowest);//To prevent running into the same number, it's removed from the input list
           
            
        }//END of order lowest to highest

        return output;//Once the list is sorted, it's returned
        
    }//END of orderList()
    
    
    public static String lowest(ArrayList<SchoolMarks> students) {//This runs through all the grades and finds the lowest
        
        //These are basic variables used for temporary tasks
        double lowestGrade = 100;
        String weakest = "Student";
        String you = "";
        char letter = 'F';
        
        for(SchoolMarks student : students) {//This runs through each student in the list to look for the lowest grade overall
            
            if(student.grade < lowestGrade) {//If the current grade is lower than the last
                
                //The values of the currently weakest student are set here temporarily
                lowestGrade = student.grade;
                weakest = student.name;
                letter = student.letterGrade;
                
                if(student.isUser) {//If the current lowest is the user
                    
                    you = "(That's You!)";//An extra bit is added to the output
                    
                }//END of check user
                
            }//END of check lower than last
            
        }//END of check lowest overall
        
        return weakest.toUpperCase().concat(" ["+ lowestGrade +"%, "+ letter +"]"+ you);//This returns the student, grade and letter grade, and if it's the user
        
    }//END of lowest()
    
    
    public static String highest(ArrayList<SchoolMarks> students) {//This runs through all the grades and finds the highest
        
        //These are basic variables used for temporary tasks
        double highestGrade = 0;
        String strongest = "Student";
        String you = "";
        char letter = 'F';
        
        for(SchoolMarks student : students) {//This runs through each student in the list to look for the highest grade overall
            
            if(student.grade > highestGrade) {//If the current grade is higher than the last
                
                //The values of the currently strongest student are set here temporarily
                highestGrade = student.grade;
                strongest = student.name;
                letter = student.letterGrade;
                
                if(student.isUser) {//If the current highest is the user
                    
                    you = "(That's You!)";//An extra bit is added to the output
                    
                }//END of check user
                
            }//END of check higher than last
            
        }//END of check highest overall
        
        return strongest.toUpperCase().concat(" ["+ highestGrade +"% "+ letter +"]"+ you);//This returns the student, grade and letter grade, and if it's the user
        
    }//END of highest()
    
    
    public static boolean askUser() {//This is used whenever the user wants to calculate again
        
        //These are basic variables used for temporary tasks
        String output;
        boolean valid;
         
        do{//This loops until the user makes a valid input
            
            output = promptS();//This will hold a valid String
        
            if(output.toLowerCase().equals("yes")) {//If the user says yes
                
                System.out.print('\u000C');//This wipes the window
                return true;//False is returned
                
            }else if(output.toLowerCase().equals("no")) {//If the user says no
                
                return false;//True is returned
                
            }else {//Else the input as invalid
                
                System.out.print("Invalid input! [YES] [NO] : ");
                valid = false;//The loop is reset
                
            }//END of ask user
            
        }while(! valid);//END of input choice
        
        System.exit(1);//If something goes wrong, the program is ended
        return false;
        
    }//END of askUser()

    
    
    // SchoolMarks Main Execution || All the main blocks of code for the program are run here
    
    public static void main (String[] args) { // Beginning of Main
        
        // Variable Declarations || These are all variables to be used in every loop of the program
        
        int numStudents;//This tracks the amount of other students the user wants (Not including the user)
        boolean valid = false;//This is used in a loop
        
        //There are a total of 10 potential individual students that can be used in the program
        SchoolMarks studentA = new SchoolMarks(false);
        SchoolMarks studentB = new SchoolMarks(false);
        SchoolMarks studentC = new SchoolMarks(false);
        SchoolMarks studentD = new SchoolMarks(false);
        SchoolMarks studentE = new SchoolMarks(false);
        SchoolMarks studentF = new SchoolMarks(false);
        SchoolMarks studentG = new SchoolMarks(false);
        SchoolMarks studentH = new SchoolMarks(false);
        SchoolMarks studentI = new SchoolMarks(false);
        SchoolMarks studentJ = new SchoolMarks(false);
        
        SchoolMarks average = new SchoolMarks(false);//This "student" is more of a stand-in for the average grade calculation
        SchoolMarks user = new SchoolMarks(true);//This stores the user's info
        
        ArrayList<SchoolMarks> allStudents;//This list holds a refrence to all 10 potential students
        ArrayList<SchoolMarks> attendance;//Refrences to the required students are held here
        
        //These hold a list of student names and grades
        double[] gradeList;
        String[] nameList;
        
        //This is a list of potential randomly assigned names
        String[] randoNames = {"John", "Jack", "Scott", "Tom", "Steve", "Alex", "Sarah", "Emily", "Lisa", "Kim", "Michael", "Stephanie", "Chris", "Kate"};
        
        
        // Beginning of Main Block of Code 
          
        do {//This is the main program that is repeated as many times as the user wants
            
            allStudents = new ArrayList<SchoolMarks>();//The list is reset every loop
            attendance = new ArrayList<SchoolMarks>();//The loop is reset every loop
            
            //Every potential student is refrenced in allStudents
            allStudents.add(studentA);
            allStudents.add(studentB);
            allStudents.add(studentC);
            allStudents.add(studentD);
            allStudents.add(studentE);
            allStudents.add(studentF);
            allStudents.add(studentG);
            allStudents.add(studentH);
            allStudents.add(studentI);
            allStudents.add(studentJ);
        
            //Welcome message
            System.out.println("\nWelcome to the School Marks Calculator, made by Will Croll.");
            System.out.println("This program will take the marks of you and your classmates, and calculate the average!");
            System.out.println("The program will ask for the names and grades of the students in your class, as well as your own name and grade.");
            
            
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//These are pauses in execution for formatting
            
            System.out.print("\n\nDo you want a set of random results? [YES] [NO] : ");
            if(askUser()) {//If the user wants to skip to the results with a random output, this will run
                
                numStudents = (int) Math.round((Math.random()*9)+1);
                
                nameList = new String[numStudents+1];
                gradeList = new double[numStudents+1];
                
                for(int i = 0; i < numStudents; i++){//This will set a random name and grade for each student
                    
                    attendance.add(allStudents.get(i));//The current student is added to the attendance
                    
                    attendance.get(i).name = randoNames[(int) Math.round(Math.random()*13)];//This assigns names
                    attendance.get(i).grade = Math.round(Math.random()*100);//This assigns grades
                    attendance.get(i).getLetter();//This gets the letter grade
                    
                }
                
                user.name = randoNames[(int) Math.round(Math.random()*13)];//This assigns a name
                user.grade = Math.round(Math.random()*100);//This assigns a grade
                user.getLetter();//This gets the letter grade
                attendance.add(user);//User is added to the list
                
            }else {//If the user wants to use the program normally, this will run
            
                System.out.print("\n\nHow many other students are in your class? Please input a number from 1 to 10 : ");
                
                do {//This will loop until the user makes a valid input
                    
                    numStudents = (int) promptD();//An inputted double is casted to an int in the total number of students
                    
                    if((numStudents < 1) || (numStudents > 10)) {//If the number is less than 1 or greater than 10
                        
                        System.out.print("Please input a number FROM 1 TO 10 : ");
                        valid = false;//The loop is reset
                        
                    }else if(numStudents == 1){//If the input is 1
                        
                        System.out.println(numStudents +" other student is attending class.");//A specific message for a singular response
                        valid = true;//The input is valid
                        
                    }else {//If the input is from 2 to 10
                        
                        System.out.println(numStudents +" other students are attending class.");//A specific message for a plural response
                        valid = true;//The input is valid
                        
                    }//END of check input
                    
                }while(! valid);//END of find number of students
                
                //The lists are explicitly initialized with the number of students + the user
                nameList = new String[numStudents+1];
                gradeList = new double[numStudents+1];
                
                
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                
                
                for(int i = 0; i < numStudents; i++){//This will take the user input for the name and grade of each student
                    
                    attendance.add(allStudents.get(i));//The current student is added to the attendance
                    
                    System.out.println("\n\n******************************************************************");
                    System.out.println("\n\nStudent #"+ (i+1) +":");
                    
                    attendance.get(i).getName("a classmate's", randoNames);//This asks for the name
                    attendance.get(i).getGrade("the classmate's");//This asks for the grade
                    
                }
                
                System.out.println("\n\n******************************************************************");
                System.out.println("\n\nYour own student information:");
                
                user.getName("your", randoNames);//This asks for the user's name
                user.getGrade("your");//This asks for the user's grade
                attendance.add(user);//The user is added to the attendance
                
                System.out.println("\n******************************************************************");
                
                
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                
            }//END of normal runthrough
            
            System.out.print('\u000C');//This wipes the window
            System.out.println("\n******************************************************************");
            System.out.println("\nRESULTS:");
            
            
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            
            for(int i = 0; i < (numStudents+1); i++) {//This adds every recorded name and grade to the respective list
                
                nameList[i] = attendance.get(i).name;//For each student (And the user), the list will include their name
                gradeList[i] = attendance.get(i).grade;//For each student (And the user), the list will include their grade

            }//END of add to lists
            
            gradeList = orderList(gradeList, numStudents+1);//This orders the list of grades
            average.getAverage(gradeList);//This finds the average of all grades
            
            //End of Main Block of Code
            
            
            
            //User Interface
            
            System.out.println("\n\nAttendance: "+ Arrays.toString(nameList));//The list of students is output
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            System.out.println("\nGrades (Least to Greatest): "+ Arrays.toString(gradeList));//The list of ordered grades is output
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            System.out.println("\n\nClass Average: ["+ average.grade +"%, "+ average.letterGrade +"]");//The average grade is output
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            System.out.println("\nWeakest Student: "+ lowest(attendance));//The lowest grade is output
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            System.out.println("\nStrongest Student: "+ highest(attendance));//The highest grade is output
            try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            System.out.println("\nYour grade: ["+ user.grade +"%, "+ user.letterGrade +"]");//The user's letter grade is output
            
            System.out.println("\n******************************************************************");
            
            
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            
            System.out.print("\n\nWould you like to make a different calculation? [YES] [NO] : ");
                        
        }while(askUser());//If the user wants to run the program again, the loop is reset

        System.out.println("\n\nThank you for using the School Marks Calculator!");//Thank you message

        
    } // END of Main
} // END of Class SchoolMarks
//END of Program


/* Notes:
- The program could be a bit more streamlined if some Arrays were ArrayLists, but I wanted to use both for the assignment requirements
- Not much crazy going on with this assignment, the hardest part was definetly finding how to order the grade list
*/
