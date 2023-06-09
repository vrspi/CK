package KayPlayer;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private static final int BOARD_SIZE = 10;
    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private Deque<int[]> snake = new ArrayDeque<>();
    private Direction direction = Direction.RIGHT;
    private int[] food = new int[2];
    private Random random = new Random();
    private boolean gameOver = false;
    private Scanner scanner = new Scanner(System.in);

    public void start() throws InterruptedException, IOException {
        initBoard();
        spawnFood();

        while (!gameOver) {
            printBoard();
            moveSnake();
            Thread.sleep(500);

            if (scanner.hasNext()) {
                char input = scanner.next().charAt(0);
                changeDirection(input);
            }
        }
        System.out.println("Game over!");
    }


    private void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        int[] startPos = {BOARD_SIZE / 2, BOARD_SIZE / 2};
        snake.add(startPos);
        board[startPos[0]][startPos[1]] = 'O';
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE + 2; i++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == food[0] && j == food[1]) {
                    System.out.print("*");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println("|");
        }

        for (int i = 0; i < BOARD_SIZE + 2; i++) System.out.print("-");
        System.out.println();
    }

    private void spawnFood() {
        int x, y;
        do {
            x = random.nextInt(BOARD_SIZE);
            y = random.nextInt(BOARD_SIZE);
        } while (board[x][y] == 'O');
        food[0] = x;
        food[1] = y;
    }

    private void moveSnake() {
        int[] head = snake.getFirst().clone();

        switch (direction) {
            case UP : head[0]--;
            case DOWN : head[0]++;
            case LEFT : head[1]--;
            case RIGHT : head[1]++;
        }

        if (head[0] < 0 || head[0] >= BOARD_SIZE || head[1] < 0 || head[1] >= BOARD_SIZE) {
            gameOver = true;
            return;
        }

        if (board[head[0]][head[1]] == 'O') {
            gameOver = true;
            return;
        }

        snake.addFirst(head);
        board[head[0]][head[1]] = 'O';

        if (head[0] == food[0] && head[1] == food[1]) {
            spawnFood();
        } else {
            int[] tail = snake.removeLast();
            board[tail[0]][tail[1]] = ' ';
        }
    }

    private void changeDirection(char input) {
        switch (input) {
            case 'w' : {
                if (direction != Direction.DOWN) direction = Direction.UP;
            }
            case 's' : {
                if (direction != Direction.UP) direction = Direction.DOWN;
            }
            case 'a' : {
                if (direction != Direction.RIGHT) direction = Direction.LEFT;
            }
            case 'd' : {
                if (direction != Direction.LEFT) direction = Direction.RIGHT;
            }
        }
    }
}