package io.novelis.demo.service.mapper;

import io.novelis.demo.domain.Article;
import io.novelis.demo.domain.User;
import io.novelis.demo.service.DTO.ArticleDTO;
import io.novelis.demo.service.DTO.UserDTO;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring" , uses = {CommentMapper.class})
public interface ArticleMapper {
    ArticleDTO articleToArticleDTO(Article article);

    Article articleDTOToArticle(ArticleDTO articleDTO);

}
