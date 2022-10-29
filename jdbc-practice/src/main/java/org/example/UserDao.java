package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

  /**
   * Setter 를 CallBack 으로 빼버린게 신기함.
   * @param user
   */

  public void create(User user) {
    new JdbcTemplate().executeUpdate(
        user,
        "insert into users values(?,?,?,?)",
        (pstmt) -> {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
          });
  }

  public User findByUserId(String userId) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    return jdbcTemplate.<User>executeQuery(
        "select userId, password, name, email from users where userid = ?",
        (pstmt) -> {
          pstmt.setString(1, userId);
        },
        (rs) -> {
          return new User(
              rs.getString("userId"),
              rs.getString("password"),
              rs.getString("name"),
              rs.getString("email")
          );
        }, User.class).orElseThrow(() -> new IllegalArgumentException("잘못된 UserId 입니다."));
  }

}
