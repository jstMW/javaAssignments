package SnakesLaddersBoardGame;

import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        int number = 100;
        SnakesLaddersBoard board = new SnakesLaddersBoard(number);


        System.out.println(board);
//
        //for (int i=0; i<10; i++) {
            //board.move(i);
            //System.out.println(board);
        //}


        Scanner userInput = new Scanner(System.in);
        while (board.getPlayerPosition() != number-1) {
            System.out.println("Enter your move: ");
            board.move(userInput.nextInt());
            System.out.println(board);
        }
        System.out.println("you win");
    }
}
