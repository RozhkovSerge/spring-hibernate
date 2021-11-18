package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> userList();
}
