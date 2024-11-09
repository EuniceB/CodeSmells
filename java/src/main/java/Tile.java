/**
 * Data class
 */
public class Tile
{
    public int X;
    public int Y;
    public Symbol symbol; // primitive obsession & shotgun surgery

    boolean isEmpty(){
        return symbol == Symbol.EMPTY;
    }
}