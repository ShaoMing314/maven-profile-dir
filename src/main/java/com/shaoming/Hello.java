package com.shaoming;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.io.resource.ResourceUtil;

import java.io.IOException;
import java.util.Properties;

public class Hello {
    public static void main(String[] args) throws Exception {

        // 测试 hello world
        System.out.println("Hello.main");

        // 测试获取resources目录下 properties 文件内容
        String str = ResourceUtil.readUtf8Str("jdbc.properties");
        System.out.println(str);
        System.out.println("===================>");
        String str1 = ResourceUtil.readUtf8Str("my.properties");
        System.out.println(str1);

        ClassPathResource resource = new ClassPathResource("my.properties");
        Properties properties = new Properties();
        properties.load(resource.getStream());
        System.out.println(properties);

        // 测试获取对应环境
        ClassPathResource profile = new ClassPathResource("jdbc.properties");
        Properties profileproperties = new Properties();
        profileproperties.load(profile.getStream());
        System.out.println("对应的环境 ====>  " + profileproperties.get("profile.env"));

    }


}
