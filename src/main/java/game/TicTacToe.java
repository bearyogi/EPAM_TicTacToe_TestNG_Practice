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
        int width = -1;
        int height = -1;

        System.out.println("Welcome to the XO game!");
        humanPlayer.setMark('X');
        computerPlayer.setMark('O');

        while(true){
            System.out.println(board.toString());
            System.out.println(arbiter.askForMove(humanPlayer));

            if(sc.hasNextInt()) width = sc.nextInt();
            if(sc.hasNextInt()) height = sc.nextInt();
            while(!humanPlayer.makeAMove(width,height,board)){
                sc.next();
                if(sc.hasNextInt()) width = sc.nextInt();
                if(sc.hasNextInt()) height = sc.nextInt();
            }

            if(arbiter.analizeBoard(board).equals("Win")){
                printWinSituation(board, humanPlayer, computerPlayer, arbiter);
                break;

            }else if(arbiter.analizeBoard(board).equals("End")){
                printDrawSituation(board.toString(), arbiter.announceDraw());
                break;
            }

            computerPlayerMove(board, computerPlayer, arbiter, randGenerator);
            arbiter.analizeBoard(board);

            if(arbiter.analizeBoard(board).equals("Win")){
                printWinSituation(board, humanPlayer, computerPlayer, arbiter);
                break;

            }else if(arbiter.analizeBoard(board).equals("End")){
                printDrawSituation(board.toString(), arbiter.announceDraw());
                break;
            }
        }
    }

    public static void computerPlayerMove(Board board, ComputerPlayer computerPlayer, Arbiter arbiter, Random randGenerator) {
        int width;
        int height;
        System.out.println(arbiter.askForMove(computerPlayer));
        width = randGenerator.nextInt(3);
        height = randGenerator.nextInt(3);
        while(!computerPlayer.makeAMove(width,height,board)){
            width = randGenerator.nextInt(3);
            height = randGenerator.nextInt(3);
        }
    }

    public static void printDrawSituation(String s, String s2) {
        System.out.println(s);
        System.out.println(s2);
    }

    public static void printWinSituation(Board board, HumanPlayer humanPlayer, ComputerPlayer computerPlayer, Arbiter arbiter) {
        System.out.println(board.toString());
        System.out.println(arbiter.announceWinner(arbiter.getWinner()));
        System.out.println(humanPlayer.endGameSpeech(arbiter.getWinner()));
        System.out.println(computerPlayer.endGameSpeech(arbiter.getWinner()));
    }
}