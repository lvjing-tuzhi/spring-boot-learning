package com.tuzhi.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: SpringBoot-Swagger
 * @description:
 * @author: 兔子
 * @create: 2021-12-31 09:50
 **/

@ApiModel("用户")
@Data
public class User {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
