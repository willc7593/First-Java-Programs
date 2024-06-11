
//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Book extends Library {
    
    // Instance Variables || Unique book values
    
    String author;
    int pages;
    
    
    
    // Class Methods || These are methods books can use; movies and games share ALMOST exact same methods
    
    public Book() {//This is the constructor for books, called when a new book is created
        
        //Basic variables used in execution
        boolean valid = false;
        int inputI;
        double inputD;
        String inputS;
        
        
        
        System.out.print('\u000C');//This wipes the window
        System.out.println("\n******************************************************");
        
        do {//This loops until the user wants to continue
            
            System.out.print("\n\nPlease input the name of the book : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the title? [YES] [NO] : ");
            
        }while(askUser());//END of get title
        
        this.title = inputS;//Title is set
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {//This loops until the user wants to continue
            
            System.out.println("\n\nPlease input the genre of the book:\n");
            
            for(int i = 0; i < genreList.length; i++) {//This prints every available genre
                
                System.out.println("- "+ genreList[i] +" = ["+ i +"]");
                
            }//END of print genres
            
            do {//This loops until a valid input is made
                
                System.out.print("\nIt is : ");
                inputI = promptI();
                
                for(int i = 0; i < genreList.length; i++) {//This loops through each genre
                    
                    if(inputI == i) {//If the input matches a genre
                        
                        valid = true;
                        break;
                        
                    }//END of check input
                        
                }//END of check genre
                
                if(! valid) {//If the input is invalid
                    
                    System.out.print(inputS.toUpperCase() +" is not a documented genre! Please input again : ");
                    valid = false;
                
                }//END of invalid
                
            }while(! valid);//END of input loop
            
            System.out.print("\nIs \""+ genreList[inputI] +"\" the genre? [YES] [NO] : ");
            
        }while(askUser());//END of get title
        
        this.genre = genreList[inputI];
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {//This loops until the user wants to continue
            
            System.out.print("\n\nPlease input the year the book released : ");
           
            do {//This loops until a valid input is made
                
                inputI = promptI();
                
                if(inputI > 2021) {//If it's greater than the current year
                    
                    System.out.print("That's an impossible release year! Please input a real year : ");
                    valid = false;
                    
                }else {//If valid
                 
                    valid = true;
                    
                }//END of check out of bounds
               
            }while(! valid);//END of input loop
            
            System.out.print("\nIs \""+ inputI +"\" the correct year? [YES] [NO] : ");
            
        }while(askUser());//END of get year
        
        this.releaseYear = inputI;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {//This loops until the user wants to continue
            
            System.out.print("\n\nPlease input the name of the author : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the author's name? [YES] [NO] : ");
            
        }while(askUser());//END of get author
        
        this.author = inputS;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {//Loops until user wants to continue
            
            System.out.print("\n\nPlease input the number of pages in the book : ");
           
            do {//This loops until valid input
                
                inputI = promptI();
                
                if(inputI <= 0) {//If the unput is less or equal to 0
                    
                    System.out.print("That's an impossible book length! Please input a real page count : ");
                    valid = false;
                    
                }else {//If valid
                 
                    valid = true;
                    
                }//END of check page length
               
            }while(! valid);//END of input loop
            
            System.out.print("\nIs \""+ inputI +"\" the amount of pages? [YES] [NO] : ");
            
        }while(askUser());//END of get pages
        
        this.pages = inputI;
                
        System.out.print('\u000C');//This wipes the window
        System.out.println("\n******************************************************");
        
        System.out.println("\n\nThe book has been borrowed!");
        System.out.println("\""+ title +"\" written by "+ author +" ("+releaseYear +"), a "+ pages +" page-long "+ genre +" book.");//Summary is returned
        
        System.out.println("\n\n******************************************************");
        
    }//END of Book Constructor
    
    
    public void read(){//This is called when the user reads a book, and wants to return it
        
        //Basic variables
        boolean valid = false;
        int inputI;
        
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {//This loops until the user wants to continue
            
            System.out.print("\n\nWhat would you rate this book? [1 TO 10] : ");
           
            do {//This loops until a valid input
                
                inputI = promptI();
               
                if((inputI < 1) || (inputI > 10)) {//If the rating is less than 1 or higher than 10
                    
                    System.out.print("That's an invalid rating! Please input again : ");
                    valid = false;
                    
                }else {//If valid
                    
                    System.out.print("\nYou give it "+ inputI +" out of 10? [YES] [NO] : ");
                    valid = true;
                    
                }//END of check rating
                
            }while(! valid);//END of input loop
            
        }while(askUser());//END of get rating
        
        System.out.println("\nThank you for your feedback! We hope you enjoyed your time with this book!");
        rating = inputI;
        
        System.out.println("\n\n******************************************************");
        
    }//END of read()
    
}//END of Class Book
