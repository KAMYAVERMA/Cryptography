import java.util.LinkedList;

class KeyGenerator{

  static LinkedList <String> allPermutations;
  static String armstrongDigits;

  static{
    armstrongDigits = "153704"; //unique digits of the armstrong number
    allPermutations = new LinkedList<String>(); 
    getPermutations(armstrongDigits, "");
  }

  String userKey;
  KeyGenerator(int uid){
    int i = uid % allPermutations.size();
    userKey = allPermutations.get(i) ;//+ System.currentTimeMillis();
    
  }   

  String getKey(){

    return userKey;
  }

  
  private static void getPermutations(String set, String sol){
     
    int i;
    char currentDigit;
    String restOfTheDigits;

    if(set.length() == 1){
      //result = sol + set  
      allPermutations.add( sol+set);

    }else{

      //for the digits of the set
      for(i =0 ; i < set.length(); i++){
        currentDigit = set.charAt(i);
        restOfTheDigits = set.substring(0,i) + set.substring(i+1);
     
        getPermutations(restOfTheDigits, sol + currentDigit);
      }//for

    }//else
  }


 
}