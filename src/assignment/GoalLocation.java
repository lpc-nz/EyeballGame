package assignment;

public class GoalLocation implements IGoalHolder {
    private int goalRow;
    private int goalCol;


    // Structure
    public GoalLocation (int targetRow, int targetCol) {
        this.goalRow = targetRow;
        this.goalCol = targetCol;
    }

    @Override
    public void addGoal(int row, int column) {
        setGoalRow(row);
        setGoalCol(column);
    }

    @Override
    public int getGoalCount() {
        return 0;
    }

    @Override
    public boolean hasGoalAt(int targetRow, int targetColumn) {
        if(this.goalRow == targetRow && this.goalCol == targetColumn){
            return true;
        }
        return false;
    }

    @Override
    public int getCompletedGoalCount() {
        return 0;
    }

    public void setGoalRow (int targetRow) {
        this.goalRow = targetRow;
    }

    public void setGoalCol(int targetCol) {
        this.goalCol = targetCol;
    }

    public int getGoalRow() {
        return goalRow;
    }

    public int getGoalCol() {
        return goalCol;
    }


}
