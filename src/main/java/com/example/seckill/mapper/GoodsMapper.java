package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 获得商品列表
     *
     * @return
     */
    List<GoodsVo> getGoodsVo();

    /**
     * 根据Id获得商品详情
     *
     * @param goodsId
     * @return
     */
    GoodsVo findGoodsVoById(Long goodsId);
}
