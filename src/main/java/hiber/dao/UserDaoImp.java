package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private EntityManager entityManager;

   @PersistenceContext
   public void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   @Override
   public void add(User user) {
      entityManager.merge(user);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public void removeUser(int id) {
      entityManager.remove(entityManager.find(User.class, id));
   }

   @Override
   public User getUserById(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public List<User> userList() {
      return entityManager.createQuery("SELECT users from User users").getResultList();
   }

}
