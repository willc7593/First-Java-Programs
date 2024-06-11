// This creates languages from the Mayan family

import java.util.Arrays;

public class Mayan extends Language {//Mayan is a child of Language
    
    public Mayan(String name, int numSpeakers) {//Mayan Constructor
  
        super(name, numSpeakers, "Central America", new String[] {"VERB", "SUBJECT", "OBJECT"}, "Mayan");//This will use the basic Language constructor
        
    }//END of Mayan Constructor
    
    @Override//This slightly changes getInfo by adding a Fun Fact
    
    public String getInfo() {//This will print the languages info to the user
        
        return ("["+ name +"] ("+ family +")\nThis language is spoken in "+ regionSpoken +" by "+ numSpeakers +" people.\nThe word order is: "+ 
            Arrays.toString(wordOrder) +"\n\nFun Fact! Languages in this family are ergative!");
        
    }//END of getInfo()
    
} // END of Child Class Mayan
 