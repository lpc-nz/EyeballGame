package assignment;

public class Level implements ILevelHolder{

    private int levelNumber;
    private int levelWidth;
    private int levelHeight;

    private int[][] allMyLevels;


    public Level( int levelHeight, int levelWidth) {
//		this.levelName = levelName;
        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth;
    }

    @Override
    public void addLevel(int height, int width) {
        allMyLevels = new int[width][height];
    }

    public int getLevelWidth() {
        return levelWidth;
    }

    public int getLevelHeight() {
        return levelHeight;
    }

    @Override
    public void setLevel(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    @Override
    public int getLevelCount() {
        return allMyLevels.length;
    }



//	public void setLevelName(String levelName) {
//		this.levelName = levelName;
//	}

    public void setLevelWidth(int levelWidth) {
        this.levelWidth = levelWidth;
    }

    public void setLevelHeight(int levelHeight) {
        this.levelHeight = levelHeight;
    }


    public String toString() {
        return String.format("%s (%s) @ $%s",  this.levelHeight, this.levelWidth);
    }

}
