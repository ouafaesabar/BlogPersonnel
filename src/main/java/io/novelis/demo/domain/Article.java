package io.novelis.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long articleId;

    @Column
    private String articleTitle;

    @Column
    private String articleContent;

    @Column
    private String articleAuthor;

    @Column
    private Date articlePublishingDate;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    List<Comment> comments;




}
