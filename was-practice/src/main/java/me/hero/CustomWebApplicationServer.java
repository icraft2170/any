package me.hero;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import me.hero.calculator.Calculator;
import me.hero.calculator.ClientRequestHandler;
import me.hero.calculator.HttpRequest;
import me.hero.calculator.operator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {
  private final int port;

  private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);


  public CustomWebApplicationServer(int port) {
    this.port = port;
  }

  public void start() throws IOException {
    try(ServerSocket serverSocket = new ServerSocket(port)) {
      logger.info("[Custom Web Application Server] start {} port", port);

      Socket clientSocket;
      logger.info("[Custom Web Application Server] waiting for client");

      while ((clientSocket = serverSocket.accept()) != null) {
        logger.info("[Custom Web Application Server] client Connected");
        new Thread(new ClientRequestHandler(clientSocket)).start();
      }
    }
  }

}
