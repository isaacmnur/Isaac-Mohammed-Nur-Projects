import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //keeps track of number of items
        int numOfScanner = 1;
        boolean continueGame = true;
        boolean debugOn = false;
        //intro statement
        System.out.println("Welcome to the battleship game!");
        System.out.println("");
        //initalizes board
        Scanner myScanner = new Scanner(System.in);
        System.out.println("");
        Board boatGame = new Board();
        boatGame.placeBoats();
        //choose to run in debug mode or not
        System.out.println("do you want to run in debug mode? (type 1 for yes and 0 for no)");
        int debug = myScanner.nextInt();
        if(debug == 1) {
            debugOn = true;
        }
        System.out.println("");
        //creating variable used in while loop
        int command;
        int num;
        int num2;
        int numOfBoats;
        //keeps going until continue game becomes false
        while(continueGame == true) {
            numOfBoats = 0;
            if(debugOn == true) {
                boatGame.print();
            }
            System.out.println("");
            //displays total shots and turns
            System.out.println("turn: " + boatGame.getTurns());
            System.out.println("total shots: " + boatGame.getTotalShots());
            System.out.println("");
            System.out.println("Type 1 to fire at a target");
            System.out.println("Type 2 to use a scanner (only once)");
            System.out.println("");
            System.out.println("enter command>");
            command = myScanner.nextInt();
            System.out.println("");
            //after command is entered action will occur
            if(command == 1) {
                System.out.println("where would you like to fire?");
                System.out.println("type x coordinate (number between 0-2)");
                num = myScanner.nextInt();
                System.out.println("");
                System.out.println("type y coordinate (number between 0-2)");
                num2 = myScanner.nextInt();
                System.out.println("");
                if(num > 3 || num < 0 || num2 > 3 || num2 < 0) {
                    System.out.println("Out of bounds. Please type number between 0-2");
                    System.out.println("");
                    continue;
                }
                boatGame.fire(num, num2);
                boatGame.setTotalShots(boatGame.getTotalShots() + 1);
                boatGame.setTurns(boatGame.getTurns() + 1);
            }
            else if(command == 2 && numOfScanner == 1) {
                System.out.println("where would you like to use scanner?");
                System.out.println("type x coordinate (number between 0-2)");
                num = myScanner.nextInt();
                System.out.println("");
                System.out.println("type y coordinate (number between 0-2)");
                num2 = myScanner.nextInt();
                System.out.println("");
                if(num > 3 || num < 0 || num2 > 3 || num2 < 0) {
                    System.out.println("Out of bounds. Please type number between 0-2");
                    System.out.println("");
                    continue;
                }
                boatGame.scanner(num, num2);
                numOfScanner -= 1;
            }
            else {
                System.out.println("Error command not allowed. Please try again.");
                boatGame.setTurns(boatGame.getTurns() + 1);
                System.out.println("");
            }
            //checks if boats are gone
            for(int i = 0; i < boatGame.getBoard().length; i++) {
                for(int j = 0; j < boatGame.getBoard()[i].length; j++) {
                    if(boatGame.getBoard()[i][j].getStatus() == 'B') {
                        numOfBoats += 1;
                    }
                }
            }
            if(numOfBoats == 0) {
                continueGame = false;
            }
        }
        System.out.println("you win!");
    }
}
