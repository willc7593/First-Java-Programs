// Assignment 8 : Ancestry.com Languages - By Will Croll


/* Program Summary: This program is designed to utilize Classes and Inheritance
- The user is able to read info on pre-made languages, some made from specific language families
- The user can also input new languages themselves, which are stored with the other languages
- The program keeps track of the languages they choose and create, and return them once the program ends
*/


/* Important (KEY) Program Elemnts Used
- Comments (//, *//*)
- Variables and declaration (double, int, char, boolean)
- Strings and concantenation
- Arrays and ArrayLists
- Scanners
- System.out.println() and .print()
- .equals(), .trim(), and Arrays.toString()
- .add(), .get(), .remove(), .indexOf(), and .toString()
- = and += assignment
- >, <, ==, >= and <= comparisons
- &&, ||, and ! comparisons
- Increment (++, --)
- Classes and constructors (new)
- Inheritance and Polymorphism (extends)
- public, protected
- super(), this, and @Override
- Methods and Static Methods (return)
- \n and \u000C
- if/if else/else statements
- switch/case/default statements (break)
- try/catch statements (continue)
- do/while loops 
- for and for/each loops 
- .next() and .hasNext() / .nextInt() and .hasNextInt()
- .toUpperCase() and .toLowerCase()
- import (java.util)
- Thread.sleep()
- System.exit(1)
*/

//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


public class Language { // Beginning of Program
    
    // Instance Variables || These are all values each language/language family share
    
    protected String name;
    protected int numSpeakers;
    protected String regionSpoken;
    protected String[] wordOrder;
    protected String family;
    
    
    // Class Methods || Methods to be used by each language
    
    public Language(String name, int numSpeakers, String regionSpoken, String[] wordOrder, String family) {//This is the Language constructor
        
        this.name = name;
        this.numSpeakers = numSpeakers;
        this.regionSpoken = regionSpoken;
        this.wordOrder = wordOrder;
        this.family = family;
        
    }//END of Language Constructor
    
    
    public String getInfo() {//This is used when the information on a language is to be printed out
        
        return ("["+ name +"] ("+ family +")\nThis language is spoken in "+ regionSpoken +" by "+ numSpeakers +" people.\nThe word order is: "+ Arrays.toString(wordOrder));
        
    }//END of getInfo()
    
    
    // Static Methods || These are methods to be used in main execution
    
    public static Language makeLanguage() {//This is used when the user wants to add a lanugage
        
        Input input = new Input();//This can make inputs
        
        //These are basic boolean values used to break loops
        boolean valid = false;
        boolean done = false;
        
        //All values to be filled in by the user
        String name;
        int numSpeakers;
        String regionSpoken;
        String[] wordOrder = new String[3];
        String family = "No Family";
        
        Language output;//This will hold every value the user inputs to be returned to the new Language
        
        do {//This loops until the user is satisfied with the Language they create
            
            System.out.println('\u000C');//Clears screen
            System.out.println("**************************************************************");
            
            System.out.print("\nPlease input the language's name : ");
            name = input.promptS();//Input name
            
            System.out.println("\n**************************************************************");
            System.out.print("\nPlease input how many people speak the language : ");
            numSpeakers = input.promptI();//Input number of speakers
            
            System.out.println("\n**************************************************************");
            System.out.print("\nPlease input the region the language is mainly spoken in : ");
            regionSpoken = input.promptS();//Input region
            
            System.out.println("\n**************************************************************");
            System.out.println("\nIn a sentence in this language, what would come first?:");
            System.out.print("[SUBJECT] [OBJECT] [VERB] : ");
            do {//This loops until the user makes a valid input
                
                switch(input.promptS().toUpperCase()) {//This searches with the user's String input
                    
                    case "SUBJECT"://If the user inputs subject
                        wordOrder[0] = "SUBJECT";//The first string is subject
                        System.out.println("\nAnd then?:");
                        System.out.print("[OBJECT] [VERB] : ");
                        do {//Loops until valid
                            
                            switch(input.promptS().toUpperCase()) {//This searches another input
                                
                                case "OBJECT"://If object
                                    wordOrder[1] = "OBJECT";//The second word is object
                                    wordOrder[2] = "VERB";//And the third is verb
                                    valid = true;
                                    break;
                                
                                case "VERB"://Same^^^^^
                                    wordOrder[1] = "VERB";
                                    wordOrder[2] = "OBJECT";
                                    valid = true;
                                    break;
                                
                                default:
                                    System.out.print("Invalid input! [OBJECT] [VERB] : ");//Loop is reset
                                    
                            }//END of search input 2
                            
                        }while(! valid);//END of input loop 2
                        break;
                        
                    
                    case "OBJECT"://Same^^^^^^^
                        wordOrder[0] = "OBJECT";
                        System.out.println("\nAnd then?:");
                        System.out.print("[SUBJECT] [VERB] : ");
                        do {
                            
                            switch(input.promptS().toUpperCase()) {
                                
                                case "SUBJECT":
                                    wordOrder[1] = "SUBJECT";
                                    wordOrder[2] = "VERB";
                                    valid = true;
                                    break;
                                
                                case "VERB":
                                    wordOrder[1] = "VERB";
                                    wordOrder[2] = "SUBJECT";
                                    valid = true;
                                    break;
                                
                                default:
                                    System.out.print("Invalid input! [SUBJECT] [VERB] : ");
                                    
                            }//END of search input 2
                            
                        }while(! valid);//END of input loop 2
                        break;
                    
                    case "VERB"://Same^^^^^^^^^^^^^^^^^^
                        wordOrder[0] = "VERB";
                        System.out.println("\nAnd then?:");
                        System.out.print("[OBJECT] [SUBJECT] : ");
                        do {
                            
                            switch(input.promptS().toUpperCase()) {
                                
                                case "OBJECT":
                                    wordOrder[1] = "OBJECT";
                                    wordOrder[2] = "SUBJECT";
                                    valid = true;
                                    break;
                                
                                case "SUBJECT":
                                    wordOrder[1] = "SUBJECT";
                                    wordOrder[2] = "OBJECT";
                                    valid = true;
                                    break;
                                
                                default:
                                    System.out.print("Invalid input! [OBJECT] [SUBJECT] : ");
                                    
                            }//END of search input 2
                            
                        }while(! valid);//END of input loop 2
                        break;
                    
                    default:
                        System.out.print("Invalid input! [SUBJECT] [OBJECT] [VERB] : ");//Loop is reset
                        
                }//END of search input 1
                
            }while(! valid);//END of input loop 1
            
            System.out.println("\n**************************************************************");
            System.out.print("\nDoes this language belong to a family? [YES] [NO] : ");
            if(! input.askUser()) {//If "YES"
                
                System.out.print("\nWhat is the family's name? : ");
                family = input.promptS();//The family name is set to the input
                
            }//END of askUser
                
            output = new Language(name, numSpeakers, regionSpoken, wordOrder, family);//The output will hold all the inputted values
            
            System.out.println('\u000C');
            System.out.println("**************************************************************\n\n");
            System.out.println(output.getInfo());//The inputted info is returned to the user
            System.out.println("\n\n**************************************************************");
            System.out.print("\nIs this the correct information? [YES] [NO] : ");//Asks if the ser is satisfied with their inputs
            
            if(! input.askUser()) {//If the user says "YES"
             
                System.out.println("\n**************************************************************");
                System.out.print("\nThe Language has been added! ");
                done = true;//The loop will break
                
            }//END of askUser
            
        }while(! done);//END of loop until done
        
        return output;//The output is returned, to be stored in the list of languages
        
    }//END of makeLanguage()
        
    
    
    // Main Execution || The main portion of the program takes place here
    
    public static void main (String[] args) { // Beginning of Main
        
        
        // Variable Declarations || These are all values to be used within the main program 
        
        Input input = new Input();//This can make inputs
        
        //Basic temporary values
        boolean valid = false;
        boolean done = false;
        int choice;
        
        //These are all pre-made languages using Child Classes
        Mayan kiche = new Mayan("Ki'che'", 2330000);
        SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 1120000000);
        SinoTibetan burmese = new SinoTibetan("Burmese", 33000000);
        IndoEuropean spanish = new IndoEuropean("Spanish", 555000000);
        IndoEuropean english = new IndoEuropean("English", 1270000000);
        IndoEuropean french = new IndoEuropean("French", 272000000);
        
        //This list holds all pre-made languages, as well as newly made lanuages
        ArrayList<Language> allLanguages = new ArrayList<Language>();
        allLanguages.add(kiche);
        allLanguages.add(mandarin);
        allLanguages.add(burmese);
        allLanguages.add(spanish);
        allLanguages.add(english);
        allLanguages.add(french);
        
        //These lists hold the total languages viewed/created
        ArrayList<Language> selected = new ArrayList<Language>();
        ArrayList<Language> added = new ArrayList<Language>();
       
        
        
        // Beginning of Main Block of Code 
        
        do {//This loops until the user is finished
            
            //Welcome message
            System.out.println('\u000C');
            System.out.println("**************************************************************");
            System.out.println("\n\nThis is the Ancestry.com database! We have a selection of Languages for you to select and learn about!");
            System.out.println("Just choose one of the following languages to learn about it's number of speakers, region spoken, or even word order!");
            System.out.println("Are we missing a language? Just add a language our database might be lacking!");
            System.out.println("\n\n**************************************************************\n");
            
            
            for(int i = 0; i < allLanguages.size(); i++) {//This prints every current language with a corrosponding integer
                
                System.out.println("["+ i +"] - \""+ allLanguages.get(i).name +"\"");
                
            }//END of for every language
            
            System.out.println("\n["+ allLanguages.size() +"] - Add a language");//This is for adding a language
            System.out.println("[" + (allLanguages.size()+1) +"] - End Program");//This is for ending the program
            
            do {//This loops until the user makes a valid input
                
                valid = false;
                System.out.print("\nI choose : ");
                choice = input.promptI();//User inputs an integer
                
                if(choice == allLanguages.size()) {//This checks if the user is asking to create a language
                    
                    System.out.print("\nAdd a Language? [YES] [NO] : ");
                        
                    if(! input.askUser()) {//If "yes"
                        
                        allLanguages.add(makeLanguage());//The language is created and added to the language list
                        added.add(allLanguages.get((allLanguages.size()-1)));//Also added to the added list
                        valid = true;
                        
                    }else {//If "no"
                        
                        valid = false;//Loop is reset
                        
                    }//END of askUser
                    
                }else if(choice == (allLanguages.size()+1)) {//This checks if the user wants to end the language
                                        
                    System.out.print("\nExit Program? [YES] [NO] : ");
                        
                    if(! input.askUser()) {//If "yes"
                        
                        try {//This will see if the selected list was added to
                            
                            if(selected.get(0) != null) {//If the list was added to
                                
                                System.out.println("\n**************************************************************");
                                System.out.print("\nResearched Languages: [");
                                
                                for(Language language : selected) {//Every language in the list is printed
                                    
                                    if(language == selected.get((selected.size()-1))) {//If it's the last language in the list
                                        
                                        System.out.print(language.name);//The name is printed
                                        
                                    }else {
                                        
                                        System.out.print(language.name +", ");//The name is printed with a ,
                                        
                                    }//END of check for last in list
                                    
                                }//END of print languages
                                
                                System.out.print("]");
                                
                            }//END of print selected languages
                            
                        }catch(Exception e) {//If there are no languages, a message is printed
                            
                            System.out.println("\n**************************************************************");
                            System.out.println("\nNo Languages were researched! This program is designed to educate you!");
                            
                        }//END of check selected list
                        
                        
                        //This block is the same as the block above, but for the "Added" list
                        try {
                            if(added.get(0) != null) {
                                System.out.print("\nAdded Languages: [");
                                for(Language language : added) {
                                    if(language == added.get((added.size()-1))) {
                                        System.out.print(language.name);
                                    }else {
                                        System.out.print(language.name +", ");
                                    }
                                }
                                System.out.print("]");
                                System.out.println("\n\n**************************************************************");
                                System.out.print("\nProgram will end. ");
                            }
                        }catch(Exception e) {
                            System.out.println("\nNo Languages were added! Help expand our database with new languages!");
                            System.out.println("\n**************************************************************");
                            System.out.print("\nProgram will end. ");
                        }
                        
                        done = true;//The program will end
                        valid = true;//The input loop will break
                        
                        
                    }else {//If "no"
                        
                        valid = false;//The program will continue
                        
                    }//END of askUser
                        
                }else if((choice >=0 ) && (choice < allLanguages.size())) {//This checks if the input is within the number range
                
                    for(int i = 0; i < allLanguages.size(); i++) {//This checks if the user is asking to view a language
                     
                        if(choice == i) {//If the integer is a match
                            
                            System.out.println("\n**************************************************************\n\n");
                            System.out.println(allLanguages.get(i).getInfo());//getInfo is called on the language
                            selected.add(allLanguages.get(i));//The language is added to the total list
                            
                            valid = true;
                            try{Thread.sleep(3000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause for formatting
                            
                            System.out.println("\n\n**************************************************************\n");
                            
                        }//END of print info
                        
                    }//END of for each language
                    
                }else {//If the input is invalid
                    
                    System.out.println("Invalid input! Please try again.");
                    valid = false;//The loop is reset
                    
                }//END of check input
                
            }while(! valid);//END of input loop
            
            System.out.print("Press ENTER to continue.");
            System.out.println("\n\n**************************************************************");
            input.promptS();//The user can press ENTER to continue the program
            
        }while(! done);//END of program loop

        // End of Main Block of Code
       
      
        
        //User Interface || This is basically just used for the thank you message
        
        System.out.println("\n\nThank you for using the Ancestry.com Language Database! Please visit again!");

    } // END of Main
} // END of Class Template
//END of Program


/* Notes:
- This Assignment is slightly less ambitious than I'd try for an Assignment, I wanted to focus more on my final project
*/
