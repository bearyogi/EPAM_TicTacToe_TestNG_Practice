package players;

import game.Board;
import lombok.Setter;

public class HumanPlayer implements Player {

    private @Setter char mark;

    public boolean makeAMove(int width, int height, Board board) {
        if(board.getBoardTTT()[width][height] == ' ') {
            board.getBoardTTT()[width][height] = mark;
            return true;
        }
        return false;
    }

    public String endGameSpeech(char mark) {
        if(mark == this.mark)
            return getClass().getSimpleName() + ": Another scrap bites the dust!";
        else
            return getClass().getSimpleName() + ": One day i'll just plug you off!";

    }
}
