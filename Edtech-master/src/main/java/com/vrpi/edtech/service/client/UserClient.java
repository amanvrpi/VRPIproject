package com.vrpi.edtech.service.client;

import com.vrpi.edtech.dto.UserDto;
import com.vrpi.edtech.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserClient implements IUserClient{
@Autowired
private UserFeignClient userFeignClient;
    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> users = userFeignClient.getAllUser();
        List<UserDto> userDtos = new ArrayList<>();

        for (UserEntity user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setEmail(user.getEmail());
            userDto.setPhoneNumber(user.getPhoneNumber());

            userDtos.add(userDto);
        }

        return userDtos;
    }
}
