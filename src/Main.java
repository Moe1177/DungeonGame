import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();
    int health = 100;
    int level = 0;
    static char[][] easyLevelMap = new char[6][15];
    static char[][] mediumLevelMap = new char[9][20];
    static char[][] hardLevelMap = new char[12][25];

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
            createGameBoard();
            printArray();
            playerMovement();
        } else if (choice == 2) {
            optionsMenu();
        } else if (choice == 3) {
            System.out.println("Thanks for playing!");
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
                createGameBoard();
                printArray();
                playerMovement();

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
        for (int y = 0; y < easyLevelMap.length; y++) {
            for (int x = 0; x < easyLevelMap[y].length; x++) {
                System.out.print(easyLevelMap[y][x]);
            }
            System.out.println();
        }
        System.out.print(" ");
    }

    public static void createGameBoard() {

        // Empty spaces inside game board will be filled with dots
        for (int y = 0; y < easyLevelMap.length; y++) {
            for (int x = 0; x < easyLevelMap[y].length; x++) {
                easyLevelMap[y][x] = '.';
            }
        }
        // Configures the borders of the game board
        for (int x = 0; x < easyLevelMap[0].length; x++) {
            easyLevelMap[0][x] = '#';
            easyLevelMap[5][x] = '#';
        }
        for (int y = 0; y < easyLevelMap.length; y++) {
            easyLevelMap[y][0] = '#';
            easyLevelMap[y][14] = '#';
        }
        // Randomizes obstacles (walls) inside the game board
        int mHard = 14;
        int mMedium = 10;
        for (int m = 0; m < 6; m++) {
            int obstaclesEasyX = rand.nextInt(0, 14);
            int obstaclesEasyY = rand.nextInt(0, 5);

            int obstaclesMediumX = rand.nextInt(0, 20);
            int obstaclesMediumY = rand.nextInt(0, 9);

            int obstaclesHardX = rand.nextInt(0, 25);
            int obstaclesHardY = rand.nextInt(0, 12);

            if (easyLevelMap[obstaclesEasyY][obstaclesEasyX] != '*') {
                easyLevelMap[obstaclesEasyY][obstaclesEasyX] = '#';
            } else if (mediumLevelMap[obstaclesMediumY][obstaclesMediumX] != '*') {
                m = mMedium;
                mediumLevelMap[obstaclesMediumY][obstaclesMediumX] = '#';
            } else if (hardLevelMap[obstaclesHardY][obstaclesHardX] != '*') {
                m = mHard;
                hardLevelMap[obstaclesHardY][obstaclesHardX] = '#';
            }

        }
        // Randomizes the location of 2 enemies
        for (int n = 0; n < 2; n++) {
            int enemiesX = rand.nextInt(0, 14);
            int enemiesY = rand.nextInt(0, 5);

            if (easyLevelMap[enemiesY][enemiesX] != '#') {
                easyLevelMap[enemiesY][enemiesX] = '*';
            }

        }
        // Randomizes the location of the door
        int doorX = rand.nextInt(1, 14);
        int doorY = rand.nextInt(1, 5);
        if (easyLevelMap[doorY][doorX] != '*' && easyLevelMap[doorY][doorX] != '#'
                && easyLevelMap[doorY][doorX] != '@') {
            easyLevelMap[doorY][doorX] = '%';
        }
        // Randomizes the location of the player
        int playerX = rand.nextInt(1, 14);
        int playerY = rand.nextInt(1, 5);
        if (easyLevelMap[playerY][playerX] != '*' && easyLevelMap[playerY][playerX] != '#' && easyLevelMap[playerY][playerX] != '%') {
            easyLevelMap[playerY][playerX] = '@';
        }
    }

    public static void playerMovement() {
        while (true) {
            System.out.print("Where do you wanna move? (Up / Down / Left / Right)");
            String choice = scanner.nextLine();

            switch (choice) {
                case "Up" -> System.out.println("Moving up...");
                case "Down" -> System.out.println("Moving down...");
                case "Left" -> System.out.println("Moving left...");
                case "Right" -> System.out.println("Moving right...");
                default -> System.out.println("Invalid move.");
            }
        }


    }
}