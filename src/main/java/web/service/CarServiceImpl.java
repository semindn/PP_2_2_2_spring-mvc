package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getCarList() {
        Car car1 = new Car("model1", "color1", 101);
        Car car2 = new Car("model2", "color2", 102);
        Car car3 = new Car("model3", "color3", 103);
        Car car4 = new Car("model4", "color4", 104);
        Car car5 = new Car("model5", "color5", 105);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        return carList;
    }
}
