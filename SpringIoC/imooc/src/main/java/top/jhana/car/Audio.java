package top.jhana.car;

public class Audio implements Car {
    public void start() {
        System.out.println("start...");
    }

    public void stop() {
        System.out.println("stop...");
    }

    public void turnLeft() {
        System.out.println("car turn left...");
    }

    public void turnRight() {
        System.out.println("car turn right...");
    }
}
