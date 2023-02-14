package io.novelis.demo.service;

import io.novelis.demo.domain.Article;
import io.novelis.demo.service.DTO.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface ArticleService {
    ArticleDTO saveArticle(ArticleDTO articleDTO);

    ArticleDTO updateUser(ArticleDTO articleDTO);

    void deleteArticle(Long id);

    List<ArticleDTO> findAll(Integer pageNo, Integer pageSize);

    ArticleDTO findOneById(long id);

    List<ArticleDTO> searchByKeyword(String keyword);
}
