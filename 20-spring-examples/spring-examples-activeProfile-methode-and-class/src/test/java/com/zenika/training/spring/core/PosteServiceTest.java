package com.zenika.training.spring.core;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
//@ActiveProfiles({"velo", "DE"})    // test_1 OK  -  test_2 KO
@ActiveProfiles({"cheval", "FR"})  // test_1 KO  -  test_2 OK
//@ActiveProfiles("FR")   //Dans ce cas j'ai une BeanCreationException : Il manque un bean "posteService"
public class PosteServiceTest {

    @Autowired
    public PosteNationale posteNationale;
    @Autowired
    public StringBuilder recorder;

    @Test
    @DirtiesContext
    @Ignore("à  activer quand @ActiveProfiles({'velo', 'DE'})")
    public void test1_ProfileVeloDE() throws Exception {
        posteNationale.distribuerLeCourrierDansTonPays();
        Assertions.assertThat(recorder.toString()).isEqualTo("ALLEMAGNE\n" +
                                                             "Le courrier est transporte A VELO\n");
    }

    @Test
//    @ActiveProfiles({"cheval", "FR"})  //On ne peut pas mettre de @ActiveProfiles sur une méthode de test
    @DirtiesContext
    public void test2_ProfileChevalFR() throws Exception {
        posteNationale.distribuerLeCourrierDansTonPays();
        Assertions.assertThat(recorder.toString()).isEqualTo("FRANCE\n" +
                                                             "Le courrier est transporte A CHEVAL\n");
    }

    @org.springframework.context.annotation.Configuration
    @ComponentScan("com.zenika.training")
    public static class Configuration {

        @Bean(name = "posteNationale")
        @Profile("DE")
        public PosteNationale posteNationaleAllemagne() {
            return new LaPosteAllemande();
        }

        @Bean(name = "posteNationale")
        @Profile("FR")
        public PosteNationale posteNationaleFrance() {
            return new LaPosteFrancaise();
        }

        @Bean(name = "posteService")
        @Profile("cheval")
        public PosteService posteServiceCheval() {
            return new PosteAChevalService();
        }

        @Bean(name = "posteService")
        @Profile("velo")
        public PosteService posteServicevelo() {
            return new PosteAVeloService();
        }

        @Bean
        public StringBuilder recorder() {
            return new StringBuilder();
        }

    }
}
