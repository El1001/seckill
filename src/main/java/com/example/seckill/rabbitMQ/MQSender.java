package com.example.seckill.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送MQ
 *
 * @author admin
 * @date 2021年 09月15日 12:00:23
 */
@Service
@Slf4j
public class MQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSeckillMessage(String message) {
        log.info("发送消息 :" + message);
        rabbitTemplate.convertAndSend("seckillExchange", "seckill.msg", message);
    }
}
