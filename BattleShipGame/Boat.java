public class Boat {
    //Boat class attributes
    private int length;
    private boolean horizontal;
    private Cell[] placement;


    public Boat(int length, boolean horizontal ) {
        //initializes attributes
        this.length = length;
        this.horizontal = horizontal;
        this.placement = new Cell[length];
        
    }

    public void setPlacement(int r, int c) {
        //initializes boat
        int row = r;
        int col = c;
        if (horizontal == true) {
            for(int b = 0; b < placement.length; b++) {
                placement[b] = new Cell(row, col, 'B');
                col++;
            }
        }
        else {
            for(int b = 0; b < placement.length; b++) {
                placement[b] = new Cell(row, col, 'B');
                row++;
            }
        }
    }

    // accessor methods
    public void setLength(int newLength) {length = newLength;}
    public void setHorizontal(boolean newHorizontal) {horizontal = newHorizontal;}
    
    public int getLength() {return length;}
    public boolean getHorizontal() {return horizontal;}
    public Cell[] getPlacement() {return placement;}
}
