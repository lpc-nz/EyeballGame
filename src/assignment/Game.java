package assignment;

import java.util.ArrayList;

public class Game  {
    private int levelWidth;
    private int levelHeight;
    private int goalRow;
    private int goalCol;
    private int blankSquareX;
    private int blankSquareY;
    private int squareX;
    private int squareY;

    private ArrayList<ILevelHolder> allMyLevels = new ArrayList<>();
    private ArrayList<IGoalHolder> allMyGoals = new ArrayList<>();
    private SquareHolder squareHolder;

    public void addLevel( int newLevelHeight, int newLevelWidth) {
        ILevelHolder newLevel = new Level(newLevelHeight , newLevelWidth);
        allMyLevels.add(newLevel);
        this.levelWidth = newLevelWidth;
        this.levelHeight = newLevelHeight;
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
        if(x > this.levelHeight || y > this.levelWidth || x < 0 || y < 0){
            throw new IllegalArgumentException();
        } else {
            squareHolder.addSquare(square, x, y);
        }
        //asd



    }

//    public void addSquare(BlankSquare blankSquare, int x, int y){
//            if(x > this.levelHeight || y > this.levelWidth || x < 0 || y < 0){
//                throw new IllegalArgumentException();
//            }
//            BlankSquare newSquare = new BlankSquare();
//            newSquare.setNewColor(Color.BLANK);
//            newSquare.setNewShape(Shape.BLANK);
//
//            this.blankSquareX = x;
//            this.blankSquareY = y;
//    }

    public void addEyeball(int x, int y, Direction up) {
    }

//    public Color getColorAt(int x, int y) {
//        if (x == this.blankSquareX && y == this.blankSquareY){
//            return Color.BLANK;
//        }else if (x == this.squareX && y == this.squareY){
//            return Color.PURPLE;
//        }
//        return Color.BLANK;
//
//    }

    public Color getColorAt(int x, int y) {
        return squareHolder.getSquare(x, y).getColor();
    }

    public Shape getShapeAt(int x, int y) {
        return squareHolder.getSquare(x, y).getShape();
    }

    public void removeGoal() {
        // TODO
    }

    public int getLevelCount() {
        return allMyLevels.size();
    }

    public int getGoalCount() {
        return allMyGoals.size();
    }


    public int getLevelWidth() {
        return levelWidth;
    }

    public int getGoalRow() {
        return goalRow;
    }

    public int getGoalCol() {
        return goalCol;
    }

    public int getSquareX() {
        return squareX;
    }

    public int getSquareY() {
        return squareY;
    }

    public int getBlankSquareX() {
        return blankSquareX;
    }

    public int getBlankSquareY() {
        return blankSquareY;
    }

    public void setBlankSquareX(int blankSquareX) {
        this.blankSquareX = blankSquareX;
    }

    public void setBlankSquareY(int blankSquareY) {
        this.blankSquareY = blankSquareY;
    }

    public void setLevelWidth(int levelWidth) {
        this.levelWidth = levelWidth;
    }

    public void setLevelHeight(int levelHeight) {
        this.levelHeight = levelHeight;
    }

    public void setGoalRow(int goalRow) {
        this.goalRow = goalRow;
    }

    public void setGoalCol(int goalCol) {
        this.goalCol = goalCol;
    }

    public void setSquareX(int squareX) {
        this.squareX = squareX;
    }

    public void setSquareY(int squareY) {
        this.squareY = squareY;
    }

    public int getLevelHeight() {
        return levelHeight;
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
        return 0;
    }

    public int getEyeballColumn() {
        return 0;
    }

    public Direction getEyeballDirection() {
        return Direction.DOWN;
    }

    public boolean canMoveTo(int x, int y) {
//        TODO
        return false;
    }

    public Message MessageIfMovingTo(int i, int i1) {
//        ToDO
        return Message.OK;
    }

    public boolean isDirectionOK(int i, int i1) {

        //TODO
        return false;
    }

    public Message checkDirectionMessage(int i, int i1) {
        //TODO
        return Message.OK;
    }

    public boolean hasBlankFreePathTo(int i, int i1) {
        //TODO
        return false;
    }

    public Message checkMessageForBlankOnPathTo(int i, int i1) {
        //TODO
        return Message.OK;
    }

    public void moveTo(int i, int i1) {
        //TODO
    }
}
