package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
  public void create(User user) {
    String sql = "insert into users values(?,?,?,?)";
    try (
        Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
    ) {
      pstmt.setString(1, user.getId());
      pstmt.setString(2, user.getPassword());
      pstmt.setString(3, user.getName());
      pstmt.setString(4, user.getEmail());
      pstmt.executeUpdate();
    } catch (Exception exception) {
      throw new RuntimeException();
    }
  }


  public User findByUserId(String userId) {
    try (
        Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = getFindUserStatement(con, userId);
        ResultSet resultSet = pstmt.executeQuery();
    ) {
      User user = null;
      if (resultSet.next()) {
        user = new User(
            resultSet.getString("userId"),
            resultSet.getString("password"),
            resultSet.getString("name"),
            resultSet.getString("email")
        );
      }
      return user;
    } catch (Exception exception) {
      throw new RuntimeException();
    }
  }

  private static PreparedStatement getFindUserStatement(Connection con, String userId) throws SQLException {
    String sql = "select userId, password, name, email from users where userid = ?";
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, userId);
    return pstmt;
  }
}
