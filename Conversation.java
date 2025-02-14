import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Conversation implements Chatbot {

  // Attributes 
  Scanner in;
  ArrayList<String> transcript;

  /**
   * Constructor 
   */

  Conversation() {
    this.in = new Scanner(System.in); /* Creates scanner called in */
    this.transcript = new ArrayList<>(); /* Creates array called transcript */
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    /* Get's the number of rounds */
    System.out.println("How many rounds?");
    int rounds = in.nextInt();
    in.nextLine();
    System.out.println("What would you like to talk about?");

    /* Loop that runs the converstaion for the correct number of rounds*/
    for (int i= 0; i < rounds; i++) {
      String inString = in.nextLine();
      transcript.add(inString);
      String resultOfChat = respond(inString);
      transcript.add(resultOfChat);
      System.out.println(resultOfChat);
    }
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    /* Closes out the converstaion */
    System.out.println("Thanks for chatting!");
    System.out.println("TRANSCRIPT:");
    System.out.println("What would you like to talk about?");

    /* Creates loop that prints the converstaion*/
    for(String s : transcript){
      System.out.println(s);
    }
    System.out.println("Thanks for chatting!");
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    /* Splits up the string into differnet words */
    String[] words = inputString.split(" ");
    String[] returnString = new String[words.length];
    int count = 0; 
    String theResponse;
    /* Creates a loop that looks at each word and sees if it matches a key word*/
    for (int i = 0; i <words.length; i++) {
      if (words[i].equalsIgnoreCase("I")){;
        returnString[i] = "you";
      }
      else if(words[i].equalsIgnoreCase("me")){;
        returnString[i] = "you";
      }
      else if(words[i].equalsIgnoreCase("am")){;
        returnString[i] = "are";
      }
      else if(words[i].equalsIgnoreCase("you")){;
        returnString[i] = "I";
      } 
      else if(words[i].equalsIgnoreCase("my")){;
        returnString[i] = "your";
      }
      else if(words[i].equalsIgnoreCase("your")){;
        returnString[i] = "my";
      }
      else{
        returnString[i]= words[i];
        count += 1; /* Counts to see if none of the words match any of the key words above*/
      }
    }
    /* If none of the key words above were mentioned returns a random response*/
    if(count == words.length){
      String[] randomResponse = {
        "Uh-huh",
        "Cool",
        "Amazing",
        "Interesting",
        "Tell me more"
       };
      Random random = new Random();
      int randomNumber = random.nextInt(5);
      theResponse = randomResponse[randomNumber];
      return theResponse;
  }
  /* If no random response is needed it joins the words back together and adds a ? */
    else {String result = String.join(" ", returnString);
    result = result + "?";
      return result;
  }
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}
