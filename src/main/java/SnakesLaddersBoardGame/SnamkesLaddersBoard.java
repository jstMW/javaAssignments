package SnakesLaddersBoardGame;

public class SnamkesLaddersBoard {

    private class Space {
        private int path;
        private int expand;

        public Space() {
            path = -1;
            expand = 0;
        }
    }

    private Space[] board;
    private int playerPosition;

    public SnamkesLaddersBoard() {

    }

}
