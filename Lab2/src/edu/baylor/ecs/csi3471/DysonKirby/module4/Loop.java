package edu.baylor.ecs.csi3471.DysonKirby.module4;

public class Loop {
    public void loop(int count){
        count--;
        if(count >= 0){
            System.out.println(count + " loops left");
            loop(count);
        }
    }

    public static void main(String[] args) {
        Loop loop = new Loop();
        loop.loop(10);
    }
}