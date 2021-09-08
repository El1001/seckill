package com.example.seckill.service;

import com.example.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
public interface IUserService extends IService<User> {
    /**
     * 登录跳转
     * @param request
     * @param response
     * @param loginVo
     * @return
     */

    RespBean login(HttpServletRequest request, HttpServletResponse response,LoginVo loginVo);

    /**
     * 根据cookie 获得用户
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    public User getByUserTicket(String userTicket, HttpServletRequest request,
                                HttpServletResponse response);

}
