package com.test.gazinfomservice.demo.db.repository;

import com.test.gazinfomservice.demo.db.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet resultSet, int i) throws SQLException {
    return new User(resultSet.getLong("id"),
        resultSet.getString("name"),
        resultSet.getString("surname"));
  }
}
