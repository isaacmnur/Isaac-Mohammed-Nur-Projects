public class Cell {
    // Cell class attributes
    private int row;
    private int col;
    private char status;

    //constructor
    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public boolean equal(Cell other) {
        //checks if cell is equal
        if(this.status == other.status && this.row == other.row && this.col == other.col) {
            return true;
        }
        return false;
    }

    //accessor methods
    public void setRow(int newRow) {row = newRow;}
    public void setCol(int newCol) {col = newCol;}
    public void setStatus(char c) {status = c;}
    
    public int getRow() {return row;}
    public int getCol() {return col;}
    public char getStatus() {return status;}
}
