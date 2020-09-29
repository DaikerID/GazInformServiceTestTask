package com.test.gazinfomservice.demo.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

  Long id;
  String name;
  String surname;

}
