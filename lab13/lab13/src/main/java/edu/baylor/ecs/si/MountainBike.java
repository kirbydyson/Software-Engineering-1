package edu.baylor.ecs.si;

public class MountainBike extends Bicycle {
    private String suspension;
    public BicycleColor color;

    public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType, BicycleColor color) {
        super(startCadence, startSpeed, startGear, color);
        this.setSuspension(suspensionType);
    }

    public String getSuspension() {
        return this.suspension;
    }

    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }

    @Override
    public void printDescription(){
        System.out.println("\nMountainBike is " + "in gear " + this.gear
                + " with a cadence of " + this.cadence +
                " and travelling at a speed of " + this.speed +
                " with a " + this.suspension + " suspension" +
                " and a color of " + this.getColor() + ".");
    }

    @Override
    public void visit(BasicService service) {
        if (service instanceof MountainBikeService) {
            service.accept(this);
        } else {
            super.visit(service);
        }
    }
}
