package com.example.seckill.service.impl;

import com.example.seckill.pojo.Order;
import com.example.seckill.mapper.OrderMapper;
import com.example.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
