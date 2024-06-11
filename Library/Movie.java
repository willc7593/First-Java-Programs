
//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Movie extends Library {
    
    // Instance Variables || Unique movie values
    
    String director;
    double watchTime;
    
    
    
    // Class Methods || THESE ARE THE EXACT SAME AS THE BOOK CLASS, LOOK THERE FOR A WALK-THROUGH
    
    public Movie() {
        
        boolean valid = false;
        int inputI;
        double inputD;
        String inputS;
        
        System.out.print('\u000C');//This wipes the window
        System.out.println("\n******************************************************");
        
        do {
            
            System.out.print("\n\nPlease input the name of the movie : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the title? [YES] [NO] : ");
            
        }while(askUser());
        
        this.title = inputS;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.println("\n\nPlease input the genre of the movie:\n");
            
            for(int i = 0; i < genreList.length; i++) {
                
                System.out.println("- "+ genreList[i] +" = ["+ i +"]");
                
            }
            
            do {
                
                System.out.print("\nIt is : ");
                inputI = promptI();
                
                for(int i = 0; i < genreList.length; i++) {
                    
                    if(inputI == i) {
                        
                        valid = true;
                        break;
                        
                    }
                        
                }
                
                if(! valid) {
                    
                    System.out.print(inputS.toUpperCase() +" is not a documented genre! Please input again : ");
                    valid = false;
                
                }
                
            }while(! valid);
            
            System.out.print("\nIs \""+ genreList[inputI] +"\" the genre? [YES] [NO] : ");
            
        }while(askUser());
        
        this.genre = genreList[inputI];
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.print("\n\nPlease input year the movie released : ");
            
            do {
                
                inputI = promptI();
                
                if((inputI < 1900) || (inputI > 2021)){
                    
                    System.out.print("That's an impossible release year! Please input a real year : ");
                    valid = false;
                    
                }else {
                 
                    valid = true;
                    
                }
               
            }while(! valid);
            
            System.out.print("\nIs \""+ inputI +"\" the correct year? [YES] [NO] : ");
            
        }while(askUser());
        
        this.releaseYear = inputI;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.print("\n\nPlease input the name of the director : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the director's name? [YES] [NO] : ");
            
        }while(askUser());
        
        this.director = inputS;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.print("\n\nPlease input the length of the movie (In hours) : ");
           
            inputD = promptD();
            
            System.out.print("\nIs \""+ inputD +" hours\" the length? [YES] [NO] : ");
            
        }while(askUser());
        
        this.watchTime = inputD;
        
        System.out.print('\u000C');//This wipes the window
        System.out.println("\n******************************************************");
        
        System.out.println("\n\nThe movie has been borrowed!");
        System.out.println("\""+ title +"\" directed by "+ director +" ("+releaseYear +"), a "+ watchTime +" hour-long "+ genre +" film.");
        
        System.out.println("\n\n******************************************************");
    
    }
    
    
    public void watch(){
    
        boolean valid = false;
        int inputI;
        
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.print("\n\nWhat would you rate this movie? [1 TO 10] : ");
           
            do {
                
                inputI = promptI();
               
                if((inputI < 1) || (inputI > 10)) {
                    
                    System.out.print("That's an invalid rating! Please input again : ");
                    valid = false;
                    
                }else {
                    
                    System.out.print("\nYou give it "+ inputI +" out of 10? [YES] [NO] : ");
                    valid = true;
                    
                }
                
            }while(! valid);
            
        }while(askUser());
        
        System.out.println("\nThank you for your feedback! We hope you enjoyed your time with this movie!");
        rating = inputI;
        
        System.out.println("\n\n******************************************************");
        
    }
    
}//END of Class Movie
