package assignment;


public class Square {

    private Shape newShape;
    private Color newColor;

    public Square(){}

    public Square( Color newColor, Shape newShape) {
        this.newShape = newShape;
        this.newColor = newColor;
    }



    public Shape getNewShape() {
        return newShape;
    }

    public Color getNewColor() {
        return newColor;
    }

    public void setNewShape(Shape newShape) {
        this.newShape = newShape;
    }

    public void setNewColor(Color newColor) {
        this.newColor = newColor;
    }
}

