package io.novelis.demo.service.mapper;


import io.novelis.demo.domain.User;
import io.novelis.demo.service.DTO.UserDTO;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO (User user);


    User  userDTOToUser (UserDTO userDTO);
}
