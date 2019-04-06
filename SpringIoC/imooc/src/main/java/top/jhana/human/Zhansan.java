package top.jhana.human;

import top.jhana.car.Car;

public class Zhansan extends AbstractHumanWithCar {

    public Zhansan(Car car) {
        super(car);
    }

    @Override
    public void gohome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
