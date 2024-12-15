package edu.baylor.ecs.si;

public class AnyHolder<T extends Bicycle>{
    protected T bike;

    public AnyHolder(T bike){ this.bike = bike; }
}
