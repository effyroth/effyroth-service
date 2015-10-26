package com.effyroth.service.services.impl;

import com.effyroth.core.services.TestService;
import com.effyroth.core.structs.TestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guzhen on 15/10/24.
 */
public class TestServiceImpl implements TestService {

    Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    public TestObject testMethod(long testLong, String testString, boolean testBool){
        log.debug(String.valueOf(testLong));
        log.debug(testString);
        log.debug(String.valueOf(testBool));
        TestObject result = new TestObject(testString);
        result.setTestBool(!testBool);
        result.setTestLong(-testLong);
        return result;
    }

    @Override
    public String testPing(){
        log.info("ping");
        return "pong";
    }
}
