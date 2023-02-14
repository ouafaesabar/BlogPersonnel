package io.novelis.demo.service.impl;

import io.novelis.demo.domain.Comment;
import io.novelis.demo.exception.DataNotFoundException;
import io.novelis.demo.repository.CommentRepository;
import io.novelis.demo.service.CommentService;
import io.novelis.demo.service.DTO.CommentDTO;
import io.novelis.demo.service.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;




    @Override
    public CommentDTO saveComment(CommentDTO commentDTO) {
        Comment comment = commentRepository.save(commentMapper.commentDTOToComment(commentDTO));
        return commentMapper.commentToCommentDTO(comment);
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDTO) {
        Comment comment = commentRepository.save(commentMapper.commentDTOToComment(commentDTO));
        return commentMapper.commentToCommentDTO(comment);
    }

    @Override
    public List<CommentDTO> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(comment -> commentMapper.commentToCommentDTO(comment))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO findOneById(long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Comment"));
        return commentMapper.commentToCommentDTO(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}
