package com.example.demo;

import com.example.demo.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    public static Logger logger= LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "chenyj");
        redisDao.setKey("age", "30");
        logger.info("name:" + redisDao.getValue("name"));
        logger.info("age:" + redisDao.getValue("age"));
    }

}
