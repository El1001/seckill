package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * Jmeter 测试接口
     *
     * @param user
     * @return
     */
    @GetMapping("userInfo")
    @ResponseBody
    public RespBean info(User user) {
        return RespBean.success(user);
    }
}
