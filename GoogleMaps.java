// Assignment 5: Google Maps - By Will Croll


/* Program Summary: This program is designed to utilize conditional statements and arrays
- The user will input the desired continent, country, and city using numbers
- The program will keep track of every place they've been, looping for as long as the user wants
- Alongside outputting a results screen, this program has a few secret interactions (Antarctica and North Korea)
*/


/* Important (KEY) Program Elemnts Used:
 - Comments
 - Variables and declaration (double, int, boolean)
 - Strings and concantenation
 - Arrays and ArrayLists (multidimensional)
 - Scanners
 - System.out.println() and .print()
 - .add() .indexOf(), and .toString()
 - ==, >= and <= comparisons
 - &&, ||, and ! comparisons
 - .equals()
 - Increment (++)
 - Classes and constructors (new)
 - Methods and functions (return)
 - \n and \u000C
 - if/if else/else statements
 - switch/case/default statements
 - try/catch statements
 - do/while loops
 - for loops 
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

public class GoogleMaps { // Beginning of Program
    
    // Instance Variables || These are all properties a new instance of GoogleMaps will inherit and write new values over
    
    String[] continents = {"NORTH AMERICA", "SOUTH AMERICA", "EUROPE", "ASIA", "AFRICA", "AUSTRALIA", "ANTARCTICA"};//A list of continents
    
    String[][] countries = {//A list of countries
        {"CANADA", "USA", "MEXICO"}, 
        {"BRAZIL", "COLUMBIA", "ARGENTINA", "PERU", "VENEZEULA", "CHILE"}, 
        {"UNITED KINGDOM", "FRANCE", "GERMANY", "ITALY", "SPAIN", "RUSSIA"}, 
        {"CHINA", "JAPAN", "THAILAND", "SOUTH KOREA", "TAIWAN", "INDIA", "NORTH KOREA"}, 
        {"NIGERIA", "ETHIOPIA", "EGYPT", "SOUTH AFRICA", "MOROCCO", "KENYA"}, 
        {"AUSTRALIA", "NEW ZEALAND"} 
    };
    
    String[][][] cities = {//A large list of cities 
        {//North America cities
            {"VANCOUVER", "CALGARY", "TORONTO", "OTTAWA", "MONTREAL", "HALIFAX"},
            {"SEATTLE", "SAN FRANSISCO", "CHICAGO", "PHILADELPHIA", "DALLAS", "NEW YORK CITY"},
            {"MEXICO CITY", "CANCUN", "PUERTO VALLARTA", "MONTERREY"}
        }, {//South America cities
            {"SAO PAULO", "RIO DE JANERIO", "SALVADOR", "BRASILIA"},
            {"BOGOTA", "CARTAGENA", "MEDELLIN", "SANTA MARTA", "CALI"},
            {"BUENOS AIRES", "MENDOZA", "USHUAIA", "CORDOBA", "ROSARIO"},
            {"CUZCO", "LIMA", "AREQIPA", "AYACHUCHO", "IQUITOS"},
            {"BARQUISIMETO", "CANAIMA", "CARACAS", "CARUPANO"},
            {"SANTIAGO", "VALPARAISO", "PUCON", "CASTRO"}
        }, {//Europe cities
            {"LONDON", "EDINBURGH", "MANCHESTER", "GLASGOW", "LIVERPOOL", "OXFORD"},
            {"PARIS", "MARSEILLE", "LYON", "NICE", "TOULOUSE", "ANNECY"},
            {"BERLIN", "MUNICH", "HAMBURG", "FRANKFURT"},
            {"ROME", "VENICE", "FLORENCE", "NAPLES", "MILAN", "PISA"},
            {"MADRID", "BARCELONA", "SEVILLE", "MALAGA", "GRANADA"},
            {"MOSCOW", "SAINT PETERSBURG", "NOVOSIBIRSK", "YEKATERINBURG"}
        }, {//Asia cities
            {"BEIJING", "HONG KONG", "SHANGHAI", "XI\'AN", "GUANGZHOU", "SHENZHEN"},
            {"TOKYO", "KYOTO", "OSAKA", "HIROSHIMA", "YOKOHAMA"},
            {"BANGKOK", "CHIANG MAI", "PATTAYA", "CHIANG RAI", "KRABI"},
            {"SEOUL", "BUSAN", "SEOGWIPO", "JEJU CITY", "GANGNEUNG"},
            {"TAIPEI", "KAOSIUNG", "CHIAYI", "TAINAN", "TAICHUNG"},
            {"DELHI", "MUMBAI", "BENGALURU", "HYDERABAD", "JAIPUR", "AGRA"}
        }, {//Africa cities
            {"LAGOS", "KANO", "IBADAN", "BENIN CITY"},
            {"ADDIS ABABA", "DIRE DAWA", "MEK'ELE", "GONDAR"},
            {"CAIRO", "ALEXANDRIA", "GIZA", "SHUBRA EL-KHEIMA", "LUXOR"},
            {"CAPE TOWN", "JOHANNESBURG", "DURBAN", "PRETORIA"},
            {"MARRAKECH", "CASABLANCA", "TANGIER", "CHEFCHAOUEN"},
            {"NAIROBI", "KISUMU", "MOMBASA"}
        }, {//Australia cities
            {"SYDNEY", "MELBOURNE", "BRISBANE", "PERTH", "CANBERRA", "CAIRNS"},
            {"AUCKLAND", "CHRISTCHURCH", "WELLINGTON", "HAMILTON"}
        }
    };
    
    //These are used to store the value of the selected area
    int currentContinent;
    int currentCountry;
    int currentCity;

    
    //GoogleMaps Constructor || The users location will be made into an instance of GoogleMaps with this
    public GoogleMaps() {}//END of GoogleMaps Constructor
    
    
    // GoogleMaps Methods || These are functions that can be used by an instance of GoogleMaps
    
    public void checkContinent() {//This will take the user's input and check if it matches the continents presented
        
        //Variables used for basic tasks
        int output;
        boolean valid;
            
        do{//This will loop until the user is satisfied with their choice
            
            System.out.println("\n\n******************************************************");
            System.out.println("\nPlease select the current continent you are in:\n");
            
            for(int i = 0; i < continents.length; i++) {//This will print out every continent to the user
                
                System.out.print("- "+ continents[i] +" = ["+ i +"]\n");//Will print a continent and its related number
                
            }//END of for continents

            System.out.print("\nI am in : ");//The user's input is shown next to this line
                
            do{//This will loop until the user inputs a valid number
                   
                output = promptInt();//This will store a valid integer
                   
                switch(output) {//This switch statement checks through all the available continents
                            
                    //For every case with a continent, it will return to the user,
                    //Set valid to true,
                    //And break the switch
                         
                    case 0: System.out.print("\nYou are in NORTH AMERICA?");
                    valid = true;
                    break;
        
                    case 1: System.out.print("\nYou are in SOUTH AMERICA?");
                    valid = true;
                    break;
        
                    case 2: System.out.print("\nYou are in EUROPE?");
                    valid = true;
                    break;
        
                    case 3: System.out.print("\nYou are in ASIA?");
                    valid = true;
                    break;
        
                    case 4: System.out.print("\nYou are in AFRICA?");
                    valid = true;
                    break;
        
                    case 5: System.out.print("\nYou are in AUSTRALIA?");
                    valid = true;
                    break;
        
                    case 6: System.out.print("\nYou are in ANTARCTICA? Seriously?");
                    valid = true;
                    break;
    
                    default : System.out.print("Invalid input! Please make another selection : ");//If the input is invalid,
                    valid = false;//The loop runs again
                        
                    }//END of check continent
                    
            }while(! valid);//END of input loop
        
        }while(askUser());//END of input contnent
        
        currentContinent = output;//The selected country will be stored in the instance variable
        
    }//END of checkContinent()
    
    
    public void checkCountry() {//This will take the user's input and check if it matches the countries presented
        
        //Variables used for basic tasks
        int output;
        boolean valid;
        
        do{//This will loop until the user is satisfied with their choice
            
            System.out.println("\n\n******************************************************");
            System.out.println("\n\nYour current continent is "+ continents[currentContinent] +". Please select your current country:\n");
            
            for(int i = 0; i < countries[currentContinent].length; i++) {//This will print out every country to the user
                
                System.out.print("- "+ countries[currentContinent][i] +" = ["+ i +"]\n");//Will print a country and its related number
                
            }
            
            System.out.print("\nI am in : ");//The user's input is shown next to this line
                
            do{//This will loop until the user inputs a valid number
                
                output = promptInt();//This will store a valid integer
                        
                switch(output) {//This switch statement checks through all the available countries
                            
                    //For every case with a country, it will return to the user, 
                    //Set valid to true,
                    //And break the switch
                         
                    case 0: System.out.print("\nYou are in "+ countries[currentContinent][0] +"?");
                    valid = true;
                    break;
        
                    case 1: System.out.print("\nYou are in "+ countries[currentContinent][1] +"?");
                    valid = true;
                    break;
        
                    case 2: System.out.print("\nYou are in "+ countries[currentContinent][2] +"?");
                    valid = true;
                    break;
        
                    case 3: System.out.print("\nYou are in "+ countries[currentContinent][3] +"?");
                    valid = true;
                    break;
        
                    case 4: System.out.print("\nYou are in "+ countries[currentContinent][4] +"?");
                    valid = true;
                    break;
        
                    case 5: System.out.print("\nYou are in "+ countries[currentContinent][5] +"?");
                    valid = true;
                    break;
        
                    case 6: System.out.print("\nYou are in NORTH KOREA? Seriously?");
                    valid = true;
                    break;
     
                    default : System.out.print("Invalid input! Please make another selection : ");//If the input is invalid,
                    valid = false;//The loop runs again
                        
                  }//END of check country
                
            }while(! valid);//END of input loop
        
        }while(askUser());//END of input country
        
        currentCountry = output;//The selected country will be stored in the instance variable
        
    }//END of checkCountry()
   
    
    public void checkCity() {//This will take the user's input and check if it matches the cities presented
          
        //Variables used for basic tasks
        int output;
        boolean valid;
            
        do{//This will loop until the user is satisfied with their choice
            
            System.out.println("\n\n******************************************************");
            System.out.println("\n\nYour current country is "+ countries[currentContinent][currentCountry] +". Please select your current city:\n");
            
            for(int i = 0; i < cities[currentContinent][currentCountry].length; i++) {//This will print out every city to the user
                
                System.out.print("- "+ cities[currentContinent][currentCountry][i] +" = ["+ i +"]\n");//Will print a cityt and its related number
                
            }
            
            System.out.print("\nI am in : ");//The user's input is shown next to this line
            
            do{//This will loop until the user inputs a valid number
                
                output = promptInt();//This will store a valid integer
                
                switch(output) {//This switch statement checks through all the available cities
                                
                    //For every case with a city, it will return to the user,
                    //Set valid to true,
                    //And break the switch
                             
                    case 0: System.out.print("\nYou are in "+ cities[currentContinent][currentCountry][0] +"?");
                    valid = true;
                    break;
            
                    case 1: System.out.print("\nYou are in "+ cities[currentContinent][currentCountry][1] +"?");
                    valid = true;
                    break;
            
                    case 2: System.out.print("\nYou are in "+ cities[currentContinent][currentCountry][2] +"?");
                    valid = true;
                    break;
            
                    case 3: System.out.print("\nYou are in "+ cities[currentContinent][currentCountry][3] +"?");
                    valid = true;
                    break;
            
                    case 4: System.out.print("\nYou are in "+ cities[currentContinent][currentCountry][4] +"?");
                    valid = true;
                    break;
            
                    case 5: System.out.print("\nYou are in "+ cities[currentContinent][currentCountry][5] +"?");
                    valid = true;
                    break;
        
                    default : System.out.print("Invalid input! Please make another selection : ");//If the input is invalid,
                    valid = false;//The loop runs again
                            
                }//END of check country
                
            }while(! valid);//END of input loop
            
        }while(askUser());//END of input city
        
        currentCity = output;//The selected city will be stored in the instance variable
        
    }//END of checkCity()
    
   
    public boolean results() {//This is used at the end of every loop to ask the user if they want to input another location
        
        //Variables for simple tasks
        String output;
        boolean valid;
        
        do{//This will loop until the user makes a valid input 
            
            output = promptString();//This will hold a valid string
            
            if(output.equals("again")) {//If the user wants to run the loop again
                
                System.out.print('\u000C');//The screen will be wiped
                return true;//True is returned
                
            }else if(output.equals("results")) {//If the user wants to end the program and see their results
                 
                return false;//False is returned
                
            }else {//Else another input will be asked for
                
                System.out.print("Invalid input! [AGAIN] [RESULTS] : ");
                valid = false;//The loop is reset
                
            }
            
        }while(! valid);//END of input choice
        
        System.exit(1);//If something goes wrong, the program is ended
        return false;
        
    }//END of results()
    
    
    
    // Global Functions || These are functions to be used globally
    
    public static int promptInt() {//This is used whenever the program needs the user to input an Integer
        
        //These are variables used locally within the function for menial tasks
        boolean valid = false;
        String fail;

        Scanner input;//Input will be made here
        
        do{//If the input fails the check, the loop will restart
                    
            input = new Scanner(System.in);//This scanner is assigned here to be reset with every loop until a valid number is input
                    
            if(input.hasNextInt()) {//This will check if the input is a String
                
                return input.nextInt();//The input is returned
                    
            }else {//If not, the program will loop and take a different input
                    
                fail = input.next();//The invalid string will be stored here to present to the user
                System.out.print("\""+ fail +"\""+" is not a valid input! Please input again : ");
    
                valid = false;//The loop wil run again
                    
            }//END of check String
                
        }while(! valid);//END of input Integer
        
        System.exit(1);//If something goes wrong, the program is ended
        return 0;
        
    }//END of promptInt()
    
    
    public static String promptString() {//This is used whenever the program needs the user to input a String
        
        //These are variables used locally within the function for menial tasks
        boolean valid = false;
        int fail;

        Scanner input;//Input will be made here
        
        do{//If the input fails the check, the loop will restart
                    
            input = new Scanner(System.in);//This scanner is assigned here to be reset with every loop until a valid number is input
                    
            if(input.hasNext()) {//This will check if the input is a number
                        
                return input.next();//The input is returned
                    
            }else {//If not, the program will loop and take a different input
                    
                fail = input.nextInt();//The invalid string will be stored here to present to the user
                System.out.print("\""+ fail +"\""+" is not a valid input! Please input again : ");
    
                valid = false;//The loop wil run again
                    
            }//END of check number
                
        }while(! valid);//END of input String
        
        System.exit(1);//If something goes wrong, the program is ended
        return "error";
        
    }//END of promptString()
    
    
    public static boolean askUser() {//This is used whenever the user wants to make a different choice
        
        //Variables used for simple tasks
        String output;
        boolean valid;
        
        System.out.print(" [YES] [NO] : ");
         
        do{//This loops until the user makes a valid input
            
            output = promptString();//This will hold a valid String
        
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

    
    public static void checkAntarctica() {//This is used if the user chooses Antarctica
        
        //Simple variables
        int output;
        boolean valid;
        
        System.out.println("\n\n******************************************************");
        System.out.print("\n\nSo you're in Antarctica? How many layers of clothing are you wearing? [1] [2] [3] [4] [5] : ");
         
        do{//This will loop until the user inputs a valid number
            
            output = promptInt();//This will hold a valid Integer
            
            switch(output) {//This will check if the input matches a given answer
                
                //For every case with an answer, a comment will be returned,
                //Execution will break for formatting,
                //Valid will be set to true,
                //And the switch will break
                
                case 1: System.out.println("\nYou would not be alive.");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 2: System.out.println("\nAre you feeling any hypothermia?");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 3: System.out.println("\nMust be cold!");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 4: System.out.println("\nGood!");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 5: System.out.println("\nYou're well prepared!");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                default : System.out.print("Invalid input! Please enter a valid number : ");//If not, this will be displayed
                valid = false;//And the loop is reset
                
            }
            
        }while(! valid);//END of input loop
        
    }//END of checkAntarctica()
 
    
    public static void checkNorthKorea() {//This is used if the user chooses North Korea
        
        //Simple variables
        int output;
        boolean valid;
        
        System.out.println("\n\n******************************************************");
        System.out.println("\n\nHow did you get into North Korea? Why are you there?!\n");
        System.out.println("- Tourism = [0]");
        System.out.println("- Spy Mission = [1]");
        System.out.println("- Prisoner of the State = [2]");
        System.out.println("- Why Not? = [3]");
        System.out.print("\nBecause... : ");
         
        do{//This will loop until the user inputs a valid number
            
            output = promptInt();//This will hold a valid Integer
            
            switch(output) {//This will check if the input matches a given answer
                
                //For every case with an answer, a comment will be returned,
                //Execution will break for formatting,
                //Valid will be set to true,
                //And the switch will break
                
                case 0: System.out.println("\nStay out of trouble!");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 1: System.out.println("\nI see. Then we never spoke of this...");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 2: System.out.println("\nThat doesn't sound good...");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                case 3: System.out.println("\nI can list several reasons!");
                try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}
                valid = true;
                break;
                
                default : System.out.print("Invalid input! Please enter a valid number : ");//If not, this will be displayed
                valid = false;//And the loop is reset
                
            }
            
        }while(! valid);//END of input loop

    }//END of checkNorthKorea()
    
    
    
    // GoogleMaps Main Execution || All the main blocks of code for the program are run here
    
    public static void main (String[] args) { // Beginning of Main
       
       
        // Variable Declarations || All these variables are used outside the main loop to keep track of total progress
        
        //Total areas visited
        int totalContinents = 0;
        int totalCountries = 0;
        int totalCities = 0;
        
        int loop = 1;//Keeps track of current loop
        
        //These hold lists of the areas the user has visited
        ArrayList<String> continentList = new ArrayList<String>();
        ArrayList<String> countryList = new ArrayList<String>();
        ArrayList<String> cityList = new ArrayList<String>();
        
        GoogleMaps Location = new GoogleMaps();//This instance of GoogleMaps will store the inputted areas during the current loop
        

        // Beginning of Main Block of Code 
        
        //Welcome message
        System.out.println("\nWelcome to the Google Maps Location Tracker, made by Will Croll.");
        System.out.println("This program will take your inputs and narrow down where in the world you are, or where you have visited!");
        System.out.println("If you have visited multiple locations, you can re-run the program as many times as you like and keep track of them all!\n");
         
        do{//This will loop until the user wants to end the program
            
            //Shows the current loop
            System.out.println("\nLocation #"+ loop +" :");
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            Location.checkContinent();//This first step takes the continent
            
            if(Location.currentContinent == 6) {//If the user chooses Antarctica
                
                Location.checkAntarctica();//The special Antarctica interaction is played
                
                if(continentList.indexOf("ANTARCTICA") >= 0) {//If the user has already chosen Antarctica
                    
                    System.out.println("\n\nYou have already been here!");//It will not be added to the total list
                    
                }else {//Else 
                    
                    continentList.add("ANTARCTICA");//It is added to the total list
                    
                }//END of check repeat
                
                loop++;//Loop increases
                
                //Final output
                System.out.println("\n\n******************************************************");
                System.out.print("\n\nYour location: Somewhere in Antarctica...");
                System.out.print("\n\nWould you like to input another location, or see your results and end the program? [AGAIN] [RESULTS] :");
                
            }else {//Else the continent isn't Antarctica, and the program continues normally
                
                Location.checkCountry();//The second step is to take the country
                
                if(Location.currentCountry == 6) {//If the user chooses North Korea
                
                    Location.checkNorthKorea();//The special North Korea interaction is played
                    
                    if(continentList.indexOf("ASIA") >= 0) {//If the user has already chosen Asia
                    
                    }else {//Else
                        
                        continentList.add("ASIA");//It is added to the total list
                        
                    }//END of check repeat
                    
                    if(countryList.indexOf("NORTH KOREA") >= 0) {//If the user has already chosen North Korea
                    
                    }else {//Else
                        
                        countryList.add("NORTH KOREA");//It is added to the total list
                        
                    }//END of check repeat 
                    
                    loop++;//Loop increases
                    
                    //Final output
                    System.out.println("\n\n******************************************************");
                    System.out.print("\n\nYour location: Trapped inside North Korea...");
                    System.out.print("\n\nWould you like to input another location, or see your results and end the program? [AGAIN] [RESULTS] :");
                    
                }else {//Else the country isn't North Korea, and the program continues normally
                    
                    Location.checkCity();//The last step is to take the city
                    
                    if(continentList.indexOf(Location.continents[Location.currentContinent]) >= 0) {//If the continent was already chosen, it won't be added to the total
                
                    }else {//Else
                        
                        continentList.add(Location.continents[Location.currentContinent]);//It is added to the total list
                        
                    }//END of check repeat continent
                    
                    if(countryList.indexOf(Location.countries[Location.currentContinent][Location.currentCountry]) >= 0) {//If the continent was already chosen, it won't be added 
                        
                    }else {//Else
                        
                        countryList.add(Location.countries[Location.currentContinent][Location.currentCountry]);//It is added to the total list
                        
                    }//END of check repeat country
                    
                    if(cityList.indexOf(Location.cities[Location.currentContinent][Location.currentCountry][Location.currentCity]) >= 0) {//If the continent was already chosen,
                        
                        System.out.println("\n\nYou have already been here!");//It will not be added to the total list
                        
                    }else {//Else
                        
                        cityList.add(Location.cities[Location.currentContinent][Location.currentCountry][Location.currentCity]);//It is added to the total list
                        
                    }//END of check repeat city
                    
                    loop++;//Loop increases
                    
                    //Final output
                    System.out.println("\n\n******************************************************");
                    System.out.print("\n\nYour location: "+ Location.cities[Location.currentContinent][Location.currentCountry][Location.currentCity]);
                    System.out.print(", "+ Location.countries[Location.currentContinent][Location.currentCountry]);
                    System.out.print(" ("+ Location.continents[Location.currentContinent] +").");
                    System.out.print("\n\nWould you like to input another location, or see your results and end the program? [AGAIN] [RESULTS] :");
                    
                }//END of North Korea or normal
            
            }//END of Antarctica or normal
        
        }while(Location.results());//END of main loop
       
        // End of Main Block of Code
        
        
        
        //User Interface || The results are given to the user and the program ends
        
        System.out.print('\u000C');//This wipes the window to give a nicely formatted output
        System.out.println("\n\n******************************************************");
        System.out.println("\n\nTotal Continents visited ["+ continentList.size() +"] : "+ continentList.toString());//Total continents
        System.out.println("\nTotal Countries visited ["+ countryList.size() +"] : "+ countryList.toString());//Total countries
        System.out.println("\nTotal Cities visited ["+ cityList.size() +"] : "+ cityList.toString());//Total cities
        System.out.println("\n\nThank you for using the Google Maps Location Tracker!");//Thank you message
        System.out.println("\n\n******************************************************");


    } // END of Main
} // END of Class GoogleMaps
//END of Program


/*
- Arrays were not even a requirement, but I went a bit crazy with them here (Especially cities...)
- Next assignment I will try to use the easier Scanner check method using Integer.parseInt() and try/catch
- 
*/
