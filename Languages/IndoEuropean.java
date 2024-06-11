// This creates languages from the Indo-European family

import java.util.Arrays;

public class IndoEuropean extends Language {//IndoEuropean is a child of Language
    
    public IndoEuropean(String name, int numSpeakers) {//IndoEuropean Constructor
  
        super(name, numSpeakers, "America and Europe", new String[] {"SUBJECT", "VERB", "OBJECT"}, "Indo-European");//This will use the Language constructor
          
    }//END of IndoEuropean Constructor
    
    @Override//This slightly changes getInfo by adding a Fun Fact
    
    public String getInfo() {//This will print the languages info to the user
        
        return ("["+ name +"] ("+ family +")\nThis language is spoken in "+ regionSpoken +" by "+ numSpeakers +" people.\nThe word order is: "+ 
            Arrays.toString(wordOrder) + "\n\nFun Fact! This is part of the largest Language Family!");
        
    }//END of getInfo()

} // END of Class IndoEuropean
