package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;

public interface CarService {
    Car get(Long id);
    void delete(Car car);
}
