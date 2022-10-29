package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcTemplate {

  public void executeUpdate(User user, String sql, PreparedStatementSetter pss) {
    try (
        Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
    ) {
      pss.setter(pstmt);
      pstmt.executeUpdate();
    } catch (Exception exception) {
      throw new RuntimeException();
    }
  }

  @SuppressWarnings("unchecked")
  public <T> Optional<T> executeQuery(String sql, PreparedStatementSetter pss, RowMapper rowMapper, Class clasz) {
    try (
        Connection con = ConnectionManager.getConnection();
        PreparedStatement pstmt = getFindUserStatement(con, sql, pss);
        ResultSet resultSet = pstmt.executeQuery();
    ) {
      Object o = null;
      if (resultSet.next()) {
        o = rowMapper.map(resultSet);
      }

      T result = (T) o;
      if (clasz.isInstance(result)) {
        return Optional.ofNullable(result);
      } else {
        return Optional.empty();
      }
      } catch (Exception exception) {
        throw new RuntimeException();
      }
  }

  private PreparedStatement getFindUserStatement(Connection con, String sql, PreparedStatementSetter pss) throws SQLException {
    PreparedStatement pstmt = con.prepareStatement(sql);
    pss.setter(pstmt);
    return pstmt;
  }




}
