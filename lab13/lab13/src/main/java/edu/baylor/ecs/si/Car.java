package edu.baylor.ecs.si;

import java.util.*;

public class Car implements BicycleVisitor{
    private List<BicycleHolder> carHolders = new ArrayList<>(4);

    @Override
    public void accept(Bicycle b) {
        carHolders.add(new BicycleHolder(b));
        System.out.println("Added Bicycle to car.");
    }

    @Override
    public void accept(MountainBike mb) {
        carHolders.add(new MountainBikeHolder(mb));
        System.out.println("Added MountainBike to car.");
    }

    @Override
    public void accept(RoadBike rb) {
        carHolders.add(new RoadBikeHolder(rb));
        System.out.println("Added RoadBike to car.");
    }
}
