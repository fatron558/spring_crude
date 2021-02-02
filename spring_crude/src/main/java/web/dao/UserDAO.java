package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
@Component
public class UserDAO {
    private static int PEOPLE_COUNT; //в дальнейшем убрать
    private List<User> users;



    @Autowired
    private EntityManagerFactory emf;

    public List<User> index() {
        List<User> users = emf.createEntityManager().createQuery("from User", User.class).getResultList();
        return users;
    }

    //public User show(int id) {
   //     return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    //}

}
