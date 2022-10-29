package com.fastcampust.springrunnner.divelog;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.context.WebServerPortFileWriter;

@SpringBootApplication
public class DiveLogApplication {
  public static void main(String[] args) {
    for (String arg : args) {
      System.out.println("arg = " + arg);
    }

    SpringApplication application = new SpringApplication(DiveLogApplication.class);
    application.setBannerMode(Mode.OFF);
    // Application PID및 포트를 기록하는 파일 생성
    application.addListeners(
        new ApplicationPidFileWriter(),
        new WebServerPortFileWriter()
    );
    application.run(args);

  }
}
