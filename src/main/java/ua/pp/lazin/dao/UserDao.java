package ua.pp.lazin.dao;

import ua.pp.lazin.entity.User;

public interface UserDao {
    public User findUserByLogin(String login);

    User update(User user);

    void persist(User user);
}
