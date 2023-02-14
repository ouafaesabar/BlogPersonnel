package io.novelis.demo.service.mapper;

import io.novelis.demo.domain.Comment;
import io.novelis.demo.service.DTO.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "article" , source = "article" , ignore = true)
    CommentDTO commentToCommentDTO (Comment comment);

    Comment  commentDTOToComment (CommentDTO commentDTO);
}
