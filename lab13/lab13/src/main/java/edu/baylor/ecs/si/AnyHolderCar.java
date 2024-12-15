package edu.baylor.ecs.si;

import java.util.*;

public class AnyHolderCar {
    public List<AnyHolder<? extends Bicycle>> carHolders;

    public AnyHolderCar() {
        this.carHolders = new ArrayList<>(4);
    }

    public <T extends Bicycle> void accept(T bike) {
        carHolders.add(new AnyHolder<>(bike));
    }
}
