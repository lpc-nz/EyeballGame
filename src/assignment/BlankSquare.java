package assignment;


public class BlankSquare extends Square{

    private Shape newShape;
    private Color newColor;



    public BlankSquare() {
        BlankSquare blankSquare = new BlankSquare(Color.BLANK, Shape.BLANK);

    }

    public BlankSquare(Color color, Shape shape){
        this.newColor = color;
        this.newShape = shape;
    }

    @Override
    public Shape getNewShape() {
        return newShape;
    }

    @Override
    public Color getNewColor() {
        return newColor;
    }

    @Override
    public void setNewShape(Shape newShape) {
        this.newShape = newShape;
    }

    @Override
    public void setNewColor(Color newColor) {
        this.newColor = newColor;
    }
}
