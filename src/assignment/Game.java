package assignment;

import java.util.ArrayList;

public class Game  {
    private int levelWidth;
    private int levelHeight;
    private int goalRow;
    private int goalCol;


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

    public void addSquare(BlankSquare square, int x, int y){

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










}
