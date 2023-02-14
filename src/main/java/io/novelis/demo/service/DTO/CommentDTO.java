package io.novelis.demo.service.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {

    private long commentId;

    private String commentContent;

    private Date commentPublishingDate;

    private UserDTO user;

    private ArticleDTO article;
}
