package com.example.seckill;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试类
 *
 * @author admin
 * @date 2021年 09月07日 17:35:15
 */
public class Test {


    public static void main(String[] args) {
        IUserService userService;
        User user = new User();
        Long tel = new Long(Long.valueOf("13911111110"));
        user.setId(tel);
        System.out.println(user);


    }
}
