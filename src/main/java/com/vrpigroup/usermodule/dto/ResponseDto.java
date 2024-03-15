package com.vrpigroup.usermodule.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "ResponseDto", description = "Data Transfer Object for Response")
public class ResponseDto {
    
    @Schema(name = "userId", description = "User ID", example = "123456789", required = true)
    private String userId;

    @Schema(name = "statusCode", description = "Status Code", example = "200", required = true)
    private String statusCode;

    @Schema(name = "statusMessage", description = "Status Message", example = "User Created Successfully", required = true)
    private String statusMessage;
}
