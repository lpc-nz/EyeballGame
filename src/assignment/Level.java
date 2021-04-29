package assignment;

public class Level implements ILevelHolder{

    protected int levelNumber;
    protected int levelWidth;
    protected int levelHeight;

    public Level( int levelHeight, int levelWidth) {
//		this.levelName = levelName;

        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth;
    }

    @Override
    public void addLevel(int height, int width) {

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
        return 0;
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
