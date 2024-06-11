// This creates languages from the Sino-Tibetan family

public class SinoTibetan extends Language {//SinoTibetan is a child of Language
    

    public SinoTibetan(String name, int numSpeakers) {//Sino Tibetan Constructor
  
        super(name, numSpeakers, "Asia", new String[] {"SUBJECT", "OBJECT", "VERB"}, "Sino-Tibetan");//This will use the basic Language constructor
        
        if(name.toLowerCase().contains("chinese")) {//If the name contains "chinese"
           
            this.wordOrder = new String[] {"SUBJECT", "VERB", "OBJECT"};//The word order is changed
            
        }//END of check name
        
    }//END of SinoTibetan Constructor

} // END of Child Class SinoTibetan
