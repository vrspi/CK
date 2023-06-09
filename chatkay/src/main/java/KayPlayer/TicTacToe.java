package KayPlayer;

import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
    private char[][] board = new char[3][3];
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private static final char PLAYER_MARKER = 'X';
    private static final char CPU_MARKER = 'O';

    public void start() {
        initializeBoard();
        printBoard();
        
        while (true) {
            playerMove();
            if (isGameOver()) break;
            printBoard();

            cpuMove();
            if (isGameOver()) break;
            printBoard();
        }

        System.out.println("Game over!");
        printBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void playerMove() {
        int row, col;
        do {
            System.out.println("Enter your move (row and column) separated by space: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (row < 0 || col < 0 || row > 2 || col > 2 || board[row][col] != '-');

        board[row][col] = PLAYER_MARKER;
    }

    private void cpuMove() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != '-');

        System.out.println("KayPlayer chose position (" + row + "," + col + ")");
        board[row][col] = CPU_MARKER;
    }

    private boolean isGameOver() {
        if (hasContestantWon(PLAYER_MARKER)) {
            printBoard();
            System.out.println("Player wins!");
            return true;
        }
        if (hasContestantWon(CPU_MARKER)) {
            printBoard();
            System.out.println("KayPlayer wins!");
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        System.out.println("It's a tie!");
        return true;
    }

    private boolean hasContestantWon(char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
            (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
            (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
            (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
            (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
            (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
            (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }
}
