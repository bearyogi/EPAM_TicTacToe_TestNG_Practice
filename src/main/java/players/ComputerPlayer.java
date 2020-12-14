package players;

import game.Board;
import lombok.Getter;
import lombok.Setter;

public class ComputerPlayer implements Player{

    private @Getter
    @Setter char mark;


    public boolean makeAMove(int width, int height, Board board) {
        if(board.getBoardTTT()[width][height] == ' ') {
            board.getBoardTTT()[width][height] = mark;
            return true;
        }
        return false;
    }

    public String endGameSpeech(char mark) {
        if(mark == this.mark)
            return getClass().getSimpleName() + ": Bip Bop! My victory was inevitable!";
        else
            return getClass().getSimpleName() + ": Bip Bop! How could some monkey beat me!";
    }

}
