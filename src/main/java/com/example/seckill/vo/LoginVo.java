package com.example.seckill.vo;

import com.example.seckill.validator.IsMobile;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
/**
 * 登录数据
 *
 * @author admin
 * @date 2021年 09月07日 12:22:46
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
