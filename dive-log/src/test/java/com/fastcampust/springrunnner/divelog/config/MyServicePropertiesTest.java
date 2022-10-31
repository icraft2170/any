package com.fastcampust.springrunnner.divelog.config;


import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServicePropertiesTest {
  void test(@Autowired MyServiceProperties myServiceProperties) {
    Assertions.assertThat(myServiceProperties.isEnabled()).isFalse();
  }
}