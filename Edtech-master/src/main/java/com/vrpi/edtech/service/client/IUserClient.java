package com.vrpi.edtech.service.client;

import com.vrpi.edtech.dto.UserDto;
import com.vrpi.edtech.dto.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface IUserClient {

    List<UserDto> getAllUser() ;

}