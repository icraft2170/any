package org.example.mvc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/") // 어떤 경로로 오더라도 DispatcherServlet이 실행되도록 한다.
public class DispatcherServlet extends HttpServlet {

  private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

  private RequestMappingHandlerMapping rmhm;

  @Override
  public void init() throws ServletException {
    rmhm = new RequestMappingHandlerMapping();
    rmhm.init();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info("[DispatcherServlet] service started. ");
    try {
      Controller handler = rmhm.findHandler(req.getRequestURI());
      String viewName = handler.handleRequest(req, resp);

      RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewName);
      requestDispatcher.forward(req, resp);
    } catch (Exception e) {
      log.error("exception occurred :[ {} ] ", e.getMessage(), e);
    }
  }
}
