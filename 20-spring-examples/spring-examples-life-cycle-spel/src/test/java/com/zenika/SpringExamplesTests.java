package com.zenika;

import com.zenika.bean.AuditBean;
import com.zenika.bean.IFinal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A system test that verifies the components of the RewardNetwork application work together to reward for dining
 * successfully. Uses Spring to bootstrap the application for use in a test environment.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringExamplesTests {

    @Autowired
    private AuditBean auditBean;

    @Autowired
    private IFinal finalBean1;

    @Autowired
    private IFinal finalBean2;

    @Autowired
    private IFinal finalBean3;


    @Test
    public void testRewardForDining() {
        assertThat(auditBean.getMessage()).isEqualTo("c'est un essai, on verra bien !");

        assertThat(finalBean1.getMessageType()).isEqualTo(Constantes.MESSAGE_TYPE_TEST);

        assertThat(finalBean2.getMessageType()).isEqualTo(Constantes.MESSAGE_TYPE_UAT);

        assertThat(finalBean3.getMessageType()).isEqualTo(Constantes.MESSAGE_TYPE_PROD);
    }


}
