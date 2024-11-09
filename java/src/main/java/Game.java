/**
 * Is this class considered a large class
 * Divergent change? about the symbol type
 * I couldn't find a lazy class or dead code
 */
public class Game {
    private Symbol lastSymbol = Symbol.EMPTY;
    private Board board = new Board();

    /**
     * Data clump (x,y) -> Position
     */
    public void Play(Symbol symbol, int x, int y) {
        validatePlay(symbol, x, y);
        updateGameState(symbol, x, y);
    }

    private void updateGameState(Symbol symbol, int x, int y) {
        lastSymbol = symbol;
        board.setTileSymbol(symbol, x, y);
    }

    private void validatePlay(Symbol symbol, int x, int y) {
        if (isFirstMove()) {
            if (symbol == Symbol.O) {
                throw new InvalidFirstPlayerException();
            }
        }
        if (isSymbolPlayedTwice(symbol)) {
            throw new InvalidNextPlayerException();
        }
        if (!board.isTileEmpty(x, y)) {
            throw new InvalidPositionException();
        }
    }

    private boolean isSymbolPlayedTwice(Symbol symbol) {
        return symbol == lastSymbol;
    }

    private boolean isFirstMove() {
        return lastSymbol == Symbol.EMPTY;
    }

    /**
     * Long method
     * Message chain
     * Comments
     * Feature envy
     * Duplicated code
     *
     * @return
     */
    public Symbol getWinnerSymbol() {
        for (int i = 0; i < Board.BOARD_WIDTH; i++) {
            Symbol columnWinnerSymbol = getWinnerSymbol(i);
            if (columnWinnerSymbol != null) return columnWinnerSymbol;
        }

        return Symbol.EMPTY;
    }

    private Symbol getWinnerSymbol(int x) {
        if (columnHasWinner(x)) {
            return board.symbolAt(x, 0);
        }
        return null;
    }

    private boolean columnHasWinner(int i) {
        return board.columnHasTheSameSymbol(i);
    }
}

