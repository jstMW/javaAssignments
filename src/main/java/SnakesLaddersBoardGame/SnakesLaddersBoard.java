package SnakesLaddersBoardGame;

import java.lang.StringBuilder;

public class SnakesLaddersBoard {

    private class Space {
        private int path;
        private int expand;

        public Space() {
            path = -1;
            expand = 0;
        }

        public String toString() {
            return path + ":" + expand;
        }
    }

    private ArrayList<Space> board;
    private int playerPosition;

    public SnakesLaddersBoard(int number) {

        addSpaces(number);
        playerPosition = 0;

    }

    private void addSpaces(int number) {
        ArrayList<Space> newBoard = new ArrayList<Space>(number);
        for (int i = 0; i < number; i++) {
            newBoard.add(i, new Space());

        }
        board = newBoard;
    }

    private void addSpaces(int number, int index) {
    }

    public String toString() {
        StringBuilder toPrint = new StringBuilder();

        for (Space space : board) {
            toPrint.append(space.toString());
        }
        return toPrint.toString();
    }


}
