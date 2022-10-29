package org.example;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;

public class ConnectionManager {

  public static Connection getConnection() {
    String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MYSQL;DB_CLOSE_DELAY=-1";
    String id = "sa";
    String password = "";
    try {
      Class.forName("org.h2.Driver");
      return DriverManager.getConnection(url, id, password);
    } catch (Exception e) {
      return null;
    }
  }


  public static DataSource getDatasource() {
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setDriverClassName("org.h2.Driver");
    hikariDataSource.setJdbcUrl("jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MYSQL;DB_CLOSE_DELAY=-1");
    hikariDataSource.setUsername("sa");
    hikariDataSource.setPassword("");
    return hikariDataSource;
  }
}
