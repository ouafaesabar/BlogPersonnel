package io.novelis.demo.service.impl;

import io.novelis.demo.domain.Article;
import io.novelis.demo.exception.DataNotFoundException;
import io.novelis.demo.repository.ArticleRepository;
import io.novelis.demo.service.ArticleService;
import io.novelis.demo.service.DTO.ArticleDTO;
import io.novelis.demo.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        Article articleSaved = articleMapper.articleDTOToArticle(articleDTO);
        return articleMapper.articleToArticleDTO(articleRepository.save(articleSaved));
    }

    @Override
    public ArticleDTO updateUser(ArticleDTO articleDTO) {
        Article articleUpdated = articleMapper.articleDTOToArticle(articleDTO);
        return articleMapper.articleToArticleDTO(articleRepository.save(articleUpdated));
    }

    @Override
    public void deleteArticle(Long id) {
           articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleDTO> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Article> page = articleRepository.findAll(pageable);
        return   page.getContent()
                .stream()
                .map(article -> articleMapper.articleToArticleDTO(article))
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDTO findOneById(long id) throws DataNotFoundException{
        Article article = articleRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Article"));
        return articleMapper.articleToArticleDTO(article);
    }

    @Override
    public List<ArticleDTO> searchByKeyword(String keyword) {
        List<Article> articles;
        if(keyword != null){
            articles = articleRepository.searchByKeyword(keyword);
        }else{
            articles = articleRepository.findAll();
        }
        return   articles
                .stream()
                .map(article -> articleMapper.articleToArticleDTO(article))
                .collect(Collectors.toList());
    }


}
