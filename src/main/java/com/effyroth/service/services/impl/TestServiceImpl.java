package com.effyroth.service.services.impl;

import com.effyroth.core.exceptions.TestException;
import com.effyroth.core.services.TestService;
import com.effyroth.core.structs.TestObject;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by guzhen on 15/10/24.
 */
public class TestServiceImpl implements TestService.Iface {

    Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    public TestObject testMethod(long testLong, String testString, boolean testBool) throws TestException, TException {
        log.debug(String.valueOf(testLong));
        log.debug(testString);
        log.debug(String.valueOf(testBool));
        TestObject result = new TestObject(testString);
        result.testBool = !testBool;
        result.testLong = -testLong;
        return result;
    }

    @Override
    public String testPing() throws TException {
        log.info("ping");
        return "pong";
    }
}
