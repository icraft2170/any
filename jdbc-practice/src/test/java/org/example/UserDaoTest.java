package org.example;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

class UserDaoTest {

  /**
   * Before Each
   * - Test Code 이전에 매 번 Call
   */
  @BeforeEach
  void setUp() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(new ClassPathResource("db_schema.sql"));
    DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
  }

  @Test
  void createTest() {
    //given
    UserDao userDao = new UserDao();
    //when
    userDao.create(new User("hero", "password", "name", "email"));

    User user = userDao.findByUserId("hero");
    //then
    assertThat(user).isEqualTo(new User("hero", "password", "name", "email"));
  }
}