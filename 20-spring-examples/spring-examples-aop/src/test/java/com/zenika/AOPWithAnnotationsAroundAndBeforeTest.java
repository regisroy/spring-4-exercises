package com.zenika;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AOPWithAnnotationsAroundAndBeforeTest extends AbstractAOPTest {

	@Test
    public void AOP_before_and_around() throws Exception {
		checkAopBeforeAndAround();
    }

}
