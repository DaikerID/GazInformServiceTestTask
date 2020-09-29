package com.test.gazinfomservice.demo.db.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.test.gazinfomservice.demo.configuration.SpringJdbcConfiguration;
import com.test.gazinfomservice.demo.db.model.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = SpringJdbcConfiguration.class)
public class UserRepositoryImplIntegrationTest {

  @Autowired
  UserRepositoryImpl userRepository;

  @Test
  void getByName() {
    String ivanName = "Ivan";
    Optional<User> byName = userRepository.findByName(ivanName);
    assertTrue(byName.isPresent());
    assertThat(byName.get()
                     .getName()).isEqualTo(ivanName);
  }

  @Test
  void update() {
    String ivanName = "Ivan";
    Optional<User> byName = userRepository.findByName(ivanName);
    assertTrue(byName.isPresent());

    User user = byName.get();
    String surname = "NewSurname";
    user.setSurname(surname);
    userRepository.updateUser(user);
    Optional<User> userWithNewSurname = userRepository.findByName(ivanName);
    assertThat(userWithNewSurname.get()
                                 .getSurname()).isEqualTo(surname);


  }
}
