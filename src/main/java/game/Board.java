package game;

import lombok.Getter;
import java.util.Arrays;

public class Board {

    private @Getter char [][] boardTTT = new char[3][3];

    public Board(){
        for(char[] row: boardTTT)
            Arrays.fill(row,' ');
    }

    @Override
    public String toString(){
        return "|---|---|---|" + "\r\n"
        + "| " + boardTTT[0][0] + " | " + boardTTT[0][1] + " | " + boardTTT[0][2] + " |" + "\r\n"
        + "|-----------|" + "\r\n"
        + "| " + boardTTT[1][0] + " | " + boardTTT[1][1] + " | " + boardTTT[1][2] + " |"+ "\r\n"
        + "|-----------|" + "\r\n"
        + "| " + boardTTT[2][0] + " | " + boardTTT[2][1] + " | " + boardTTT[2][2] + " |"+ "\r\n"
        + "|---|---|---|";
    }
}
