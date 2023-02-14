package io.novelis.demo.service.impl;

import io.novelis.demo.repository.UserRepository;
import io.novelis.demo.service.CommentService;
import io.novelis.demo.service.DTO.CommentDTO;
import io.novelis.demo.service.DTO.UserDTO;
import io.novelis.demo.service.UserService;
import io.novelis.demo.service.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private CommentService commentService;



    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.userToUserDTO(user))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<UserDTO> findOneById(long id) {
       return Optional.of(userMapper.userToUserDTO((userRepository.findById(id)).get()));
    }

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        return commentService.saveComment(commentDTO);
    }


}
