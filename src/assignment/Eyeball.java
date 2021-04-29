package assignment;

public class Eyeball implements IEyeballHolder{

    private Direction direction;
    private int eyeballRow;
    private int eyeballCol;

    public Eyeball(int eyeballRow, int eyeballCol, Direction direction) {

        this.eyeballRow = eyeballRow;
        this.eyeballCol = eyeballCol;
        this.direction = direction;

    }

    @Override
    public void addEyeball(int row, int column, Direction direction) {
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
