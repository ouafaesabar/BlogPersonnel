package io.novelis.demo.dao;

import io.novelis.demo.domain.User;

import java.util.Set;

public interface UserDao {
    void save();

    void update();

    Set<User> findAll();

    User findById(Long id);
}
