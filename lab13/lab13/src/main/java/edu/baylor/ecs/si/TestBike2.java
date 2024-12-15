package edu.baylor.ecs.si;

public class TestBike2 {
    public static void main(String[] args) {
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1, BicycleColor.RED);
        bike02 = new MountainBike(20, 10, 5, "Dual", BicycleColor.BLUE);
        bike03 = new RoadBike(40, 20, 8, 23, BicycleColor.BLACK);

        AnyHolderCar car = new AnyHolderCar();
        car.accept(bike01);
        car.accept(bike02);
        car.accept(bike03);

        for (AnyHolder<? extends Bicycle> holder : car.carHolders) {
            Bicycle b = holder.bike;
            b.printDescription();
        }
    }
}
