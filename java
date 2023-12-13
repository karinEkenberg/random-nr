/*Pseudocode
Step 1: declare constants and variables
int CONSTANT = 123;

int[] variable;
int otherVariable = 0;

Step 2:  Ask for user input
print "How many random numbers do you desire?"
save input

Step 3: Prevent errors from user input
catch(WrongUserInput e){
print("wrong entry");
}

Step 4: Generate random numbers
math(random) * 1000 = random numbers;

Step 5: Sort the random numbers
bubblesort;

Step 6: Print out results
print("here are your random numbers");
print("these were even, these were odd");
*/
//importing class to handle input mismatch exceptions
import java.util.InputMismatchException;
//importing class to read user input
import java.util.Scanner;


class Main {
  public static void main(String[] args) {

//create a scanner object to read input from console
    Scanner userInput = new Scanner(System.in);
//declare constants
    int EVEN = 2;
//declare integer variables, array and count
    int[] randomArray;
    int randomCount = 0;
    int[] evenArray;
    int evenCount = 0;
    int[] oddArray;
    int oddCount = 0;

//Using the useDelimiter method which works well with the scanner and will seperate tokens //from input data, could add more such as , or !.
     userInput.useDelimiter("[-:>|\\s]"); 
//while loop that runs until the condiditon is no longer true
    while(true){
      System.out.print("How many random numbers in the range 0 - 999 are desired? ");
//try catch blocks, try to execute then catch to handle the exception:
      try{
        String temp = userInput.nextLine();
        randomCount = Integer.parseInt(temp);

        randomArray = new int[randomCount];
        evenArray = new int[randomCount];
        oddArray = new int[randomCount];
        System.out.println();
        System.out.println("Here are the random numbers:");
        break;
      }
//catches OutOfMemoryErrors that may accur during the execution of the code in the try block
      catch (OutOfMemoryError e){
        System.out.println("I cannot handle that number, try again.");
      }
      catch (InputMismatchException e){
        System.out.println("I can only read integers, please enter a integer.");
      }
      catch (NumberFormatException e){
        //userInput.nextLine(); //clear the input from System.in
        System.out.println("I can only read integers, please enter a integer.");
      }
      
    }
//generate random numbers
  for(int i = 0; i < randomCount; i++){ 
    randomArray[i] = (int)(Math.random() * 1000);
    if(randomArray[i] % EVEN == 0){
      evenArray[evenCount] = randomArray[i];
      evenCount++;
    }
    else{
      oddArray[oddCount] = randomArray[i];
      oddCount++;
    }
  }
//print all the random numbers:
    for(int number : randomArray){
      System.out.print(number + " ");
       }
    System.out.println();
//sorting the even array in ascending order
    for (int i = 0; i < evenCount; i++) {
      // Iterate through the subarray and compare adjacent elements
      for (int j = 0; j < evenCount-1; j++) {
        // Swap elements if left element is greater than right element
        if (evenArray[j] > evenArray[j+1]) {
          int temp = evenArray[j];
          evenArray[j] = evenArray[j+1];
          evenArray[j+1] = temp;
        }
      }
    }
    System.out.println();
    System.out.println("Here are the random numbers arranged:");
    //print even numbers
      if(evenCount == 0){
        System.out.print("No even numbers");
      }
      else{
        for(int i = 0; i < evenCount; i++){
          System.out.print(evenArray[i] + " ");
        } 
      } 

//sorting the odd array descending order
   for (int i = 0; i < oddArray.length; i++) {
      // Iterate through the subarray and compare adjacent elements
      for (int j = 0; j < oddArray.length-1; j++) {
        // Swap elements if left element is greater than right element
        if (oddArray[j] < oddArray[j+1]) {
          int temp = oddArray[j];
          oddArray[j] = oddArray[j+1];
          oddArray[j+1] = temp;
        }
      }
    }
System.out.print("- ");
//print odd numbers
if(oddCount == 0){
       System.out.print("No odd numbers");
}
  else{
        for(int l = 0; l < oddCount; l++){
      System.out.print(oddArray[l] + " ");
    }
  }
    System.out.println();//astethics

    System.out.println("Of the above " + (evenCount + oddCount) + " numbers, " + evenCount + " were even and  " + oddCount + " odd.");
  }

  }

