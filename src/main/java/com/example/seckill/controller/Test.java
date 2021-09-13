package com.example.seckill.controller;

import com.example.seckill.pojo.Goods;
import com.example.seckill.pojo.SeckillGoods;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.ISeckillGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.util.MD5Util;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试类
 *
 * @author admin
 * @date 2021年 09月07日 17:35:15
 */
@RestController
public class Test {
    @Autowired
    IUserService userService;
    @Autowired
    IGoodsService goodsService;
    @Autowired
    ISeckillGoodsService seckillGoodsService;

    @RequestMapping("/insert")
    public RespBean regular(User userInput) {

        User user = new User();
        Long tel = new Long(Long.valueOf("18811111111"));
        user.setId(tel);
        user.setSalt("1a2b3c4d");
        user.setNickname("王二");
        String inputpassword = "123456";
        String password = MD5Util.inputPassToDBPass(inputpassword, user.getSalt());
        user.setPassword(password);
        userService.save(user);
        System.out.println(user);
        return RespBean.success("ok");
    }

    @GetMapping("/insertGoods")
    public RespBean insertGoods() {
        Goods goods = new Goods();
        goods.setId(1);
        goods.setGoodsImg("null");
        goods.setGoodsName("商品名称");
        goods.setGoodsDetail("商品详情");
        goods.setGoodsPrice(BigDecimal.valueOf(5000.00));
        goods.setGoodsStock(100);
        goods.setGoodsTitle("商品标题");
        goodsService.save(goods);
        return RespBean.success("OK");
    }

    @GetMapping("/insertSeckillGoods")
    public RespBean insertSeckillGoods() {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setGoodsId(1);
        seckillGoods.setId(1);
        seckillGoods.setSeckillPrice(BigDecimal.valueOf(0.001));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = sf.parse("2030-12-12 12:30:00");
            endDate = sf.parse("2000-01-01 12:30:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        seckillGoods.setStartDate(startDate);
        seckillGoods.setEndDate(endDate);
        seckillGoods.setStockCount(100);
        seckillGoodsService.save(seckillGoods);
        return RespBean.success("OK");
    }
}
