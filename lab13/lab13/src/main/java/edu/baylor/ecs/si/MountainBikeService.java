package edu.baylor.ecs.si;

public class MountainBikeService extends BasicService{
    @Override
    public void accept(Bicycle bike) {
        if(bike instanceof MountainBike){
            System.out.println("fixing MountainBike");
        } else{
            super.accept(bike);
        }
    }
}
