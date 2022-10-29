package org.example;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionManager {

  public static final String DB_DRIVER = "org.h2.Driver";
  public static final String URI = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MYSQL;DB_CLOSE_DELAY=-1";
  public static final String USER_NAME = "sa";
  public static final String PASSWORD = "";
  public static final int MAX_POOL_SIZE = 40;

  public static final DataSource ds;

  static {
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setDriverClassName(DB_DRIVER);
    hikariDataSource.setJdbcUrl(URI);
    hikariDataSource.setUsername(USER_NAME);
    hikariDataSource.setPassword(PASSWORD);
    hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);

    ds = hikariDataSource;
  }

  public static Connection getConnection() {
    try {
      return ds.getConnection();
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

  public static DataSource getDataSource() {
    return ds;
  }

}
