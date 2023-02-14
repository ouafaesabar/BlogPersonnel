package io.novelis.demo.service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ArticleDTO {

    private long articleId;

    private String articleTitle;

    private String articleContent;

    private String articleAuthor;

    private Date articlePublishingDate;

    private List<CommentDTO> comments;

}
