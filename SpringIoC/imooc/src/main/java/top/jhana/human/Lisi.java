package top.jhana.human;

import top.jhana.car.Car;

public class Lisi extends AbstractHumanWithCar {
    public Lisi(Car car) {
        super(car);
    }

    @Override
    public void gohome() {
        car.start();
        car.stop();
    }
}
