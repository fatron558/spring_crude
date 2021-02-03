package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    public void saveUser(User user);
    public List<User> getAllUsers();
}
