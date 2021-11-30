package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {

    SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car get(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public void delete(Car car) {
        sessionFactory.getCurrentSession().delete(car);
    }
}
