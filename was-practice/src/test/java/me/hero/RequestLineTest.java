package me.hero;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RequestLineTest {

  @Test
  void create() {
    RequestLine requestLine = new RequestLine("GET http://localhost:8080/calculate?operand1=11&operator=*&operand2=55");

    assertThat(requestLine).isNotNull();
    assertThat(requestLine).isEqualTo(new RequestLine("GET", "http://localhost:8080/calculate",
        "operand1=11&operator=*&operand2=55"));
  }


}
