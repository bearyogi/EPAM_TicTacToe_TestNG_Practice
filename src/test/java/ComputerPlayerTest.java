import game.Board;
import org.testng.annotations.Test;
import players.ComputerPlayer;

import static org.testng.Assert.*;

public class ComputerPlayerTest {
    ComputerPlayer computerPlayer = new ComputerPlayer();
    String expectedWinSpeech = "ComputerPlayer: Bip Bop! My victory was inevitable!";
    String expectedLoseSpeech = "ComputerPlayer: Bip Bop! How could some monkey beat me!";
    Board board = new Board();
    @Test
    public void testGetMark(){
        computerPlayer.setMark('X');
        assertEquals('X',computerPlayer.getMark());
    }
    @Test
    public void testWinSpeech(){
        computerPlayer.setMark('X');
        assertEquals(computerPlayer.endGameSpeech('X'),expectedWinSpeech);
    }
    @Test
    public void testLoseSpeech(){
        computerPlayer.setMark('X');
        assertEquals(computerPlayer.endGameSpeech('O'),expectedLoseSpeech);
    }
    @Test
    public void testMakeAMoveOnEmptyPlace(){
        assertTrue(computerPlayer.makeAMove(0,0,board));
    }
    @Test
    public void testMakeAMoveOnOccupiedPlace(){
        computerPlayer.makeAMove(2,2,board);
        assertFalse(computerPlayer.makeAMove(2,2,board));
    }
}
