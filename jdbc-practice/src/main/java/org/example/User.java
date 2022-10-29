package org.example;

import java.util.Objects;

public class User {

  private final String id;
  private final String password;
  private final String name;
  private final String email;

  public User(String id, String password, String name, String email) {
    this.id = id;
    this.password = password;
    this.name = name;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(getId(), user.getId()) && Objects.equals(getPassword(),
        user.getPassword()) && Objects.equals(getName(), user.getName())
        && Objects.equals(getEmail(), user.getEmail());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPassword(), getName(), getEmail());
  }
}
