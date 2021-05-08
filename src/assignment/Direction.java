package assignment;

public enum Direction {
    UP(0), LEFT(1), DOWN(2), RIGHT(3);

    private final int id;
    Direction(int id) { this.id = id; }
    public int getValue() { return id; }
}