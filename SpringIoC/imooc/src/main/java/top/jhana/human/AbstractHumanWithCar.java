package top.jhana.human;

import top.jhana.car.Car;

public abstract class AbstractHumanWithCar implements Human {

    protected Car car;

    public AbstractHumanWithCar(Car car) {
        this.car = car;
    }

    public abstract void gohome();
}
