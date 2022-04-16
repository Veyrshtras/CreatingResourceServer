package com.example.resourceserverlesson8.dto;

import com.example.resourceserverlesson8.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String fullName;

    public static UserDto fromUser(User user){
        UserDto dto=new UserDto();
        dto.setFullName(user.getFullName());
        dto.setId(user.getId());
        return dto;
    }
}
