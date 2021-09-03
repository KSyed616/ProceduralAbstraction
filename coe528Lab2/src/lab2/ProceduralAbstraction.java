package lab2;
import java.util.ArrayList;
import java.util.Scanner;
/*Kumail Syed
  500953361
  January 26, 2021
  Section 1
*/
public class ProceduralAbstraction {
    //Method for reversesFactorial
    public static int reverseFactorial(int x){
        //Declaring and initializing variables we will need
        int i = 0;
        //If statement for the case in which x is 1 or less than 1, including negative numbers
        if(x<=1){
           return 1;
        }
        //For loop to check for the reverse factorial
        for(i = 1; x>i; i++){
            
            /*We check for reverse factorial by dividing the number (x) with the value of i, which starts at 1 and 
              increments by 1 at every run of the loop, and stops when x is divided into 1.
              For example, if x was 6 we first divide by 1, this will make x 6, we then divide by 2 which will make x 3 and then we divide with 3 and that will make x 1
              and end the loop since we now know that it is factorial 3
            */
            x=x/i;
            //We send j instead of i because i is incremented 1 higher than the actual value
            
        }
        //Returning the value of i as that represents the factorial
        return i;
    }
    //Method to check if the 2D array is a nice matrix
    public static boolean isMatrixNice(int[][] arr){
        //Declaring and Initializing the varaibles we'll need to use
        
        int rows = arr.length;//Rows is initialized at the size of rows as in a matrix the size of rows cannot change
        int col = 0;
        int i;
        //Printing array that was sent
        for (i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + " "); 
                } 
                System.out.println("\n");
        }
        
        int sumD1 = 0,
            sumD2 = 0,
            sumRow = 0,
            sumCol = 0;
        //For loop to check if matrix is square
        for(i=0; i<rows; i++){
            /*If statement that works by comparing size of column at i row to the size of row and 
              if the sizes of each column for every i row is equal to that of the rows it's declared to be a square matrix 
            */
            if(arr[i].length == rows){
                col = arr[i].length;
            }
            else{
                System.out.println("Matrix is not square");
                return false;
            }
        }
        /*If statement to check the sum of both diagonals
          We check size of diagonals first as there are always only 2 and if they fail we can easily conclude matrix is not nice
        */
        if(rows == col){
            //We need to use nested for loop to get the sum
            for(i = 0; i<rows; i++){
                for(int j = 0; j<col; j++){
                    //If statement that only works when both i and j are equal or in other words when it's the same row and column
                    if(i == j){
                        //Getting sum of primary diagonal, much easier than getting secondary sum as you can just use i and j to determine it
                        sumD1 += arr[i][j];
                        /*Getting sum of secondary diagonal, in this case the row still follows i whereas the column is
                          reversed meaning it will start the final column and go to the first one
                          This can also be done by having the columns follow j and make the rows go from the final position to first
                        */
                        sumD2 += arr[i][col-j-1];
                    } 
                }
            }
        }
        //If statement which checks if the sum of the two diagonals are equal, if they aren't it returns false and ends method
        if(sumD1 != sumD2){
            System.out.println("The diagonals are not equal");
            return false;
        }
        //For loop to check the sum of columns
        for(i = 0; i<col; i++){
            sumCol = 0;//Necessary to reset sum of columns or it will keep a running sum rather than just a sum of the individual column
            for(int j = 0; j<rows; j++){
                /*Getting the sum of each row, this gets sum of column of rather than row because it's written [j][i]   
                  and since j is the subject of the second for loop this will result in the rows cycling through while the column remains same
                  meaning it sums the column before changing to next column
                */
                sumCol+=arr[j][i];
            }
            //If statement to check if sum of column is equal to that of the diagonal, if they aren't equal it returns false and ends method
            if(sumCol != sumD1){
                System.out.println("The columns do not equal the sum of diagonals");
                return false;
            }
        }
        /*For loop to check sum of rows, follows similar format to that of sum of columns except the convention is flipped to write [i][j]
          meaning it will cycle through the row fully before moving to next row
        */
        for(i = 0; i<rows; i++){
            sumRow = 0;
            for(int j = 0; j<col; j++){
                sumRow+=arr[i][j];
            }
            //If statement to check if the sum of rows is equal to that of the diagonal, if they aren't equal it returns false and ends method
            if(sumRow != sumD1){
                System.out.println("The rows do not equal the sum of diagonals");
                return false;
            } 
        }
        //If method is not prematurely ended due to one of the conditions failing the sum is printed and it returns true
        System.out.println("The sum of the array is: "+sumRow);
        return true;
    }
    //Main class to check different unique cases for the two procedures
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //Getting user input to send appropriate number to get it's reverse factorial
        System.out.println("Enter an integer number: ");
        int num = in.nextInt();
        System.out.println("Reverse factorial of the number you entered is: "+reverseFactorial(num)+"\n");
        //Declaring 5 2D arrays that have different conditions
        int[][] arr1 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};//Nice matrix
        int[][] arr2 = {{1, 1}, {1, 1, 1}, {1, 1, 1}};//Not square
        int[][] arr3 = {{1, 1, 1}, {1, 1, 1}};//Not square
        int[][] arr4 = {{1, 2, 1}, {1, 2, 1}, {1, 2, 1}};//Sum of column and row aren't equal to each other
        int[][] arr5 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 2}};//Two diagonal sums aren't equal
        int[][] arr6 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};//Example given in notes
        
        isMatrixNice(arr1);
        isMatrixNice(arr2);
        isMatrixNice(arr3);
        isMatrixNice(arr4);
        isMatrixNice(arr5);
        isMatrixNice(arr6);
    }
}
//END
