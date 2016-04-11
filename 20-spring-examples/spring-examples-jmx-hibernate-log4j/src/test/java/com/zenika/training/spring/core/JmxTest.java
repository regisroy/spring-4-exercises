package com.zenika.training.spring.core;

import com.zenika.training.spring.core.config.AppConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class JmxTest {

    @Test
//    @Ignore("Devrait etre fait par un main, mais là comme ca je bénéficie du runner Spring")
    public void testName() throws Exception {

        System.out.println("\nJmxTest.testName\n");

        System.out.print("Ready.  Press Enter to Stop...");
        System.in.read();
    }
}
