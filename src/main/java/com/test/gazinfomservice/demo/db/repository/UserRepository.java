package com.test.gazinfomservice.demo.db.repository;

import com.test.gazinfomservice.demo.db.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

  Optional<User> findByName(String name);

  void updateUser(User user);

  List<User> getAll();

}
