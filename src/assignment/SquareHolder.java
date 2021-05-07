package assignment;

import java.util.ArrayList;

public class SquareHolder {

     Square[][] mySquares;

     public SquareHolder(int height, int width) {
          mySquares = new Square[height][width];
     }

     public void addSquare(Square square, int row, int column) {
          mySquares[row][column] = square;
     }

     public Square getSquare(int row, int column) {
          return mySquares[row][column];
     }



     //Color getColorAt(int row, int column);
     //Shape getShapeAt(int row, int column);

}
