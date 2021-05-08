package assignment;


public abstract class Square {

    private Shape newShape;
    private Color newColor;

    public Square(){}

    public Square( Color newColor, Shape newShape) {
        this.newShape = newShape;
        this.newColor = newColor;
    }

    public Shape getShape() {
        return newShape;
    }

    public Color getColor() {
        return newColor;
    }

    public void setNewShape(Shape newShape) {
        this.newShape = newShape;
    }

    public void setNewColor(Color newColor) {
        this.newColor = newColor;
    }
}

