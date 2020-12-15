package game;

import lombok.Getter;
import lombok.Setter;
import players.Player;

public class Arbiter {

    private @Getter @Setter
    char winner;

    public String analizeBoard(Board board){
        char[][] boardTiles = board.getBoardTTT();

        if(boardTiles[0][0] != ' ' && boardTiles[0][0] == boardTiles[0][1] && boardTiles[0][0] == boardTiles[0][2]) {setWinner(boardTiles[0][0]); return "Win";}
        if(boardTiles[1][0] != ' ' && boardTiles[1][0] == boardTiles[1][1] && boardTiles[1][0] == boardTiles[1][2]) {setWinner(boardTiles[1][0]); return "Win";}
        if(boardTiles[2][0] != ' ' && boardTiles[2][0] == boardTiles[2][1] && boardTiles[2][0] == boardTiles[2][2]) {setWinner(boardTiles[2][0]); return "Win";}

        if(boardTiles[0][0] != ' ' && boardTiles[0][0] == boardTiles[1][0] && boardTiles[0][0] == boardTiles[2][0]) {setWinner(boardTiles[0][0]); return "Win";}
        if(boardTiles[0][1] != ' ' && boardTiles[0][1] == boardTiles[1][1] && boardTiles[0][1] == boardTiles[2][1]) {setWinner(boardTiles[0][1]); return "Win";}
        if(boardTiles[0][2] != ' ' && boardTiles[0][2] == boardTiles[1][2] && boardTiles[0][2] == boardTiles[2][2]) {setWinner(boardTiles[0][2]); return "Win";}

        if(boardTiles[0][0] != ' ' && boardTiles[0][0] == boardTiles[1][1] && boardTiles[0][0] == boardTiles[2][2]) {setWinner(boardTiles[0][0]); return "Win";}
        if(boardTiles[2][0] != ' ' && boardTiles[2][0] == boardTiles[1][1] && boardTiles[2][0] == boardTiles[0][2]) {setWinner(boardTiles[2][0]); return "Win";}


        for(int width = 0;width<3;width++){
            for(int height = 0;height<3;height++){
                if(boardTiles[width][height] == ' ') return "Continue";
            }
        }

            return "End";
    }

    public String askForMove(Player player){ return "Enter your move, " + player.getClass().getSimpleName(); }
    public String announceWinner(char mark){ return "And the winner is... " + mark + " !";}
    public String announceDraw(){ return "Nobody won!";}
}
