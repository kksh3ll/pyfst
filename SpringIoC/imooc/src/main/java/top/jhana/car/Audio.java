package top.jhana.car;

public class Audio implements Car {
    @Override
    public void start() {
        System.out.println("start...");
    }

    @Override
    public void stop() {
        System.out.println("stop...");
    }

    @Override
    public void turnLeft() {
        System.out.println("car turn left...");
    }

    @Override
    public void turnRight() {
        System.out.println("car turn right...");
    }
}
