package io.novelis.demo.dao;

import io.novelis.demo.domain.Article;

import java.util.List;
import java.util.Set;

public interface ArticleDao  {

    void save();

    void update();

    void delete();

    List<Article> findAll();

    Article findById(Long id);
}
