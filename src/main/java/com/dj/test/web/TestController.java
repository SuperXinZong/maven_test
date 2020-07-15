package com.dj.test.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.test.base.ResultModel;
import com.dj.test.pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/test")// /test?userId=1
    public ResultModel test(Integer[] userIds) {
        return new ResultModel().success(userIds);
    }

    @RequestMapping("/test1")// /test?userId=1
    public ResultModel test1(User user) {

        // 同时返回 user 和 age
        int age = 1;
        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("age", age);
        return new ResultModel().success(result);
    }

    @RequestMapping("/getUser/{userId}") // 必传 有别于get /test/1
    public ResultModel getUser(@PathVariable Integer userId) {
        return new ResultModel().success(userId);
    }

    public static void main(String[] args) {
        // JSON数组格式的字符串
        String str = "[{\"id\":\"zs\",\"hobby\":[\"篮球\",\"足球\"]},{\"id\":\"ls\",\"hobby\":[\"篮球\",\"排球\"]}]";
        // 字符串->可操作的JSON对象/JSON数组
        JSONArray jsonArray = JSON.parseArray(str);// List
        System.out.println(jsonArray.getJSONObject(1).getJSONArray("hobby").get(1));
        // JSON对象格式的字符串
        String str1 = "{\"id\":\"zs\",\"hobby\":[\"篮球\",\"足球\"], \"age\":27}";
        JSONObject obj = JSON.parseObject(str1);
        System.out.println(obj.get("id"));
        System.out.println(obj.getInteger("age"));
        System.out.println(obj.getJSONArray("hobby").get(1));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (Integer num: list) {

        }
    }

}
