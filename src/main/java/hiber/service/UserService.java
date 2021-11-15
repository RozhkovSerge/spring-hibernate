package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    User get(Long id);
    void add(User user);
    List<User> listUsers();
    void delete(User user);
}
