package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void updateUser(User user);
   void removeUser(int id);
   User getUserById(int id);
   public List<User> userList();




}
