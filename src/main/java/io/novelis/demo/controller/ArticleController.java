package io.novelis.demo.controller;


import io.novelis.demo.service.ArticleService;
import io.novelis.demo.service.DTO.ArticleDTO;
import io.novelis.demo.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;




    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDTO>> getArticles (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize
    ){
        List<ArticleDTO> result = articleService.findAll(pageNo,pageSize);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDTO> getArticle (@PathVariable long id){
        ArticleDTO result = articleService.findOneById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("articlesKeyword")
    public ResponseEntity<List<ArticleDTO>> getArticlesByKeyword (@RequestParam("keyword") String keyword){
        List<ArticleDTO> result =  articleService.searchByKeyword(keyword);
        return ResponseEntity.ok(result);
    }


    @PostMapping(value = "/article" , consumes = {"application/json"})
    public ResponseEntity<ArticleDTO> createArticle (@RequestBody ArticleDTO article){
        ArticleDTO result = articleService.saveArticle(article);
        return ResponseEntity.ok(result);

    }

    @PutMapping("/updateArticle")
    public ResponseEntity<ArticleDTO> updateArticle (@RequestBody ArticleDTO article){
        ArticleDTO result = articleService.updateUser(article);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteArticle/{id}")
    public void deleteArticle (@PathVariable long id){
        articleService.deleteArticle(id);
    }

}
