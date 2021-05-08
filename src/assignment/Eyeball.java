package assignment;

public class Eyeball implements IEyeballHolder{

    private Direction direction;
    private int eyeballRow;
    private int eyeballCol;
//    private Shape eyeballShape;
//    private Color eyeballColor;
    private Square square;

    public Eyeball(int eyeballRow, int eyeballCol, Direction direction) {

        this.eyeballRow = eyeballRow;
        this.eyeballCol = eyeballCol;
        this.direction = direction;

    }

    public void setSquare(Square currentSquare){
        square = currentSquare;
    }

    public Square getSquare(){
        return square;
    }

    @Override
    public void addEyeball(int column, int row, Direction direction) {
        this.eyeballRow = row;
        this.eyeballCol = column;
        this.direction = direction;
    }

    @Override
    public int getEyeballRow() {
        return eyeballRow;
    }

    @Override
    public int getEyeballColumn() {
        return eyeballCol;
    }

    @Override
    public Direction getEyeballDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setEyeballRow(int eyeballRow) {
        this.eyeballRow = eyeballRow;
    }

    public void setEyeballCol(int eyeballCol) {
        this.eyeballCol = eyeballCol;
    }
}
