package assignment;

import java.util.ArrayList;

public class Game  {
    private int goalRow;
    private int goalCol;

    private ArrayList<ILevelHolder> allMyLevels = new ArrayList<ILevelHolder>();
    private ArrayList<IGoalHolder> allMyGoals = new ArrayList<IGoalHolder>();
    private SquareHolder squareHolder;
    private Eyeball eyeball;
    private Message message;
    private Direction currentDirection;


    public void addLevel( int newLevelHeight, int newLevelWidth) {
        ILevelHolder newLevel = new Level(newLevelHeight , newLevelWidth);
        allMyLevels.add(newLevel);
        squareHolder = new SquareHolder(newLevelHeight, newLevelWidth);
    }

    public void addGoal(int targetRow, int targetCol) {
        GoalLocation newGoal = new GoalLocation(targetRow, targetCol);
        allMyGoals.add(newGoal);
        this.goalRow = targetRow;
        this.goalCol = targetCol;
    }

    public void addSquare(Square square, int col, int row){
        //TODO
        if(col > squareHolder.levelHeight || row > squareHolder.levelWidth || col < 0 || row < 0){
            throw new IllegalArgumentException();
        } else {
            squareHolder.addSquare(square, col, row);
        }
    }

    public void addEyeball(int col, int row, Direction dir) {
        setCurrentDirection(dir);
        if(col > squareHolder.levelHeight || row > squareHolder.levelWidth || col < 0 || row < 0){
            throw new IllegalArgumentException();
        } else {
            eyeball = new Eyeball(col, row, dir);
            eyeball.setSquare(squareHolder.getSquare(col, row));
        }
    }

    public Color getColorAt(int col, int row) {
        return squareHolder.getSquare(col, row).getColor();
    }

    public Shape getShapeAt(int col, int row) {
        return squareHolder.getSquare(col, row).getShape();
    }

    public int getLevelWidth() { return squareHolder.levelWidth; }

    public int getLevelHeight() { return squareHolder.levelHeight; }

    public void removeGoal() {
        // TODO
    }

    public int getLevelCount() {
        return allMyLevels.size();
    }

    public int getGoalCount() {
        return allMyGoals.size();
    }

    public int getGoalRow() {
        return goalRow;
    }

    public int getGoalCol() {
        return goalCol;
    }
    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public void setGoalRow(int goalRow) {
        this.goalRow = goalRow;
    }

    public void setGoalCol(int goalCol) {
        this.goalCol = goalCol;
    }

    public void setCurrentDirection(Direction direction){
        this.currentDirection = direction;
    }


    public String toString() {
        String result = "";
        for (ILevelHolder level : this.allMyLevels) {
            result += level + "\n";
        }
        return result;
    }

    public void setLevel(int levelSize) {
        if(levelSize > allMyLevels.size()) {
            throw new IllegalArgumentException();
        }

    }

    public boolean hasGoalAt(int targetRow, int targetCol) {
        addGoal(targetRow, targetCol);
        if(goalRow == targetRow && goalCol == targetCol) {
            return true;
        }
        return false;
    }

    public int getCompletedGoalCount() {
        // TODO Auto-generated method stub
        return 0;
    }


    public int getEyeballRow() {
        return eyeball.getEyeballRow();
    }

    public int getEyeballColumn() {
        return eyeball.getEyeballColumn();
    }

    public Direction getEyeballDirection() {
        return eyeball.getEyeballDirection();
    }

    public boolean canMoveTo(int col, int row) {
//        TODO
        if(col > squareHolder.levelHeight || row > squareHolder.levelWidth || col < 0 || row < 0){
            throw new IllegalArgumentException();
        } else {
            if (getColorAt(col, row) == eyeball.getSquare().getColor() || getShapeAt(col, row) == eyeball.getSquare().getShape()){
                message = Message.OK;
                return true;
            }
        }
        message = Message.DIFFERENT_SHAPE_OR_COLOR;
        return false;
    }

    public Message MessageIfMovingTo(int col, int row) {
//        ToDO
        canMoveTo(col,row);
        return message;

    }

    public boolean isDirectionOK(int col, int row) {
        //TODO
        Direction currDir = eyeball.getEyeballDirection();

        int deltaX = row - eyeball.getEyeballColumn();
        int deltaY = col - eyeball.getEyeballRow();
        // relative to North
        Direction newDir = null;
        if(deltaX == 0 && deltaY < 0){
            newDir = Direction.UP;
        } else if(deltaX < 0 && deltaY == 0) {
            newDir = Direction.LEFT;
        } else if( deltaX == 0 && deltaY > 0) {
            message = Message.BACKWARDS_MOVE;
            newDir = Direction.DOWN;
        } else if(deltaX > 0 && deltaY == 0) {
            newDir = Direction.RIGHT;
        }

        //Calculate to convert to Direction
        if (newDir == null)
            return false;
        else {
            int value =  newDir.getValue() - currDir.getValue();
            if(Math.abs(value) == 2){
                message = Message.BACKWARDS_MOVE;
                return false;
            }
            int index = Math.floorMod(value, 4); // To get positive remainder
            index = (index + currDir.getValue()) %4;
            System.out.println(index);
            eyeball.setDirection(Direction.values()[index]);
            return true;
        }
    }
    public Message checkDirectionMessage(int col, int row) {
        isDirectionOK(col ,row);
        return message;
    }

    public boolean hasBlankFreePathTo(int col, int row) {
        //TODO
        int deltaX = row - eyeball.getEyeballColumn();
        int deltaY = col - eyeball.getEyeballRow();

        if (deltaY == 0) {

        } else if (deltaX == 0) {
            for (int y=0; y< Math.abs(deltaY); y++) {
                Square square = squareHolder.getSquare(y, col);
                if (square instanceof BlankSquare) {
                    message = Message.MOVING_OVER_BLANK;
                    return false;
                }
            }
        }

        return true;
    }

    public Message checkMessageForBlankOnPathTo(int col, int row) {
        hasBlankFreePathTo(col ,row);
        return message;
    }

    public void moveTo(int col, int row) {
        //TODO
        //MessageIfMovingTo(col,row);
        isDirectionOK(col, row);
        eyeball.setEyeballRow(col);
        eyeball.setEyeballCol(row);


    }
}
