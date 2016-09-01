package fr.enedis;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PourquoiSansSpringFrameworkTest {

    //#1 Avant Spring, avant DI : pas d'injection de dépendances
    @Test
    public void basique_pas_d_injection_de_dependance() throws Exception {
        LaPosteFrancaise laPoste = new LaPosteFrancaise(new CentreDeDistribution());

        boolean resultat = laPoste.envoyerCourrier(
                new Colis("rue du Général Leclerc - Avignon"),
                new Colis("rue de la victoire - Lille")
        );

        assertThat(resultat).isTrue();
    }

    //#2 : Avec Spring : nous faciliter la vie
    //     a) le code comme on pourrait le faire sans spring
    //     b) remplacer le code standard par qqch de plus simple avec spring framework
    @Test
    public void creer_une_base_de_donnes_H2_et_sa_datasource() throws Exception {
        Class.forName("org.h2.Driver");
        PoolableConnectionFactory factory = new PoolableConnectionFactory(
                new DriverManagerConnectionFactory("jdbc:hsqldb:mem:testdb", "sa", ""),
                new GenericObjectPool(null),
                null, null, false, true
        );
        DataSource database = new PoolingDataSource(factory.getPool());

        assertThat(database).isInstanceOf(DataSource.class);

        Connection connection = database.getConnection();
        /*
        Si je veux mettre à jour ma base de données, faire le code ici -> pas hyper simple
         */
        connection.close();
    }

    //#3 Avec spring framework : nous ppermettre de supprimer le boilerplate code
    //   a) cas classique java d'accés en DB avec JDBC : beaucoup de code technique
    //   b) Quel est le code vraiment utile ?
    @Test
    public void supprimer_le_boilerplate_code() throws Exception {
        DataSource database = creerUneDataSource();
        Connection connection = database.getConnection();

        List<Person> personList = new ArrayList<>();
        Connection conn = null;
        String sql = "select first_name, age from PERSON where last_name=?";
        try {
            conn = DataSourceUtils.getConnection(database);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "last_name");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                personList.add(new Person(rs.getString("prenom"), ""));
            }
        } catch (SQLException e) {
            /* ??? */
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                /* ??? */
            }
        }
//        PersonneService personneService = new PersonneService();

        Assertions.assertThat(personList).isNotNull();

        connection.close();
    }

    private DataSource creerUneDataSource() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        PoolableConnectionFactory factory = new PoolableConnectionFactory(
                new DriverManagerConnectionFactory("jdbc:hsqldb:mem:testdb", "sa", ""),
                new GenericObjectPool(null),
                null, null, false, true
        );
        return new PoolingDataSource(factory.getPool());
    }
}
