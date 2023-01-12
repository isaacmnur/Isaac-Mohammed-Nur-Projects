import java.util.Random;

public class Board{
    //Board class attributes
    private int row;
    private int col;
    private Cell[][] gameBoard;
    private Boat[] boats;
    private int totalShots = 0;
    private int turns = 1;

    //constructor
    public Board() {
        Random random = new Random();
        row = 3;
        col = 3;
        //sets up board with cell objects
        gameBoard = new Cell[row][col];

        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = new Cell(i, j, '-');
            }
        }
    
        boats = new Boat[1];
        boats[0] = new Boat(2, random.nextBoolean());
    }

    public void placeBoats() {
        //places boat in position on the game board array
        Random random = new Random();
        boolean rightPlacement = false;
        //places the boat on the board
        if (boats.length == 1) {
            while(rightPlacement == false) {
                for(int i = 0; i < boats.length; i++) {
                    boats[i].setPlacement(random.nextInt(this.row), random.nextInt(this.col));
                }
                try {
                    for(int i = 0; i < boats.length; i++) {
                        for(int j = 0; j < boats[i].getPlacement().length; j++) {
                            int boatRow = boats[i].getPlacement()[j].getRow();
                            int boatCol = boats[i].getPlacement()[j].getCol();
                            gameBoard[boatRow][boatCol].setStatus('B');
                        }
                    }
                    rightPlacement = true;
                }
                catch (Exception e){
                    rightPlacement = false;
                }
            }    
        }  
    }


    public void fire(int x, int y) {
        //checks if boat is present and if it is then it changes status to Hit
        try {
            if(gameBoard[x][y].getStatus() == '-' || gameBoard[x][y].getStatus() == 'M') {
                gameBoard[x][y].setStatus('M');
                System.out.println("miss");
            }
            else if(gameBoard[x][y].getStatus() == 'B') {
                gameBoard[x][y].setStatus('H');
                System.out.println("Hit!");
            }
            else if(gameBoard[x][y].getStatus() == 'H') {
                System.out.println("Already hit");
            }
        }
        catch (Exception e) {
            System.out.println("miss");
        }
        System.out.println("");
        
    }
    
    
    public void print() {
        //used for debugging prints out entire board
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j].getStatus());
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    
    public void scanner(int x, int y) {
        //Scans coordinate then prints if location has boat.
        if(gameBoard[x][y].getStatus() == 'B') {
            System.out.println("boat is present at this coordinate");
        }
        else if(gameBoard[x][y].getStatus() == 'H') {
            System.out.println("boat is already hit at this coordinate");
        }
        else {
            System.out.println("boat not present at this coordinate");
        }
        System.out.println("");
    }

    //accessor methods
    public void setBoard(Cell[][] newGameBoard) {gameBoard = newGameBoard;}
    public void setBoats(Boat[] newBoats) {boats = newBoats;}
    public void setTotalShots(int newShots) {totalShots = newShots;}
    public void setTurns(int newTurns) {turns = newTurns;}
    
    public Cell[][] getBoard() {return gameBoard;}
    public Boat[] getBoats() {return boats;}
    public int getTotalShots(){return totalShots;}
    public int getTurns() {return turns;}




    
}
