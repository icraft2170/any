package me.hero;

import java.io.IOException;

//Get /calculator?operand1=
public class Main {
  public static void main(String[] args) throws IOException {
    new CustomWebApplicationServer(8080).start();
  }
}