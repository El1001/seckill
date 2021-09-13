package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * 获取商品列表
     *
     * @return
     */
    List<GoodsVo> findGoodsVo();

    /**
     * 根据Id 获得商品详情
     *
     * @param goodsId
     * @return
     */
    GoodsVo getGoodsVoById(Long goodsId);

}
