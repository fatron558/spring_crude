package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> getAllUsers();

    User getUser(int id);

    void editUser(User user, int id);

    void deleteUser(int id);
}
