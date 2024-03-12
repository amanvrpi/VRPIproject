package com.vrpi.edtech.service.client;

import com.vrpi.edtech.dto.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "usermodule")
public interface UserFeignClient {
    @GetMapping("/vrpi-user/all")
    public List<UserEntity> getAllUser();

}
