public class Board {
    public static final int BOARD_WIDTH = 3;

    private final Symbol[][] tiles = new Symbol[BOARD_WIDTH][BOARD_WIDTH];

    public Board() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                tiles[i][j] = Symbol.EMPTY;
            }
        }
    }

    /**
     * Data clump (row,column) -> Position
     */
    public Symbol symbolAt(int row, int column) {
        return tiles[row][column];
    }

    public boolean isTileEmpty(int row, int column) {
        return symbolAt(row, column) == Symbol.EMPTY;
    }

    public boolean isColumnFilled(int x) {
        return !isTileEmpty(x, 0) &&
                !isTileEmpty(x, 1) &&
                !isTileEmpty(x, 2);
    }

    public boolean columnHasTheSameSymbol(int x) {
        return isColumnFilled(x) && symbolAt(x, 0).symbol == symbolAt(x, 1).symbol &&
                symbolAt(x, 2).symbol == symbolAt(x, 1).symbol;
    }

    /**
     * Long parameter list
     * Data clump (row,column) -> Position
     */
    public void setTileSymbol(Symbol symbol, int row, int column) {
        tiles[row][column] = symbol;
    }
}