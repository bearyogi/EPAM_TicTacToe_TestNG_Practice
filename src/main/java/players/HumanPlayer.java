package players;

import game.Board;
import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;

public class HumanPlayer implements Player {

    private @Getter
    @Setter char mark;

    public boolean makeAMove(int width, int height, Board board) {
        try {
            if (board.getBoardTTT()[width][height] == ' ') {
                board.getBoardTTT()[width][height] = mark;
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Input width and height must be in range [0 - 2]!");
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
