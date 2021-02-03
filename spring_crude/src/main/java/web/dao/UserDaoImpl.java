package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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






}
