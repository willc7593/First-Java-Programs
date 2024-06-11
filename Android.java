// Assignment 3: Android - Will Croll


/* Program Summary: This program is designed to utilize Classes and methods in Java.
 * It's a battle simulator between the player drone and computer drone, and is significantly based off of random draws.
 * In this turn-based game, players must strategize which methods of their drone they want to use each turn.
 * Data management is also important, as the user must keep an eye on battery life, health, and weigh their chances.
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
 - Math.random() and Math.round()
 - Classes and constructors (new)
 - Methods and functions (return)
 - \n
 - if/if else/else statements
 - do/while statements
 - Arithmetic Operators (+, -, *, /, %)
 - Assignment opperators (+=, -=)
 - .next() and .hasNext() and number equivalents
 - .toUpperCase() and .toLowerCase()
 - String.format("%.2f")
 - import, java.util, and Scanner
 - try/catch with Thread.sleep()
 - System.exit(1) (Hopefully not accessible)
*/

import java.util.Scanner; // This line of code is placed outside of the class to import the Scanner class from java.util

public class Android { // Beginning of Program

    // Instance Variables || These are all properties a new instance of Android will inherit and write new values over
    int code = 8675309;//Starting activation code (Refrenced in opening comment message)
    int batteryLevel;//Keeps track of the drone's battery
    int batteryTotal;//Keeps track of total battery lost during the game
    int position;//Keeps track of the drone position
    double health;//Keeps track of the drone's health
    double damageTotal;//Keeps track of total damage dealt during the game
    
    String name;//Will store the drone's user-inputted name
    
    // Android Constructor || Both player and enemy drones will be instances of Android
    public Android(int bat, double hp) {
        
        //When created, the new instances will assign their unique values here
        batteryLevel = bat;
        health = hp;
        position = 0;
        
    }//END of Android Constructor
    
    
    // Android Methods || All actions the drone can perfom are created here
    
    public boolean activate() {//This will activate the player drone if the password they input is correct
        
        //Temporary variables for menial tasks
        boolean valid;
        int output;
        
        Scanner input;//Will take the user's password input
        
        do{//If the user fails to input the correct password, this code will restart
       
            input = new Scanner(System.in);//Input scanner is assigned (Not declared) so the input resets every loop
            
            if(input.hasNextInt()) {//This will check if the input is a number
                
                output = input.nextInt();//Input is assigned to a variable
                
                if(output == 8675309) {//This will check if the right password was inputted
                    
                    System.out.println("\nSYSTEMS ONLINE. READY FOR COMBAT");
                    
                    return true;//This will end the method and return true
                    
                }else {//Else the user will have to try again
                
                    System.out.print("INCORRECT PASSPHRASE. PLEASE TRY AGAIN : ");
                    
                    valid = false;//This will reset the loop
                    
                }//END of check password
                
            }else {//Else the user will have to try again
                
                System.out.print("INCORRECT PASSPHRASE. PLEASE TRY AGAIN (Hint: The password does not include letters or symbols) : ");
                
                valid = false;//This will reset the loop
                
            }//END of check int
            
        }while(valid == false);//END of input password loop
        
        return false;//Hopefully the program will not have to come to this
        
    }//END of activate()
    
    
    public String nameBot(String context) {//This will take the user input to name the specified drone
        
        //Basic variables used for menial tasks
        boolean valid;
        String output;
        
        //These will take inputs for the name and confirmation
        Scanner input;
        Scanner ask;
        
        do{//If the user wants to input another name, the code will restart
            
            //The scanners are assigned (Not declared) so the inputs reset every loop
            input = new Scanner(System.in);
            ask = new Scanner(System.in);
            
            System.out.print("\nWHAT IS "+ context +" NAME? : ");
            output = input.next().toUpperCase();//Input is assigned
            
            System.out.print("IS \'"+ output +"\' THE DESIRED TITLE? [YES] [NO] : ");
            if(ask.next().toLowerCase().equals("yes")) {//This will ask the user if they are satisfied with their choise
                
                valid = true;
                return output;//Returns the name to the specified droid
                
            }else {//Else the user will get to input again
                
                valid = false;
                
            }//END of confirm name
            
        }while(valid == false);//END of input name loop
        
        return "ENEMY";//Hopefully the program will not reach this
        
    }//END of nameBot()
    
    
    public boolean checkBattery() {//This method is used to return the current battery life and if the user has lost
        
        if(batteryLevel <= 0) {//This will first see if the user has reached 0%
            
            System.out.println("* BATTERY FULLY DEPLETED. INITIATING SHUTDOWN SEQUENCE...*");
            
            return true;//This will return that defeat = true
            
        }else {//Else the current battery life is returned
            
            System.out.println("BATTERY LEVELS: "+ batteryLevel +"%");
            
            return false;//This will return that defeat = false
            
        }//END of check battery level
        
    }//END of checkBattery()
    
    
    public int chargeBattery() {//This method is called to charge 30% of the user's battery
        
        //These access the droid's instance variables to update their values
        batteryLevel += 30;
        batteryTotal += 30;
        
        if(batteryLevel >= 100) {
            
            System.out.println("\nBATTERY AT MAXIMUM CAPACITY");
            
            batteryLevel = 100;//To avoid over-charging, this will default the level back to 100
            
        }
        
        return batteryLevel;//Returns the new number to whatever called for it
        
    }//END of chargeBattery()
    
    
    public double act(double enemyHP) {//This is the big main method used for the duration of the players turn. It includes following action after moving
        
        //Basic variables to hold certain values
        boolean valid;
        double damage;
        String output;
        
        Scanner input;//This will take the user's desired action input
        
        if((position == -1) || (position == 1)) {//This checks for if the user dodged left or right
            
            //These will drain the user of 15% battery, and add 15 to the total amount drained
            batteryLevel -= 15;
            batteryTotal += 15;
            
            System.out.print("\nWhat will you do? [FIRE] [HELP] : ");
            do{//This will loop until the player chooses fire
                
                //The user's choice will be recorded and assigned here
                input = new Scanner(System.in);
                output = input.next().toLowerCase();
                input.close();
                
                if(output.equals("fire")) {//If the user chose fire 
                    
                    damage = (Math.random()*7.5) + 7.5;//A random number between 7.5 and 15 is chosen
                    damage = Math.round(damage*100);//It's rounded up and multplied by 100
                    damage = damage/100;//Then it's divided by 100 to return 2 decimal places
                    
                    enemyHP -= damage;//The enemy health will lose the amount of damage dealt
                    damageTotal += damage;//The damage will be recorded to the total of the game
                    
                    System.out.println("BLASTERS ENGAGED");
                    System.out.println("\nDealt "+ damage +" damage!\n");
                    
                    valid = true;
                    return enemyHP;//This will return the current health of the enemy
                    
                }else if (output.equals("help")){//If the user chose help
                    
                    instructions();//If the player needs to remind themselves of the instructions
                    System.out.print("\nWhat will you do? [FIRE] [HELP] : ");//Asks again for an input
                    valid = false;
                    
                } else {//Else the loop will restart`
                    
                    System.out.print("INVALID INPUT. RE-ENTER COMMAND : ");
                    valid = false;
                    
                }//END of check input
                
            }while(valid == false);//END of input loop
            
        }else if(position == 0) {//Or if they stayed in place
            
            System.out.print("\nWhat will you do? [CHARGE] [FIRE] [HELP] : ");
            
            do{//This will loop until the player's input is valid
                
                //The user's choice will be recorded and assigned here
                input = new Scanner(System.in);
                output = input.next().toLowerCase();
                input.close();
                
                if(output.equals("fire")) {//If the user chose to fire
                    
                    damage = (Math.random()*15) + 15;//A random number between 15 and 30 is chosen
                    damage = Math.round(damage*100);//It's rounded up and multplied by 100
                    damage = damage/100;//Then it's divided by 100 to return 2 decimal places
                    
                    enemyHP -= damage;//The enemy health will lose the amount of damage dealt
                    damageTotal += damage;//The damage will be recorded to the total of the game
                    
                    System.out.println("BLASTERS ENGAGED");
                    System.out.println("\nDealt "+ damage +" damage!\n");
                    
                    batteryLevel -= 10;//The battery will deplete by 10%
                    valid = true;
                    return enemyHP;//This will return the current health of the enemy
                    
                }else if(output.equals("charge")){//If the user inputs charge
                    
                    batteryLevel = chargeBattery();//The battery level will be updated
                    System.out.println("\nBATTERY LEVELS: "+ batteryLevel +"% CHARGED\n");
                    
                    valid = true;
                    return enemyHP;//Since nothing has changed with the enemy's health, it will just return the current health
                    
                }else if (output.equals("help")){
                    
                    instructions();//If the player needs to remind themselves of the instructions
                    System.out.print("\nWhat will you do? [CHARGE] [FIRE] [HELP] : ");
                    valid = false;
                    
                } else {//Else the loop will restart
                    
                    System.out.print("INVALID INPUT. RE-ENTER COMMAND : ");
                    valid = false;
                    
                }//END of check input
                
            }while(valid == false);//END of input loop
            
        }else {//Else something must have went wrong
            
            System.out.println("\nSomething went wrong! Whoops!");
            System.exit(1);//Hopefully the program won't reach this
            
        }//END of check position

        return 0;//Hopefully this won't be reached
    }//END of act()
    
    
    public void move() {//This method will move the drone left, center, or right
        
        position = 0;//When called, the position instance variable is reset to act as a refrence point
        
        //Basic variables for menial tasks
        boolean valid;
        String output;
        
        Scanner input;//User input, you know the drill
        
        System.out.print("\nWhere will you go? [LEFT] [STAY] [RIGHT] [HELP] : ");
        
        do{//This will loop until the player's input is valid
            
            //The user's choice will be recorded and assigned here
            input = new Scanner(System.in);
            output = input.next().toLowerCase();
            input.close();
            
            if(output.equals("left")) {//If the user chooses left
                
                position --;//The position is set to -1
                System.out.println("POSITION VECTORED LEFT");
                valid = true;
                
            }else if(output.equals("right")){//If the user chooses right
                
                position ++;//The position is set to 1
                System.out.println("POSITION VECTORED RIGHT");
                valid = true;
                
            }else if(output.equals("stay")){//If the user chooses stay
                
                //The position stays as 0
                System.out.println("POSITION MAINTAINED");
                valid = true;
                
            }else if(output.equals("help")) {//If the user chooses help
                
                instructions();//If the player needs to remind themselves of the instructions
                System.out.print("\nWhere will you go? [LEFT] [STAY] [RIGHT] [HELP] : ");
                valid = false;
                
            }else {//Else the loop will reset
                
                System.out.print("INVALID INPUT. RE-ENTER COMMAND : ");
                valid = false;
                
            }//END of check input
            
        }while(valid == false);//END of input loop
        
    }//END of move()
    
    
    public double attack(double playerHP, int position) {//This method will be used by the enemy to attack the player drone
        
        double target = Math.round(Math.random()*3);//This will choose one of 4 targets to shoot at
        double damage;//The damage will be stored here
        
        //FOr the if statement below, the bot has a 50% chance to choose 0 (If the user stays), 25% for -1 (Left), and 25% for 1 (Right)
        if(((target <= 1) && (position == 0)) || ((target == 2) && (position == -1)) || ((target == 3) && (position == 1))){//If the target of the boss matches the player's position
            
            damage = (Math.random()*20) + 20;//The boss attacks from between 20 and 40
            damage = Math.round(damage*100);//It's rounded up and multplied by 100
            damage = damage/100;//Then it's divided by 100 to return 2 decimal places
        
            playerHP -= damage;//The damage is taken away from the players health
            damageTotal += damage;//The damage is added to the total amount of damage taken
                    
            System.out.println("\n"+ name +" dealt "+ damage +" damage to you!");
                  
            return playerHP;//The new health value is returned here
            
        } else {//Else the boss will miss it's attack
            
            System.out.println("\n"+ name +" missed their attack!");
            
            return playerHP;//Since the players health does not change, the current health is returned
            
        }//END of check position
                   
    }//END of attack()
    
    
    public boolean checkHealth(String entity) {//This method is used to check the current health of the drone
        
        if(entity.equals("player")) {//If the players health is being checked
            
            if(health <= 0) {//If your health has gone below 0
                
                System.out.println("* HEALTH FULLY DEPLETED. INITIATING SELF-DESTRUCT SEQUENCE... *");
                return true;//Then defeat will be set to true
                
            }else {//Else the program continues as usual
                
                System.out.println(name +"'S HEALTH: "+ String.format("%.2f",health));//The current health is returned
                return false;//Defeat will be false
                
            }//END of check player
            
        }else if(entity.equals("boss")) {//If the enemies health is being checked
            
            if(health <= 0) {//If the enemies health has gone below 0
                
                System.out.println("* "+ name +" ELIMINATED. VICTORY! *");
                return true;//Then victory will be set to true
                
            }else {//Else the progrm continues as usual
                
                System.out.println(name +"'S HEALTH: "+ String.format("%.2f",health));//The current health is returned
                return false;//Victory will be false
                
            }//END of check boss
            
        }else {//This won't happen
            
            //This should'nt happen
            System.out.println("\nSomething went wrong! Whoops!");
            System.exit(1);
            return false;//Could this actually happen somehow?
            
        }//END of check entity
       
    }//END of checkHealth()
    
    
    public static void instructions() {//This global function is called whenever the user needs to refresh on the rules
        
        System.out.println("\n");
        System.out.println("******************** BATTLE DRONE: INSTRUCTIONS ********************");
        System.out.println("- Object of the game: Destroy the enemy boss drone by depleting it's health to 0");
        System.out.println("- Defeat conditions: Either your health is depleted or your battery runs out\n");
        System.out.println("HOW TO PLAY:");
        System.out.println("- Your drone and the enemy drone both have health to watch for. You start with 150 hit points and the boss has 200");
        System.out.println("- You also have a battery to keep your eye on. Letting it drop to 0% will result in defeat");
        System.out.println("- Every trun, the enemy will fire at one of 3 positions: left, center, or right. Make sure you are not in the line of fire");
        System.out.println("- You have the option to dodge or stay put. You can dodge left or right");
        System.out.println("- If you choose to stay put, you can fire at the enemy and deal between 15 and 30 points of damage, OR you can charge 30% of your battery");
        System.out.println("- If you dodge, you can fire at the enemy and deal 7.5 to 15 points of damage. Consider your risk/reward in every situation");
        System.out.println("- Dodging will drain 5% battery, and firing drains 10%");
        System.out.println("- The enemy has a higher chance of shooting you when you stay put, so weigh your options wisely!");
        System.out.println("- The enemy drone also cannot dodge, so you will always hit it, but it has more health and deals more damage");
        System.out.println("- The game will end once you defeat the enemy drone. Good luck!");
        System.out.println("********************************************************************");
        System.out.println("\n");
        
        try{Thread.sleep(5000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Cool pause in execution
        
    }//END of instructions()
    
    
    
    // Android Main Execution || The main execution og the game is carried out here
    
    /**
    * ************************** GOVERNMENT OF CANADA ****************************
    * ********************* DROID ACTIVATION CODE: 8675309 ***********************
    * *** MISHANDLEMENT OF GOVERNMENT TECHNOLOGY WILL LEAD TO IMMEDIATE ARREST ***
    * ******************************* GOOD LUCK *********************************
    *///This message is displayed on the opening prompt when choosing main() in BlueJ (Note the password displayed)
    
    public static void main (String[] args) { // Beginning of Main
        
        
        // Variable Declarations || These will be used for holding basic values 
        //These will hold a boolean for whether the victory/defeat conditions have been met
        boolean defeatA;
        boolean defeatB;
        boolean victory;
        
        int turn = 0;//This will hold the current number of turns
        
        //These are used once when asked to view the instructions
        String answer;
        Scanner help = new Scanner(System.in);
        
        //These are the new instances of Androis, Player and Boss, and are constructed with their own unique values
        Android Player = new Android(100, 150);
        Android Boss = new Android(100, 200);
        
        
        // Beginning of Main Block of Code 
        
        System.out.println("Welcome to the Android Program, made by Will Croll.");
        System.out.println("This program will pit your drone against the boss drone in a 1v1 boss battle program!\n");//Welcome messages
        
        System.out.print("Would you like to view the instructions? [YES] [NO] : ");
        answer = help.next();//Users input is recorded
        if(answer.equals("yes")) {//If the user wants to read the instructions
            
            instructions();//The instructions will be called for the user
            
        }else if(answer.equals("no")) {//If they type no, the program continues
            
            System.out.println("Looks like you're ready!");
            
        }else{//Else an invalid input will continue the program anyways
            
            System.out.println("Your input was invalid, so we'll just guess that you're ready to play!");
            
        }//END of check help
        help.close();//Scanner will close
        
        System.out.print("\nActivate your Battle Drone with your Government-supplied secret activation code : ");
        Player.activate();//This will call activate() on the player drone, requiring the user to input the secret password
        
        Player.name = Player.nameBot("MY");//This will call nameBot() on the player, assigning a name
        Boss.name = Boss.nameBot("MY OPPONENT'S");//This will call nameBot() on the enemy, assigning a name
        
        System.out.print("\nLET'S DO THIS\n");
        try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
        
        do{//This loop is the main gameplay loop. All aspects of the game/program take place here
            
            turn++;//Every round, the number of turns will increase
            System.out.println("\n\n******************** TURN "+ turn +" ********************\n");
            
            Player.move();//This executes the move() sequence
            
            Player.health = Boss.attack(Player.health, Player.position);//This executes attack(), calculating the enemy's attack
            
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            Boss.health = Player.act(Boss.health);//The players act() is executed, deciding the player's main actions
            
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            defeatA = Player.checkHealth("player");//The player's health is outputted
            victory = Boss.checkHealth("boss");//The enemy's health is outputted
            defeatB = Player.checkBattery();//The player's battery power is outputted
            
            try{Thread.sleep(2000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            //While both the victory and defeat conditions are not met, the cycle will continue
        }while((defeatA == false) && (defeatB == false) && (victory == false));//END of gameplay loop
        
        // End of Main Block of Code
        
        
        
        //User Interface || The final output of the game's results
        
        if(((defeatA == true) || (defeatB == true)) && (victory == true)) {//If both the player and enemy lose
            
            //The game ends in a tie, and the results and statistics are returned
            System.out.println("\n\n******************** IT'S A TIE! ********************");
            System.out.println("\nTurns taken : "+ turn);
            System.out.println("\nTotal battery power used : "+ Player.batteryTotal +"%");
            System.out.println("\nTotal damage given : "+ String.format("%.2f", Player.damageTotal));
            System.out.println("\nTotal damage taken : "+ String.format("%.2f", Boss.damageTotal));
            
            try{Thread.sleep(3000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            System.out.println("\n\nThanks for playing! Try for real next time!");//Thank you message, and end of program
            
        }else if(victory == true) {//If the player wins
            
            //The results and statistics are returned
            System.out.println("\n\n******************** YOU WIN! ********************");
            System.out.println("\nTurns taken : "+ turn);
            System.out.println("\nTotal battery power used : "+ Player.batteryTotal +"%");
            System.out.println("\nTotal damage given : "+ String.format("%.2f", Player.damageTotal));
            System.out.println("\nTotal damage taken : "+ String.format("%.2f", Boss.damageTotal));
            
            try{Thread.sleep(3000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            System.out.println("\n\nThanks for playing! Congrats on the win!");//Thank you message, and end of program
            
        }else if((defeatA == true) || (defeatB == true)) {//If the player loses
            
            //The results and statistics are returned
            System.out.println("\n\n******************** YOU LOSE... *****************\n");
            System.out.println("\nTurns taken : "+ turn);
            System.out.println("\nTotal battery power used : "+ Player.batteryTotal +"%");
            System.out.println("\nTotal damage given : "+ String.format("%.2f", Player.damageTotal));
            System.out.println("\nTotal damage taken : "+ String.format("%.2f", Boss.damageTotal));
            
            try{Thread.sleep(3000);}catch(InterruptedException ex){Thread.currentThread().interrupt();}//Pause in code for cool formatting
            
            System.out.println("\n\nThanks for playing! Better luck next time!");//Thank you message, and end of program
            
        }else {//Else...?
            
            //This shouldn't happen
            System.out.println("\nSomething went wrong! Whoops!");
            System.exit(1);//The program will be forcibly shut down
            
        }
    


    } // END of Main
} // END of Class Android
//END of Program


/*
- The activation code is '8675309', it's included in the starting comments for main()
- The equivalent to the hover() method the assignemnt instructions ask for is move()
- Sometimes the health numbers would round improperly and return 8 decimals, I'm still not sure why, so I used .format() in some of the outputs to fix it
- try/catch statements are put on one line since I have yet to fully understand them
*/
//600 lines of code! 