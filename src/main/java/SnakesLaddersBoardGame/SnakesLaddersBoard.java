package SnakesLaddersBoardGame;

import java.lang.StringBuilder;
import java.util.Random;

public class SnakesLaddersBoard {

    private class Space {
        private int path;
        private int expand;

        public Space() {
            path = -1;
            expand = 0;
        }

        public int getPath() {
            return path;
        }

        public int getExpand() {
            return expand;
        }

        public void setPath(int newPath) {
            path = newPath;
        }
    }

    private ArrayList<Space> board;
    private int playerPosition;

    public SnakesLaddersBoard(int number) {

        addSpaces(number);
        modifyBoard();
        playerPosition = 0;

    }

    private void addSpaces(int number) {
        ArrayList<Space> newBoard = new ArrayList<Space>(number);
        for (int i = 0; i < number; i++) {
            newBoard.add(i, new Space());

        }
        board = newBoard;
    }

    /**
     * make some spaces ladders and some snakes
     * defualt is %10 fo the space number
     *
     */
    private void modifyBoard() {
        int howMany = board.size() / 10;

        changeSpacesToSnakes(howMany);
        changeSpacesToLadders(howMany);

    }

    private void changeSpacesToLadders(int howMany) {

        int start = 1;
        int end = board.size()-1;
        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            int from = rand.nextInt(end) + start;
            int to = rand.nextInt(end) + start + from;
            while (from < start || to > end) {
                // if (hasRole(board.get(from)) && hasRole(board.get(to))) {
                // continue;
                // }
                //ToDo: must prevent reassigning a role to an space that already has a role assigned to it!

                from = rand.nextInt(end) + start;
                to = rand.nextInt(end) + start + from;
            }
            System.out.println(from + "->" + to);
            board.get(to).setPath(from);
        }

    }

    private void changeSpacesToSnakes(int howMany) {

        int start = 1;
        int end = board.size()-1;
        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            int from = rand.nextInt(end) + start;
            int to = rand.nextInt(end) + start - from;
            while (from < start || to > end || to < from) {
                from = rand.nextInt(end) + start;
                to = rand.nextInt(end) + start - from;
            }
            System.out.println(to + "->" + from);
            board.get(to).setPath(from);
        }

    }

    private boolean hasRole(Space space) {
        return space.getPath() == -1;
    }

    private void addSpaces(int number, int index) {
    }

    public String toString() {
        StringBuilder toPrint = new StringBuilder("@ ");

        for (int i = 1; i < board.size(); i++) {
            toPrint.append(i);
            if (board.get(i).getExpand() > 0) {
                toPrint.append("+");
            } else if (board.get(i).getExpand() < 0) {
                toPrint.append("-");
            }
            if (board.get(i).getPath() != -1) {
                toPrint.append("->");
                toPrint.append(board.get(i).getPath());
                toPrint.append(" ");
            } else {
                toPrint.append(" ");
            }
        }
        return toPrint.toString();
    }

}
