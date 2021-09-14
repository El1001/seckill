package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.DetailVo;
import com.example.seckill.vo.GoodsVo;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 商品列表
     *
     * @param request
     * @param response
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/toList", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, User user) {
//        这里 使用userArgumentResolver 来 优化登录问题
//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
//        User user = userService.getByUserTicket(ticket,request,response);
//        if (null == user) {
//            return "login";
//        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //  从redis 中获得页面
        String html = (String) valueOperations.get("goodsList"); // 不能用string。value of emm

        if (!StringUtils.isEmpty(html)) {
            return html;
        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());

        // return "goodsList";
        // 为空则渲染 存入 redis 并返回

        WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goodsList", webContext);
        if (!StringUtils.isEmpty(html)) {
            valueOperations.set("goodsList", html, 60, TimeUnit.SECONDS);
        }
        return html;
    }

    @GetMapping(value = "/toDetail/{goodsId}"/* 导致 无法 转化错误 原因 原先 使用手动渲染， 现在改成 本地, produces = "text/html;charset=utf-8"*/)
    @ResponseBody
    public RespBean toDetail(HttpServletRequest request, HttpServletResponse response,
                             Model model, User user, @PathVariable Long goodsId) {
        /*ValueOperations valueOperations = redisTemplate.opsForValue();
        String html = (String) valueOperations.get("goodsDetail:" + goodsId); // 不能用string。value of emm
        if (!StringUtils.isEmpty(html)) {
            return html;
        }


        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        model.addAttribute("goods", goodsVo);
*/

        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);

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

        DetailVo detailVo = new DetailVo();

        detailVo.setGoodsVo(goodsVo);
        detailVo.setUser(user);
        detailVo.setRemainSeconds(remainSeconds);
        detailVo.setSeckillStatus(seckillStatus);

        return RespBean.success(detailVo);
/*

        model.addAttribute("secKillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        // return "goodsDetail";
        WebContext context = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goodsDetail", context);
        if (!StringUtils.isEmpty(html)) {
            valueOperations.set("goodsDetail:" + goodsId, html, 60, TimeUnit.SECONDS);
        }
        return html;
*/

    }


}
