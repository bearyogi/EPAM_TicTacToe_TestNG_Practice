import game.Board;
import org.testng.annotations.Test;
import players.HumanPlayer;

import static org.testng.Assert.*;

public class HumanPlayerTest {
    HumanPlayer humanPlayer = new HumanPlayer();
    String expectedWinSpeech = "HumanPlayer: Another scrap bites the dust!";
    String expectedLoseSpeech = "HumanPlayer: One day i'll just plug you off!";
    Board board = new Board();
    @Test
    public void testGetMark(){
        humanPlayer.setMark('X');
        assertEquals('X',humanPlayer.getMark());
    }
    @Test
    public void testWinSpeech(){
        humanPlayer.setMark('X');
        assertEquals(humanPlayer.endGameSpeech('X'),expectedWinSpeech);
    }
    @Test
    public void testLoseSpeech(){
        humanPlayer.setMark('X');
        assertEquals(humanPlayer.endGameSpeech('O'),expectedLoseSpeech);
    }
    @Test
    public void testMakeAMoveOnEmptyPlace(){
        assertTrue(humanPlayer.makeAMove(0,0,board));
    }
    @Test
    public void testMakeAMoveOnOccupiedPlace(){
        humanPlayer.makeAMove(2,2,board);
        assertFalse(humanPlayer.makeAMove(2,2,board));
    }
    @Test
    public void testMakeAMoveWithInvalidInput(){assertFalse(humanPlayer.makeAMove(3,2,board));}
}
