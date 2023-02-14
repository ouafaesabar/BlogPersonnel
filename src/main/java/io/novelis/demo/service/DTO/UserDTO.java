package io.novelis.demo.service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UserDTO {

    private long userId;

    private String userName;

    private String userPassword;

}
