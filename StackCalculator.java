package edu.ics211.h08;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Scanner;

public class StackCalculator {
  
 private StackInterface<Double> stack;
  
 //Constructor which checks if the stack is null
 public StackCalculator(StackInterface<Double> stack) {
   Objects.requireNonNull(stack, "Internal Stack cannot be null.");
   this.stack = stack;
 } 
 
 //method to add value onto stack
 public void pushValue(double add) {
     stack.push(add);      
 }
 
 //method to calculate  postfix operations, also checks whether there are enough values and throws exception if 1 or less values 
 public void applyOperation(char operation) {
 Double top = stack.pop();
 Double under = 0.0;
 try {
   under = stack.peek();}
   catch (EmptyStackException e) {
     stack.push(top);
     throw new EmptyStackException();
   }
 under = stack.pop();
 Double result = 0.0; 
 switch (operation) {
   case '+' : result = under + top; break;
   case '-' : result = under - top; break;
   case '*' : result = under * top; break;
   case '/' : result = under / top; break;
   default : throw new IllegalArgumentException("");
 }
  System.out.println("The result is " +  result);
  stack.push(result);
 }
   
 //same as peek for stacks
 public double getTop() {
 return stack.peek();
 }
 
 //method created to allow main method to work
  public static boolean checkDouble(String check) {
    if (check == null) {return false;}
    try {
      @SuppressWarnings("unused")
      double attempt = Double.parseDouble(check);
    } catch (Exception e) {
        return false;
      }
    return true;
  }
  

//main method to run calculator and check if it runs properly with methods
  public static void main(String[] args) {
    System.out.println("|||  Stack Calculator  |||\nPlease input numbers and operators 1 at a time\nOnly available operators are +, -, *, /\nEnter = to close the Calculator");
    Scanner in = new Scanner(System.in);
    String input = in.next();
    //ArrayStack<Double> stack = new ArrayStack<Double>();
    LinkedStack<Double> stack = new LinkedStack<Double>();
    StackCalculator calc = new StackCalculator(stack); 
    while (!input.equals("=")) {
      if (checkDouble(input)) {
        Double add = Double.parseDouble(input);
        calc.pushValue(add);
        }else {
            char inp = input.charAt(0);
            calc.applyOperation(inp);
        }
        
      input = in.next();
    }
    System.out.println("You have closed the calculator!");
  }

}
