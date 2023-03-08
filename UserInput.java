/*******************
   Name: Jennifer Byrne
   
   Date: January 19, 2020
   
   Notes: ENTD381 Week 7 Assignment - This program requests the user to enter their name, validates user input, and echos
          the user's name. It also requests 3 test scores from the user and validates the entered scores.The program 
          calculates the average test score, echos the test scores to the user, and prints the user's average test score.  
  
*******************/
// Imports the Java utility library
import java.util.*;

// Class declaration
public class UserInput {
   
   // Global static variable "name"
   static String name;
   
   // Creates a new Scanner object for user input
   static Scanner sc = new Scanner(System.in);
   
   // Main method
   public static void main(String[] args) {

      System.out.print("What is your name? ");                          // System requests user's name                             
      String name = GetValidName();                                     // Initializes instance of GetValidName 
      System.out.println("Hello, " + name + ".");                       // System echos name
      
      System.out.print("Please enter your test score for Test 1: ");    // System requests user's first test score
      int testGrade1 = GetValidScore();                                 // Initializes instance of GetValidScore 
      
      System.out.print("Please enter your test score for Test 2: ");    // System requests user's second test score
      int testGrade2 = GetValidScore();                                 // Initializes instance of GetValidScore
      
      System.out.print("Please enter your test score for Test 3: ");    // System requests user's third test score
      int testGrade3 = GetValidScore();                                 // Initializes instance of GetValidScore
      
      int avgTestScore = ((testGrade1 + testGrade2 + testGrade3) / 3);  // System calculates average of three test scores
      
      // System echos test scores entered
      System.out.printf("Your test scores are: %4d %4d %4d %n", testGrade1, testGrade2, testGrade3);
      
      // System outputs average test score
      System.out.print("Your average test score is " + avgTestScore + ".");
      
   }
   
   // GetValidName method - input validation to check that only letters have been entered for user's name
   public static String GetValidName() {
      
      // User inputs value for "name"     
      String name = sc.nextLine();
      
      // Loop - if value of "name" is null or if "name" contains characters other than letters 
      while (name == null || name.matches("(^[a-zA-Z]+$)") == false) {
         
         // Then system will respond with message to try again       
         System.out.println("Please use letters only - no numbers or special characters.");
         System.out.print("Try again: ");
         // User will input new value for "name" - overwrites previous "name" value
         name = sc.nextLine();
              
      }
      
      // Returns validated value of "name" to main method
      return name;
      
   }
   
   // GetValidScore method - input validation to check the values of test scores are only numbers between 0 and 100
   public static int GetValidScore() {
      
      // Loop
      while (true) {
         
         // Try statement
         try {
            
            // User inputs value for "testGrade"
            int testGrade = sc.nextInt();
            
            // Nested Loop - if value of "testGrade" is not between 0 and 100
            while (testGrade < 0 || testGrade > 100) {
               
               // Then system will request user to try again
               System.out.println("Please enter a grade between 0 and 100.");
               System.out.print("Try again: ");
               // User will input new value for "testGrade" - overwrites previous "testGrade" value
               testGrade = sc.nextInt();
               
            }    
            
            // Returns validated value of "testGrade"
            return testGrade;   
                      
         } 
         
         // Catch block for InputMismatchException    
         catch (InputMismatchException e) {
            
            // Discards user input
            sc.next();
            // System requests user to try again and returns to the overarching loop
            System.out.println("Please enter a numerical value between 0 and 100.");
            System.out.print("Try again: ");
         
         }
      
      }    
   
   }
   
}
