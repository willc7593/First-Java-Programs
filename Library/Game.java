
//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Game extends Library {
    
    // Instance Variables || Unique game values
    
    String developer;
    String platform;
    
    String[] gameGenres = {"PLATFORMER", "ADVENTURE", "RPG", "SHOOTER", "PUZZLE", "STRATEGY", "SPORTS", "RACING", "RYTHM", "FIGHTING", "ARCADE", "SIMULATOR"};
    
    
    
    
    // Class Methods || THESE ARE THE EXACT SAME AS THE BOOK CLASS, LOOK THERE FOR A WALK-THROUGH
    
    public Game() {
        
        boolean valid = false;
        int inputI;
        double inputD;
        String inputS;
        
        System.out.print('\u000C');//This wipes the window
        System.out.println("\n******************************************************");
        
        do {
            
            System.out.print("\n\nPlease input the title of the game : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the title? [YES] [NO] : ");
            
        }while(askUser());
        
        this.title = inputS;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.println("\n\nPlease input the genre of the game:\n");
            
            for(int i = 0; i < gameGenres.length; i++) {
                
                System.out.println("- "+ gameGenres[i] +" = ["+ i +"]");
                
            }
            
            do {
                
                System.out.print("\nIt is : ");
                inputI = promptI();
                
                for(int i = 0; i < gameGenres.length; i++) {
                    
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
            
            System.out.print("\nIs \""+ gameGenres[inputI] +"\" the genre? [YES] [NO] : ");
            
        }while(askUser());
        
        this.genre = gameGenres[inputI];
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.print("\n\nPlease input year the game released : ");
            
            do {
                
                inputI = promptI();
                
                if((inputI < 1980) || (inputI > 2021)){
                    
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
            
            System.out.print("\n\nPlease input the name of the developer : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the name of the developer? [YES] [NO] : ");
            
        }while(askUser());
        
        this.developer = inputS;
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        do {
            
            System.out.print("\n\nPlease input the platform the game is on : ");
           
            inputS = promptS();
            
            System.out.print("\nIs \""+ inputS +"\" the platform? [YES] [NO] : ");
            
        }while(askUser());
        
        this.platform = inputS;

        System.out.print('\u000C');//This wipes the window
        System.out.println("\n******************************************************");
        
        System.out.println("\n\nThe game has been borrowed!");
        System.out.println("\""+ title +"\" developed by "+ developer +" ("+releaseYear +"), a "+ genre +" game for the "+ platform);
        
        System.out.println("\n\n******************************************************");

    }
    
    
    public void play(){
    
        boolean valid = false;
        int inputI;
        
        do {
            
            System.out.print("\n\nWhat would you rate this game? [1 TO 10] : ");
           
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
        
        System.out.println("\nThank you for your feedback! We hope you enjoyed your time with this game!");
        rating = inputI;
        
        System.out.println("\n\n******************************************************");
    
    }
    
}//END of Class Game
