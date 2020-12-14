package game;

import players.ComputerPlayer;
import players.HumanPlayer;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner sc = new Scanner(System.in);
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        Arbiter arbiter = new Arbiter();
        Random randGenerator = new Random();
        int width;
        int height;

        System.out.println("Welcome to the XO game!");
        humanPlayer.setMark('X');
        computerPlayer.setMark('O');

        while(true){
            System.out.println(board.toString());
            System.out.println(arbiter.askForMove(humanPlayer));

            width = sc.nextInt();
            height = sc.nextInt();

            while(!humanPlayer.makeAMove(width,height,board)){
                width = sc.nextInt();
                height = sc.nextInt();
            }

            if(arbiter.analizeBoard(board).equals("Win")){
                System.out.println(board.toString());
                System.out.println(arbiter.announceWinner(arbiter.getWinner()));
                System.out.println(humanPlayer.endGameSpeech(arbiter.getWinner()));
                System.out.println(computerPlayer.endGameSpeech(arbiter.getWinner()));
                break;

            }else if(arbiter.analizeBoard(board).equals("End")){
                System.out.println(board.toString());
                System.out.println(arbiter.announceDraw());
                break;
            }

            System.out.println(arbiter.askForMove(computerPlayer));
            width = randGenerator.nextInt(3);
            height = randGenerator.nextInt(3);
            while(!computerPlayer.makeAMove(width,height,board)){
                width = randGenerator.nextInt(3);
                height = randGenerator.nextInt(3);
            }

            arbiter.analizeBoard(board);

            if(arbiter.analizeBoard(board).equals("Win")){
                System.out.println(board.toString());
                System.out.println(arbiter.announceWinner(arbiter.getWinner()));
                System.out.println(humanPlayer.endGameSpeech(arbiter.getWinner()));
                System.out.println(computerPlayer.endGameSpeech(arbiter.getWinner()));
                break;

            }else if(arbiter.analizeBoard(board).equals("End")){
                System.out.println(board.toString());
                System.out.println(arbiter.announceDraw());
                break;
            }

        }

    }
}