import java.util.Random;
import java.util.Scanner;

public class Game2048 {
    private static final int GRID_SIZE = 4;
    private int[][] grid;
    private Random random;
    private Scanner scanner;

    public Game2048() {
        grid = new int[GRID_SIZE][GRID_SIZE];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void play() {
        initializeGame();
        printGrid();

        while (true) {
            System.out.println("Enter a direction (W/A/S/D):");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("W") || input.equals("A") || input.equals("S") || input.equals("D")) {
                moveTiles(input);
                if (!isGridFull() && placeRandomTile()) {
                    printGrid();
                } else {
                    System.out.println("Game Over!");
                    break;
                }
            } else {
                System.out.println("Invalid input! Please enter a valid direction (W/A/S/D).");
            }
        }

        scanner.close();
    }

    private void initializeGame() {
        // Clear the grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 0;
            }
        }

        // Place the initial tiles
        placeRandomTile();
        placeRandomTile();
    }

    private void printGrid() {
        System.out.println("---------");

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("---------");
    }

    private boolean isGridFull() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean placeRandomTile() {
        int row, col;

        do {
            row = random.nextInt(GRID_SIZE);
            col = random.nextInt(GRID_SIZE);
        } while (grid[row][col] != 0);

        grid[row][col] = (random.nextInt(2) + 1) * 2; // Generate a 2 or 4

        return true;
    }

    private void moveTiles(String direction) {
        switch (direction) {
            case "W":
                moveUp();
                break;
            case "A":
                moveLeft();
                break;
            case "S":
                moveDown();
                break;
            case "D":
                moveRight();
                break;
        }
    }
}
//только до этого момента смогла написать, дальше чуточку сложновато 
