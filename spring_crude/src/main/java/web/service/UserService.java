package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<User> getAllUsers();
}
