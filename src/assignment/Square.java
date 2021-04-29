package assignment;


import java.util.ArrayList;

public class Square implements ISquareHolder {

    private Shape symbol;
    private Color color;
    private ArrayList<Square> square;
    private int x;
    private int y;

    public Square(Square square, int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void addSquare(Square square, int row, int column) {

    }

    @Override
    public Color getColorAt(int row, int column) {
        return null;
    }

    @Override
    public Shape getShapeAt(int row, int column) {
        return null;
    }


    public Shape getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }



}

