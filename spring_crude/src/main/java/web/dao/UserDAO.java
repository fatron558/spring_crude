package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@Component
public class UserDAO {
    private static int PEOPLE_COUNT; //в дальнейшем убрать
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++PEOPLE_COUNT, "Tom"));
        users.add(new User(++PEOPLE_COUNT, "Bob"));
        users.add(new User(++PEOPLE_COUNT, "Mike"));
        users.add(new User(++PEOPLE_COUNT, "Katy"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

}
