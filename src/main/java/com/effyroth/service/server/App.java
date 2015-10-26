package com.effyroth.service.server;

import com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by guzhen on 15/10/24.
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            new ClassPathXmlApplicationContext(
                    "dubbo-provider.xml"
            ).start();

            log.info( App.class.getSimpleName() +  " start .......");

            CountDownLatch countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
        } catch (Exception e) {
            log.error("start server error !", e);
        }finally{
            log.info( App.class.getSimpleName() +  " shutdown! ");
        }

    }
}
