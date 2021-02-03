package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
        em.flush();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void editUser(User userUpdate, int id) {
        Query query = em.createQuery("update User u set u.firstName = :firstName, u.lastName = :lastName, u.age = :age where u.id = :id")
                .setParameter("id", id)
                .setParameter("firstName", userUpdate.getFirstName())
                .setParameter("lastName", userUpdate.getLastName())
                .setParameter("age", userUpdate.getAge());
        query.executeUpdate();
    }

    @Override
    public void deleteUser(int id) {
        em.remove(getUser(id));
    }
}
