package com.test.gazinfomservice.demo.db.repository;

import com.test.gazinfomservice.demo.db.model.User;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public Optional<User> findByName(String name) {
    String findByNameUserQuery = "SELECT * FROM USER WHERE name = ?";
    return Optional.ofNullable(
        jdbcTemplate.queryForObject(findByNameUserQuery, new Object[]{name},
            new UserRowMapper()));
  }

  @Override
  @Transactional
  public void updateUser(User user) {
    String updateUserQuery = "UPDATE USER SET name = ?, surname = ? where id = ?";
    jdbcTemplate.update(updateUserQuery,
        user.getName(), user.getSurname(), user.getId());
  }

  @Override
  public List<User> getAll() {
    String sql = "SELECT * FROM USER";
    return jdbcTemplate.query(sql, new UserRowMapper());
  }
}
