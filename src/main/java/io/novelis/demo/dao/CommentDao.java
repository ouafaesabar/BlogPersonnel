package io.novelis.demo.dao;

import io.novelis.demo.domain.Comment;

import java.util.Set;

public interface CommentDao {
    void save();

    void update();

    void delete();

    Set<Comment> findAll();

    Comment findById(Long id);
}
