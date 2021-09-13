package com.example.seckill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试加锁
 *
 * @author admin
 * @date 2021年 09月09日 11:05:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVo {

    public Integer test1;

    public static class testMethod {
        public Integer test1 = 200;
        public synchronized static void getSynchronized(){
            System.out.println("test synchronized");
            Integer test3 = 300;
        }

    }
}
