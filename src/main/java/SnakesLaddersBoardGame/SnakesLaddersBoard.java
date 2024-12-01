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

        public void setExpand(int val) {
            expand = val;
        }
    }

    private ArrayList<Space> board;
    private int playerPosition;

    public SnakesLaddersBoard(int number) {

        addSpaces(number);
        modifyBoard();
        playerPosition = 0;

    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    private void addSpaces(int number) {
        ArrayList<Space> newBoard = new ArrayList<Space>(number);
        for (int i = 0; i < number; i++) {
            newBoard.add(i, new Space());
        }
        board = newBoard;
    }

    private void addSpaces(int number, int index) {
        ArrayList<Space> newBoard = new ArrayList<Space>(number);
        for (int i = 0; i < number; i++) {
            newBoard.add(index, new Space());
        }
        board = newBoard;
    }

    private void modifyBoard() {



        //generate 10% snakes and 10% ladders
        int howMany = board.size() / 10;
        /*I could also make it random like this if you wish to be random uncomment this
        //This could be a setting in the game using Enums later I just add it for demonstration
        int difficulty = 20;
        int howMany = board.size() / rand.nextInt(1, difficulty);
         */


        //to check I don't assign any role to start and end of the board space
        //I just made sure that the random number is bounded between 1-(size-2)
        changeSpacesToSnakes(howMany);

        changeSpacesToLadders(howMany);

        //this is could be aslo a setting and different from the others
        //Note that I don't really understand expansion, like if the space you land on has
        //expansion forward it and you move 3, the effective would be 3-1?? I did that :)
        addExpansion(howMany);
    }

    private void addExpansion(int howMany) {
        int start = 1;
        int end = board.size() - 2;
        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            int chosenSpace = rand.nextInt(start, end);
            if (hasNoRole(board.get(chosenSpace))) {
                if (rand.nextBoolean()) {
                    board.get(chosenSpace).setExpand(1);
                } else {
                    board.get(chosenSpace).setExpand(-1);
                }
            } else {
                //make sure that we will have 10% of this role
                //And we don't get out of the loop before doing so
                i--;
            }
        }

    }



    private void changeSpacesToLadders(int howMany) {

        int start = 1;
        int end = board.size() - 2;
        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            int from = rand.nextInt(start, end) + start;
            int to = rand.nextInt(start, end) + start + from;
            while (from < start || to > end) {
                //since I first made snakes I just need to check I don't override a snake to ladder
                from = rand.nextInt(start, end) + start;
                to = rand.nextInt(start, end) + start + from;
            }
            if (hasNoRole(board.get(to))) {
                board.get(to).setPath(from);
            } else {
                //make sure that we will have 10% of this role
                //And we don't get out of the loop before doing so
                i--;
            }
        }

    }

    private void changeSpacesToSnakes(int howMany) {

        int start = 1;
        int end = board.size() - 2;
        Random rand = new Random();

        for (int i = 0; i < howMany; i++) {
            int from = rand.nextInt(start, end) + start;
            int to = rand.nextInt(start, end) + start - from;
            while (from < start || to > end || to < from) {
                from = rand.nextInt(start, end) + start;
                to = rand.nextInt(start, end) + start - from;
            }
            if (hasNoRole(board.get(from))) {
                board.get(to).setPath(from);
            } else {
                //make sure that we will have 10% of this role
                //And we don't get out of the loop before doing so
                i--;
            }
        }

    }

    private boolean hasNoRole(Space space) {
        return space.getPath() == -1;
    }

    public void move(int number) {
        playerPosition += number + board.get(playerPosition + number).getExpand();
        if (board.get(playerPosition).getPath() != -1) {
            playerPosition = board.get(playerPosition).getPath();
        }
    }

    public String toString() {
        StringBuilder toPrint = new StringBuilder();


        for (int i = 0; i < board.size(); i++) {
            toPrint.append(i+1);
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
        toPrint.append("\nthe player is located at: ");
        toPrint.append(getPlayerPosition()+1);
        return toPrint.toString();
    }

}
