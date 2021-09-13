package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.mapper.GoodsMapper;
import com.example.seckill.pojo.Goods;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获得商品列表
     *
     * @return
     */
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.getGoodsVo();
    }

    /**
     * 根据Id 获得商品详情
     *
     * @param goodsId
     * @return
     */
    @Override
    public GoodsVo getGoodsVoById(Long goodsId) {
        return goodsMapper.findGoodsVoById(goodsId);
    }
}
