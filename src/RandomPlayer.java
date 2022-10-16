import java.awt.*;

/***
 * This class runs when the "Random Player" button is pressed.
 * The computer will make a random move.
 */

public class RandomPlayer {

    public Chip[][] gameBoard;

    public Point move(Chip[][] pBoard){

        System.out.println("Random Player Move");

        gameBoard = pBoard;
        Point myMove = new Point(0,0);
        //return a random move in the form of x, y or row, column

        int randomCol;
        int randomRow;

        do {
            //the goal is that after the random players turn the smallest even number will be left on the board
            //this definitly involves something that checks if the number can be divided by two And something that can count the whole board
            randomRow = (int) (Math.random() * 10);
            randomCol = (int) (Math.random() * 10);
        } while(!gameBoard[randomRow][randomCol].isAlive);

        myMove = new Point(randomRow,randomCol);
        // if gameBoard randomrow+randomco/2 {}
        return myMove;

    }

}
