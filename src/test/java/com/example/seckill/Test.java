package com.example.seckill;

import com.sun.deploy.net.MessageHeader;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 测试
 *
 * @author admin
 * @date 2021年 09月08日 16:23:54
 */
public class Test {
    static int index, len;
    static String str = "babad";

    public static void main(String[] args) {
        int pushed[] = new int[] {1,2,3,4,5};
        int popeed[] = new int[] {4,5,3,2,1};
        System.out.println(Arrays.stream(exchange(pushed)).toArray().toString());

    }
    public static int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1; //初始化i指向0，j指向n-1
        while (i < j) {    //当奇偶指针相遇时表示调整完成
            if (nums[i] % 2 != 0) i++;    //奇数指针指向位置是奇数，则指针右移
            else swap(nums, i, j--);     //奇数指针指向位置是偶数，则将其交换到偶数的位置j
        }
        return nums;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
