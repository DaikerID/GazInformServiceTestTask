package com.test.gazinfomservice.demo.db.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.gazinfomservice.demo.db.model.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
class UserRepositoryImplTest {

  @InjectMocks
  private UserRepositoryImpl userRepository;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Test
  void findByName() {
    String findByNameUserQuery = "SELECT * FROM USER WHERE name = ?";

    String name = "name";
    User user = new User(1L, name, "Qwe");
    when(jdbcTemplate.queryForObject(eq(findByNameUserQuery), any(),
        any(BeanPropertyRowMapper.class))).thenReturn(user);

    Optional<User> userByNameOptional = userRepository.findByName(name);
    assertTrue(userByNameOptional.isPresent());
    User userByName = userByNameOptional.get();
    assertThat(userByName).isEqualTo(user);
  }

  @Test
  void updateUser() {
    String updateUserQuery = "UPDATE USER SET name = ?, surname = ? where id = ?";
    User user = new User(1L, "name", "Qwe");
    userRepository.updateUser(user);
    verify(jdbcTemplate, times(1)).update(updateUserQuery, user.getName(), user.getSurname(),
        user.getId());
  }
}