package edu.baylor.ecs.si;

public class RoadBike extends Bicycle{
    private int tireWidth;
    public BicycleColor color;

    public RoadBike(int startCadence, int startSpeed, int startGear, int tireWidth, BicycleColor color) {
        super(startCadence, startSpeed, startGear, color);
        this.setTireWidth(tireWidth);
    }

    public int getTireWidth() {
        return this.tireWidth;
    }

    public void setTireWidth(int tireWidth) {
        this.tireWidth = tireWidth;
    }

    @Override
    public void printDescription(){
        System.out.println("\nRoadBike is " + "in gear " + this.gear
                + " with a cadence of " + this.cadence +
                " and travelling at a speed of " + this.speed +
                " with a tire width of " + this.tireWidth +
                " and a color of " + this.getColor() + ".");
    }

    @Override
    public void visit(BasicService service) {
        if (service instanceof RoadBikeService) {
            service.accept(this);
        } else {
            super.visit(service);
        }
    }
}
