import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

public class C3p0t {
   public static JdbcTemplate jjj()throws Exception{
       ComboPooledDataSource cpds = new ComboPooledDataSource();
       cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
       cpds.setJdbcUrl( "jdbc:mysql://127.0.0.1:3306/snake?useSSL=false" );
       cpds.setUser("root");
       cpds.setPassword("m1234y5678");
// the settings below are optional -- c3p0 can work with defaults
       cpds.setMinPoolSize(5);
       cpds.setAcquireIncrement(5);
       cpds.setMaxPoolSize(20);
       JdbcTemplate template = new JdbcTemplate(cpds);
       return template;
   }
}
