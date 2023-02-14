import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();
    static int[][] easyLevelMap = new int[6][15];
    static int[][] mediumLevelMap = new int[9][20];
    static int[][] hardLevelMap = new int[12][25];


    public static void main(String[] args) {
        mainMenu();
        optionsMenu();
    }
    // Method that controls the main Menu
    public static void mainMenu() {
        System.out.print("Hello, welcome to our dungeon game! \n" + "\n" +
                "To start a new game press : (1) \n" +
                "To open the options menu press: (2) \n" +
                "To quit the game press: (3) \n");
        int choice = scanner.nextInt();
        if (choice == 1) {

        } else if (choice == 2) {

        } else if (choice == 3) {

        } else {
            System.out.println("Please input a number between 1 & 3.");
        }
    }
    // Method that controls the options Menu
    public static void optionsMenu() {
        System.out.print("Options: \n" + "\n" +
                "(1) Set difficulty \n" +
                "(2) Go back to main menu \n");
        int optionsChoice = scanner.nextInt();
        // Big if statement is used if the player selects "set difficulty" option.
        if (optionsChoice == 1) {
            System.out.print("Select difficulty: \n" + "\n" +
                    "(0) Easy \n" +
                    "(2) Medium \n" +
                    "(3) Hard \n");
            int difficultyChoice = scanner.nextInt();
            // Nested if statement used when user selects level (body of these statements will be the default arrays).
            if (difficultyChoice == 0) {
                printArray();
            } else if (difficultyChoice == 2) {

            } else if (difficultyChoice == 3) {

            } else {
                System.out.println("Input one of the available options!");
            }
        // This else if statement brings back to the main menu if user selects number 2.
        } else if (optionsChoice == 2) {
            mainMenu();
        } else {
            System.out.println("Input the number 1 or 2");
        }
    }
    public static void printArray() {
        // Prints easy map choice
        int murs = 0;
        int vide = 1;

        for (int y = 0; y < easyLevelMap.length; y++) {
            for (int x = 0; x < easyLevelMap[y].length; x++) {
                if (easyLevelMap[y][x] == vide) {
                    System.out.print(".");
                } else if (easyLevelMap[y][x] == murs) {
                    System.out.print("#");
                }
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}