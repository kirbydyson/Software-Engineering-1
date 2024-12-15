package edu.baylor.ecs.si;

public enum BicycleColor {
    RED(1),
    BLUE(2),
    GREEN(3),
    YELLOW(4),
    BLACK(5),
    WHITE(6);

    private final int id;

    BicycleColor(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
