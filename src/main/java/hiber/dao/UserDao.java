package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    User get(Long id);

    User getByCar(String model, int series);

    void add(User user);

    List<User> listUsers();

    void delete(User user);


}
