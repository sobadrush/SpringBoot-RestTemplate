package com.nanshan.springbootresttemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author RogerLo
 * @date 2023/10/20
 */
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${local.server.port}")
    protected int port;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        logger.info("============= 【" + testInfo.getDisplayName() + "】 ==============");
    }

}
