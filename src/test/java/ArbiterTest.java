import game.Arbiter;
import game.Board;
import org.testng.annotations.Test;
import players.ComputerPlayer;
import players.HumanPlayer;

import static org.testng.Assert.*;

public class ArbiterTest {
    Arbiter arbiter = new Arbiter();
    HumanPlayer humanPlayer = new HumanPlayer();
    ComputerPlayer computerPlayer = new ComputerPlayer();
    String expectedWinMessage = "Win";
    String expectedContinueMessage = "Continue";
    String expectedEndMessage = "End";
    String expectedAnnounceDrawMessage = "Nobody won!";
    String expectedAnnounceWinnerHumanMessage = "And the winner is... X !";
    String expectedAnnounceWinnerComputerMessage = "And the winner is... O !";
    String expectedAskHumanForMoveMessage = "Enter your move, HumanPlayer";
    String expectedAskComputerForMoveMessage = "Enter your move, ComputerPlayer";

    @Test
    public void testAnalizeBoardWinHorizontalLine(){
        Board board = new Board();
        humanPlayer.makeAMove(0,0,board);
        humanPlayer.makeAMove(0,1,board);
        humanPlayer.makeAMove(0,2,board);
        assertEquals(arbiter.analizeBoard(board),expectedWinMessage);
    }
    @Test
    public void testAnalizeBoardWinVerticalLine(){
        Board board = new Board();
        humanPlayer.makeAMove(0,0,board);
        humanPlayer.makeAMove(1,0,board);
        humanPlayer.makeAMove(2,0,board);
        assertEquals(arbiter.analizeBoard(board),expectedWinMessage);
    }
    @Test
    public void testAnalizeBoardWinCrossLine(){
        Board board = new Board();
        humanPlayer.makeAMove(0,0,board);
        humanPlayer.makeAMove(1,1,board);
        humanPlayer.makeAMove(2,2,board);
        assertEquals(arbiter.analizeBoard(board),expectedWinMessage);
    }
    @Test
    public void testAnalizeBoardContinue(){
        Board board = new Board();
        assertEquals(arbiter.analizeBoard(board),expectedContinueMessage);
    }
    @Test
    public void testAnalizeBoardEnd(){
        Board board = new Board();
        humanPlayer.setMark('X');
        computerPlayer.setMark('O');
        humanPlayer.makeAMove(0,0,board);
        humanPlayer.makeAMove(0,1,board);
        computerPlayer.makeAMove(0,2,board);
        computerPlayer.makeAMove(1,0,board);
        computerPlayer.makeAMove(1,1,board);
        humanPlayer.makeAMove(1,2,board);
        humanPlayer.makeAMove(2,0,board);
        computerPlayer.makeAMove(2,1,board);
        computerPlayer.makeAMove(2,2,board);
        assertEquals(arbiter.analizeBoard(board),expectedEndMessage);
    }
    @Test
    public void testAnnounceDraw(){
        assertEquals(arbiter.announceDraw(),expectedAnnounceDrawMessage);
    }
    @Test
    public void testAnnounceWinnerHuman(){
        assertEquals(arbiter.announceWinner('X'),expectedAnnounceWinnerHumanMessage);
    }
    @Test
    public void testAnnounceWinnerComputer(){
        assertEquals(arbiter.announceWinner('O'),expectedAnnounceWinnerComputerMessage);
    }
    @Test
    public void testAskForMoveHuman(){
        assertEquals(arbiter.askForMove(humanPlayer),expectedAskHumanForMoveMessage);
    }
    @Test
    public void testAskForMoveComputer(){
        assertEquals(arbiter.askForMove(computerPlayer),expectedAskComputerForMoveMessage);
    }
}
