import game.Board;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class BoardTest {
    Board board = new Board();
    char[][] expectedBoard = new char[3][3];
    String expectedMessage = "|---|---|---|" + "\r\n"
            + "| " + ' ' + " | " + ' ' + " | " + ' ' + " |" + "\r\n"
            + "|-----------|" + "\r\n"
            + "| " + ' ' + " | " + ' ' + " | " + ' ' + " |"+ "\r\n"
            + "|-----------|" + "\r\n"
            + "| " + ' ' + " | " + ' ' + " | " + ' ' + " |"+ "\r\n"
            + "|---|---|---|";

    public char[][] fillBoardWithBlankMarks(){
        for(char[] row: expectedBoard)
            Arrays.fill(row,' ');
        return this.expectedBoard;
    }

    @Test
    public void testToString(){
        assertEquals(expectedMessage,board.toString());
    }
    @Test
    public void testGetBoardTTT() {assertEquals(fillBoardWithBlankMarks(),board.getBoardTTT());}
}
