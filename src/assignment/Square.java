package assignment;




public class Square {

    protected Shape squareShape;
    protected Color squareColor;
    private PlayableSquare playableSquare;
//    private ArrayList<Square> square;


    public Square(Color newColor, Shape newShape) {

        this.squareShape = newShape;
        this.squareColor = newColor;
    }

    public Square(){

    }
//
//    public void addSquare(Square square, int row, int column) {
//
//    }




    public Color getColorAt(int row, int column) {
        return null;
    }


    public Shape getShapeAt(int row, int column) {
        return null;
    }


    public Shape getSymbol() {
        return squareShape;
    }

    public Color getColor() {
        return squareColor;
    }

//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }



}

