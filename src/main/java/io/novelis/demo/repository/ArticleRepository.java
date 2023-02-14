package io.novelis.demo.repository;

import io.novelis.demo.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.articleTitle LIKE %?1% or a.articleAuthor LIKE %?1% or a.articlePublishingDate LIKE %?1%")
    List<Article> searchByKeyword(String keyword);

    Page<Article> findAll(Pageable pageable);
}
