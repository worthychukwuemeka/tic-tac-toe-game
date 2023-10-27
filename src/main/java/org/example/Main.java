package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("To make a move, enter the row and column (0-2) separated by a space.");

        while (true) {
            printBoard(game);
            System.out.print("Player " + game.getCurrentPlayer() + ", enter your move (e.g., 0 0): ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                char winner = game.checkWinner();
                if (winner != ' ') {
                    printBoard(game);
                    if (winner == 'D') {
                        System.out.println("It's a draw! The game is over.");
                    } else {
                        System.out.println("Player " + winner + " wins! The game is over.");
                    }
                    break;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void printBoard(TicTacToe game) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(game.getBoard()[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
