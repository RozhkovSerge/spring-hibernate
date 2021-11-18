package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }

   @Transactional
   @Override
   public void removeUser(int id) {
      userDao.removeUser(id);
   }

   @Transactional
   @Override
   public User getUserById(int id) {
      return userDao.getUserById(id);
   }

   @Transactional
   @Override
   public List<User> userList() {
      return null;
   }
}
