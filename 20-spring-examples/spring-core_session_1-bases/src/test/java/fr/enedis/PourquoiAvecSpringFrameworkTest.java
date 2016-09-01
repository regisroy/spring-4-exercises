package fr.enedis;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PourquoiAvecSpringFrameworkTest {

    //1. je voudrais changer le système de transport => ici pb il faut que je change les classes métier
    //2. j'introduit Spring avec une configuration Java (classe de configuration interne AppConfig)
    //3. je crée le bean LaPosteFrancaise
    //4. explorons les dépendances (inspectons tous les object qui sont créés en interne)
    //
    //10. créons un ApplicationContext : new AnnotationConfigApplicationContext(xxx.class);
    @Test
    public void basique_pas_d_injection_de_dependance() throws Exception {
        LaPosteFrancaise laPoste = new LaPosteFrancaise();

        boolean resultat = laPoste.envoyerCourrier(
                new Colis("rue du Général Leclerc - Avignon"),
                new Colis("rue de la victoire - Lille")
        );



        assertThat(resultat).isTrue();
    }


    @Configuration
    public static class AppConfig {

        @Bean
        public LaPosteFrancaise laposte() {
            return new LaPosteFrancaise();
        }


    }

    //1. je voudrais créer une datasource dbcp avec une base de données embarquées
    //2. je voudrais créer une base de données embarquées
    //3. je  voudrais mettre à jour la base de données (schema + inbbsertion de données)
    //4. je voudrais requeter simplemenet la DB pour récupérer le nombre de personnes
    @Test
    public void creer_une_base_de_donnes_H2_et_sa_datasource() throws Exception {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                //.setName("")                          //default testdb
//                .setType(EmbeddedDatabaseType.H2)       //default HSQLDB

                .addScript("/fr/enedis/schema.sql")
                .addScript("/fr/enedis/data.sql")

                .build();

        assertThat(database).isInstanceOf(DataSource.class);

        //récupération de données pour finir le test
        JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
        Integer nbPersones = jdbcTemplate.queryForObject("select count(1) from PERSON", Integer.class);

        Assertions.assertThat(nbPersones).isEqualTo(4);
    }

}
