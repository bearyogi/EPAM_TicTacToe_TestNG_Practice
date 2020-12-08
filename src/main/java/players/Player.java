package players;

import game.Board;

public interface Player {
    boolean makeAMove(int width, int height, Board board);
    String endGameSpeech(char mark);
}
