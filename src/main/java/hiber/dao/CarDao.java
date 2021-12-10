package hiber.dao;

import hiber.model.Car;

public interface CarDao {
    Car get(Long id);

    void delete(Car car);
}
