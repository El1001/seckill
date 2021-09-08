package com.example.seckill.vo;

import com.example.seckill.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品返回对象
 *
 * @author admin
 * @date 2021年 09月08日 17:26:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    //大数的精确计算
    private BigDecimal seckillPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;
}
