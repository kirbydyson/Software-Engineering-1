package edu.baylor.ecs.si;

public class RoadBikeService extends BasicService{
    @Override
    public void accept(Bicycle bike) {
        if(bike instanceof RoadBike){
            System.out.println("fixing RoadBike");
        } else{
            super.accept(bike);
        }
    }
}
