package me.hero;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.hero.calculator.ClientRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {
  private final int port;

  private final ExecutorService executorService = Executors.newFixedThreadPool(10);

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

        executorService.execute(new ClientRequestHandler(clientSocket));
      }
    }
  }

}
