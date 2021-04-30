package assignment;
//
//
//import java.awt.Color;
//import java.awt.Shape;

public class PlayableSquare extends Square implements ISquareHolder{

    private Color color;
    private Shape shape;

    public PlayableSquare(Color newColor, Shape newShape) {
        this.color = newColor;
        this.shape = newShape;

    }

    @Override
    public void addSquare(Square square, int row, int column) {

    }

//    @Override
//    public void addSquare(Square square, int row, int column) {
//
//    }
}
