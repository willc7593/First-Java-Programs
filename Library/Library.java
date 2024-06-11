// Assignment 7 : Library - By Will Croll


/* Program Summary: This program is designed to utilize Array/ArrayLists, Loops, and Classes
- Every "day", the user can take out an inputted book, movie, or game from the "library"; These can be returned and dded to a total library
- The program keeps track of the days the user has a peice of media, and if it becomes overdue
- Once the user has returned all media they've taken out, and paid their debt, they can end the program and see a summarization of all their media
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
- Methods and Static Methods (return)
- \n and \u000C
- if/if else/else statements
- switch/case/default statements (break)
- try/catch statements (continue)
- do/while loops 
- for and for/each loops 
- .next() and .hasNext() / .nextInt() and .hasNextInt()
- .toUpperCase() and .toLowerCase()
- String.format("%.2f")
- import (java.util)
- Thread.sleep()
- System.exit(1)
*/

//These are imports from java.util for crucial objects, like scanners and arrays
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Library { // Beginning of Program
   
    // Instance Variables || These are variables each peice of media have in common
    
    String title = "EMPTY";
    String genre;
    int releaseYear;
    
    int daysTillDue = 7;
    int rating;
    
    String[] genreList = {"ACTION", "ADVENTURE", "COMEDY", "DRAMA", "ROMANCE", "MYSTERY", "FANTASY", "FICTION", "SCI-FI", "HORROR", "THRILLER"};
    
    
    
    // Class Methods || There are no methods every class has in common, since they require unique values

    public Library() {}//Since each form of media has it's own unique constructor, the Library constructor is left pretty much empty
    
    
    
    // Static Functions || These are methods used throughout the program, either for basic or specific tasks
    
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
    
    
    public static void printMedia(Library[] list, boolean askInt) {//This is used when the program needs to print out a list of media

        ArrayList<String> output = new ArrayList<String>();
        
        for(Library i : list) {//This goes through every name in the list
            
            if(i == null) {//If the current index is empty
                
                continue;
                
            }else {//Else it's normal
             
                output.add(i.title);
                
            }//END of empty check
            
        }//END of add name
        
        if(askInt) {//If the program needs integer inputs
         
            for(int i = 0; i < output.size(); i++) {//This prints every name and a corrosponding integer
                
                System.out.println("- "+ output.get(i) +" = ["+ i +"]");
                
            }//END of print each
            
        }else {//If the program is just printing out the names
            
            System.out.print(output.toString() +"\n");
            
        }//END of check print type
        
    }//END of printMedia()
    

    public static double countdown(Book[] books, Movie[] movies, Game[] game) {//This will check every media taken out and reurn the days left
        
        double money = 0;
        
        for(Book book : books) {//For every book owned
            
            if(book != null) {//If the book exists
                 
                book.daysTillDue--;
                
                if(book.daysTillDue < 0) {
                    
                    System.out.println("- \""+ book.title + "\" is overdue! Your debt has increased by $5!");
                    money += 5;
                    
                }else if(book.daysTillDue == 0) {
                
                    System.out.println("- \""+ book.title + "\" is due today! Better turn it in or you'll be charged!");
                    
                }else if(book.daysTillDue == 1) {
                    
                    System.out.println("- \""+ book.title + "\" is due tommorow! Return it soon!");
                    
                }else {
                 
                    System.out.println("- \""+ book.title + "\" has "+ book.daysTillDue +" days left");
                    
                }//END of print days left
                
            }//END of check null
            
        }//END of print books
        
        for(Movie movie : movies) {//For every movie owned
            
            if(movie != null) {//If the movie exists
            
                movie.daysTillDue--;
               
                if(movie.daysTillDue < 0) {
                    
                    System.out.println("- \""+ movie.title + "\" is overdue! Your debt has increased by $10!");
                    money += 10;
                    
                }else if(movie.daysTillDue == 0) {
                    
                    System.out.println("- \""+ movie.title + "\" is due today! Better turn it in or you'll be charged!");
                    
                }else if(movie.daysTillDue == 1) {
                    
                    System.out.println("- \""+ movie.title + "\" is due tommorow! Return it soon!");
                    
                }else {
                 
                    System.out.println("- \""+ movie.title + "\" has "+ movie.daysTillDue +" days left");
                    
                }//END of print days left
                
            }//END of check null
            
        }//END of print movies
        
        if(game[0] != null) {//If the user has a game out
         
            game[0].daysTillDue--;
            
            if(game[0].daysTillDue < 0) {
                    
                System.out.println("- \""+ game[0].title + "\" is overdue! Your debt has increased by $15!");
                money += 15;
                    
            }else if(game[0].daysTillDue == 0) {
                
                System.out.println("- \""+ game[0].title + "\" is due today! Better turn it in or you'll be charged!");
                
            }else if(game[0].daysTillDue == 1) {
                
                System.out.println("- \""+ game[0].title + "\" is due tommorow! Return it soon!");
                
            }else {
             
                System.out.println("- \""+ game[0].title + "\" has "+ game[0].daysTillDue +" days left");
                
            }//END of print days left
            
        }//END of check null
    
        return money;//If the user racks up debt, the new amount is returned
        
    }//END of countdown()
    
    
    public static void averageB(ArrayList<Book> list) {//This will find some bonus averages at the end of the program for books
        
        int last = 0;
        int totalPages = 0;
        double averageRating = 0;
        String faveGenre = "";
        ArrayList<Integer> allGenres = new ArrayList<Integer>();
        
        for(Book book : list) {//This loop through the total books rented
         
            totalPages += book.pages;//Adds total pages
            averageRating += book.rating;//Adds rating
            
        }//END of get totalPages and averageRating
        
        for(int i = 0; i < list.size(); i++) {//This will check which genre is repeated the most
           
            allGenres.add(0);
            
            for(int j = i; j < list.size(); j++) {//Goes through the list again
                
                if(list.get(i).genre.equals(list.get(j).genre)) {//If the current genre is the same as another later in thelist
                    
                    allGenres.set(i, (allGenres.get(i)+1));//The genre is added to this list as a representation of how many times it's repeated
                    
                }//END of add list
                
            }//END of inner loop
            
        }//END of get most repeated genre
        
        for(int i : allGenres) {//This goes through every index in the list
            
            if(i > last) {//If the current genre is repeated more than the last
                
                faveGenre = list.get(allGenres.indexOf(i)).genre;
                
            }//END of check higher
            
            last = i;//The last number is constantly being set to the current highest amount
            
        }//END of get most repeated
        
        //End message, returning total pages, average rating, and fave genre
        System.out.println("\nTotal pages read: "+ totalPages +" / Average book rating: "+ (averageRating/list.size()) +" / Favorite genre: "+ faveGenre);
        
    }//END of averageB()
    
    
    public static void averageM(ArrayList<Movie> list) {//This works the exact same as above^^^^^^
        
        int last = 0;
        double totalHours = 0;
        double averageRating = 0;
        String faveGenre = "";
        ArrayList<Integer> allGenres = new ArrayList<Integer>();
        
        for(Movie movie : list) {
         
            totalHours += movie.watchTime;
            averageRating += movie.rating;
            
        }
        
        for(int i = 0; i < list.size(); i++) {
           
            allGenres.add(0);
            
            for(int j = i; j < list.size(); j++) {
                
                if(list.get(i).genre.equals(list.get(j).genre)) {
                    
                    allGenres.set(i, (allGenres.get(i)+1));
                    
                }
                
            }
            
        }
        
        for(int i : allGenres) {
            
            if(i > last) {
                
                faveGenre = list.get(allGenres.indexOf(i)).genre;
                
            }
            
            last = i;
            
        }
        
        System.out.println("\nTotal hours watched: "+ totalHours +" / Average movie rating: "+ String.format("%.1f", (averageRating/list.size())) +" / Favorite genre: "+ faveGenre);
        
    }//END of averageM()
    
    
    public static void averageG(ArrayList<Game> list) {//This works the exact same as above^^^^^
        
        int last = 0;
        double averageRating = 0;
        String faveGenre = "";
        ArrayList<Integer> allGenres = new ArrayList<Integer>();
        
        for(Game game : list) {
       
            averageRating += game.rating;
            
        }
        
        for(int i = 0; i < list.size(); i++) {
           
            allGenres.add(0);
            
            for(int j = i; j < list.size(); j++) {
                
                if(list.get(i).genre.equals(list.get(j).genre)) {
                    
                    allGenres.set(i, (allGenres.get(i)+1));
                    
                }
                
            }
            
        }
        
        for(int i : allGenres) {
            
            if(i > last) {
                
                faveGenre = list.get(allGenres.indexOf(i)).genre;
                
            }
            
            last = i;
            
        }
        
        System.out.println("\nAverage game rating: "+ (averageRating/list.size()) +" / Favorite genre: "+ faveGenre);
        
    }//END of averageG()
    
    
    
    // Main Execution || The bulk of the program takes place here
    
    public static void main (String[] args) { // Beginning of Main
       
        // Variable Declarations || These are all variables that will come into play during the main program
      
        int day = 0;//Current "day"
        int action;//Used to hold what the user wants to do the current turn
        double debt = 0;//Holds total debt
        boolean valid;//Used to see if the main input is valid
        boolean done = false;//Set to true when the program will end
        
        int booksOut = 0;
        int moviesOut = 0;
        boolean gameOut = false;
        
        int inputI;//Used once
        
        //These hold the current media the user has taken out; They are arrays since the size is SET
        Book[] currentBooks = new Book[3];
        Movie[] currentMovies = new Movie[2];
        Game[] currentGame = new Game[1];
        
        //These hold the total media the user has taken out; They are ArrayLists since the size changes
        ArrayList<Book> bookLibrary = new ArrayList<Book>();
        ArrayList<Movie> movieLibrary = new ArrayList<Movie>();
        ArrayList<Game> gameLibrary = new ArrayList<Game>();
      
        
        // Beginning of Main Block of Code 
       
        do {//Every "day" is a reset of this loop
            
            System.out.println("\nThis is the Assignment 7 Library! We offer a wide variety of books, movies, and games for you to borrow!");
            System.out.println("Just specify to the program which peice of media you want to borrow, and we'll let you have it. Just remember to return it within 7 days!");
            System.out.println("If you don't return something within a week, you'll start to build up a debt! Books add $5, Movies add $10, and Games add $15.");
            System.out.println("You can have a total of 3 books, 2 movies, and 1 game out at a time. Be sure to keep track of everything you borrow!");
            
            day++;
            System.out.println("\n******************************************************");
            System.out.println("\n\nDAY "+ day +":");
            
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            if((booksOut == 0) && (moviesOut == 0) && (! gameOut)) {//This checks what the user hs out currently, and lists them
                
                System.out.println("\n\nLooks like you don't have anything out yet!");
                
            }else {//If the user does have something out
                
                if(booksOut == 0) {//Prints books
                    
                    System.out.println("\n\nLooks like you don't have any books out at the moment!");
                    
                }else {//If the user does have a book
                    
                    System.out.print("\n\nYou have "+ booksOut +" book(s) out: ");
                    printMedia(currentBooks, false);
                    
                }//END of print book
                
                if(moviesOut == 0) {//Same^^^^^
                    
                    System.out.println("Looks like you don't have any movies out at the moment!");
                    
                }else {
                    
                    System.out.print("You have "+ moviesOut +" movie(s) out: ");
                    printMedia(currentMovies, false);
                    
                }//END of print movies
                
                if(! gameOut) {//Same^^^^^^
                    
                    System.out.println("Looks like you don't have any games out at the moment!\n");
                    
                }else {
                    
                    System.out.println("You have a game out at the moment: ["+ currentGame[0].title +"]\n");
                    
                }//END of print game
                
            }//END of print current media
            
            debt += countdown(currentBooks, currentMovies, currentGame);//This both prints the days each media has left, and updates debt if need be
            
            if(debt > 0) {//Prints debt
                
                System.out.println("\nYOU CURRENTLY OWE $"+ debt +"!");
                
            }//END of check debt
            
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            
            //Alll the actions the user can take
            System.out.println("\n\nWhat would you like to do today?");
            System.out.println("\n- Take out a Book = [0]");
            System.out.println("- Take out a Movie = [1]");
            System.out.println("- Take out a Game = [2]");
            System.out.println("\n- Return a Book = [3]");
            System.out.println("- Return a Movie = [4]");
            System.out.println("- Return a Game = [5]");
            System.out.println("\n- Skip today = [6]");
            System.out.println("- Pay back debt = [7]");
            System.out.println("- End the program = [8]");
             
            do {//This will loop until the user inputs a valid integer
                
                valid = false;
                System.out.print("\nI want to : ");
  
                action = promptI();
                
                switch(action) {//This checks every available option
                    
                    case 0 ://If the user chooses 0
                        if(booksOut == 3) {//This checks if the user has reached the max books allowed out
                            
                            System.out.println("\nYou already have 3 Books out! Try something else.");
                            valid = false;
                            break;
                            
                        }else {//If they can take a new book out
                            
                            System.out.print("\nYou want to take out a Book? [YES] [NO] : ");
                            
                            if(! askUser()) {//If the user says yes
                                
                                currentBooks[booksOut] = new Book();
                                booksOut++;

                                valid = true;
                                break;
                                
                            }else {//If the user says no
                                
                                valid = false;
                                break;
                                
                            }//END of user check
                            
                        }//END of option 0
                       
                        
                    case 1 ://Same^^^^^^^^^^
                        if(moviesOut == 2) {
                            
                            System.out.println("\nYou already have 2 Movies out! Try something else.");
                            valid = false;
                            break;
                            
                        }else {
                            
                            System.out.print("\nYou want to take out a Movie? [YES] [NO] : ");
                            
                            if(! askUser()) {
                                
                                currentMovies[moviesOut] = new Movie();
                                moviesOut++;

                                valid = true;
                                break;
                                
                            }else {
                                
                                valid = false;
                                break;
                                
                            }
                            
                        }//END of option 1
                    
                        
                    case 2 ://Same^^^^^^^^^
                        if(gameOut) {
                            
                            System.out.println("\nYou already have a Game out! Try something else.");
                            valid = false;
                            break;
                            
                        }else {
                            
                            System.out.print("\nYou want to take out a Game? [YES] [NO] : ");
                            
                            if(! askUser()) {
                                
                                currentGame[0] = new Game();
                                gameOut = true;

                                valid = true;
                                break;
                                
                            }else {
                                
                                valid = false;
                                break;
                                
                            }
                            
                        }//END of option 2
                   
                        
                    case 3 ://If the user chooses 3
                        if(booksOut == 0) {//If the user does not have any books
                            
                            System.out.println("\nYou don't have any Books yet! Try something else .");
                            valid = false;
                            break;
                            
                        }else {//If the user has a book
                            
                            System.out.print("\nYou want to return a Book? [YES] [NO] : ");
                            
                            if(! askUser()) {//If the user says yes
                                
                                System.out.print('\u000C');//This wipes the window
                                System.out.println("\n******************************************************");
                                System.out.println("\n\nWhich book do you want to return?\n"); 
                                printMedia(currentBooks, true);
                                
                                do {//This loops until the user makes a valid input
                                    
                                    System.out.print("\nI want to return : ");
                                    inputI = promptI();
                                    
                                    switch(inputI) {//This checks the input
                                        
                                        case 0 ://If 0
                                            System.out.print("\nReturn "+ currentBooks[0].title +"? [YES] [NO] : ");
                                            if(! askUser()) {//If yes
                                                
                                                currentBooks[0].read();
                                                bookLibrary.add(currentBooks[0]);
                                                
                                                currentBooks[0] = currentBooks[1];
                                                currentBooks[1] = currentBooks[2];
                                                currentBooks[2] = null;
                                                booksOut--;
                                                
                                                valid = true;
                                                break;
                                                
                                            }else {//If no
                                             
                                                valid = false;
                                                break;
                                                
                                            }//END of option 0

                                        
                                            
                                        case 1 ://Same^^^^    
                                            System.out.print("\nReturn "+ currentBooks[1].title +"? [YES] [NO] : ");
                                            if(! askUser()) {
                                                
                                                currentBooks[1].read();
                                                bookLibrary.add(currentBooks[1]);
                                                
                                                currentBooks[1] = currentBooks[2];
                                                currentBooks[2] = null;
                                                booksOut--;
                                                
                                                valid = true;
                                                break;
                                                
                                            }else {
                                             
                                                valid = false;
                                                break;
                                                
                                            }
                                        
                                            
                                        case 2 ://Same^^^^^^^^^
                                            System.out.print("\nReturn "+ currentBooks[2].title +"? [YES] [NO] : ");
                                            if(! askUser()) {
                                                
                                                currentBooks[2].read();
                                                bookLibrary.add(currentBooks[2]);
                                                
                                                currentBooks[2] = null;
                                                booksOut--;
                                                
                                                valid = true;
                                                break;
                                                
                                            }else {
                                             
                                                valid = false;
                                                break;
                                                
                                            }
                                        
                                            
                                        default ://Incorrect input
                                            System.out.print("You don't have that book out! Please input again : ");
                                            valid = false;
                                        
                                    }//END of check input
                                    
                                }while(! valid);//END of loop input
                                
                                break;
                                
                            }else {//If user says no
                                
                                valid = false;
                                break;
                                
                            }//END of check user
                            
                        }//END of option 3
                      
                        
                    case 4 ://Same^^^^^
                        if(moviesOut == 0) {
                            
                            System.out.println("\nYou don't have any Movies yet! Try something else.");
                            valid = false;
                            break;
                            
                        }else {
                            
                            System.out.print("\nYou want to return a Movie? [YES] [NO] : ");
                            
                            if(! askUser()) {
                                
                                System.out.print('\u000C');//This wipes the window
                                System.out.println("\n******************************************************");
                                System.out.println("\n\nWhich movie do you want to return?\n");
                                printMedia(currentMovies, true);
                                
                                do {
                                    
                                    System.out.print("\nI want to return : ");
                                    inputI = promptI();
                                    
                                    switch(inputI) {
                                        
                                        case 0 : 
                                            System.out.print("\nReturn "+ currentMovies[0].title +"? [YES] [NO] : ");
                                            if(! askUser()) {
                                                
                                                currentMovies[0].watch();
                                                movieLibrary.add(currentMovies[0]);
                                                
                                                currentMovies[0] = currentMovies[1];
                                                currentMovies[1] = null;
                                                moviesOut--;
                                                
                                                valid = true;
                                                break;
                                                
                                            }else {
                                             
                                                valid = false;
                                                break;
                                                
                                            }
                                        
                                            
                                        case 1 :    
                                            System.out.print("\nReturn "+ currentMovies[1].title +"? [YES] [NO] : ");
                                            if(! askUser()) {
                                                
                                                currentMovies[1].watch();
                                                movieLibrary.add(currentMovies[1]);
                                                
                                                currentMovies[1] = null;
                                                moviesOut--;
                                                
                                                valid = true;
                                                break;
                                                
                                            }else {
                                             
                                                valid = false;
                                                break;
                                                
                                            }

                                            
                                        default :
                                            System.out.print("You don't have that movie out! Please input again : ");
                                            valid = false;
                                        
                                    }
                                    
                                }while(! valid);
                                
                                break;
                                
                            }else {
                                
                                valid = false;
                                break;
                                
                            }
                            
                        }//END of option 4
                       
                        
                    case 5 ://Same^^^^^^^^^^^^^^(But simpler)
                        if(! gameOut) {
                            
                            System.out.println("\nYou don't have a Game yet! Try something else.");
                            valid = false;
                            break;
                        
                        }else {
                            
                            System.out.print("\nYou want to return your Game? ("+ currentGame[0].title +") [YES] [NO] : ");
                            
                            if(! askUser()) {
                                
                                System.out.print('\u000C');//This wipes the window
                                System.out.println("\n******************************************************");
                                
                                currentGame[0].play();
                                gameLibrary.add(currentGame[0]);
                                        
                                currentGame[0] = null;
                                gameOut = false;
                                
                                valid = true;
                                break;
                                
                            }else {
                                
                                valid = true;
                                break;
                                
                            }
                            
                        }//END of option 5
                    
                        
                    case 6 ://Option 6
                        System.out.print("\nYou want to skip today? [YES] [NO] : ");
                        if(! askUser()) {//If yes
                            
                            System.out.println("\nSkipping today...");
                            System.out.println("\n\n******************************************************");
                            valid = true;
                            break;
                            
                        }else {//If no
                            
                            valid = false;
                            break;
                        
                        }//END of option 6
                        
                        
                    case 7 ://Option 7
                        if(debt == 0) {//If the user has no debt
                            
                            System.out.println("\nYou don't owe any late fees! (Yet...)");
                            valid = false;
                            break;
                        
                        }else {//If the user has debt
                            
                            System.out.print("\nYou want to pay back debt? [YES] [NO] : ");
                            
                            if(! askUser()) {//If yes
                                
                                System.out.print('\u000C');//This wipes the window
                                System.out.println("\n******************************************************");
                                
                                System.out.println("\n\n$"+ debt +" has been payed back to the library.");
                                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                                System.out.println("That'll teach you for avoiding returning library property!");
                                
                                System.out.println("\n\n******************************************************");
                                
                                debt = 0;
                                valid = true;
                                break;
                                
                            }else {//If no
                                
                                valid = false;
                                break;
                            
                            }//END of check user
                        
                        }//END of option 7
                      
                        
                    case 8 ://Last option
                        if(((booksOut > 0) || (moviesOut > 0) || (gameOut)) || (debt > 0)) {//If the user has debt/has media taken out
                            
                            System.out.println("\nYou still have un-returned media, or still owe the library for late fees!");
                            System.out.println("You must owe nothing to the library before exiting. Try something else.");
                            valid = false;
                            break;
                        
                        }else {//If the user is free to go
                            
                            System.out.print("\nYou want to end the program? Your final results will be displayed [YES] [NO] : ");
                            
                            if(! askUser()) {//If yes
                                
                                System.out.println("\nEnding program...");
                                System.out.println("\n\n******************************************************");
                                valid = true;
                                done = true;
                                break;
                                
                            }else {//If no
                                
                                valid = false;
                                done = false;
                                break;
                                
                            }//END of check user
                        
                        }//END of option 8
                    
                    default ://If input is invalid
                        System.out.println("Invalid input! Please try again.");
                        valid = false;
                    
                }//END of switch for input
                
            }while(! valid);//END of check input
            
            try{Thread.sleep(3000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
            System.out.print('\u000C');//This wipes the window
            
        }while(! done);//END of main looop
    
        // End of Main Block of Code
       
        
        
        //User Interface || Results displayed here
        
        System.out.println("\n******************************************************");
        System.out.println("\nRESULTS: ["+ day +" DAYS]");
        try{Thread.sleep(1000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nBooks:");
        
        try{//Checks if user took out any books
            
            bookLibrary.get(0);
            
            for(Book book : bookLibrary) {//If there are books, they are all printed out
                
                System.out.print("\n-\""+ book.title +"\" written by "+ book.author +" ("+ book.releaseYear +"), a "+ book.pages +" page-long "+ book.genre +" book : ");
                System.out.println("Took "+ (7 - book.daysTillDue) +" days to read. ["+ book.rating +" OUT OF 10]");
                
            }//End of print every book
            
            averageB(bookLibrary);//Prints averages
            
        }catch(Exception e) {//If no books
            
            System.out.println("\nNo books were taken out");
            
        }//END of book summary
        
        try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nMovies:");
        
        try{//SAME^^^^^^^^^^^^^^^^
            
            movieLibrary.get(0);
            
            for(Movie movie : movieLibrary) {
            
                System.out.print("\n-\""+ movie.title +"\" directed by "+ movie.director +" ("+ movie.releaseYear +"), a "+ movie.watchTime +" hour-long "+ movie.genre +" film : ");
                System.out.println("Took "+ (7 - movie.daysTillDue) +" days to watch. ["+ movie.rating +" OUT OF 10]");
                
            }
            
            averageM(movieLibrary);
            
        }catch(Exception e) {
            
            System.out.println("\nNo movies were taken out");
            
        }//END of movie summary
       
        
        try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nGames:");
        
        try{//SAME^^^^^^^^^^^^^^^^^^^^
            
            gameLibrary.get(0);
            
            for(Game game : gameLibrary) {
            
                System.out.print("\n-\""+ game.title +"\" developed by "+ game.developer +" ("+ game.releaseYear +"), a "+ game.genre +" game for the "+ game.platform +" : ");
                System.out.println("Took "+ (7 - game.daysTillDue) +" days to beat. ["+ game.rating +" OUT OF 10]");
                
            }
            
            averageG(gameLibrary);
            
        }catch(Exception e) {
            
            System.out.println("\nNo games were taken out");
            
        }//END of game summary
        
        try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
        
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\nThank you for using the Library Program! Please return soon!");
        System.out.println("\n******************************************************");

        
    } // END of Main
} // END of Class Library
//END of Program


/* Notes:
- Hashmap was not used, instead I stored whole instances of classes in Arrays/ArrayLists
- The program is very long, I didn't have time to go back and comment on every single line; next time, I'll comment as I code
- General code is commented on, but since book/movie/game code is very similar, "same" with "^^^" is written alot to save time haha
- I could have simplified LOTS of things, like the classes sharing a single constructor, or a smaller Main with more types of static methods
*/
