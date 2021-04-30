package assignment;

import java.util.ArrayList;

public class Game  {
    private int levelWidth;
    private int levelHeight;
    private int goalRow;
    private int goalCol;
    private int colorAtX;
    private int colorAtY;


    private ArrayList<Level> allMyLevels = new ArrayList<Level>();
    private ArrayList<GoalLocation> allMyGoals = new ArrayList<GoalLocation>();
    private ArrayList<Square> allMySquares = new ArrayList<Square>();

    public void addLevel( int newLevelHeight, int newLevelWidth) {
        Level newLevel = new Level(newLevelHeight , newLevelWidth);
        allMyLevels.add(newLevel);
        this.levelWidth = newLevelWidth;
        this.levelHeight = newLevelHeight;

    }

    public void addGoal(int targetRow, int targetCol) {
        GoalLocation newGoal = new GoalLocation(targetRow, targetCol);
        allMyGoals.add(newGoal);
        this.goalRow = targetRow;
        this.goalCol = targetCol;

    }

    public void addSquare(ISquareHolder newSquare, int x, int y){
        try {
            throw new IllegalArgumentException("Square can not blank");
        } catch (Exception e) {
            throw new IllegalArgumentException("");
        }
    }

    public void addEyeball(int x, int y, Direction up) {
    }

    public Color getColorAt(int x, int y) {
        this.colorAtX = x;
        this.colorAtY = y;
        return Color.RED;
    }

    public Shape getShapeAt(int i, int i1) {
        return Shape.BLANK;
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


    public int getLevelHeight() {
        return levelHeight;
    }


    public String toString() {
        String result = "";
        for (Level level : this.allMyLevels) {
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
