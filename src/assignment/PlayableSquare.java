package assignment;


public class PlayableSquare extends Square{

    private Color color;
    private Shape shape;


    public PlayableSquare(Color newColor, Shape newShape) {
        super(newColor, newShape);
    }


    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }


}
