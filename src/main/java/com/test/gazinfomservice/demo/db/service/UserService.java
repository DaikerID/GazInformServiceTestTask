package com.test.gazinfomservice.demo.db.service;

import com.test.gazinfomservice.demo.db.model.User;
import com.test.gazinfomservice.demo.db.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public Optional<User> findByName(String name) {
    return userRepository.findByName(name);
  }


  public void updateUser(User user) {
    userRepository.updateUser(user);
  }
}
