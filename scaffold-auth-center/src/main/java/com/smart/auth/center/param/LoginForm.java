package com.smart.auth.center.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录form
 * @author guxiaobai
 * @since 2018-01-23
 */
@Data
public class LoginForm {



	@ApiModelProperty("用户名")
	@NotBlank(message = "用户名不能为空")
	private String username;


	@ApiModelProperty("密码")
	@NotBlank(message="密码不能为空")
	private String password;

}
