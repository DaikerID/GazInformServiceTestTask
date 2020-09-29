package com.test.gazinfomservice.demo.db.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.gazinfomservice.demo.db.model.User;
import com.test.gazinfomservice.demo.db.repository.UserRepositoryImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepositoryImpl userRepository;

  @Test
  void findByName() {
    String name = "name";
    User user = new User(1L, name, "Qwe");
    when(userRepository.findByName(name)).thenReturn(Optional.of(user));

    Optional<User> optionalUser = userService.findByName(name);

    assertTrue(optionalUser.isPresent());
    User userFromOptional = optionalUser.get();
    assertThat(userFromOptional).isEqualTo(user);
  }

  @Test
  void updateUser() {
    User user = new User(1L, "name", "Qwe");
    userService.updateUser(user);
    verify(userRepository, times(1)).updateUser(user);
  }

}