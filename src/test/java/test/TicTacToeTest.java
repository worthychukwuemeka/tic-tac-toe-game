package test;

import org.example.TicTacToe;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testMakeMove() {
        assertTrue(game.makeMove(0, 0));
        assertFalse(game.makeMove(0, 0)); // Invalid move, cell already occupied
        assertTrue(game.makeMove(1, 1));
    }

    @Test
    public void testCheckWinner() {
        // Test horizontal win
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        assertEquals('X', game.checkWinner());

        // Test diagonal win
        game.initializeBoard();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 2);
        game.makeMove(2, 0);
        assertEquals('O', game.checkWinner());

        // Test no winner
        game.initializeBoard();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(1, 1);
        assertEquals(' ', game.checkWinner());
    }
}

