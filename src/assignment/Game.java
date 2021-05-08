package assignment;

import java.util.ArrayList;

public class Game  {
    private int goalRow;
    private int goalCol;

    private ArrayList<ILevelHolder> allMyLevels = new ArrayList<>();
    private ArrayList<IGoalHolder> allMyGoals = new ArrayList<>();
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

    public void addSquare(Square square, int x, int y){
        //TODO
        if(x > squareHolder.levelHeight || y > squareHolder.levelWidth || x < 0 || y < 0){
            throw new IllegalArgumentException();
        } else {
            squareHolder.addSquare(square, x, y);
        }
    }

    public void addEyeball(int x, int y, Direction dir) {
        setCurrentDirection(dir);
        if(x > squareHolder.levelHeight || y > squareHolder.levelWidth || x < 0 || y < 0){
            throw new IllegalArgumentException();
        } else {
            eyeball = new Eyeball(x, y, dir);
            eyeball.setSquare(squareHolder.getSquare(x, y));
        }
    }

    public Color getColorAt(int x, int y) {
        return squareHolder.getSquare(x, y).getColor();
    }

    public Shape getShapeAt(int x, int y) {
        return squareHolder.getSquare(x, y).getShape();
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

    public boolean canMoveTo(int x, int y) {
//        TODO
        if(x > squareHolder.levelHeight || y > squareHolder.levelWidth || x < 0 || y < 0){
            throw new IllegalArgumentException();
        } else {
            if (getColorAt(x, y) == eyeball.getSquare().getColor() || getShapeAt(x, y) == eyeball.getSquare().getShape()){
                message = Message.OK;
                return true;
            }
        }
        message = Message.DIFFERENT_SHAPE_OR_COLOR;
        return false;
    }

    public Message MessageIfMovingTo(int x, int y) {
//        ToDO
        canMoveTo(x,y);
        return message;

    }

    public boolean isDirectionOK(int x, int y) {
        //TODO
        Direction currDir = eyeball.getEyeballDirection();

        int deltaX = y - eyeball.getEyeballColumn();
        int deltaY = x - eyeball.getEyeballRow();
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
            return true;
        }

    }


    public Message checkDirectionMessage(int x, int y) {
        isDirectionOK(x ,y);
        return message;
    }

    public boolean hasBlankFreePathTo(int x, int y) {
        //TODO
        int deltaX = y - eyeball.getEyeballColumn();
        int deltaY = x - eyeball.getEyeballRow();

        if (deltaY == 0) {

        } else if (deltaX == 0) {
            for (int row=0; row< Math.abs(deltaY); row++) {
                Square square = squareHolder.getSquare(row, x);
                if (square instanceof BlankSquare) {
                    message = Message.MOVING_OVER_BLANK;
                    return false;
                }
            }
        }

        return true;
    }

    public Message checkMessageForBlankOnPathTo(int x, int y) {
        hasBlankFreePathTo(x ,y);
        return message;
    }

    public void moveTo(int x, int y) {
        //TODO
        MessageIfMovingTo(x,y);
        eyeball.setEyeballRow(x);
        eyeball.setEyeballCol(y);

    }
}
