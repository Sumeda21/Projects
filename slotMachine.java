package Spring2023;
import java.util.Scanner;
/* Sean Umeda*/
public class slotMachine {
  
  public static String slotRoll()         //Slot roll method which creates slot machine symbols
  {
    int x = (int)(Math.random()*24+1);    //Does a random roll from 1-25
    String result = " ";                  //Creates string to be used outside of if statement
    if(x <= 12)                           //# from 1-12 return ('), at a 48% chance
      {
        result = "o^o";
      }
      else if(12 < x && x <= 18)          //# from 13-18 return BAR, at a 24% chance
        {
          result = "BAR";
        }
        else if(18 < x && x <= 22)        //# from 19-22 return " $ ", at a 16% chance
          {
            result = " $ ";
          }
          else if(22 < x && x <= 24)      //# from 23-24 return $$$, at a 8% chance
            {
              result = "$$$";
            }
            else if(x == 25)              //# from 25 return " 7 ", at a 4% chance
              {
                result = " 7 ";
              }
    
    return result;                        //Returns a single symbol based on random dice roll
  }

  public static void main(String[] args) {
    int coins = 100;                      //Gives the player 100 coins (Can be altered)
    
    Scanner in = new Scanner(System.in); 
    
    int input = 0;                        //Declares input to be used later 
    
    while (coins > 0)                     //Keeps game going until user runs out of coins
    {      
     System.out.println("How many coins would you like to bet?");                         //Asks for how many coins to bet
     System.out.println("Please enter a number between 1-5, to bet that many coins.");    
     System.out.println("6 will display the payout table and 9 will exit the game  ");    //6 opens payout table and 9 exits game
     System.out.println("Number of coins: " + coins);                                     //Shows user their coins 
     System.out.print("\nPlease enter a number: ");                                       //Asks for a number to indicate coins bet
     input = in.nextInt();                                                              //Next input is used as bet
     System.out.println();                                                                //New line for formatting
       
     if (input == 9)                                                                      //If input is nine, sets coins to zero, terminating loop
     {
       coins = 0;     
     }
       else if(input == 6)                                                     //If input is 6, show payout table
       {
           System.out.println("|  7  ||  7  ||  7  | = Bet * 42");             //Prints statements for payout table
           System.out.println("| $$$ || $$$ || $$$ | = Bet * 22");
           System.out.println("|  $  ||  $  ||  $  | = Bet * 12");
           System.out.println("| BAR || BAR || BAR | = Bet * 8");
           System.out.println("| (') || (') || (') | = Bet * 4\n");
       }
       else if (coins - input < 0)                                            //If input/bet amount is more than coins held 
       {
         System.out.println("You do not have enough coins.\n");               //Show "You do not have enough coins" message
       }
       else                                                                   //Else start the game
       {
         String one = slotRoll();                                             //Slot roll 3 times, each to give a symbol
         String two = slotRoll();
         String three = slotRoll();
         
         System.out.println("=====================");                         //Print statement to draw slots with the symbols
         System.out.println("|-------------------|  O");
         System.out.println("|--  SHILL SLOTS  --|  |");
         System.out.println("|-------------------|  |");
         System.out.println("| " + one + " || " + two + " || " + three +" |   |" );
         System.out.println("|===================|--|");
         System.out.println("|===================|");
         System.out.println("|=====|       |=====|");
         System.out.println("|=====|       |=====|"); 
         System.out.println("=====================\n");
         
         if(!one.equals(two) || !two.equals(three))                           //If statement which checks for a loss/symbols not matching
         {
           System.out.println("Sorry, you didnt win anything this time\n");   //Print statement which tell the user they lost
           coins = coins - input;                                             //Removes coins bet from balance
         }
         else if(one.equals(" 7 "))                                           //If the first one is 7 (as all the loss possibilities are eliminated above)
           {  
             int coinsWon = input*42;                                         //User wins 42 times bet               
             System.out.println("You won " + coinsWon + " coins\n");          //Prints out coins won
             coins = coins + coinsWon - input;                                //Removes coins bet from balance
           }
           else if(one.equals("$$$"))                                         //If first symbol is $$$
             {
               int coinsWon = input*22;                                       //User wins 22 times bet   
               System.out.println("You won " + coinsWon + " coins\n");        //Prints out coins won
               coins = coins + coinsWon - input;                              //Removes coins bet from balance
             }
             else if(one.equals(" $ "))                                       //If first symbol is " $ "
               {
                 int coinsWon = (int)input * 12;                              //User wins 12 times bet  
                 System.out.println("You won " + coinsWon + " coins\n");      //Prints out coins won
                 coins = coins + coinsWon - input;                            //Removes coins bet from balance
               }
               else if(one.equals("BAR"))                                     //If first symbol is BAR
                 {
                   int coinsWon = input * 8;                                  //User wins 8 times bet
                   System.out.println("You won " + coinsWon + " coins\n");    //Prints out coins won
                   coins = coins + coinsWon - input;                          //Removes coins bet from balance
                 }
                 else if(one.equals("o^o"))                                   //If first symbol is o^o
                   {
                     int coinsWon = input * 4;                                //User wins 4 times bet
                     System.out.println("You won " + coinsWon + " coins\n");  //Prints out coins won
                     coins = coins + coinsWon - input;                        //Removes coins bet from balance
                   }
       }
    }
    if (input != 9)                                       //If input is not any of the above, or 9, user is out of coins
        {
          System.out.print("You are out of coins!");      //Message that the user is out of coins
        }
    in.close();
  }
}