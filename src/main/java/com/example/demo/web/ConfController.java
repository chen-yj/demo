package com.example.demo.web;

import com.example.demo.bean.AnotherConfBean;
import com.example.demo.bean.ConfBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置的三种方式
 * 1、直接通过${}获取，配置文件application.yml中its:配置
 * 2、bean形式，从默认配置中获取，参照ConfBean
 * 3、bean形式，指定配置文件，参照AnotherConfBean
 */
@RestController //标注RESTful控制层
@EnableConfigurationProperties({ConfBean.class, AnotherConfBean.class})
public class ConfController {

    @Value("${its.name}")
    private String name;

    @Value("${its.age}")
    private int age;

    @GetMapping("/hiit")
    public String it() {
        return "hi, its name is " + name + " and " + age + " years old.";
    }

    @Autowired
    ConfBean confBean;

    @GetMapping("/hime")
    public String me() {
        return "hi, my name is " + confBean.getName() + " and " + confBean.getAge() + " years old. UUID:" + confBean.getUuid();
    }

    @Autowired
    AnotherConfBean anotherConfBean;
    @GetMapping("/hitest")
    public String you() {
        return "hi, my name is " + anotherConfBean.getName() + " and " + anotherConfBean.getAge() + " years old.";
    }
}
