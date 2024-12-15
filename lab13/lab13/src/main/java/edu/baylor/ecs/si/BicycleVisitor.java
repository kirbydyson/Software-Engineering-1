package edu.baylor.ecs.si;

public interface BicycleVisitor {
    void accept(Bicycle bike);
    void accept(MountainBike bike);
    void accept(RoadBike bike);
}
