package io.novelis.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column
    private String commentContent;

    @Column
    private Date commentPublishingDate;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    @JsonIgnore
    private Article article;


}
