package io.novelis.demo.service;

import io.novelis.demo.domain.User;
import io.novelis.demo.service.DTO.CommentDTO;
import io.novelis.demo.service.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> findAll();

    Optional<UserDTO> findOneById(long id);

    CommentDTO addComment(CommentDTO commentDTO);

}
