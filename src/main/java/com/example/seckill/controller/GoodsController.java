package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IUserService userService;
    @Autowired
    IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toLogin(Model model, User user) {
//        这里 使用userArgumentResolver 来 优化登录问题
//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
//        User user = userService.getByUserTicket(ticket,request,response);
//        if (null == user) {
//            return "login";
//        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    @GetMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        model.addAttribute("goods", goodsVo);

        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            nowDate = sf.parse(sf.format(nowDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //  秒杀状态
        int seckillStatus = 0;
        // 剩余开始时间
        long remainSeconds = 0;
        // 秒杀未开始
        if (nowDate.before(startDate)) {
            remainSeconds = (startDate.getTime() - nowDate.getTime()) / 1000;
        }
        // 秒杀 已结束
        else if (nowDate.after(endDate)) {
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("secKillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        // 秒杀中
        return "goodsDetail";
    }


}
