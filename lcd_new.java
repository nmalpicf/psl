import java.util.*;
import java.lang.Math;

public class lcd_new {

    static final String vertical   = "|";
    static final String horizontal = "¯";
    static final String space      = " ";

//Function to split usersEntry
    private static String[] separate(String userIn){
      String[] splited = userIn.split(",");
      return new String[] {splited[0], splited[1]};
    }

//isNumeric function definition
    private static boolean isNumeric(String str){
      return str.matches("[+-]?\\d*(\\.\\d+)?");
    }

//Function to chek if Entry is a Numeric one
    private static boolean checkInt(String str){
      if (isNumeric(str)){
        return true;
      } else {
        throw new IllegalArgumentException("Size parameter ["+ str + "] "
                                           + "is not a number");
      }
    }

//Function to clearScreen
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

//Function to catch Enter key
    private static void promptEnterKey(){
      System.out.println("Press \"ENTER\" to continue...");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
    }

//Function to create matrix for each number for given size
    private static String[][] matrixCreate(int size){
      int cols = size + 2;
      int rows = (2*size)+3;
      String matrix[][] = new String[rows][cols];
      return matrix;
    }

//Function to initialize matrix
    private static String[][] initMatrix(String[][] matrix){
      for (int i=0; i < matrix.length; i++) {
        for (int j=0; j < matrix[i].length; j++){
            matrix[i][j] = space;
        }
      }
      return matrix;
    }

//Function to print matrix
    private static void printMatrix(String[][] matrix, int row){
      for (int i=0; i < matrix[0].length; i++) {
            System.out.print(matrix[row][i]);
      }
    }

//Function to set numbers to display
    private static String[][] numbersCreate(String[][] matrix, int numbers){
      int row = matrix.length;
      int col = matrix[0].length;
      int halfCol = Math.round(col/2);
      int halfRow = Math.round(row/2);

      switch (numbers){
        case 1:
          for (int i = 0; i < row; i++){
            matrix[i][halfCol] = vertical;
          }
        break;

        case 2:
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col ; i++){
            matrix[halfRow][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = 0; i < halfRow; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = halfRow; i < row - 1; i++){
            matrix[i][0] = vertical;
          }
        break;

        case 3:
          for (int i = 0; i < row; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[halfRow][i] = horizontal;
          }
        break;

        case 4:
          for (int i = 0; i < row; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < col; i++){
            matrix[halfRow][i] = horizontal;
          }
          for (int i = 0; i < halfRow; i++){
            matrix[i][0] = vertical;
          }
        break;

        case 5:
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[halfRow][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = halfRow; i < row - 1; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < halfRow; i++){
            matrix[i][0] = vertical;
          }
        break;

        case 6:
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[halfRow][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = halfRow; i < row - 1; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < row - 1; i++){
            matrix[i][0] = vertical;
          }
        break;

        case 7:
          for (int i = 0; i < row; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
        break;

        case 8:
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[halfRow][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = 0; i < row - 1; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < row - 1; i++){
            matrix[i][0] = vertical;
          }
        break;

        case 9:
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[halfRow][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = 0; i < row - 1; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < halfRow; i++){
            matrix[i][0] = vertical;
          }
        break;

        case 0:
          for (int i = 0; i < col; i++){
            matrix[0][i] = horizontal;
          }
          for (int i = 0; i < col; i++){
            matrix[row - 1][i] = horizontal;
          }
          for (int i = 0; i < row - 1; i++){
            matrix[i][col - 1] = vertical;
          }
          for (int i = 0; i < row - 1; i++){
            matrix[i][0] = vertical;
          }
        break;
      }
      return matrix;
    }

//Function to get digits from numbers
    private static int[] digits(int numbers){
      int i = 0;
      int l = String.valueOf(numbers).length();
      int vector[] = new int[l];
      while (numbers > 0) {
        vector[i] = numbers % 10;
        numbers = numbers/10;
        i++;
      }
      return invArray(vector);
    }

//Function to invert Array
    private static int[] invArray(int[] n) {
        int aux;
        for (int i = 0; i < n.length / 2; i++) {
            aux = n[i];
            n[i] = n[n.length - 1 - i];
            n[n.length - 1 - i] = aux;
        }

        return n;
    }

//Main
    public static void main(String[] args) {
      String userIn = "1,0";
      while(userIn != "0,0"){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nEnter size followed by \",\" and digits you "
                          + "want to print \nEnter \"0,0\" if you want to "
                          + "exit\n\n");

        userIn = sc.nextLine();
        String[] splited = separate(userIn);
        int numbers = 0;
        int size = 0;
        if(checkInt(splited[1])){
          numbers = Integer.parseInt(splited[1]);
          if (String.valueOf(numbers).length() <= 11){
          System.out.print("\n\nnumbers to print = " + numbers + "\n");;
          } else {
          throw new IllegalArgumentException("numbers parameter [" + numbers + "] "
                                              + "must be less than 10 digits");
          }
        }

        if(checkInt(splited[0])){
          size = Integer.parseInt(splited[0]);
          if (size > 0 && size < 10){
          System.out.print("size = " + size + "\n\n");
          String matrix[][] = matrixCreate(size);
          int rows = (2*size)+3;
          int l = String.valueOf(numbers).length();
          int vector[] = digits(numbers);
          for (int i = 0; i < rows; i++){
            for (int j = 0; j < l; j++){
              printMatrix(numbersCreate(initMatrix(matrix),vector[j]),i);
              System.out.print(space);
            }
            System.out.print("\n");
          }
          System.out.print("\n\n");
          } else {
          throw new IllegalArgumentException("Size parameter [" + size + "] "
                                              + "must be between 1 and 10");
          }
        }
        promptEnterKey();
        clearScreen();
      }
    }
}
