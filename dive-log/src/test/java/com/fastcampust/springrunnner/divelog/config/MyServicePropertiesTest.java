package com.fastcampust.springrunnner.divelog.config;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServicePropertiesTest {
  void test(@Autowired MyServiceProperties myServiceProperties) {
    Assertions.assertThat(myServiceProperties.isEnabled()).isFalse();
  }
}