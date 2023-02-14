package io.novelis.demo.service;

import io.novelis.demo.domain.Comment;
import io.novelis.demo.service.DTO.CommentDTO;

import java.util.List;
import java.util.Optional;

public interface CommentService {


    List<CommentDTO> findAll();

    CommentDTO saveComment(CommentDTO commentDTO);


    CommentDTO updateComment(CommentDTO commentDTO);

    CommentDTO findOneById(long id);

    void deleteComment(long id);



}
